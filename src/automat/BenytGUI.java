package automat;

import java.awt.EventQueue;
import java.io.IOException;
import javax.swing.JFrame;

public class BenytGUI {

    public static void main(String[] arg) throws IOException {

        Billetautomat ba = new Billetautomat();

        MainGUI mainGUI = new MainGUI();                                           // opret panelet
        JFrame vindue = new JFrame("Billetautomat v.4.232.9960");               // opret et vindue på skærmen

        mainGUI.setup(ba);

        vindue.add(mainGUI);                                                       // vis panelet i vinduet

        vindue.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);               // reagér på luk
        vindue.pack();                                                          // sæt vinduets størrelse
        vindue.setVisible(true);

        // åbn vinduet
        while (mainGUI.isShowing()) {
            try {
                Thread.sleep(5000);

                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        
                        mainGUI.updateUserGUI();
                    }
                });
            } catch (InterruptedException ex) {

            }

        }
    }
}
