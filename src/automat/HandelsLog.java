package automat;

import java.util.Date;

/* En klasse der bruges til at gemme data om handel */
public class HandelsLog {

    /**
     * Den transarktions tekst der bilver lavet.
     */
    private String tekst;
    
    /**
     * Konstruktør
     * 
     * @param valg
     * Valg beskriver den tekst der bliver printet.
     * @param penge
     * ind kastede penge.
     */
    public HandelsLog(int valg, double penge) {
        Date netopNu = null;
        switch(valg) {
            
            case 1: {
                tekst = ("** Der er indkastet " + penge + netopNu.toString());
                break;
            }
            default: {
                System.err.println("Fejl i oprettelse af transaktionslog");
            }
        }
    }
    
    /**
     * Printer alle transaktions logge.
     */
    public void printAlle() {
        
    }
}
