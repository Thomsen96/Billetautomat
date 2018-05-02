
package central;

import automat.Billettype;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Central {
    
    ArrayList<Billettype> billeter = new ArrayList<>();     // Holder styr på alle billettyper.
    List<String> linjer;
    int billetVersion;


    public Central() throws IOException {
        if ( pullBilleter() == 1) {
            linjer = Files.readAllLines(Paths.get("src/central/Billeter.txt"), Charset.defaultCharset());
        
            linjer = Files.readAllLines(Paths.get("src/central/Billeter.txt"), Charset.defaultCharset());
            billetVersion = Integer.parseInt(linjer.get(0));
            for( int i = 1; i < linjer.size(); i++) {
            
                String lin = linjer.get(i);
                int split = lin.indexOf("¤");
                String billetnavn = lin.substring( 0 , split);
                double billetpris = Double.parseDouble(lin.substring(split + 1));

                billeter.add(new Billettype(billetnavn, billetpris));
            }
        } else {
            System.out.println("Fejl i opstart!!");
        }
    }
    
    public void skrivFil() throws IOException {
        
        FileWriter fil = new FileWriter("src/central/Billeter.txt");
        PrintWriter ud = new PrintWriter(fil);
        ud.println(billetVersion + 1);
        for (int i=0; i<billeter.size(); i++) {
            ud.println(billeter.get(i).getType() + "¤" + billeter.get(i).getBilletpris());
        }
        ud.close();
        
        pushBilleter();
    }
    
    private void pushBilleter() throws IOException {
        
        linjer = Files.readAllLines(Paths.get("src/central/Billeter.txt"), Charset.defaultCharset());
        String data = "";
        for(int i = 0 ; i < linjer.size(); i++) {
            data += linjer.get(i) + "\n";
        }
        
        datakommunikation.FtpForbindelse FTP = new datakommunikation.FtpForbindelse();
        FTP.forbind("ubuntu4.saluton.dk","oop_jonas","java1234");
       
        FTP.sendTekst("STOR Billeter.txt", data);
    }
    
    private int pullBilleter() throws IOException {
        datakommunikation.FtpForbindelse FTP = new datakommunikation.FtpForbindelse();

        FTP.forbind("ubuntu4.saluton.dk","oop_jonas","java1234");

        String indhold = FTP.modtagTekst("RETR Billeter.txt");

        FileWriter fil = new FileWriter("src/central/Billeter.txt");
        PrintWriter ud = new PrintWriter(fil);
        ud.print(indhold);
        ud.close();
        return 1;
    }
}
