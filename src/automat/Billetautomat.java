package automat;

import java.util.ArrayList;

/**
 * Model af en simpel billetautomat til enkeltbilletter med én fast pris.
 */
public class Billetautomat {

    
    private int billetpris;    // Prisen for én billet.
    private int balance; // Hvor mange penge kunden p.t. har puttet i automaten
    private int antalBilletterSolgt; // Antal billetter automaten i alt har solgt
    private boolean montørtilstand;
    
    
    
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
        return returbeløb;
    }

    /**
     * montørLogin Bestemmer montør tilstand ud fra login streng.
     *
     * @param String adgangskode
     */
    void montørLogin(String adgangskode) {
        if ("1234".equals(adgangskode)) {
            montørtilstand = true;
            System.out.println("Montørtilstand aktiveret");
            System.out.println("Du kan nu angive billetpris");
        } else {
            montørtilstand = false;
            System.out.println("Montørtilstand deaktiveret");
        }
    }

    /**
     * getTotal Montør funktion
     *
     * @return penge tjent.
     */
    public int getTotal() {
        if (montørtilstand) {
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
        this.billetpris = billetpris;
    }

    /**
     * nulstil Nulstiller antal billeter solgt
     */
    public void nulstil() {
        if (montørtilstand) {
            antalBilletterSolgt = 0;
        } else {
            System.out.println("Afvist - log ind først");
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
            
        } else {
            System.out.println("Afvist - log ind først.");
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
