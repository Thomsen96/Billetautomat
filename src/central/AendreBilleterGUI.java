package central;

import java.io.IOException;
import javax.swing.DefaultListModel;

public class AendreBilleterGUI extends javax.swing.JPanel {

    Central c;
    CentralGUI ejer;
    
    public AendreBilleterGUI() {
        initComponents();
    }

    public void setup(Central c, CentralGUI ejer) {
        this.c = c;
        this.ejer = ejer;
        update();
    }
    
    public void update() {
        updateList(0);
        updateTxt();
    }
    
    public void updateList(int index) {
        DefaultListModel newList = new DefaultListModel();
        for( int i = 0; i < c.billeter.size(); i++) {
            newList.addElement(String.format("%s    -     %s",c.billeter.get(i).getType() ,c.billeter.get(i).getBilletpris() ));
        }
        listBilleter.setModel(newList);
        listBilleter.setSelectedIndex(index);
    }
    
    public void updateTxt() {
        int index = listBilleter.getSelectedIndex();
        String billetnavn = c.billeter.get(index).getType();
        double billetpris = c.billeter.get(index).getBilletpris();
        txtInputBilletnavn.setText(billetnavn);
        txtOutputBilletNavn.setText(billetnavn);
        txtInputPris.setText("" + billetpris);
        txtOutputPris.setText("" + billetpris);
    }    
    
    private void updateBillet() {
        int index = listBilleter.getSelectedIndex();
        c.billeter.get(index).setType(txtInputBilletnavn.getText());
        c.billeter.get(index).setBilletpris(Double.parseDouble(txtInputPris.getText()));
        updateList(index);
        updateTxt();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtOutputBilletNavn = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtInputBilletnavn = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtOutputPris = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtInputPris = new javax.swing.JTextField();
        btnOpdaterBillet = new javax.swing.JButton();
        btnGemFil = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listBilleter = new javax.swing.JList<>();

        jLabel1.setText("Billeter:");

        jLabel2.setText("Valgte billet:");

        txtOutputBilletNavn.setEditable(false);

        jLabel3.setText("Nytnavn på billeten:");

        jLabel4.setText("Før pris:");

        txtOutputPris.setEditable(false);

        jLabel5.setText("Ny pris:");

        btnOpdaterBillet.setText("Opdater Billet");
        btnOpdaterBillet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpdaterBilletActionPerformed(evt);
            }
        });

        btnGemFil.setText("Gem Opdateringer");
        btnGemFil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGemFilActionPerformed(evt);
            }
        });

        listBilleter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                listBilleterMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(listBilleter);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtOutputPris, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtInputBilletnavn)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtInputPris, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtOutputBilletNavn)
                            .addComponent(btnOpdaterBillet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnGemFil, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(251, 251, 251)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 4, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtOutputBilletNavn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtOutputPris, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtInputBilletnavn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtInputPris, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnOpdaterBillet, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(btnGemFil, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnOpdaterBilletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpdaterBilletActionPerformed
        updateBillet();
    }//GEN-LAST:event_btnOpdaterBilletActionPerformed

    private void btnGemFilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGemFilActionPerformed
        try {
            c.skrivFil();
        } catch (IOException ex) {
            System.out.println("central.AendreBilleterGUI.btnGemFilActionPerformed()");
        }
    }//GEN-LAST:event_btnGemFilActionPerformed

    private void listBilleterMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listBilleterMousePressed
        updateTxt();
    }//GEN-LAST:event_listBilleterMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGemFil;
    private javax.swing.JButton btnOpdaterBillet;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listBilleter;
    private javax.swing.JTextField txtInputBilletnavn;
    private javax.swing.JTextField txtInputPris;
    private javax.swing.JTextField txtOutputBilletNavn;
    private javax.swing.JTextField txtOutputPris;
    // End of variables declaration//GEN-END:variables
}
