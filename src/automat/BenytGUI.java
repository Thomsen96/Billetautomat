package automat;

import java.awt.EventQueue;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class BenytGUI {

    public static void main(String[] arg) throws IOException {

        Billetautomat ba = new Billetautomat();
        MainGUI mainGUI = new MainGUI();                                       
        JFrame vindue = new JFrame("Billetautomat v.4.232.9960");               
        
        mainGUI.setup(ba);
        
        vindue.add(mainGUI);                                                    // vis panelet i vinduet
        vindue.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);               // reagér på luk
        vindue.pack();                                                          // set vinduets stoerrelse
        vindue.setVisible(true);

        // åbn vinduet
        while (mainGUI.isShowing()) {
            try {
                Thread.sleep(10000);
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        
                        try {
                            if(ba.checkForUpdate() == 1) {
                                mainGUI.updateUserGUI(); 
                            }
                        } catch (IOException ex) {
                            Logger.getLogger(BenytGUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
            } catch (InterruptedException ex) {
            }
        }
    }
}
