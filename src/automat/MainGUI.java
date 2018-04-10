/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automat;

import javax.swing.JFrame;

/**
 *
 * @author Jonas
 */
public class MainGUI extends javax.swing.JPanel {
    
    Billetautomat ba;
    MainGUI ejer = this;
    
      
    
    /**
     * Creates new form MainGUI
     */
    public MainGUI() {
        initComponents();        
    }
    
    void setBa(Billetautomat ba) {
        this.ba = ba;
        koebGUI1.setup(ba, ejer);
        userGUI1.setup(ba, ejer);
        montoerGUI1.setup(ba, ejer);
    }
    
    
    
    
    public void setTab(int index) {
        jTabbedPane1.setSelectedIndex(index);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        userGUI1 = new automat.UserGUI();
        koebGUI1 = new automat.KoebGUI();
        montoerGUI1 = new automat.MontoerGUI();

        jTabbedPane1.addTab("tab1", userGUI1);
        jTabbedPane1.addTab("tab2", koebGUI1);
        jTabbedPane1.addTab("tab3", montoerGUI1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane jTabbedPane1;
    private automat.KoebGUI koebGUI1;
    private automat.MontoerGUI montoerGUI1;
    private automat.UserGUI userGUI1;
    // End of variables declaration//GEN-END:variables

}