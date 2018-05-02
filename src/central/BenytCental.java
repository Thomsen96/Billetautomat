
package central;

import java.awt.EventQueue;
import java.io.IOException;
import javax.swing.JFrame;

public class BenytCental {
    public static void main(String[] args) throws IOException {
        
        Central c = new Central();
        CentralGUI centralGUI = new CentralGUI();                                       
        JFrame vindue = new JFrame("Cental v.2.223.0453");  
        
        centralGUI.setup(c);
        
 
        vindue.add(centralGUI);                                                    // vis panelet i vinduet
        vindue.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);               // reagér på luk
        vindue.pack();                                                          // set vinduets stoerrelse
        vindue.setVisible(true);

        // åbn vinduet
        while (centralGUI.isShowing()) {
            try {
                Thread.sleep(1000);
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                       //ingen ting..
                    }
                });
            } catch (InterruptedException ex) {
            }
        }
    }
}
    
