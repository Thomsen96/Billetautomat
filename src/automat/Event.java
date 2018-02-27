
package automat;

import java.util.Date;

public class Event {
    private Date Dato;
    private String event;
    private double var;
    private String tekst;
    private int valg;
    
    public Event(String event, double var) {
        Dato = new Date();
        this.event = event;
        switch(event) {
            case "indsæt penge" : {
                valg = 1;
                tekst = Dato.toString() + "Der er indsat " + var +" kr.";
                break;
            } case "penge retur": {
                valg = 2;
                tekst = Dato.toString() + "Der er returneret" + var + " kr.";
                break;
            } case "print billet": {
                valg = 3;
                tekst = Dato.toString() + "Der printes en billet til " + var + " kr.";
                break;
            } case "admin login": {
                valg = 4;
                tekst = Dato.toString() + "Admin logget ind.";
                break;
            } case "admin logud": {
                valg = 5;
                tekst = Dato.toString() + "Admin logget ud.";
                break;
            } case "admin forsøg": {
                valg = 6;
                tekst = Dato.toString() + "Forsøgt Admin login.";
                break;
            } case "reset": {
                valg = 7;
                tekst = Dato.toString() + "Automat reset.";
                break;
            } case "billetpris sat": {
                valg = 8;
                tekst = Dato.toString() + "Billetpris er sat til" + var + " kr.";
                break;
            } default: {
                valg = 0;
                tekst = Dato.toString() + "Fejl i LOG!!";
                break;
            }
            
        }
    }
}
