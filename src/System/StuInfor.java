package System;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;

import javax.swing.*;
//查看学生信息界面类
public class StuInfor extends JFrame implements ActionListener{
	private JButton jButton1;
    private JButton jButton2,jButton3,jButton4;
    private JDesktopPane jDesktopPane1;
    private JLabel jLabel1;
    private JScrollPane jScrollPane1;
    private JTable jTable1;
    private JButton sreturn;
    private JDBCConnection connect=new JDBCConnection();
 	private java.sql.Connection con=null;
 	private ResultSet rs;
    
    public StuInfor() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jDesktopPane1 = new JDesktopPane();
        jLabel1 = new JLabel();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();
        jButton1 = new JButton();
        jButton1.addActionListener( this);
        sreturn = new JButton();
        sreturn.addActionListener( this);
        jButton2 = new JButton();
        jButton2.addActionListener( this);
        jButton4 = new JButton("优秀率");
        jButton4.addActionListener( this);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("微软雅黑", 0, 24)); 
        jLabel1.setForeground(new Color(240));
        jLabel1.setText("学生信息 ");
        jButton1.setText("最高分");
        sreturn.setText("返回上一级");
        jButton2.setText("查询");

        jDesktopPane1.setLayer(jLabel1, JLayeredPane.DEFAULT_LAYER);

        GroupLayout jDesktopPane1Layout = new GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 178,GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1,GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
        );
        Object[][] object=new Object [60][8];
        ShowStudent(object);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
        		object ,
            new String [] {
                "学号", "姓名", "班级", "面向对象", "高等数学", "大学英语","平均成绩","总成绩"
            }
        ) {
            Class[] types = new Class [] {
                String.class,String.class,String.class,String.class,
                String.class, String.class,String.class,String.class
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
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21)
                .addComponent(jButton2)
                .addGap(18)
                .addComponent(jButton1)
                .addGap(18)
                .addComponent(jButton4)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sreturn)
               
                .addGap(26))
            .addComponent(jScrollPane1,GroupLayout.DEFAULT_SIZE, 663, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1,GroupLayout.PREFERRED_SIZE, 316,GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(sreturn)
                    .addComponent(jButton2)
                    .addComponent(jButton4))
                .addGap(22, 22, 22))
        );

        pack();
    }
    
    public void actionPerformed(ActionEvent e){
    	if(e.getSource()==jButton2){
			Inquest chu=new Inquest();
			chu.setVisible(true);
			this.setVisible(false);
		}else if(e.getSource()==jButton1){
			Score stu=new Score();
		}else if(e.getSource()==jButton4){
			Excellent stu=new Excellent();
		}else if(e.getSource()==sreturn){
			StuSystem stu=new StuSystem();
			stu.setVisible(true);
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
    			Object obj1=a[i][3];
    			String str1=obj1.toString();
    			double b=Double.valueOf(str1).doubleValue();
    			Object obj2=a[i][4];
    			String str2=obj2.toString();
    			double c=Double.valueOf(str2).doubleValue();
    			Object obj3=a[i][5];
    			String str3=obj3.toString();
    			double d=Double.valueOf(str3).doubleValue();
    			DecimalFormat df =  new  DecimalFormat(  "0.00 " );
    			double e=b+c+d;
    			double f=e/3;
    			String g=df.format(f);
    			String str4=g;
    			String str5=Double.toString(e);
    			a[i][6]=str4;
    			a[i][7]=str5;
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
            java.util.logging.Logger.getLogger(StuInfor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StuInfor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StuInfor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StuInfor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StuInfor().setVisible(true);
            }
        });
    }
    
 
}