package automat;
public class MontoerAendreBilleter extends javax.swing.JPanel {
    
    Billetautomat ba;
    MainGUI ejer;
    
    public MontoerAendreBilleter() {
        initComponents();
    }

    public void setup(Billetautomat ba, MainGUI ejer) {
        this.ba = ba;
        this.ejer = ejer;
        updateBilletValg();
        
    }
    
    public void update() {
        txtOutputBilletNavn.setText(String.format("%s",ba.billeter.get(billetValg.getSelectedIndex()).getType()));
        txtOutputBilletPris.setText(String.format("%.2f",ba.billeter.get(billetValg.getSelectedIndex()).getBilletpris()));    
        
        txtInputBilletnavn.setText(String.format("%s",ba.billeter.get(billetValg.getSelectedIndex()).getType()));
        jsInputBilletPris.setValue((Double)ba.billeter.get(billetValg.getSelectedIndex()).getBilletpris());
        
    }
    
    public void updateBilletValg() { 
        billetValg.removeAll();
        for( int i = 0; i < ba.billeter.size(); i++) {
            billetValg.addItem(String.format("%-20s",ba.billeter.get(i).getType()));
        }
        billetValg.addItem(String.format("%-20s" , "Ny billet"));
        update();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        billetValg = new java.awt.Choice();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtOutputBilletNavn = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtInputBilletnavn = new javax.swing.JTextField();
        txtOutputBilletPris = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jsInputBilletPris = new javax.swing.JSpinner();
        btnFjernBillet = new javax.swing.JButton();
        btnOpdaterBillet = new javax.swing.JButton();

        billetValg.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                billetValgItemStateChanged(evt);
            }
        });

        jLabel16.setText("Valgte billet:");

        jLabel17.setText("Nuværende billetnavn:");

        txtOutputBilletNavn.setEditable(false);

        jLabel18.setText("Nyt billetnavn:");

        txtOutputBilletPris.setEditable(false);

        jLabel19.setText("Nuværende zone pris:");

        jLabel20.setText("Ny billet pris:");

        jsInputBilletPris.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));

        btnFjernBillet.setText("Fjern billet");
        btnFjernBillet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFjernBilletActionPerformed(evt);
            }
        });

        btnOpdaterBillet.setText("Opdater");
        btnOpdaterBillet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpdaterBilletActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtOutputBilletNavn)
                    .addComponent(billetValg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtInputBilletnavn, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jsInputBilletPris)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel19))
                                .addGap(0, 380, Short.MAX_VALUE))
                            .addComponent(txtOutputBilletPris))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnOpdaterBillet, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                            .addComponent(btnFjernBillet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jLabel16)
                .addGap(5, 5, 5)
                .addComponent(billetValg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtOutputBilletNavn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtInputBilletnavn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtOutputBilletPris, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnFjernBillet, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jsInputBilletPris, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnOpdaterBillet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(81, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void billetValgItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_billetValgItemStateChanged
        if (billetValg.getSelectedIndex() > ba.billeter.size() - 1) {
            txtOutputBilletNavn.setText(billetValg.getSelectedItem());
            txtOutputBilletPris.setText("10.00");
            txtInputBilletnavn.setText(billetValg.getSelectedItem());
            jsInputBilletPris.setValue(10);
        } else {
            update();
        }
    }//GEN-LAST:event_billetValgItemStateChanged

    private void btnFjernBilletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFjernBilletActionPerformed
        ba.montoerFjernBillet(billetValg.getSelectedIndex());
        updateBilletValg();
        billetValg.select(0);
        ejer.updateUserGUI();
    }//GEN-LAST:event_btnFjernBilletActionPerformed

    private void btnOpdaterBilletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpdaterBilletActionPerformed
        if ( billetValg.getSelectedIndex() > ba.billeter.size() - 1) {
            ba.billeter.add(new Billettype(txtInputBilletnavn.getText(), (double)jsInputBilletPris.getValue()));
        } else {
            ba.montoerOpdaterBillet(billetValg.getSelectedIndex(), txtInputBilletnavn.getText(), (Double)jsInputBilletPris.getValue());
            updateBilletValg();

        }
        ejer.updateUserGUI();
    }//GEN-LAST:event_btnOpdaterBilletActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public java.awt.Choice billetValg;
    private javax.swing.JButton btnFjernBillet;
    private javax.swing.JButton btnOpdaterBillet;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JSpinner jsInputBilletPris;
    private javax.swing.JTextField txtInputBilletnavn;
    private javax.swing.JTextField txtOutputBilletNavn;
    private javax.swing.JTextField txtOutputBilletPris;
    // End of variables declaration//GEN-END:variables
}
