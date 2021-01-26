/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vku.hrm;
import java.sql.*;
import java.time.Month;
import javax.swing.JOptionPane;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Calendar;
/**
 *
 * @author Admin
 */
public class login extends javax.swing.JFrame {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    /**
     * Creates new form login
     */
    public login() {
        initComponents();
        conn = db.java_db();
        curentDateTime();
    }
    public void curentDateTime(){
        Calendar cal = new GregorianCalendar();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int date = cal.get(Calendar.DATE);
        
        lbl_date.setText((date)+"/"+(month +1)+"/"+year);
        
        int hour = cal.get(Calendar.HOUR);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);
        
        lbl_time.setText(hour+":"+minute+":"+second);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_username = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_combobox = new javax.swing.JComboBox<>();
        btn_login = new javax.swing.JButton();
        txt_password = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        lbl_date = new javax.swing.JMenu();
        lbl_time = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CHƯƠNG TRÌNH QUẢN LÝ NHÂN SỰ CHO CÔNG TY MAI VẠN TÍN");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 220, 600, 17);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tên đăng nhập:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 250, 100, 30);

        txt_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usernameActionPerformed(evt);
            }
        });
        jPanel1.add(txt_username);
        txt_username.setBounds(140, 250, 150, 30);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Mật khẩu:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 290, 90, 30);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Vai trò:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(30, 320, 50, 40);

        txt_combobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Sales" }));
        txt_combobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_comboboxActionPerformed(evt);
            }
        });
        jPanel1.add(txt_combobox);
        txt_combobox.setBounds(140, 330, 150, 30);

        btn_login.setText("Đăng nhập");
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });
        jPanel1.add(btn_login);
        btn_login.setBounds(185, 370, 100, 23);
        jPanel1.add(txt_password);
        txt_password.setBounds(140, 290, 150, 30);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vku/hrm/images/hinh nen động.gif"))); // NOI18N
        jLabel5.setMaximumSize(new java.awt.Dimension(100, 100));
        jLabel5.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel1.add(jLabel5);
        jLabel5.setBounds(0, 0, 600, 420);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        lbl_date.setText("Date");
        jMenuBar1.add(lbl_date);

        lbl_time.setText("Time");
        jMenuBar1.add(lbl_time);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        // TODO add your handling code here:
        //String sql = "select id,username,password,division from Users where (username =? and password =? and division =?)";
        String sql = "select * from Users Where (username =? and password =? and division =?)";
        try {
            int count =0;
            
            pst = conn.prepareStatement(sql);
            
            pst.setString(1, txt_username.getText());
            pst.setString(2, txt_password.getText());
            pst.setString(3, txt_combobox.getSelectedItem().toString());
            
            rs = pst.executeQuery();
            String access = txt_combobox.getSelectedItem().toString();
            
            while(rs.next()){ 
                count=1;
                System.out.println("rs.next():"+rs.getString(1));
            }
            System.out.println("count:"+count);
            System.out.println("access: "+access);
            if(access == "Admin"){
                if(count == 1){
                    JOptionPane.showMessageDialog(null, "Đăng Nhập Thành Công!");
                    MainMenu j =  new MainMenu();
                    j.setVisible(true);
                    this.dispose();    
                }
                else JOptionPane.showMessageDialog(null, "Đăng nhập thất bại!");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }finally{
            try {
                rs.close();
                pst.close();
            } catch (Exception e) {
                //JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_btn_loginActionPerformed

    private void txt_comboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_comboboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_comboboxActionPerformed

    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usernameActionPerformed

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_login;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenu lbl_date;
    private javax.swing.JMenu lbl_time;
    private javax.swing.JComboBox<String> txt_combobox;
    private javax.swing.JTextField txt_password;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
