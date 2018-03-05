package automat;

import java.util.Scanner;

/**
 * Kundens brugergrænseflade for køb og udskivning a billetter.
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
            System.out.println("Balancen er på " + automat.getBalance() + " kroner");
            System.out.println();
            System.out.println("Tast 1 for at indbetale penge");
            System.out.println("Tast 2 for at udskrive din billet");
            System.out.println("Tast 3 for at få returpengene");
            System.out.println("Tast 4 for at se alle  billettyper");
            System.out.println();
            System.out.println("Tast 10 for at logge ind som montør");

            if (automat.erMontør()) {
                System.out.println("Tast 11 for at se status (montør)");
                System.out.println("Tast 12 for at nulstille (montør)");
                System.out.println("Tast 13 for at sætte billetpris (montør)");
                System.out.println("Tast 14 for at printe log på skærmen");
                System.out.println("Tast 15 for at logge ud af montørtilstand");
            }

            int valg = tastatur.nextInt();
            tastatur.nextLine();
            switch (valg) {
                case 1: {
                    System.out.print("Skriv beløb: ");
                    int beløb = tastatur.nextInt();
                    automat.indsætPenge(beløb);
                    break;
                }
                case 2: {
                    System.out.print("Indtast zoneantal: ");
                    int zoner = tastatur.nextInt();
                    automat.udskrivBillet(zoner);
                    break;
                }
                case 3: {
                    double beløb = automat.returpenge();
                    System.out.println("Du fik " + beløb + " retur retur");
                    break;
                }
                case 4: {
                    automat.udskrivBilletTyper();
                    break;
                }
                case 10: {
                    // Her logger man ind i montør tilstand
                    System.out.print("Skriv kode: ");
                    String kode = tastatur.next();
                    automat.montørLogin(kode);
                    break;
                }
                case 11: {
                    if (automat.erMontør()) {
                        System.out.println("Antal billetter solgt: " + automat.getAntalBilletterSolgt());
                        System.out.println("Total indkomst: " + automat.getTotal() + " kr");
                    } else {
                        System.out.println("Afvist - Log ind først.");
                    }
                    break;
                }
                case 12: {
                    if (automat.erMontør()) {
                        automat.nulstil();
                    } else {
                        System.out.println("Afvist - Log ind først.");
                    }
                    break;
                }
                case 13: {
                    if (automat.erMontør()) {
                        System.out.print("Hvilken zone skal ændres? ");
                        int zone = tastatur.nextInt();
                        System.out.print("\nSkriv beløb: ");
                        double beløb = tastatur.nextDouble();
                        automat.setBilletpris(beløb, zone);
                    } else {
                        System.out.println("Afvist - Log ind først.");
                    }
                    break;
                }
                case 14: {
                    // Her printer man loggen
                    if (automat.erMontør()) {
                        System.out.println( "Tryk 1 for at printe alle.\n"
                                          + "Tast 2 for at søge på UUID.\n"
                                          + "Tast 3 for at søge på tilbagebetalinger.\n"
                                          + "Tast 4 for at søge på indsatte penge.");
                        int tast = tastatur.nextInt();
                        switch(tast) {
                            case 1: {
                                automat.montørLog();
                                break;
                            } case 2: {
                                System.out.print("Indtast UUID: ");
                                String søg = tastatur.next();
                                automat.montørFindUUID(søg);
                                break;
                            } case 3: {
                                 System.out.println("Søg efter tilbagebetalinger.");
                                System.out.print("Tryk O hvis du vil søge over eller lig med beløbet, og U hvis du vil søge under eller lig med: ");
                                String underOver = tastatur.next();
                                System.out.print("Indtast det beløb du vil søge efter: ");
                                double beløb = tastatur.nextDouble();
                                automat.montørFindTilbageBetalinger(beløb, underOver);
                                break;
                            } case 4: {
                                System.out.println("Søg efter indbetalinger.");
                                System.out.print("Tryk O hvis du vil søge over eller lig med beløbet, og U hvis du vil søge under eller lig med: ");
                                String underOver = tastatur.next();
                                System.out.print("Indtast det beløb du vil søge efter: ");
                                double beløb = tastatur.nextDouble();
                                automat.montørFindIndsattePenge(beløb, underOver);
                                break;
                            }
                        }
                    } else {
                        System.out.println("Afvist - Log ind først.");
                    }
                    
                    break;
                }
                case 15: {
                    // Her logger man ud fra montør tilstand
                    automat.montørLogin("");
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
