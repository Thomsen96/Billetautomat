
package automat;

public class MontoerGeneralt extends javax.swing.JPanel {
    
    Billetautomat ba;
    
    public MontoerGeneralt() {
        initComponents();
    }
    
    public void setup(Billetautomat ba) {
        this.ba = ba;
        update();
    }
    
    public void update() {
        txtOutputBalance.setText(String.format("%.2f",ba.getBalance()));
        txtOutputSolgt.setText(String.format("%d", ba.getSolgteBilleter()));
        txtOutputKunder.setText(String.format("%d", ba.getKunder()));
        txtOutputTjent.setText(String.format("%.2f",ba.getTotalTjent()));
        txtStation.setText(ba.getStation());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        txtOutputBalance = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtOutputKunder = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtOutputTjent = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtOutputSolgt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnPrintLog = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtStation = new javax.swing.JTextField();
        btnSetStation = new javax.swing.JButton();

        jLabel2.setText("Balancen er:");

        txtOutputBalance.setEditable(false);

        jLabel3.setText("Antal kunder:");

        txtOutputKunder.setEditable(false);

        jLabel4.setText("Penge tjent:");

        txtOutputTjent.setEditable(false);

        jLabel5.setText("Antal billeter solgt");

        txtOutputSolgt.setEditable(false);

        jLabel1.setText("Udskriv loggen til en fil:");

        btnPrintLog.setText("Udskriv");

        jLabel6.setText("Station:");

        txtStation.setText(" ");

        btnSetStation.setText("Opdater");
        btnSetStation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetStationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtOutputTjent)
                    .addComponent(txtOutputSolgt, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                    .addComponent(btnPrintLog, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                    .addComponent(txtOutputBalance)
                    .addComponent(txtOutputKunder))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtStation, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSetStation)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtOutputBalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtStation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSetStation))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtOutputKunder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtOutputTjent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtOutputSolgt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnPrintLog))
                .addContainerGap(135, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSetStationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetStationActionPerformed
        ba.setStation(txtStation.getText());
    }//GEN-LAST:event_btnSetStationActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPrintLog;
    private javax.swing.JButton btnSetStation;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtOutputBalance;
    private javax.swing.JTextField txtOutputKunder;
    private javax.swing.JTextField txtOutputSolgt;
    private javax.swing.JTextField txtOutputTjent;
    private javax.swing.JTextField txtStation;
    // End of variables declaration//GEN-END:variables
}
