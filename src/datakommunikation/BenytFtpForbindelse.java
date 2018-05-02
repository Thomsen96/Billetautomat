package datakommunikation;
public class BenytFtpForbindelse {
    public static void main(String[] a) throws Exception {
        FtpForbindelse f = new FtpForbindelse();
        // bemærk - vær altid MEGET FORSIGTIG med at angive adgangskoder i en fil!!
        f.forbind("ubuntu4.saluton.dk","oop_jonas","java1234");

        //f.sendKommando("HELP");    // få liste over kommandoer som tjenesten kender
        f.modtagTekst("LIST");     // få liste over filer på værten

        String indhold = "";
        //f.sendTekst("STOR fil.txt", indhold);       // gem en tekstfil på værten

        indhold = f.modtagTekst("RETR /home/oop_jonas/Billeter.txt");    // hent filen igen 
        System.out.println("Fil hentet med indholdet: "+indhold);
    }
}