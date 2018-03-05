package automat;

import java.util.ArrayList;

/**
 * Model af en simpel billetautomat til enkeltbilletter med én fast pris.
 */
public class Billetautomat {

    private double balance; // Hvor mange penge kunden p.t. har puttet i automaten
    private boolean montørtilstand;
    private int tæller = 0;
    ArrayList<Event> eventLog = new ArrayList<>();
    ArrayList<Billettype> billeter = new ArrayList<>();

    /**
     * Opret en billetautomat der sælger billetter til 10 kr.
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

    /**
     * Giver prisen for en billet.
     *
     * @param inType
     * @param zoner
     * @return pris på billet med zoner
     */
    public double getBilletpris(String inType, int zoner) {
        double resultat = billeter.get(søgBilletTyper(inType)).getBilletpris();
        return resultat + resultat * (zoner - 1) * 0.8;
    }

    /**
     * Modtag nogle penge (i kroner) fra en kunde.
     *
     * @param beløb
     */
    public void indsætPenge(double beløb) {
        if (beløb >= 0) {
            balance = balance + beløb;
            eventLog.add(new Event("indsæt penge", beløb, "" , 0));
        } else {
            System.err.println("Man kan ikke indsætte et negative beløb.");
        }
    }

    /**
     * Giver balancen (beløbet maskinen har modtaget til den næste billet).
     *
     * @return Nuværende balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Udskriv en billet. Opdater total og nedskriv balancen med billetprisen
     * @param inType
     * @param zoner søger efter billeter med det antal zoner
     */
    public void udskrivBillet(int inType, int zoner) {
        double billetpris = getBilletpris(billeter.get(inType).getType(), zoner);
        if (balance < billetpris) {
            System.out.println("Du mangler at indbetale nogle penge");
        } else {
            balance = balance - billetpris; // Billetter koster 10 kroner

            eventLog.add(new Event("print billet", billetpris, "" , zoner));
            
            System.out.println("##########B##T#########");
            System.out.println("# BlueJ Trafikselskab #");
            System.out.println("#                     #");
            System.out.println("#  " + billeter.get(inType).getType() + "billet      #");
            System.out.println("#        " + billetpris + " kr.       #");
            System.out.println("#                     #");
            System.out.println("#        " + eventLog.get(eventLog.size()-1).getDato() + "             #");
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
        double returbeløb = balance;
        balance = 0;
        System.out.println("Du får " + returbeløb + " kr retur");
        eventLog.add(new Event("penge retur", returbeløb, "" , 0));
        return returbeløb;
    }

    /**
     * montørLogin Bestemmer montør tilstand ud fra login streng.
     *
     * @param String adgangskode
     */
    void montørLogin(String adgangskode) {
        if ("1234".equals(adgangskode)) {
            eventLog.add(new Event("admin login", 0, "" , 0));
            montørtilstand = true;
            System.out.println("Montørtilstand aktiveret");
            System.out.println("Du kan nu angive billetpris");

        } else {
            if (montørtilstand == true) {
                eventLog.add(new Event("admin logud", 0, "" , 0));
                montørtilstand = false;
                System.out.println("Montørtilstand deaktiveret");
            } else {
                eventLog.add(new Event("admin forsøg", 0, "" , 0));
                montørtilstand = false;
                System.out.println("Forkert adgangskode");
            }
        }
    }

    /**
     * getTotal Montør funktion
     *
     * @return penge tjent.
     */
    public double getTotal() {
        if (montørtilstand) {
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
     * getAntalBillerterSolgt Montør funktion
     *
     * @return antal billeter solgt.
     */
    public int getAntalBilletterSolgt() {
        if (montørtilstand) {
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
     * @param billetpris
     * @param zone
     */
    public void setBilletpris(String inType, double inPris) {
        if (montørtilstand) {
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
     * nulstil Nulstiller antal billeter solgt
     */
    public void nulstil() {
        if (montørtilstand) {
            balance = 0;
            eventLog.add(new Event("reset", 0, "" , 0));
        } else {
            System.out.println("Afvist - log ind først");
            eventLog.add(new Event("manglende tilladelse", 12, "" , 0));
        }
    }


    public void montørLog() {
        if (montørtilstand) {
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

    public void montørFindUUID(String søg) {
        if (montørtilstand) {
            tæller = 0;
            System.out.println("Der søges efter loggen med UUID: " + søg);
            eventLog.forEach((Event) -> {
                if (Event.sammenlignUUID(søg)) {
                    Event.printLog();
                    tæller += 1;

                }
            });
            if (tæller == 0) {
                System.out.println("Der var ikke noget UUID med " + søg);
            }

        } else {
            System.out.println("Afvist - log ind først.");
            eventLog.add(new Event("manglende tilladelse", 14, "" , 0));
        }
    }

    public void montørFindTilbageBetalinger(double over, String underOver) {
        if (montørtilstand) {
            tæller = 0;
            System.out.println("Der ledes efter tilbetalinger " + underOver + " " + over + " kr.\n");
            eventLog.forEach((Event) -> {
                if (Event.getVar() >= over && Event.getValg() == 2 && underOver.equals("o") || underOver.equals("O")) {
                    Event.printLog();
                    tæller += 1;

                } else if (Event.getVar() <= over && Event.getValg() == 2 && underOver.equals("u") || underOver.equals("U")) {
                    Event.printLog();
                    tæller += 1;
                }
            });
            if (tæller == 0 && underOver.equals("o") || underOver.equals("O")) {
                System.out.println("Der var ingen tilbagebetalinger over " + over + " kr.");
            }
            if (tæller == 0 && underOver.equals("u") || underOver.equals("U")) {
                System.out.println("Der var ingen tilbagebetalinger under " + over + " kr.");
            }
        } else {
            System.out.println("Afvist - log ind først.");
            eventLog.add(new Event("manglende tilladelse", 14, "" , 0));
        }
    }

    public void montørFindIndsattePenge(double over, String underOver) {
        if (montørtilstand) {
            tæller = 0;
            System.out.println("Der ledes efter indbetalinger " + underOver + " " + over + " kr.\n");
            eventLog.forEach((Event) -> {
                if (Event.getVar() >= over && Event.getValg() == 1 && underOver.equals("o") || underOver.equals("O")) {
                    Event.printLog();
                    tæller += 1;

                } else if (Event.getVar() <= over && Event.getValg() == 1 && underOver.equals("u") || underOver.equals("U")) {
                    Event.printLog();
                    tæller += 1;
                }
            });
            if (tæller == 0 && underOver.equals("o") || underOver.equals("O")) {
                System.out.println("Der var ingen indbagebetalinger over " + over + " kr.");
            }
            if (tæller == 0 && underOver.equals("u") || underOver.equals("U")) {
                System.out.println("Der var ingen indbagebetalinger under " + over + " kr.");
            }
            
        } else {
            System.out.println("Afvist - log ind først.");
            eventLog.add(new Event("manglende tilladelse", 14, "" , 0));
        }
    }

    /**
     * erMontør Checker om tilstanden er montør.
     *
     * @return montørtilstand
     */
    public boolean erMontør() {
        return montørtilstand;
    }
    
    public void udskrivBilletTyper() {
        for( int i = 0; i < billeter.size(); i++) {
            System.out.println((i+1) + ". for en " + billeter.get(i).getType() + " koster " + billeter.get(i).getBilletpris() + " kroner.");
        }
    }
    
    public int søgBilletTyper(String søgType){
        for (int i = 0; i < billeter.size() ; i++ ) {
            if (billeter.get(i).getType().equals(søgType)) {
                return i; // returnere det index som der har det antal zoner.
            }
        }
        return -1; //Hvis der ikke findes en billet med det antal zoner.
    }
}
