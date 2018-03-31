package automat;

import javax.swing.JFrame;

public class BenytGUI {

    public static void main(String[] arg) {
        
        Billetautomat ba = new Billetautomat();
        
        
        
        
        
        UserGUI uGUI = new UserGUI();                                           // opret panelet
        
        uGUI.ba = ba;
        
        uGUI.setupBilletChoice();

        JFrame vindueUser = new JFrame("Billetautomat v.4.232.9960");               // opret et vindue på skærmen
        vindueUser.add(uGUI);                                                       // vis panelet i vinduet

        vindueUser.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);               // reagér på luk
        vindueUser.pack();                                                          // sæt vinduets størrelse
        vindueUser.setVisible(true);                                                // åbn vinduet
        
        
        
        
    }
}
