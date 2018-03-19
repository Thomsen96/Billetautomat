package automat;

import javax.swing.JFrame;

public class BenytGUI {

    public static void main(String[] arg) {
        
        Billetautomat ba = new Billetautomat();
        
        UserGUI uGUI = new UserGUI();                                           // opret panelet
        
        uGUI.ba = ba;
        
        uGUI.setupBilletChoice();

        JFrame vindue = new JFrame("Billetautomat v.4.232.9960");               // opret et vindue på skærmen
        vindue.add(uGUI);                                                       // vis panelet i vinduet

        vindue.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);               // reagér på luk
        vindue.pack();                                                          // sæt vinduets størrelse
        vindue.setVisible(true);                                                // åbn vinduet
    }
}