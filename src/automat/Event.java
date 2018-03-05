//Log filer
package automat;

import java.util.Date;
import java.util.UUID;

public class Event {
    private Date Dato = new Date();
    private UUID uuid = UUID.randomUUID();
    private String event;
    private double var1;
    private int var2;
    private String tekst;
    private int eventType;
    
    
    
    public Event(String event, double var, int intVar) {
        this.event = event;
        this.var1 = var;
        this.var2 = intVar;
        switch(event) {
            case "indsæt penge" : {
                eventType = 1;
                tekst = uuid.toString() + " " + Dato.toString() + " Der er indsat " + var +" kr.";
                break;
            } case "penge retur": {
                eventType = 2;
                tekst = uuid.toString() + " " + Dato.toString() + " Der er returneret " + var + " kr.";
                break;
            } case "print billet": {
                eventType = 3;
                tekst = uuid.toString() + " " + Dato.toString() + " Der printes en billet til " + var + " kr. med " + intVar + " zoner.";
                break;
            } case "admin login": {
                eventType = 4;
                tekst = uuid.toString() + " " + Dato.toString() + " Admin logget ind.";
                break;
            } case "admin logud": {
                eventType = 5;
                tekst = uuid.toString() + " " + Dato.toString() + " Admin logget ud.";
                break;
            } case "admin forsøg": {
                eventType = 6;
                tekst = uuid.toString() + " " + Dato.toString() + " Forsøgt Admin login.";
                break;
            } case "reset": {
                eventType = 7;
                tekst = uuid.toString() + " " + Dato.toString() + " Automat reset.";
                break;
            } case "billetpris sat": {
                eventType = 8;
                tekst = uuid.toString() + " " + Dato.toString() + " Billet med " + intVar + " zoner er sat til" + var + " kr.";
                break;
            } case "manglende tilladelse": {
                eventType = 8;
                tekst = uuid.toString() + " " + Dato.toString() + " Der er frsøgt at tilgå montrør funktion ID:" + var;
                break;
            } default: {
                eventType = 0;
                tekst = uuid.toString() + " " + Dato.toString() + " Fejl i LOG!!";
                break;
            }
            
        }
    }
    
    public void printLog() {
        System.out.println(tekst);
    }
    
    public boolean sammenlignUUID (String søg) {
        return uuid.toString().equals(søg);
    }
    
    public double getVar() {
        return var1;
    }
    
    public int getValg() {
        return eventType;
    }
    
    
    
}
