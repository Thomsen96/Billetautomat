package automat;

import javax.swing.JFrame;

public class BenytGUI {

    public static void main(String[] arg) {
        
        Billetautomat ba = new Billetautomat();
        
        UserGUI uGUI = new UserGUI();                                           // opret panelet
        uGUI.ba = ba;
        
        
        uGUI.setupBilletChoice();

        JFrame UserGUI = new JFrame("Billetautomat v.4.232.9960");               // opret et vindue på skærmen
        uGUI.userGUI = UserGUI;
        UserGUI.add(uGUI);                                                       // vis panelet i vinduet

        UserGUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);               // reagér på luk
        UserGUI.pack();                                                          // sæt vinduets størrelse
        UserGUI.setVisible(true);      
        
        // åbn vinduet
        

        
    }
}
