package automat;
public class MontoerSoegninger extends javax.swing.JPanel {
    
    Billetautomat ba;
    
    public MontoerSoegninger() {
        initComponents();
    }
    
    public void setup(Billetautomat ba) {
        this.ba = ba;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSpinner_ind_venstre = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        jSpinner_ind_h = new javax.swing.JSpinner();
        btnIndSearch = new javax.swing.JButton();
        btnReturSearch = new javax.swing.JButton();
        jSpinner_retur_h = new javax.swing.JSpinner();
        jLabel11 = new javax.swing.JLabel();
        jSpinner_retur_venstre = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jSpinner_penge_venstre = new javax.swing.JSpinner();
        jLabel14 = new javax.swing.JLabel();
        jSpinner_penge_h = new javax.swing.JSpinner();
        btnPengeSearch = new javax.swing.JButton();
        btnUUIDSearch = new javax.swing.JButton();
        txtInputUUID = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Indbetalinger:");

        jLabel7.setText("Mellem:");

        jSpinner_ind_venstre.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 10.0d));

        jLabel8.setText("og");

        jSpinner_ind_h.setModel(new javax.swing.SpinnerNumberModel(1000.0d, 0.0d, null, 10.0d));

        btnIndSearch.setText("Soeg");
        btnIndSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIndSearchActionPerformed(evt);
            }
        });

        btnReturSearch.setText("Soeg");
        btnReturSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturSearchActionPerformed(evt);
            }
        });

        jSpinner_retur_h.setModel(new javax.swing.SpinnerNumberModel(1000.0d, 0.0d, null, 10.0d));

        jLabel11.setText("og");

        jSpinner_retur_venstre.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 10.0d));

        jLabel10.setText("Mellem:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Returpenge");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Penge:");

        jLabel13.setText("Mellem:");

        jSpinner_penge_venstre.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 10.0d));

        jLabel14.setText("og");

        jSpinner_penge_h.setModel(new javax.swing.SpinnerNumberModel(1000.0d, 0.0d, null, 10.0d));

        btnPengeSearch.setText("Soeg");
        btnPengeSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPengeSearchActionPerformed(evt);
            }
        });

        btnUUIDSearch.setText("Soeg");
        btnUUIDSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUUIDSearchActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("UUID:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSpinner_ind_venstre, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSpinner_ind_h, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnIndSearch))
                    .addComponent(jLabel9)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSpinner_retur_venstre, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSpinner_retur_h, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnReturSearch))
                    .addComponent(jLabel12)
                    .addComponent(jLabel15)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtInputUUID, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSpinner_penge_venstre, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSpinner_penge_h, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnPengeSearch)
                            .addComponent(btnUUIDSearch))))
                .addContainerGap(377, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(btnIndSearch)
                    .addComponent(jSpinner_ind_venstre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner_ind_h, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(btnReturSearch)
                    .addComponent(jSpinner_retur_venstre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner_retur_h, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(btnPengeSearch)
                    .addComponent(jSpinner_penge_venstre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner_penge_h, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtInputUUID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUUIDSearch))
                .addContainerGap(112, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnIndSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIndSearchActionPerformed
        double venstre = (Double)jSpinner_ind_venstre.getValue();
        double hoejre = (Double)jSpinner_ind_h.getValue();
        ba.montoerFindIndsattePengeMellem(venstre, hoejre);
    }//GEN-LAST:event_btnIndSearchActionPerformed

    private void btnReturSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturSearchActionPerformed
        double venstre = (Double)jSpinner_retur_venstre.getValue();
        double hoejre = (Double)jSpinner_retur_h.getValue();
        ba.montoerFindReturPengeMellem(venstre, hoejre);
    }//GEN-LAST:event_btnReturSearchActionPerformed

    private void btnPengeSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPengeSearchActionPerformed
        double venstre = (Double)jSpinner_penge_venstre.getValue();
        double hoejre = (Double)jSpinner_penge_h.getValue();
        ba.montoerFindPengeMellem(venstre, hoejre);
    }//GEN-LAST:event_btnPengeSearchActionPerformed

    private void btnUUIDSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUUIDSearchActionPerformed
        ba.montoerFindUUID(txtInputUUID.getText());
    }//GEN-LAST:event_btnUUIDSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIndSearch;
    private javax.swing.JButton btnPengeSearch;
    private javax.swing.JButton btnReturSearch;
    private javax.swing.JButton btnUUIDSearch;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSpinner jSpinner_ind_h;
    private javax.swing.JSpinner jSpinner_ind_venstre;
    private javax.swing.JSpinner jSpinner_penge_h;
    private javax.swing.JSpinner jSpinner_penge_venstre;
    private javax.swing.JSpinner jSpinner_retur_h;
    private javax.swing.JSpinner jSpinner_retur_venstre;
    private javax.swing.JTextField txtInputUUID;
    // End of variables declaration//GEN-END:variables
}
