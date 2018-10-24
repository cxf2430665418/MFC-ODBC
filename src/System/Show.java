package System;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
//显示界面类
public class Show extends JFrame{
	Object[][] object;
	JDesktopPane jDesktopPane1;
	JLabel jLabel1;
	JScrollPane jScrollPane1;
	JTable jTable1;
	private JDBCConnection connect=new JDBCConnection();
 	private java.sql.Connection con=null;
 	private ResultSet rs;
    
    public Show() {
        initComponents();        
    }
    public Show(Object[][] object){
    	this.object=object;
    	initComponents();
    }
    @SuppressWarnings("unchecked")
 
    private void initComponents() {
    
        jDesktopPane1 = new JDesktopPane();
        jLabel1 = new JLabel();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new Font("微软雅黑", 0, 24)); 
        jLabel1.setForeground(new Color(255));
        jLabel1.setText("查询结果");

        jDesktopPane1.setLayer(jLabel1,JLayeredPane.DEFAULT_LAYER);

        GroupLayout jDesktopPane1Layout = new GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(jLabel1,GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1,GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
        );
        

        
		jTable1.setModel(new javax.swing.table.DefaultTableModel(
                 object,
                new String [] {
                    "学号", "姓名", "班级", "面向对象", "高等数学", "大学英语"
                }
            ) {
                Class[] types = new Class [] {
                    String.class, String.class, String.class, String.class,
                    String.class, String.class, String.class, String.class
                };

                public Class getColumnClass(int columnIndex) {
                    return types [columnIndex];
                }
            });
        
        jScrollPane1.setViewportView(jTable1);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addGap(22))
        )
        );

        pack();
    }
    
    
    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Show.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Show.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Show.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Show.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Show().setVisible(true);
            }
        });
    }
 
}