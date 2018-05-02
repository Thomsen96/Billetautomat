package central;
public class CentralGUI extends javax.swing.JPanel {
    
    Central c;
    CentralGUI ejer = this;
    
    
    public CentralGUI() {
        initComponents();
    }
    
    public void setup(Central c) {
        this.c = c;
        AendreBillerterGUI1.setup(c, ejer);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();
        AendreBillerterGUI1 = new central.AendreBilleterGUI();

        jTabbedPane2.addTab("tab1", AendreBillerterGUI1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private central.AendreBilleterGUI AendreBillerterGUI1;
    private javax.swing.JTabbedPane jTabbedPane2;
    // End of variables declaration//GEN-END:variables

}
