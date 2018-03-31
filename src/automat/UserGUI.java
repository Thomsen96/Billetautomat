/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automat;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;



/**
 *
 * @author Jonas
 */
public class UserGUI extends javax.swing.JPanel {
    Billetautomat ba;
    int zoneAntal;
    int billetAntal;
    
    double pris;
    
    /**
     * Creates new form UserGUI
     */
    public UserGUI() {
        initComponents();
        
        
    }
    
    public void setupBilletChoice() {
                 
   for( int i = 0; i < ba.billeter.size(); i++) {
            billetValg.addItem(String.format("%-20s  -  %4.2f kr",ba.billeter.get(i).getType(), ba.billeter.get(i).getBilletpris()));
        }
        update();
    }
    
    public void update(){
        updateInput();
        updateKurv();
        updateOutput();
    }
    
    public void updateInput(){
        billetAntal =  (Integer)billetInput.getValue();
        zoneAntal   =  (Integer)zoneInput.getValue();
        pris = billetAntal * ba.getBilletpris(ba.billeter.get(billetValg.getSelectedIndex()).getType(), zoneAntal);
    }
    
    public void updateKurv() {
        ba.totalPris = 0;
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
            
            ba.totalPris += ba.kurv.get(i).getPris();
        }
        kurvList.setModel(listModel);
    }
    
    public void updateOutput() {
        subTotalOutput.setText(String.format("%.2f kr",pris));
        totalPrisOut.setText(String.format("%.2f kr", ba.totalPris));
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
        jTextField3 = new javax.swing.JTextField();
        addtoKurv = new javax.swing.JButton();
        redigerBillet = new javax.swing.JButton();
        fjernFraKurv = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        kurvList = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();

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

        zoneInput.setModel(new javax.swing.SpinnerNumberModel(1, 1, 9, 1));
        zoneInput.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                zoneInputStateChanged(evt);
            }
        });

        jLabel2.setText("Zone antal:");

        jLabel3.setText("Billet antal:");

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

        jTextField3.setEditable(false);
        jTextField3.setText("Hovedbanegården");

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

        jButton4.setText("Køb");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        kurvList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(kurvList);

        jButton1.setText("Montør");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel1)
                                .addComponent(billetValg, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(zoneInput, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(billetInput))
                            .addGap(121, 121, 121)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(addtoKurv, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(subTotalOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(121, 121, 121)))
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
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
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
                        .addComponent(jButton4)))
                .addContainerGap(12, Short.MAX_VALUE))
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
        
        updateInput();
        ba.addtoKurv(billetAntal, ba.billeter.get(billetValg.getSelectedIndex()).getType(), zoneAntal, pris, billetValg.getSelectedIndex());
        update();
        
        
        
    }//GEN-LAST:event_addtoKurvActionPerformed

    /**
     * Når knappen "rediger" bliver trykket.
     * @param evt 
     */
    private void redigerBilletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redigerBilletActionPerformed
        Kurv tempKurv = ba.getkurv(kurvList.getSelectedIndex());
        
        billetValg.select(tempKurv.getIndex());
        zoneInput.setValue(tempKurv.getZoner());
        billetInput.setValue(tempKurv.getAntalBilleter());
        
        ba.totalPris -= tempKurv.getPris();
        update();
    }//GEN-LAST:event_redigerBilletActionPerformed

    /**
     * Mår knappe "slet" bliver trykket
     * @param evt 
     */
    private void fjernFraKurvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fjernFraKurvActionPerformed
        ba.kurv.remove(kurvList.getSelectedIndex());
        update();
    }//GEN-LAST:event_fjernFraKurvActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        MontoerGUI mGUI = new MontoerGUI();
        
        mGUI.ba = this.ba;
        ba.montoerLogin("1234");
        JFrame vindueMontoer = new JFrame("Montør");               // opret et vindue på skærmen
        vindueMontoer.add(mGUI);                                                       // vis panelet i vinduet
        
        vindueMontoer.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);               // reagér på luk
        vindueMontoer.pack();                                                          // sæt vinduets størrelse
        vindueMontoer.setVisible(true);                                                // åbn vinduet
        
        mGUI.update();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        KoebGUI kGUI = new KoebGUI();
        
        kGUI.ba = this.ba;
        JFrame vindueMontoer = new JFrame("Betaling");               // opret et vindue på skærmen
        vindueMontoer.add(kGUI);                                                       // vis panelet i vinduet
        
        vindueMontoer.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);               // reagér på luk
        vindueMontoer.pack();                                                          // sæt vinduets størrelse
        vindueMontoer.setVisible(true);                                                // åbn vinduet
        
        kGUI.updateKurv();
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addtoKurv;
    private javax.swing.JSpinner billetInput;
    public java.awt.Choice billetValg;
    private javax.swing.JButton fjernFraKurv;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
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
    private javax.swing.JTextField jTextField3;
    private javax.swing.JList<String> kurvList;
    private javax.swing.JButton redigerBillet;
    private javax.swing.JTextField subTotalOutput;
    private javax.swing.JTextField totalPrisOut;
    private javax.swing.JSpinner zoneInput;
    // End of variables declaration//GEN-END:variables
}
