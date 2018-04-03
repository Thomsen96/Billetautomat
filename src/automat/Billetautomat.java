package automat;

import java.util.ArrayList;

/**
 * Model af en simpel billetautomat til enkeltbilletter med én fast pris.
 */
public class Billetautomat {

    private double balance; // Hvor mange penge kunden p.t. har puttet i automaten
    private boolean montoertilstand;
    private int taeller = 0;
    private int solgteBilleter = 0;
    private double totalPris = 0;
    ArrayList<Event> eventLog = new ArrayList<>();
    ArrayList<Billettype> billeter = new ArrayList<>();
    ArrayList<Kurv> kurv = new ArrayList<>(); 

    
    /**
     * Oprette billetautomaten men nogle standart billeter.
     */
    public Billetautomat() {
        
        // opretter billeterne.
        billeter.add(new Billettype("Voksen", 12));
        billeter.add(new Billettype("Barn (0-14 år)", 6));
        billeter.add(new Billettype("Cykel", 14));
        billeter.add(new Billettype("Pensionist", 8));
        billeter.add(new Billettype("Blå sokker", 4));
        billeter.add(new Billettype("Weekend", 30));
        billeter.add(new Billettype("24-Timer (voksen)", 20));
        
        // sætter balancen
        balance = 0;
    }
    public int getSolgteBilleter(){
        return solgteBilleter;
    }

    /**
     * Giver prisen for en billet.
     *
     * @param inType - billet som String
     * @param zoner - Antal zoner der ønskes.
     * @return pris på billet med zoner
     */
    public double getBilletpris(String inType, int zoner) {
        double resultat = billeter.get(soegBilletTyper(inType)).getBilletpris();
        resultat += (resultat * (zoner - 1) * 0.8);
        resultat = Math.round(resultat * 10.0) / 10.0;
        return resultat;
    }

    /**
     * Modtag nogle penge (i kroner) fra en kunde.
     *
     * @param beloeb - Beløb der ønskes indsat
     */
    public void indsaetPenge(double beloeb) {
        if (beloeb >= 0) {
            balance = balance + beloeb;
            System.out.println("Der er indsat " + beloeb + " kr.");
            eventLog.add(new Event("indsæt penge", beloeb, "" , 0));
        } else {
            System.err.println("Man kan ikke indsætte et negative beløb.");
        }
    }

    /**
     * Giver balancen (beloebet maskinen har modtaget til den naeste billet).
     *
     * @return - Nuvaerende balance
     */
    public double getBalance() {
        return balance;
    }
    
    /**
     * 
     * @return Totale pris for kurven
     */
    public double getTotalPris() {
        return totalPris;
    }

    /**
     * 
     * @return 1 for printede billeter -1 hvis ikke nok penge.
     */
    public int udskrivBilleter() {
        if(balance >= totalPris) {
            for(int i = 0; i < kurv.size(); i++) {
                for(int j = 0; j < kurv.get(i).getAntalBilleter(); j++) {
                    printBillet(kurv.get(i).getIndex(), kurv.get(i).getZoner());
                }
            }
            kurv.clear();   
            return 1;
        } else {
            return -1;
        }
    }
    
    /**
     * Udskriv en billet. Opdater total og nedskriv balancen med billetprisen
     * @param inType - Streng navn på billeten
     * @param zoner søger efter billeter med det antal zoner
     */
    public void printBillet(int inType, int zoner) {
        double billetpris = getBilletpris(billeter.get(inType).getType(), zoner);
        if (balance < billetpris) {
            System.out.println("Du mangler at indbetale nogle penge");
        } else {
            balance -= billetpris; // Billetter koster 10 kroner
            solgteBilleter += 1;
            eventLog.add(new Event("print billet", billetpris, "" , zoner));
            
            System.out.println("##########B##T#########");
            System.out.println("# BlueJ Trafikselskab #");
            System.out.println("#                     #");
            System.out.println("#  " + billeter.get(inType).getType() + " billet  #");
            System.out.println("#      " + billetpris + "0 kr.      #");
            System.out.println("#                     #");
            System.out.println("#    " + eventLog.get(eventLog.size()-1).getDato() + "    #");
            System.out.println("#  " + eventLog.get(eventLog.size()-1).getUUID() + "  #");
            System.out.println("##########B##T#########");
            System.out.println();

            
        }
    }

    /**
     * returpenge nulstiller også balancen.
     *
     * @return beregner hvor mange penge man skal have retur
     */
    public double returpenge() {
        double returbeloeb = balance;
        balance = 0;
        System.out.println("Du får " + returbeloeb + " kr retur");
        eventLog.add(new Event("penge retur", returbeloeb, "" , 0));
        return returbeloeb;
    }

    /**
     * montoerLogin Bestemmer montoer tilstand ud fra login streng.
     *
     * @param adgangskode
     */
    public void montoerLogin(String adgangskode) {
        if ("1234".equals(adgangskode)) {
            eventLog.add(new Event("admin login", 0, "" , 0));
            montoertilstand = true;
            System.out.println("Montørtilstand aktiveret");

        } else {
            if (montoertilstand == true) {
                eventLog.add(new Event("admin logud", 0, "" , 0));
                montoertilstand = false;
                System.out.println("Montørtilstand deaktiveret");
            } else {
                eventLog.add(new Event("admin forsøg", 0, "" , 0));
                montoertilstand = false;
                System.out.println("Forkert adgangskode");
            }
        }
    }

    /**
     * getTotal Montoer funktion
     *
     * @return penge tjent.
     */
    public double montoerGetTotal() {
        if (montoertilstand) {
            double total = 0;
            for(int i = 0; i < eventLog.size(); i++) {
                if (eventLog.get(i).getValg() == 3) {
                    total += eventLog.get(i).getVar();
                }
            }
            return total;

        } else {
            eventLog.add(new Event("manglende tilladelse", 11, "" , 0));
            System.out.println("Afvist - log ind først");
            return 0;
        }
    }

    /**
     * getAntalBillerterSolgt Montoer funktion
     *
     * @return antal billeter solgt.
     */
    public int montoerGetAntalBilletterSolgt() {
        if (montoertilstand) {
            int total = 0;
            for(int i = 0; i < eventLog.size(); i++) {
                if (eventLog.get(i).getValg() == 3) {
                    total += 1;
                }
            }
            return total;
        } else {
            eventLog.add(new Event("manglende tilladelse", 11, "" , 0));
            System.out.println("Afvist - log ind først");
            return 0;
        }
    }

    /**
     * setBilletpris Setter en ny billet pris
     *
     * @param inType - Billet navn der ønskes ændret
     * @param inPris - Nye pris på billet.
     */
    public void montoerSetBilletpris(String inType, double inPris) {
        if (montoertilstand) {
            for(int i = 0; i < billeter.size(); i++) {
                if (billeter.get(i).getType().equals(inType)) {
                    billeter.get(i).setBilletpris(inPris);
                    eventLog.add(new Event("billetpris sat", inPris, inType, 0));
                    return;
                }
            }
            billeter.add(new Billettype(inType, inPris));
            eventLog.add(new Event("billetpris sat", inPris, inType, 0));
        } else {
            eventLog.add(new Event("manglende tilladelse", 13, "" , 0));
        }

    }

    /**
     * Nulstiller: antal billeter solgt og balancen.
     */
    public void montoerNulstil() {
        if (montoertilstand) {
            balance = 0;
            eventLog.add(new Event("reset", 0, "" , 0));
        } else {
            System.out.println("Afvist - log ind først");
            eventLog.add(new Event("manglende tilladelse", 12, "" , 0));
        }
    }


    public void montoerLog() {
        if (montoertilstand) {
            System.out.println("Her kommer alle logs:");
            System.out.println("");
            eventLog.forEach((Event) -> {
                Event.printLog();
            });
        } else {
            System.out.println("Afvist - log ind først.");
            eventLog.add(new Event("manglende tilladelse", 14, "" , 0));
        }
    }

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
            eventLog.add(new Event("manglende tilladelse", 14, "" , 0));
        }
    }

    public void montoerFindTilbageBetalinger(double over, String underOver) {
        if (montoertilstand) {
            taeller = 0;
            System.out.println("Der ledes efter tilbetalinger " + underOver + " " + over + " kr.\n");
            eventLog.forEach((Event) -> {
                if (Event.getVar() >= over && Event.getValg() == 2 && underOver.equals("o") || underOver.equals("O")) {
                    Event.printLog();
                    taeller += 1;

                } else if (Event.getVar() <= over && Event.getValg() == 2 && underOver.equals("u") || underOver.equals("U")) {
                    Event.printLog();
                    taeller += 1;
                }
            });
            if (taeller == 0 && underOver.equals("o") || underOver.equals("O")) {
                System.out.println("Der var ingen tilbagebetalinger over " + over + " kr.");
            }
            if (taeller == 0 && underOver.equals("u") || underOver.equals("U")) {
                System.out.println("Der var ingen tilbagebetalinger under " + over + " kr.");
            }
        } else {
            System.out.println("Afvist - log ind først.");
            eventLog.add(new Event("manglende tilladelse", 14, "" , 0));
        }
    }

    public void montoerFindIndsattePenge(double over, String underOver) {
        if (montoertilstand) {
            taeller = 0;
            System.out.println("Der ledes efter indbetalinger " + underOver + " " + over + " kr.\n");
            eventLog.forEach((Event) -> {
                if (Event.getVar() >= over && Event.getValg() == 1 && underOver.equals("o") || underOver.equals("O")) {
                    Event.printLog();
                    taeller += 1;

                } else if (Event.getVar() <= over && Event.getValg() == 1 && underOver.equals("u") || underOver.equals("U")) {
                    Event.printLog();
                    taeller += 1;
                }
            });
            if (taeller == 0 && underOver.equals("o") || underOver.equals("O")) {
                System.out.println("Der var ingen indbagebetalinger over " + over + " kr.");
            }
            if (taeller == 0 && underOver.equals("u") || underOver.equals("U")) {
                System.out.println("Der var ingen indbagebetalinger under " + over + " kr.");
            }
            
        } else {
            System.out.println("Afvist - log ind først.");
            eventLog.add(new Event("manglende tilladelse", 14, "" , 0));
        }
    }

    public void montoerFindIndsattePengeMellem(double venstre, double højre, int valg1, int valg2) {
        if (montoertilstand) {
            int count = 0;
            if ( venstre < højre) {
                for( int i = 0; i < eventLog.size(); i++) {
                    if(eventLog.get(i).getVar() >= venstre && eventLog.get(i).getVar() <= højre && 
                            eventLog.get(i).getValg() == valg1 || eventLog.get(i).getValg() == valg2) {
                        eventLog.get(i).printLog();
                        count += 1;
                    }
                }
            } else {
                for( int i = 0; i < eventLog.size(); i++) {
                    if(eventLog.get(i).getVar() <= venstre && eventLog.get(i).getVar() >= højre && eventLog.get(i).getValg() == valg1 ) {
                        eventLog.get(i).printLog();
                        count += 1;
                    }
                }
            }
            if (count == 0) {
                System.out.println("Intet match på søgning mellem: " + venstre + " og " + højre + " kr.");
            }
        } else {
            System.out.println("Afvist - log ind først.");
            eventLog.add(new Event("manglende tilladelse", 14, "" , 0));
        }
    }
    
    /**
     * erMontoer Checker om tilstanden er montoer.
     *
     * @return montoertilstand
     */
    public boolean erMontoer() {
        return montoertilstand;
    }
    
    public void udskrivBilletTyper() {
        for( int i = 0; i < billeter.size(); i++) {
            System.out.println((i+1) + ". for en " + billeter.get(i).getType() + " koster " + billeter.get(i).getBilletpris() + " kroner.");
        }
    }
    
    public int soegBilletTyper(String soegType){
        for (int i = 0; i < billeter.size() ; i++ ) {
            if (billeter.get(i).getType().equals(soegType)) {
                return i; // returnere det index som der har det antal zoner.
            }
        }
        return -1; //Hvis der ikke findes en billet med det antal zoner.
    }
    
    public void addtoKurv(int inAntal, String inString, int inZoner, double inPris, int inIndex){
        kurv.add(new Kurv(inAntal, inString, inZoner, inPris, inIndex));
        totalPris += inPris;
        
    }
    
    public void removeItemKurv(int index) {
        totalPris -= kurv.get(index).getPris();
        kurv.remove(index);
    }
    
    /**
     * Giver en kurv.
     * 
     * @param index - Den plads i arrayListen der ønskes returneret.
     * @return Det kurv objekt der er ønsket.
     */
    public Kurv getkurv(int index) {
        Kurv tempKurv = kurv.get(index);
        totalPris -= tempKurv.getPris();
        kurv.remove(index);
        return tempKurv;
    }
    
    
    
    
    
    
}
