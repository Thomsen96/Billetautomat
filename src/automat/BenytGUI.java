package automat;

import java.awt.EventQueue;
import java.io.IOException;
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
                Thread.sleep(5000);
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        // Handle billet update
                    }
                });
            } catch (InterruptedException ex) {
            }
        }
    }
}
