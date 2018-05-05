package automat;

public class MainGUI extends javax.swing.JPanel {
    
    Billetautomat ba;

    public MainGUI() {
        initComponents(); 
        
        // Denne funktion er givet af Jacob Nordfalk
        jTabbedPane1.setUI(new javax.swing.plaf.basic.BasicTabbedPaneUI() {
			protected int calculateTabAreaHeight(int t, int h, int m) {
				return 0;
			}
		});
    }
    
    /**
     * Denne funktion bliver brugt til at oprette GUI vinduet og sikre at alle de
     * forskellige paneler har de rigtige rettigheder og egenskaber.
     * @param ba Instansen af billetautomaten.
     * this Er denne GUI, og det gør at de alle sammen har mulighed for at tilgå funktionerne i denne fil.
     */
    public void setup(Billetautomat ba) {
        this.ba = ba;
        koebGUI1.setup(ba, this);
        userGUI1.setup(ba, this);
        montoerLoginGUI1.setup(ba, this);
        montoerGUI1.setup(ba, this);
    }
    
    /**
     * Opdatere UserGUI's interface for brugeren.
     * - Text
     */
    public void updateUserGUI() {
        userGUI1.update();
        userGUI1.updateBilletValg();
    }
    
    public void updateMontoerGUI() {
        montoerGUI1.updateMontoerGUI();
    }
    
    /**
     * Denne funktion bruges til at skifte imellem skærmbilleder.
     * Og den opdatere alle siderne.
     * @param index Det index man ønsker at skifte til.
     */
    public void setTab(int index) {
        jTabbedPane1.setSelectedIndex(index);
        userGUI1.update();
        koebGUI1.update();
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        userGUI1 = new automat.UserGUI();
        koebGUI1 = new automat.KoebGUI();
        montoerLoginGUI1 = new automat.montoerLoginGUI();
        montoerGUI1 = new automat.MontoerGUI();

        jTabbedPane1.setEnabled(false);
        jTabbedPane1.addTab("MainGUI", userGUI1);
        jTabbedPane1.addTab("KoebGUI", koebGUI1);
        jTabbedPane1.addTab("MontoerLoginGUI", montoerLoginGUI1);
        jTabbedPane1.addTab("MontoerGUI", montoerGUI1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane jTabbedPane1;
    private automat.KoebGUI koebGUI1;
    private automat.MontoerGUI montoerGUI1;
    private automat.montoerLoginGUI montoerLoginGUI1;
    private automat.UserGUI userGUI1;
    // End of variables declaration//GEN-END:variables

}
