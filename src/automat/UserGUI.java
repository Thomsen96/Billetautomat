package automat;

import javax.swing.DefaultListModel;

public class UserGUI extends javax.swing.JPanel {
    Billetautomat ba;
    MainGUI ejer;

    public UserGUI() {
        initComponents();
        
        
    }
    public void setup(Billetautomat ba, MainGUI mainGUI) {
        this.ba = ba;
        ejer = mainGUI;
        updateBilletValg();
        update();
    }

    
    public void update(){
        updateKurv();
        updateOutput();
    }
    
    public void updateBilletValg() {
        billetValg.removeAll();
        for( int i = 0; i < ba.billeter.size(); i++) {
            billetValg.addItem(String.format("%-20s  -  %4.2f kr",ba.billeter.get(i).getType(), ba.billeter.get(i).getBilletpris()));
        }
    }
    
    public void updateKurv() {
        DefaultListModel listModel = new DefaultListModel();
        for( int i = 0; i < ba.kurv.size(); i++) {
            listModel.addElement(String.format("%d%s%s%s%d%s%.2f%s"
                    , ba.kurv.get(i).getAntalBilleter() 
                    , " stk    " 
                    , ba.kurv.get(i).getType() 
                    , "      " 
                    , ba.kurv.get(i).getZoner() 
                    , " zoner        "
                    , ba.kurv.get(i).getPris()
                    , " kr."));
        }
        kurvList.setModel(listModel);
    }
    
    public void updateOutput() {
        double pris = (Integer)billetInput.getValue() * ba.getBilletpris(ba.billeter.get(billetValg.getSelectedIndex()).getType(), (Integer)zoneInput.getValue());
        subTotalOutput.setText(String.format("%.2f kr",pris));
        totalPrisOut.setText(String.format("%.2f kr", ba.getTotalPris()));
        labStation.setText(ba.getStationNavn());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jMenuItem2 = new javax.swing.JMenuItem();
        billetValg = new java.awt.Choice();
        jLabel1 = new javax.swing.JLabel();
        zoneInput = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        billetInput = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        subTotalOutput = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        totalPrisOut = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        labStation = new javax.swing.JTextField();
        addtoKurv = new javax.swing.JButton();
        redigerBillet = new javax.swing.JButton();
        fjernFraKurv = new javax.swing.JButton();
        btnOpenKoeb = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        kurvList = new javax.swing.JList<>();
        btnOpenMontoer = new javax.swing.JButton();

        jMenuItem1.setText("jMenuItem1");

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        jMenuItem2.setText("jMenuItem2");

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        billetValg.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                billetValgItemStateChanged(evt);
            }
        });

        jLabel1.setText("Bilettype");

        zoneInput.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        zoneInput.setModel(new javax.swing.SpinnerNumberModel(1, 1, 9, 1));
        zoneInput.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                zoneInputStateChanged(evt);
            }
        });

        jLabel2.setText("Zone antal:");

        jLabel3.setText("Billet antal:");

        billetInput.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        billetInput.setModel(new javax.swing.SpinnerNumberModel(1, 1, 10, 1));
        billetInput.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                billetInputStateChanged(evt);
            }
        });

        jLabel4.setText("Pris:");

        subTotalOutput.setEditable(false);
        subTotalOutput.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        subTotalOutput.setText("0,00 kr");

        jLabel5.setText("Indkøbskurv:");

        jLabel6.setText("Total:");

        totalPrisOut.setEditable(false);
        totalPrisOut.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        totalPrisOut.setText("0,00 kr");

        jLabel7.setText("Stadtion:");

        labStation.setEditable(false);
        labStation.setText("Hovedbanegården");

        addtoKurv.setText("Tilføj til kurv");
        addtoKurv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addtoKurvActionPerformed(evt);
            }
        });

        redigerBillet.setText("Rediger");
        redigerBillet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redigerBilletActionPerformed(evt);
            }
        });

        fjernFraKurv.setText("Slet");
        fjernFraKurv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fjernFraKurvActionPerformed(evt);
            }
        });

        btnOpenKoeb.setText("Køb");
        btnOpenKoeb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenKoebActionPerformed(evt);
            }
        });

        kurvList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(kurvList);

        btnOpenMontoer.setText("Montør");
        btnOpenMontoer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenMontoerActionPerformed(evt);
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
                    .addComponent(jLabel1)
                    .addComponent(billetValg, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labStation, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(addtoKurv, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(subTotalOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(zoneInput, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(billetInput, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(redigerBillet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fjernFraKurv, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalPrisOut, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                    .addComponent(btnOpenMontoer, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnOpenKoeb, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(labStation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOpenMontoer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(billetValg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(zoneInput, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(billetInput, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(subTotalOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addtoKurv))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(redigerBillet)
                            .addComponent(fjernFraKurv)
                            .addComponent(totalPrisOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnOpenKoeb)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void zoneInputStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_zoneInputStateChanged
        update();
    }//GEN-LAST:event_zoneInputStateChanged

    private void billetInputStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_billetInputStateChanged
        update();
    }//GEN-LAST:event_billetInputStateChanged

    private void billetValgItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_billetValgItemStateChanged
        update();
    }//GEN-LAST:event_billetValgItemStateChanged

 /**
 * Når knappen "tilføj" bliver trykket.
 * @param evt 
 */
    private void addtoKurvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addtoKurvActionPerformed
        
        int billetAntal = (Integer)billetInput.getValue();
        String BilletNavn = ba.billeter.get(billetValg.getSelectedIndex()).getType();
        int zoneAntal = (Integer)zoneInput.getValue();
        double pris = (Integer)billetInput.getValue() * ba.getBilletpris(ba.billeter.get(billetValg.getSelectedIndex()).getType(), (Integer)zoneInput.getValue()); 
        
        
        ba.addtoKurv(billetAntal, BilletNavn , zoneAntal, pris, billetValg.getSelectedIndex());
        update();
        
        
        
    }//GEN-LAST:event_addtoKurvActionPerformed

    /**
     * Når knappen "rediger" bliver trykket.
     * @param evt 
     */
    private void redigerBilletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redigerBilletActionPerformed
        
        if (kurvList.getSelectedIndex() >= 0) {
            Kurv tempKurv = ba.getkurv(kurvList.getSelectedIndex());
            
            billetValg.select(tempKurv.getIndex());
            zoneInput.setValue(tempKurv.getZoner());
            billetInput.setValue(tempKurv.getAntalBilleter());

            update();
        }
        
    }//GEN-LAST:event_redigerBilletActionPerformed

    /**
     * Mår knappe "slet" bliver trykket
     * @param evt 
     */
    private void fjernFraKurvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fjernFraKurvActionPerformed
        if (kurvList.getSelectedIndex() >= 0) {
            ba.removeItemKurv(kurvList.getSelectedIndex());
            update();
        }
        
    }//GEN-LAST:event_fjernFraKurvActionPerformed

    private void btnOpenMontoerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenMontoerActionPerformed
        ejer.setTab(2);    // MontoerLoginGUI
    }//GEN-LAST:event_btnOpenMontoerActionPerformed

    private void btnOpenKoebActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenKoebActionPerformed
        ejer.setTab(1);   // KoebGUI
        
    }//GEN-LAST:event_btnOpenKoebActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addtoKurv;
    private javax.swing.JSpinner billetInput;
    public java.awt.Choice billetValg;
    private javax.swing.JButton btnOpenKoeb;
    private javax.swing.JButton btnOpenMontoer;
    private javax.swing.JButton fjernFraKurv;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JList<String> jList1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> kurvList;
    private javax.swing.JTextField labStation;
    private javax.swing.JButton redigerBillet;
    private javax.swing.JTextField subTotalOutput;
    private javax.swing.JTextField totalPrisOut;
    private javax.swing.JSpinner zoneInput;
    // End of variables declaration//GEN-END:variables
}
