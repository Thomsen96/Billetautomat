
package automat;

import java.io.IOException;

public class MontoerGeneralt extends javax.swing.JPanel {
    
    Billetautomat ba;
    
    public MontoerGeneralt() {
        initComponents();
    }
    
    public void setup(Billetautomat ba) {
        this.ba = ba;
    }
    
    public void update() {
        txtOutputBalance.setText(String.format("%.2f",ba.getBalance()));
        txtOutputSolgt.setText(String.format("%d", ba.montoerGetAntalBilletterSolgt()));
        txtOutputKunder.setText(String.format("%d", ba.getKunder()));
        txtOutputTjent.setText(String.format("%.2f",ba.montoerGetTotal()));
        txtStation.setText(ba.getStationNavn());
        txtStationID.setText(ba.getStationiD());
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
        jLabel7 = new javax.swing.JLabel();
        txtStationID = new javax.swing.JTextField();

        jLabel2.setText("Balancen er:");

        txtOutputBalance.setEditable(false);

        jLabel3.setText("Antal kunder:");

        txtOutputKunder.setEditable(false);

        jLabel4.setText("Penge tjent:");

        txtOutputTjent.setEditable(false);

        jLabel5.setText("Antal billeter solgt");

        txtOutputSolgt.setEditable(false);

        jLabel1.setText("Udskriv loggen output:");

        btnPrintLog.setText("Udskriv");
        btnPrintLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintLogActionPerformed(evt);
            }
        });

        jLabel6.setText("Station:");

        txtStation.setText(" ");

        btnSetStation.setText("Opdater");
        btnSetStation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetStationActionPerformed(evt);
            }
        });

        jLabel7.setText("iD:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtOutputSolgt, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                    .addComponent(btnPrintLog, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                    .addComponent(txtOutputBalance)
                    .addComponent(txtOutputKunder)
                    .addComponent(txtOutputTjent))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtStation, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtStationID, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSetStation)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtOutputBalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(txtStation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtOutputKunder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(txtStationID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnSetStation, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOutputSolgt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtOutputTjent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnPrintLog))
                .addContainerGap(135, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSetStationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetStationActionPerformed
        try {
            ba.setAutomat(txtStation.getText(), txtStationID.getText());
        } catch (IOException ex) {
            System.out.println("automat.MontoerGeneralt.btnSetStationActionPerformed()");
        }
    }//GEN-LAST:event_btnSetStationActionPerformed

    private void btnPrintLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintLogActionPerformed
        ba.montoerPrintLogs();
    }//GEN-LAST:event_btnPrintLogActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPrintLog;
    private javax.swing.JButton btnSetStation;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtOutputBalance;
    private javax.swing.JTextField txtOutputKunder;
    private javax.swing.JTextField txtOutputSolgt;
    private javax.swing.JTextField txtOutputTjent;
    private javax.swing.JTextField txtStation;
    private javax.swing.JTextField txtStationID;
    // End of variables declaration//GEN-END:variables
}
