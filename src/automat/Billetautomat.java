package automat;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Model af en billetautomat
 */
public class Billetautomat {
    
    private int billetVersion = 0;
    private String iD = "";
    private double balance = 0;                                 // Hvor mange penge kunden p.t. har puttet i automaten
    private boolean montoertilstand = false;                        // Bestemmer om man har montør retigheder.
    private int solgteBilleter = 0;                         // Tæller hvor mange billeter der er solgt
    private double totalPris = 0;                           // Tæller sammen hvor mange penge man har for i kurven.
    private double totalPengeTjent = 0;                     // Tæller hvor meget man har købt for i denne kørsel.
    private int kunderTotal = 0;                            // Tæller hvor mange kunder der har været igennem.    
    private String station;
    ArrayList<Event> eventLog = new ArrayList<>();          // Holder styr på alle events.
    ArrayList<Billettype> billeter = new ArrayList<>();     // Holder styr på alle billettyper.
    ArrayList<Kurv> kurv = new ArrayList<>();               // Holder styr på hvad der er i kurven.

    /**
     * Initialiszere billetautomaten ved at downloade billterne fra en FTP sever.
     * og læser billeterne ind i programmet fra den down loadede fil.
     * @throws java.io.IOException
     */
    public Billetautomat() throws IOException {
        
        // Henter filen
        pullBilleter();  
        
        // Læser en fil lokalt der beskriver hvilken station den står på og hvilket ID den har.
        List<String> linjer = Files.readAllLines(Paths.get("src/automat/Automat.txt"), Charset.defaultCharset());
        station = linjer.get(0);
        iD = linjer.get(1);
        
        linjer.clear();
        
        // oprætter billeter fra filen.
        linjer = Files.readAllLines(Paths.get("src/automat/Billeter.txt"), Charset.defaultCharset());
        // BilletVersion er den version af billeter som automaten køre på.
        billetVersion = Integer.parseInt(linjer.get(0));
        
        for( int i = 1; i < linjer.size(); i++) {
            // Læser billeten ind. og finder karakteren ¤ som opdeler billetnavne fra prisen.
            String lin = linjer.get(i);
            int split = lin.indexOf("¤");
            
            String billetnavn = lin.substring( 0 , split);
            double billetpris = Double.parseDouble(lin.substring(split + 1));
            
            // Opretter billeten til Arraylisten.
            billeter.add(new Billettype(billetnavn, billetpris));
        }
    }

    /**
     *
     * @return - Stationens navn.
     */
    public String getStation() {
        return station;
    }

    /**
     * @param nyStation - Nyt stations navn
     */
    public void setStation(String nyStation) {
        station = nyStation;
    }

    /**
     * @return Antal solgte billeter i denne kørsel.
     */
    private int getSolgteBilleter() {
        return solgteBilleter;
    }

    /**
     * @return Total antal penge automaten har tjent.
     */
    private double getTotalTjent() {
        return totalPengeTjent;
    }

    /**
     * Giver prisen for en billet.
     * @param inType billet som String
     * @param zoner Antal zoner der ønskes.
     * @return pris på billet med zoner
     */
    public double getBilletpris(String inType, int zoner) {
        double resultat = billeter.get(soegBilletTyper(inType)).getBilletpris();
        resultat += (resultat * (zoner - 1) * 0.8);
        resultat = Math.round(resultat * 10.0) / 10.0;
        return resultat;
    }

    /**
     * Finder in billets index ud fra navnet.
     * @param soegType
     * @return 
     */
    private int soegBilletTyper(String soegType) {
        for (int i = 0; i < billeter.size(); i++) {
            if (billeter.get(i).getType().equals(soegType)) {
                return i; // returnere det index som der har det antal zoner.
            }
        }
        return -1; //Hvis der ikke findes en billet med det antal zoner.
    }
    
    /**
     * Modtag nogle penge (i kroner) fra en kunde.
     * @param beloeb Beløb der ønskes indsat
     */
    public void indsaetPenge(double beloeb) {
        if (beloeb >= 0) {
            balance = balance + beloeb;
            System.out.println("Der er indsat " + beloeb + " kr.");
            eventLog.add(new Event("insert penge", beloeb, "", 0));
        } else {
            System.err.println("Man kan ikke insertte et negative beløb.");
        }
    }

    /**
     * Giver balancen som der er inde i maskinen.
     * @return - Nuvaerende balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Giver det totale antal kunder der har været igennem maskinen.
     * @return Total antal kunder
     */
    public int getKunder() {
        return kunderTotal;
    }

    /**
     * @return Totale pris for alle billeterne i kurven.
     */
    public double getTotalPris() {
        return totalPris;
    }

    /**
     * Udskriver billeterne hvis der er penge nok i maskinen.
     * @return 1 hvis billeter er printet. -1 hvis der ikke var nok penge.
     */
    public int udskrivBilleter() {
        if (balance >= totalPris) {
            for (int i = 0; i < kurv.size(); i++) {
                totalPengeTjent += kurv.get(i).getPris();
                for (int j = 0; j < kurv.get(i).getAntalBilleter(); j++) {
                    solgteBilleter += 1;
                    printBillet(kurv.get(i).getType(), kurv.get(i).getPris()/kurv.get(i).getAntalBilleter(), kurv.get(i).getZoner());
                }
            }
            balance -= totalPris;
            kunderTotal += 1;
            kurv.clear();
            totalPris = 0;
            return 1;
        } else {
            return -1;
        }
    }

    /**
     * Udskriver en billet.
     * @param inType Billetnavn
     * @param inPris Billetpris
     * @param zoner antal zoner billeten er gyldig.
     */
    public void printBillet(String inType, double inPris, int zoner) {
       
        eventLog.add(new Event("print billet", inPris, "", zoner));

        System.out.println("###################B##T###################");
        System.out.println("#          BlueJ Trafikselskab           #");
        System.out.println("#                                        #");
        System.out.println("#            " + inType + " billet               #");
        System.out.println("#              " + inPris + "0 kr.                 #");
        System.out.println("#                                        #");
        System.out.println("#      " + eventLog.get(eventLog.size() - 1).getDato() + "     #");
        System.out.println("#  " + eventLog.get(eventLog.size() - 1).getUUID() + "  #");
        System.out.println("###################B##T###################");
        System.out.println();

    }

    /**
     * returpenge nulstiller også balancen.
     * @return Antal penge retur
     */
    public double returpenge() {
        double returbeloeb = balance;
        balance = 0;
        System.out.println("Du får " + returbeloeb + " kr retur");
        eventLog.add(new Event("penge retur", returbeloeb, "", 0));
        return returbeloeb;
    }

    /**
     * Login funktion til montør indstillinger.
     * @param adgangskode Koden for at logge ind.
     */
    public void montoerLogin(String adgangskode) {
        if (adgangskode.equals("1234")) {
            eventLog.add(new Event("admin login", 0, "", 0));
            montoertilstand = true;
            System.out.println("Montørtilstand aktiveret");

        } else {
            if (montoertilstand == true) {
                eventLog.add(new Event("admin logud", 0, "", 0));
                montoertilstand = false;
                System.out.println("Montørtilstand deaktiveret");
            } else {
                eventLog.add(new Event("admin forsøg", 0, "", 0));
                montoertilstand = false;
                System.out.println("Forkert adgangskode");
            }
        }
    }

    /**
     * Montør funktion der finder hvor meget der er tjent.
    * @return penge tjent.
     */
    public double montoerGetTotal() {
        if (montoertilstand) {
            return getTotalTjent();
        } else {
            eventLog.add(new Event("manglende tilladelse", 11, "", 0));
            System.out.println("Afvist - log ind først");
            return 0;
        }
    }

    /**
     * Montør funk. Giver antal billeter solgt.
     * @return antal billeter solgt.
     */
    public int montoerGetAntalBilletterSolgt() {
        if (montoertilstand) {
            return getSolgteBilleter();
        } else {
            eventLog.add(new Event("manglende tilladelse", 11, "", 0));
            System.out.println("Afvist - log ind først");
            return 0;
        }
    }

    /**
     * Fjerener en billet fra salgsmulighederne.
     * @param index i Arraylisten
     */
    public void montoerFjernBillet(int index) {
        billeter.remove(index);
    }


    /**
     * Opdatere en billets navn
     * @param index Index i arrayet
     * @param nytNavn nye billetnavn.
     */
    public void montoerOpdaterBilletNavn(int index, String nytNavn) {
        billeter.get(index).setType(nytNavn);
    }
    

    /**
     * Opdatere en billet.
     * @param index - Index på Billeten
     * @param nyPris - Den nye pris
     */
    public void montoerOpdaterBilletPris(int index, double nyPris) {
        billeter.get(index).setBilletpris(nyPris);
//      totalPris = 0;
//      for (int i = 0; i < kurv.size(); i++) {
//          totalPris += kurv.get(i).getPris();
//      }
    }
    
    /**
     * Tilføjer en ny billet til Billeter arrayet.
     * @param inType Billetnavn
     * @param inPris Billetpris
     */
    public void montoerOpretBillet(String inType, double inPris) {
        billeter.add(new Billettype(inType, inPris));
        
    }

    /**
     * Nulstiller: antal billeter solgt og balancen.
     */
    public void montoerNulstil() {
        if (montoertilstand) {
            balance = 0;
            eventLog.add(new Event("reset", 0, "", 0));
        } else {
            System.out.println("Afvist - log ind først");
            eventLog.add(new Event("manglende tilladelse", 12, "", 0));
        }
    }
    
    /**
     * Printer alle logs hvis man er i montør tilstand
     */
    
    public void montoerLog() {
        if (montoertilstand) {
            System.out.println("Her kommer alle logs:\n");
            for(int i = 0; i < eventLog.size(); i++) {
                eventLog.get(i).printLog();
            }
        } else {
            System.out.println("Afvist - log ind først.");
            eventLog.add(new Event("manglende tilladelse", 14, "", 0));
        }
    }

    /**
     * En søgefunktion der søger på et UUID
     * @param soeg UUID der søges efter hvis det findes printes den i output.
     */
    public void montoerFindUUID(String soeg) {
        if (montoertilstand) {
            int count = 0;
            System.out.println("Der søges efter loggen med UUID: " + soeg);
            for (int i = 0; i < eventLog.size(); i++) {
                if (eventLog.get(i).sammenlignUUID(soeg)) {
                    eventLog.get(i).printLog();
                    count += 1;
                }
            }
            if (count == 0) {
                System.out.println("Der var ikke noget UUID med " + soeg);
            }

        } else {
            System.out.println("Afvist - log ind først.");
            eventLog.add(new Event("manglende tilladelse", 14, "", 0));
        }
    }
    
    /**
     * Finder alle indsatte penge i mellem 2 værdier.
     * @param venstre
     * @param hoejre 
     */
    public void montoerFindIndsattePengeMellem(double venstre, double hoejre) {
        if (montoertilstand) {
            int count = 0;
            for (int i = 0; i < eventLog.size(); i++) {
                    if (    eventLog.get(i).getVar()  >= venstre && 
                            eventLog.get(i).getVar()  <= hoejre  && 
                            eventLog.get(i).getValg() == 1       ){
                        
                        eventLog.get(i).printLog();
                        count += 1;
                    }
                }
            if (count == 0) {
                System.out.println("Der er ikke indsat penge i mellem " + venstre + " og " + hoejre + " kr.");
            }
        } else {
            System.out.println("Afvist - log ind først.");
            eventLog.add(new Event("manglende tilladelse", 14, "", 0));
        }
    }

    
    public void montoerFindReturPengeMellem(double venstre, double hoejre) {
        if (montoertilstand) {
            int count = 0;
            for (int i = 0; i < eventLog.size(); i++) {
                    if (    eventLog.get(i).getVar()  >= venstre && 
                            eventLog.get(i).getVar()  <= hoejre  && 
                            eventLog.get(i).getValg() == 2       ){ // Valg 2 er Event "retur"
                        
                        eventLog.get(i).printLog();
                        count += 1;
                    }
                }
            if (count == 0) {
                System.out.println("Der er ikke returneret penge i mellem " + venstre + " og " + hoejre + " kr.");
            }
        } else {
            System.out.println("Afvist - log ind først.");
            eventLog.add(new Event("manglende tilladelse", 14, "", 0));
        }
    }
    
    /**
     * Printer alle logs der håndtere penge ind og ud af maskinen.
     * @param venstre
     * @param hoejre 
     */
    public void montoerFindPengeMellem(double venstre, double hoejre) {
        if (montoertilstand) {
            int count = 0;
            for (int i = 0; i < eventLog.size(); i++) {
                    if (    eventLog.get(i).getVar()  >= venstre && 
                            eventLog.get(i).getVar()  <= hoejre  && 
                            eventLog.get(i).getValg() == 1       || // Indsæt penge
                            eventLog.get(i).getValg() == 2       ){ // Retur  penge
                        
                        eventLog.get(i).printLog();
                        count += 1;
                    }
                }
            if (count == 0) {
                System.out.println("Der er ikke returneret penge i mellem " + venstre + " og " + hoejre + " kr.");
            }
        } else {
            System.out.println("Afvist - log ind først.");
            eventLog.add(new Event("manglende tilladelse", 14, "", 0));
        }
        
    }
    
    /**
     * erMontoer Checker om tilstanden er montoer.
     * @return montoertilstand
     */
    public boolean erMontoer() {
        return montoertilstand;
    }

    /**
     * Tilføjer en billet til kurven.
     * @param inAntal Antal billeter
     * @param inString Billetnavnet
     * @param inZoner Antal zoner
     * @param inPris Prisen for de valgt billeter
     * @param inIndex Indexet i billeterne.
     */
    public void addtoKurv(int inAntal, String inString, int inZoner, double inPris, int inIndex) {
        kurv.add(new Kurv(inAntal, inString, inZoner, inPris, inIndex));
        totalPris += inPris;
    }

    /**
     * Fjerner et objekt i kurven.
     * @param index indexet i kurven der ønskes slettet.
     */
    public void removeItemKurv(int index) {
        totalPris -= kurv.get(index).getPris();
        kurv.remove(index);
    }

    /**
     * Returner en kruv og sletter den fra arraylisten.
     * @param index - Den plads i arrayListen der ønskes returneret.
     * @return Det kurv objekt der er ønsket.
     */
    public Kurv getkurv(int index) {
        Kurv tempKurv = kurv.get(index);
        totalPris -= tempKurv.getPris();
        kurv.remove(index);
        return tempKurv;
    }

    /**
     * Downloader Billeter.txt filen fra en FTP server.
     * @return 1 hvis det er gået godt
     * @throws IOException 
     */
    private void pullBilleter() throws IOException {
        datakommunikation.FtpForbindelse FTP = new datakommunikation.FtpForbindelse();
        
        FTP.forbind("ubuntu4.saluton.dk","oop_jonas","java1234");
        String indhold;
        
        indhold = FTP.modtagTekst("RETR Billeter.txt");
        
        FileWriter fil = new FileWriter("src/automat/Billeter.txt");
        PrintWriter ud = new PrintWriter(fil);
        ud.print(indhold);
        ud.close();
    }
    
    /**
     * downloader en ny Billeter.txt fil og ser om billeterne skal opdateres.
     * @return 1 hvis der er opdateret. ellers 0.
     * @throws IOException 
     */
    public int checkForUpdate() throws IOException {
        
        pullBilleter();
        
        List<String> linjer = Files.readAllLines(Paths.get("src/automat/Billeter.txt"), Charset.defaultCharset());
        
        if(billetVersion < Integer.parseInt(linjer.get(0))) {
            updateBilleter();
        } else {
            return 0;
        }
        return 1;
    }
    
    /**
     * Opdatere billeterne ud fra den nye fil.
     * @throws IOException 
     */
    private void updateBilleter() throws IOException {
        
        List<String> linjer = Files.readAllLines(Paths.get("src/automat/Billeter.txt"), Charset.defaultCharset());
                
        billetVersion = Integer.parseInt(linjer.get(0));
        
        billeter.clear();
        
        for( int i = 1; i < linjer.size(); i++) {
            
            String lin = linjer.get(i);
            int split = lin.indexOf("¤");
            
            String billetnavn = lin.substring( 0 , split);
            double billetpris = Double.parseDouble(lin.substring(split + 1));
            
            billeter.add(new Billettype(billetnavn, billetpris));
        }    
    }
}
