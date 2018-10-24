package System;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
//管理学生信息类
public class StuEdit extends JFrame implements ActionListener{
	Object[][] object;
	JButton jButton1;
	JButton jButton3;
	JButton jButton4;
	JButton jButton5;
	JButton jButton6;
	JButton jButton7;
	JDesktopPane jDesktopPane1;
	JLabel jLabel1;
	JScrollPane jScrollPane1;
	JTable jTable1;
	private JDBCConnection connect=new JDBCConnection();
 	private java.sql.Connection con=null;
 	private ResultSet rs;
    
    public StuEdit() {
    	 
        initComponents();        
    }

    @SuppressWarnings("unchecked")
 
    private void initComponents() {

        jDesktopPane1 = new JDesktopPane();
        jLabel1 = new JLabel();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();

        jButton3 = new JButton();
        jButton4 = new JButton();
        jButton5 = new JButton();
        jButton6 = new JButton();
        jButton7 = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new Font("微软雅黑", 0, 24)); 
        jLabel1.setForeground(new Color(255));
        jLabel1.setText("学生信息管理");

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
        
        object=new Object [60][6];
        ShowStudent(object);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            object ,
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
        

        jButton3.setFont(new Font("微软雅黑", 0, 15)); 
        jButton3.setText("返回上一级");
        jButton3.addActionListener(this);
        jButton5.setText("新增");
        jButton5.addActionListener(this);
        jButton6.setText("删除");
        jButton6.addActionListener(this);
        jButton7.setText("修改");
        jButton7.addActionListener(this);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton5)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton7)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(26))
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
                    .addComponent(jButton3)
                    .addComponent(jButton5)
                    .addComponent(jButton6)
                    .addComponent(jButton7))
                .addGap(22))
        );

        pack();
    }
    
    public void actionPerformed(ActionEvent e){
    	if(e.getSource()==jButton3){
			new StuSystem().setVisible(true);
			this.setVisible(false);
		}else if(e.getSource()==jButton5){
			new Increase().setVisible(true);
			this.setVisible(false);
		}else if(e.getSource()==jButton6){
			new Delete().setVisible(true);
			this.setVisible(false);
		}else if(e.getSource()==jButton7){
			new Modif().setVisible(true);
			this.setVisible(false);
		}
    }
    
    public void ShowStudent(Object[][] a){
    	try{
    		int i=0;
    		con=connect.getConnection();
    		Statement stmt=con.createStatement(); 
    		rs=stmt.executeQuery("select * from st");
    		while(rs.next()){
    			a[i][0]=rs.getString("id");
    			a[i][1]=rs.getString("name");
    			a[i][2]=rs.getString("class");
    			a[i][3]=rs.getString("java");
    			a[i][4]=rs.getString("math");
    			a[i][5]=rs.getString("english");
    			i=i+1;
    		}
    	}catch(SQLException e1) {
			System.out.println("SQL Exception occur.Message is；");
			System.out.println(e1.getMessage());
		}finally {
			connect.closeConnection();
		}
		
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
            java.util.logging.Logger.getLogger(StuEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StuEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StuEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StuEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StuEdit().setVisible(true);
            }
        });
    }
 
}

