package automat;

import java.util.ArrayList;
import java.util.Date;

/**
 * Model af en simpel billetautomat til enkeltbilletter med én fast pris.
 */
public class Billetautomat {

    
    private int billetpris;    // Prisen for én billet.
    private int balance; // Hvor mange penge kunden p.t. har puttet i automaten
    private int antalBilletterSolgt; // Antal billetter automaten i alt har solgt
    private boolean montørtilstand;
    private int zonePlacering;
    private Date netopNu;
    ArrayList<Event> eventLog = new ArrayList<>();
    
    
    
    /**
     * Opret en billetautomat der sælger billetter til 10 kr.
     */
    public Billetautomat() {
        billetpris = 10;
        balance = 0;
        antalBilletterSolgt = 0;
    }

    /**
     * Giver prisen for en billet.
     *
     * @return pris på billet
     */
    public int getBilletpris() {
        int resultat = billetpris;
        return resultat;
    }

    /**
     * Modtag nogle penge (i kroner) fra en kunde.
     *
     * @param beløb
     */
    public void indsætPenge(int beløb) {
        balance = balance + beløb;
        eventLog.add(new Event("indsæt penge" , beløb));
        //("** Der er blevet indsat " + beløb + " kr.    " + netopNu.toString())
    }

    /**
     * Giver balancen (beløbet maskinen har modtaget til den næste billet).
     *
     * @return Nuværende balance
     */
    public int getBalance() {
        return balance;
    }

    /**
     * Udskriv en billet. Opdater total og nedskriv balancen med billetprisen
     */
    public void udskrivBillet() {
        if (balance < 10) {
            System.out.println("Du mangler at indbetale nogle penge");
        } else {
            balance = balance - billetpris; // Billetter koster 10 kroner

            System.out.println("##########B##T#########");
            System.out.println("# BlueJ Trafikselskab #");
            System.out.println("#                     #");
            System.out.println("#        Billet       #");
            System.out.println("#        " + billetpris + " kr.       #");
            System.out.println("#                     #");
            System.out.println("##########B##T#########");
            System.out.println("# Du har " + (balance) + " kr til gode       #");
            System.out.println("##########B##T#########");
            System.out.println();

            antalBilletterSolgt = antalBilletterSolgt + 1;
            eventLog.add(new Event("print billet" , billetpris));
        }
    }

    /**
     * returpenge nulstiller også balancen.
     *
     * @return beregner hvor mange penge man skal have retur
     */
    public int returpenge() {
        int returbeløb = balance;
        balance = 0;
        System.out.println("Du får " + returbeløb + " kr retur");
        eventLog.add(new Event("penge retur" , returbeløb));
        return returbeløb;
    }

    /**
     * montørLogin Bestemmer montør tilstand ud fra login streng.
     *
     * @param String adgangskode
     */
    void montørLogin(String adgangskode) {
        if ("1234".equals(adgangskode)) {
            eventLog.add(new Event("admin login" , 0));
            montørtilstand = true;
            System.out.println("Montørtilstand aktiveret");
            System.out.println("Du kan nu angive billetpris");
            
        } else {
            if(montørtilstand == true) {
                eventLog.add(new Event("admin logud" , 0));
                montørtilstand = false;
                System.out.println("Montørtilstand deaktiveret");
            } else {
                eventLog.add(new Event("admin forsøg" , 0));
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
    public int getTotal() {
        if (montørtilstand) {
            eventLog.add(new Event("manglende tilladelse", 11));
            return billetpris * antalBilletterSolgt;
            
        } else {
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
            eventLog.add(new Event("manglende tilladelse", 11));
            return antalBilletterSolgt;
        } else {
            System.out.println("Afvist - log ind først");
            return 0;
        }
    }

    /**
     * setBilletpris Setter en ny billet pris
     *
     * @param billetpris
     */
    public void setBilletpris(int billetpris) {
        if(montørtilstand) {
            this.billetpris = billetpris;
            eventLog.add(new Event("billetpris sat" , billetpris));
        } else {
            eventLog.add(new Event("manglende tilladelse", 13));
        }
        
    }

    /**
     * nulstil Nulstiller antal billeter solgt
     */
    public void nulstil() {
        if (montørtilstand) {
            antalBilletterSolgt = 0;
            eventLog.add(new Event("reset" , 0));
        } else {
            System.out.println("Afvist - log ind først");
            eventLog.add(new Event("manglende tilladelse", 12));
        }
    }

    /**
     * setAntalBilleterSolgt Ændre total antal billeter solgt.
     *
     * @param antalBilletterSolgt
     */
    public void setAntalBilletterSolgt(int antalBilletterSolgt) {
        if (montørtilstand) {
            this.antalBilletterSolgt = antalBilletterSolgt;
        } else {
            System.out.println("Afvist - log ind først.");
        }
    }


    public void montørLog() {
        if(montørtilstand) {
            System.out.println("Her kommer alle logs:");
            System.out.println("");
            eventLog.forEach((element) -> {
                System.out.println(element);
            });
        } else {
            System.out.println("Afvist - log ind først.");
            eventLog.add(new Event("manglende tilladelse", 14));
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
}
