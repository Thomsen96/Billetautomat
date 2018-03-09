package automat;

import java.util.Scanner;

/**
 * Kundens brugergraenseflade for koeb og udskivning a billetter.
 */
public class BenytBilletautomat {

    public static void main(String[] arg) {
        Billetautomat automat = new Billetautomat();
        Scanner tastatur = new java.util.Scanner(System.in);  // forbered
        
        System.out.println("BenytBilletautomat version 3");
        System.out.println();

        while (true) {
            System.out.println("-----------------------------------------------");
            automat.udskrivBilletTyper();
            System.out.println("\nBalancen er på " + automat.getBalance() + " kroner");
            System.out.println();
            System.out.println("Tast 1 for at indbetale penge");
            System.out.println("Tast 2 for at udskrive din billet");
            System.out.println("Tast 3 for at få returpengene");
            System.out.println("Tast 4 for at se alle  billettyper");
            System.out.println();
            System.out.println("Tast 10 for at logge ind som montør");

            if (automat.erMontoer()) {
                System.out.println("Tast 11 for at se status (montør)");
                System.out.println("Tast 12 for at nulstille (montør)");
                System.out.println("Tast 13 for at sætte billetpris (montør)");
                System.out.println("Tast 14 for at printe log på skærmen (montør)");
                System.out.println("Tast 15 for at logge ud af montørtilstand (montør)");
            }
            
            System.out.println("-----------------------------------------------");
            
            System.out.println("Menu valg: ");
            int valg = tastatur.nextInt();
            switch (valg) {
                case 1: {
                    System.out.print("Skriv beløb: ");
                    double beloeb = tastatur.nextDouble();
                    automat.indsaetPenge(beloeb);
                    break;
                }
                case 2: {                                                       // Der skal printes en liste af forskellige billet typer.
                    automat.udskrivBilletTyper();
                    System.out.print("Indtast hvilken type billet du ønsker: ");
                    int type = tastatur.nextInt() - 1;
                    System.out.print("\nIndtast ønskede zone antal: ");
                    int zoner = tastatur.nextInt();
                    if(zoner>0 && zoner<10){
                        automat.udskrivBillet(type, zoner);
                    }
                    else{
                        System.out.println("En billet skal have et antal zoner mellem 0 og 10.");
                    }
                    break;
                }
                case 3: {
                    double beloeb = automat.returpenge();
                    System.out.println("Du fik " + beloeb + " retur retur");
                    break;
                }
                case 4: {
                    automat.udskrivBilletTyper();
                    break;
                }
                case 10: {
                    // Her logger man ind i montoer tilstand
                    System.out.print("Skriv kode: ");
                    String kode = tastatur.next();
                    automat.montoerLogin(kode);
                    break;
                }
                case 11: {
                    if (automat.erMontoer()) {
                        System.out.println("Antal billetter solgt: " + automat.getAntalBilletterSolgt());
                        System.out.println("Total indkomst: " + automat.getTotal() + " kr");
                    } else {
                        System.out.println("Afvist - Log ind først.");
                    }
                    break;
                }
                case 12: {
                    if (automat.erMontoer()) {
                        automat.nulstil();
                    } else {
                        System.out.println("Afvist - Log ind først.");
                    }
                    break;
                }
                case 13: {
                    if (automat.erMontoer()) {
                        System.out.print("Hvilken billet skal ændres? ");
                        String inType = tastatur.next();
                        System.out.print("\nHvad skal en zone koste? ");
                        double inBeloeb = tastatur.nextDouble();
                        if(inBeloeb >= 0){
                            automat.setBilletpris(inType, inBeloeb);
                        }
                        else{
                            System.out.println("En billet kan ikke have negativ pris.");
                        }
                    } else {
                        System.out.println("Afvist - Log ind først.");
                    }
                    break;
                }
                case 14: {
                    // Her printer man loggen
                    if (automat.erMontoer()) {
                        System.out.println( "Tryk 1 for at printe alle.\n"
                                          + "Tast 2 for at søge på UUID.\n"
                                          + "Tast 3 for at søge på tilbagebetalinger.\n"
                                          + "Tast 4 for at søge på indsatte penge.");
                        int tast = tastatur.nextInt();
                        switch(tast) {
                            case 1: {
                                automat.montoerLog();
                                break;
                            } case 2: {
                                System.out.print("Indtast UUID: ");
                                String soeg = tastatur.next();
                                automat.montoerFindUUID(soeg);
                                break;
                            } case 3: {
                                 System.out.println("Søg efter tilbagebetalinger.");
                                System.out.print("Tryk O hvis du vil søge over eller lig med beloebet, og U hvis du vil søge under eller lig med: ");
                                String underOver = tastatur.next();
                                System.out.print("Indtast det beløb du vil søge efter: ");
                                double beloeb = tastatur.nextDouble();
                                automat.montoerFindTilbageBetalinger(beloeb, underOver);
                                break;
                            } case 4: {
                                System.out.println("Soeg efter indbetalinger.");
                                System.out.print("Tryk O hvis du vil søge over eller lig med beloebet, og U hvis du vil søge under eller lig med: ");
                                String underOver = tastatur.next();
                                System.out.print("Indtast det beløb du vil søge efter: ");
                                double beloeb = tastatur.nextDouble();
                                automat.montoerFindIndsattePenge(beloeb, underOver);
                                break;
                            }
                        }
                    } else {
                        System.out.println("Afvist - Log ind først.");
                    }
                    
                    break;
                }
                case 15: {
                    // Her logger man ud fra montoer tilstand
                    automat.montoerLogin("");
                    break;
                }
                default: {
                    System.out.println("Ugyldigt valg, prøv igen");
                    break;
                }
            }
        }
    }
}
