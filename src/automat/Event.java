//Log filer
package automat;

import java.util.Date;
import java.util.UUID;

// test

public class Event {
    private Date Dato = new Date();
    private UUID uuid = UUID.randomUUID();
    private String event;
    private double penge;
    private String billetnavn;
    private int zoner;
    private String tekst;
    private int eventType;
    
    
    /**
     * Konstruktoren opretter en streng med nogle parameter. Ud fra disse parameter
     * kan man finde specifikke events igen.
     * @param event      Brues til at bestemme opbygning af steng.
     * @param penge        Bruges til at holde værdier i forskellige scenarier.
     * @param billetNavn Bruges til at sige hvilken billet der printes.
     * @param zoner      Bruges til at skrive hvor mange zoner der printes.
     */
    public Event(String event, double penge, String billetNavn, int zoner) {
        this.event = event;
        this.penge = penge;
        this.billetnavn = billetNavn;
        this.zoner = zoner;
        
        switch(event) {
            case "insert penge" : {
                eventType = 1;
                tekst = uuid.toString() + " " + Dato.toString() + " Der er indsat " + penge +" kr.";
                break;
            } case "penge retur": {
                eventType = 2;
                tekst = uuid.toString() + " " + Dato.toString() + " Der er returneret " + penge + " kr.";
                break;
            } case "print billet": {
                eventType = 3;
                tekst = uuid.toString() + " " + Dato.toString() + " Der printes en" + billetnavn + " billet til " + penge + " kr. med " + zoner + " zoner.";
                break;
            } case "admin login": {
                eventType = 4;
                tekst = uuid.toString() + " " + Dato.toString() + " Admin logget ind.";
                break;
            } case "admin logud": {
                eventType = 5;
                tekst = uuid.toString() + " " + Dato.toString() + " Admin logget ud.";
                break;
            } case "admin forsoeg": {
                eventType = 6;
                tekst = uuid.toString() + " " + Dato.toString() + " Forsøgt Admin login.";
                break;
            } case "reset": {
                eventType = 7;
                tekst = uuid.toString() + " " + Dato.toString() + " Automat reset.";
                break;
            } case "billetpris sat": {
                eventType = 8;
                tekst = uuid.toString() + " " + Dato.toString() + " Der er oprettet en ny type billet: " + billetNavn + " en zone er sat til " + penge + " kr.";
                break;
            } case "manglende tilladelse": {
                eventType = 8;
                tekst = uuid.toString() + " " + Dato.toString() + " Der er forsøgt at tilgå montoer funktion ID: " + penge;
                break;
            } default: {
                eventType = 0;
                tekst = uuid.toString() + " " + Dato.toString() + " Fejl i LOG!! der var forsøgt at til føje: " + event;
                break;
            }
            
        }
    }
    
    /**
     * Printer denne log.
     */
    public void printLog() {
        System.out.println(tekst);
    }
    
    /**
     * Sammenligner 2 UUID's
     * @param soeg Det UUID man øsner sammenlignet med denne uuid.
     * @return Boelean om det var et match.
     */
    public boolean sammenlignUUID (String soeg) {
        return soeg.equals(uuid.toString());
    }
    
    /**
     * Den værdi der er i "penge" i dette objekt.
     * @return værdi
     */
    public double getValue() {
        return penge;
    }
    
    /**
     * Hvilket ID er dette objekt
     * @return ID på objektet.
     */
    public int getValg() {
        return eventType;
    }
    
    /**
     * 
     * @return UUID'et for dette objekt.
     */
    public UUID getUUID() {
        return uuid;
    }
    
    /**
     * 
     * @return Dato fra dette objekt.
     */
    public Date getDato() {
        return Dato;
    }
    
}
