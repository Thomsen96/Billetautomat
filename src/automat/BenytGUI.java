package automat;

import java.awt.EventQueue;
import java.io.IOException;
import javax.swing.JFrame;

public class BenytGUI {

    public static void main(String[] arg) throws IOException, InterruptedException {

        Billetautomat ba = new Billetautomat();
        MainGUI mainGUI = new MainGUI();                                       
        JFrame vindue = new JFrame("Billetautomat v.4.232.9960");               
        
        // Setup GUI'en med værdierne.
        mainGUI.setup(ba);
        
        // Setup vinduet.
        vindue.add(mainGUI);                                                    // vis panelet i vinduet
        vindue.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);               // reagér på luk
        vindue.pack();                                                          // set vinduets stoerrelse
        vindue.setVisible(true);

        // Luk programmet hvis vinduet lukkes
        while (mainGUI.isShowing()) {
            try {
                if(ba.checkForUpdate() == 1) {
                    mainGUI.updateUserGUI(); 
                }
            } catch (IOException ex) {
                System.err.println("Ingen internet forbindelse, og kan derfor ikke opdatere billeter.");
            }
            Thread.sleep(10000);
        }
    }
}
