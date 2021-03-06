/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desktopserver;

import static desktopserver.FormDashboard.displayVillaAll;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import static javax.swing.SwingConstants.CENTER;

/**
 *
 * @author TOTO
 */
public class FormOrderDetail extends javax.swing.JFrame {

    String email,villaName,buktiBayar,notes,status,idReservation;
    Integer villaId,totalGuest,idUser;
    Date checkin,checkout;
    FormDashboard parent;
    /**
     * Creates new form FormOrderDetail
     */
    public FormOrderDetail() {
        initComponents();
    }
    
    public FormOrderDetail(String item, FormDashboard _parent) {
        try {
            initComponents();
            String[] arr1 = item.split("\\|\\|");
            String[] arr2 = arr1[0].split(";;");
            
            parent = _parent;
            email = arr2[16];
            status = arr2[5];
            villaName = arr2[11];
            idReservation = arr2[1];
            notes = arr2[8];
            buktiBayar = arr2[9];
            villaId = Integer.parseInt(arr2[10]);
            idUser = Integer.parseInt(arr2[12]);
            totalGuest = Integer.parseInt(arr2[6]);
            checkin = new SimpleDateFormat("yyyy-MM-dd").parse(arr2[3]);
            checkout = new SimpleDateFormat("yyyy-MM-dd").parse(arr2[4]);
            
            labelOrderDetailId.setHorizontalAlignment(CENTER);
            labelBuktiBayar.setHorizontalAlignment(CENTER);
            labelOrderDetailId.setText("Reservation Detail("+idReservation+")");
            
            if(buktiBayar.equals("null"))
            {
                buktiBayar = "BELUM ADA BUKTI PEMBAYARAN";
                labelBuktiBayar.setForeground(Color.red);
            }
            else
            {
                labelBuktiBayar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                labelBuktiBayar.setForeground(Color.blue.darker());
            }
            
            labelBuktiBayar.setText(buktiBayar);
            textEmail.setText(email);
            IsiComboBoxVilla();
            dateCheckIn.setDate(checkin);
            dateCheckOut.setDate(checkout);
            textTotalGuest.setValue(totalGuest);
            textNotes.setText(notes);
            comboBoxStatus.setSelectedItem(status);
            textTotalPrice.setText(arr2[7]);
            this.getContentPane().setBackground(Color.WHITE);
            
            //[1]idreservation,[2]res_timestamp,[3]chcekin_date,[4]checkout_date,[5]status,[6]total_guest,[7]total_price,[8]notes,[19]url_bukti_pembayaran,[10]idvilla,
            //[11]villa_name,[12]iduser,[13]fullname,[14]display_name[15],phone_number,[16]email,[17]no_ktp;;
            //333;;2021-06-14 16:35:00.0;;2021-06-15;;2021-06-17;;PENDING;;2;;3600000;;Tolong sediakan grill;;null;;1;;The La Llorona;;1;;Jasti Ohanna;;jasti;;08123456789;;jasti@gmail.com;;3315060711900001

                    
                    
        } catch (ParseException ex) {
            Logger.getLogger(FormOrderDetail.class.getName()).log(Level.SEVERE, null, ex);
        }


        
    }
    
    
    public void IsiComboBoxVilla()
    {
        String result = FormDashboard.displayVillaAll();
        String[] arr1 = result.split("\\|\\|");
        System.out.println(Arrays.toString(arr1));
        
        for(Integer i=0;i<arr1.length; i++)
        {
            String[] arr2 = arr1[i].split(";;");
            comboBoxVillaType.addItem(arr2[1] + ")" + arr2[2] + "\n");
        }
        
        comboBoxVillaType.setSelectedItem(villaId + ")" + villaName + "\n");
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelOrderDetailId = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        labelBuktiBayar = new javax.swing.JLabel();
        textEmail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        comboBoxVillaType = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        dateCheckIn = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        dateCheckOut = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        textTotalGuest = new com.toedter.components.JSpinField();
        jLabel8 = new javax.swing.JLabel();
        textNotes = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        comboBoxStatus = new javax.swing.JComboBox<>();
        buttonChange = new javax.swing.JButton();
        buttonCancel = new javax.swing.JButton();
        buttonClose = new javax.swing.JButton();
        textTotalPrice = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setLocation(new java.awt.Point(600, 150));

        labelOrderDetailId.setFont(new java.awt.Font("Rubik", 1, 24)); // NOI18N
        labelOrderDetailId.setForeground(new java.awt.Color(29, 212, 121));
        labelOrderDetailId.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelOrderDetailId.setText("Reservasion Detail 001");

        jLabel10.setFont(new java.awt.Font("Rubik", 0, 14)); // NOI18N
        jLabel10.setText("Bukti Pembayaran");

        labelBuktiBayar.setFont(new java.awt.Font("Rubik", 1, 14)); // NOI18N
        labelBuktiBayar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelBuktiBayar.setText("BELUM ADA BUKTI PEMBAYARAN");
        labelBuktiBayar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelBuktiBayar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelBuktiBayarMouseClicked(evt);
            }
        });

        textEmail.setFont(new java.awt.Font("Rubik", 0, 14)); // NOI18N
        textEmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textEmail.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Rubik", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Email");

        jLabel4.setFont(new java.awt.Font("Rubik", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Villa Type");

        comboBoxVillaType.setFont(new java.awt.Font("Rubik", 0, 14)); // NOI18N
        comboBoxVillaType.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Rubik", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Check In");

        dateCheckIn.setBackground(java.awt.Color.white);
        dateCheckIn.setDateFormatString("yyyy-MM-dd");
        dateCheckIn.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Rubik", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Check Out");

        dateCheckOut.setBackground(java.awt.Color.white);
        dateCheckOut.setDateFormatString("yyyy-MM-dd");
        dateCheckOut.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Rubik", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Total Guests");

        textTotalGuest.setBackground(java.awt.Color.white);
        textTotalGuest.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel8.setFont(new java.awt.Font("Rubik", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Notes");

        textNotes.setFont(new java.awt.Font("Rubik", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Rubik", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("STATUS");

        comboBoxStatus.setFont(new java.awt.Font("Rubik", 0, 14)); // NOI18N
        comboBoxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PENDING", "APPROVED", "DECLINED", "CANCELED" }));

        buttonChange.setBackground(new java.awt.Color(8, 191, 91));
        buttonChange.setFont(new java.awt.Font("Rubik", 1, 14)); // NOI18N
        buttonChange.setForeground(new java.awt.Color(255, 255, 255));
        buttonChange.setText("CHANGE");
        buttonChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonChangeActionPerformed(evt);
            }
        });

        buttonCancel.setBackground(new java.awt.Color(8, 191, 91));
        buttonCancel.setFont(new java.awt.Font("Rubik", 1, 14)); // NOI18N
        buttonCancel.setForeground(new java.awt.Color(255, 255, 255));
        buttonCancel.setText("CANCEL");
        buttonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelActionPerformed(evt);
            }
        });

        buttonClose.setBackground(new java.awt.Color(255, 102, 102));
        buttonClose.setFont(new java.awt.Font("Rubik", 1, 14)); // NOI18N
        buttonClose.setForeground(new java.awt.Color(255, 255, 255));
        buttonClose.setText("CLOSE");
        buttonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCloseActionPerformed(evt);
            }
        });

        textTotalPrice.setFont(new java.awt.Font("Rubik", 0, 14)); // NOI18N
        textTotalPrice.setEnabled(false);

        jLabel11.setFont(new java.awt.Font("Rubik", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Total Price ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(buttonClose, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel10)
                    .addComponent(labelOrderDetailId)
                    .addComponent(labelBuktiBayar, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(textEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel11)
                            .addGap(18, 18, 18)
                            .addComponent(textTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addGap(18, 18, 18)
                            .addComponent(comboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addGap(18, 18, 18)
                            .addComponent(textTotalGuest, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addGap(18, 18, 18)
                            .addComponent(dateCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(18, 18, 18)
                            .addComponent(dateCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(18, 18, 18)
                            .addComponent(comboBoxVillaType, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addGap(18, 18, 18)
                            .addComponent(textNotes, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(buttonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(buttonChange, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(labelOrderDetailId)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelBuktiBayar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(comboBoxVillaType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dateCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(textTotalGuest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(textNotes, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(textTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(comboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCancel)
                    .addComponent(buttonChange))
                .addGap(10, 10, 10)
                .addComponent(buttonClose)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
        textEmail.setText(email);
        IsiComboBoxVilla();
        dateCheckIn.setDate(checkin);
        dateCheckOut.setDate(checkout);
        textTotalGuest.setToolTipText(totalGuest+"");
        textNotes.setText(notes);
        comboBoxStatus.setSelectedItem(status);
    }//GEN-LAST:event_buttonCancelActionPerformed

    private void buttonChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonChangeActionPerformed
        String sEmail = textEmail.getText();
        String sNotes = textNotes.getText();
//        String sCheckIn = ((JTextField)dateCheckIn.getDateEditor().getUiComponent()).getText();
//        String sCheckOut = ((JTextField)dateCheckOut.getDateEditor().getUiComponent()).getText();
        String[] arrVilla = comboBoxVillaType.getSelectedItem().toString().split("\\)");
        Integer sVillaId = Integer.parseInt(arrVilla[0]);
        System.out.println("IdVilla : " +sVillaId);
        Integer sTotalGuest = textTotalGuest.getValue();
        String sStatus = comboBoxStatus.getSelectedItem().toString();
        String resultUpdate = "";
        String resultStatus = "";
        if(buktiBayar.equals("BELUM ADA BUKTI PEMBAYARAN"))
        {
            if(sStatus.equals("APPROVED"))
            {
                JOptionPane.showMessageDialog(null, "Tidak bisa meng-APPROVED reservasi yang belum ada bukti pembayarannya!", "Warning",JOptionPane.WARNING_MESSAGE );
            }
            else
            {
                 resultUpdate = FormDashboard.updateReservation(sEmail, sTotalGuest, sNotes ,Integer.parseInt(idReservation));
                 resultStatus = FormDashboard.changeStatus(sStatus,Integer.parseInt(idReservation));
            }
        }
        else
        {
             resultUpdate = FormDashboard.updateReservation(sEmail, sTotalGuest, sNotes ,Integer.parseInt(idReservation));
             resultStatus = FormDashboard.changeStatus(sStatus,Integer.parseInt(idReservation));
        }
        
        System.out.println("resultUpdate = " + resultUpdate + "\n");
        System.out.println("resultStatus = " + resultStatus + "\n");
        
        String message = "";
        if(resultUpdate.contains("true"))
        {
            message = "Pengubahan Data Reservasi(" + idReservation + ") : BERHASIL\n";
            if(resultStatus.contains("true"))
            {
                message += "Pengubahan Status Reservasi(" + idReservation + ") : BERHASIL\n";
            }
            else
            {
                message += "Pengubahan Status Reservasi(" + idReservation + ") :GAGAL\n";
            }
        }
        else
        {
            message = "Pengubahan Data Reservasi(" + idReservation + ") : GAGAL\n";
            if(resultStatus.contains("true"))
            {
                message += "Pengubahan Status Reservasi(" + idReservation + ") :BERHASIL\n";
            }
            else
            {
                message += "Pengubahan Status Reservasi(" + idReservation + ") :GAGAL\n";
            }
        }
        
        JOptionPane.showMessageDialog(null, message);
        parent.TampilReservasi("", "");
        
      
       
    }//GEN-LAST:event_buttonChangeActionPerformed

    private void buttonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCloseActionPerformed
        
        
        this.dispose();
    }//GEN-LAST:event_buttonCloseActionPerformed

    private void labelBuktiBayarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelBuktiBayarMouseClicked
        try {

            if(!labelBuktiBayar.getText().equals("BELUM ADA BUKTI PEMBAYARAN"))
            {
                Desktop.getDesktop().browse(new URI(labelBuktiBayar.getText()));
                
            }

        } catch (IOException | URISyntaxException e1) {
            e1.printStackTrace();
        }
    }//GEN-LAST:event_labelBuktiBayarMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormOrderDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormOrderDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormOrderDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormOrderDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormOrderDetail().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonChange;
    private javax.swing.JButton buttonClose;
    private javax.swing.JComboBox<String> comboBoxStatus;
    private javax.swing.JComboBox<String> comboBoxVillaType;
    private com.toedter.calendar.JDateChooser dateCheckIn;
    private com.toedter.calendar.JDateChooser dateCheckOut;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel labelBuktiBayar;
    private javax.swing.JLabel labelOrderDetailId;
    private javax.swing.JTextField textEmail;
    private javax.swing.JTextField textNotes;
    private com.toedter.components.JSpinField textTotalGuest;
    private javax.swing.JTextField textTotalPrice;
    // End of variables declaration//GEN-END:variables
}
