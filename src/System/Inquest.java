package System;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

import javax.swing.*;
//查询界面类
public class Inquest extends JFrame implements ActionListener{
	Object [][] object2;
	private JDesktopPane jpan1;
	private JLabel jlabel1,jlabel2;
	private JTextField sno;
	private JButton jbut1,jbut2;
	private JDBCConnection connect=new JDBCConnection();
 	private java.sql.Connection con=null;
	public Inquest(){
		initComponents();
	}
	public Inquest(Object [][] a){
		object2=a;
	}
	private void initComponents(){
		jpan1=new JDesktopPane();
		jlabel1=new JLabel();
		jlabel2=new JLabel("关键字查询");
		sno=new JTextField();
		jbut1=new JButton("查询");
		jbut1.addActionListener(this);
		jbut2=new JButton("返回上一级");
		jbut2.addActionListener(this);
		jlabel1.setFont(new Font("微软雅黑", 0, 24)); 
        jlabel1.setForeground(Color.black);
        jlabel1.setText("查询学生成绩");
        
        
        jpan1.setLayer(jlabel1, JLayeredPane.DEFAULT_LAYER);
        
        GroupLayout layout2=new GroupLayout(jpan1);
        jpan1.setLayout(layout2);
        GroupLayout.ParallelGroup hGroup2 = layout2.createParallelGroup(GroupLayout.Alignment.LEADING);
        hGroup2.addGroup(layout2.createSequentialGroup()
        		.addComponent(jlabel1, GroupLayout.PREFERRED_SIZE, 600, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE));
        layout2.setHorizontalGroup(hGroup2);
        //创建GroupLayout的垂直连续组，，越先加入的ParallelGroup，优先级级别越高。
        GroupLayout.ParallelGroup vGroup2 = layout2.createParallelGroup(GroupLayout.Alignment.LEADING);
        vGroup2.addComponent(jlabel1, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE);
        layout2.setVerticalGroup(vGroup2);
        
        GroupLayout layout=new GroupLayout(getContentPane());
        this.getContentPane().setLayout(layout);
        GroupLayout.ParallelGroup hGroup=layout.createParallelGroup(GroupLayout.Alignment.LEADING);
        hGroup.addComponent(jpan1);
        hGroup.addGroup(GroupLayout.Alignment.TRAILING,layout.createSequentialGroup()       		
        		.addGap(100)
                .addComponent(jbut1)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 334, Short.MAX_VALUE)
                .addComponent(jbut2)
                .addGap(100));
        layout.setHorizontalGroup(hGroup);
        hGroup.addGroup(GroupLayout.Alignment.TRAILING,layout.createSequentialGroup()       		
        		.addGap(100)
                .addComponent(jlabel2)
                .addGap(18)
                .addComponent(sno)
                .addGap(200));
        layout.setHorizontalGroup(hGroup);
        
        GroupLayout.ParallelGroup vGroup=layout.createParallelGroup(GroupLayout.Alignment.LEADING);
        vGroup.addGroup(GroupLayout.Alignment.TRAILING,layout.createSequentialGroup()
        		.addComponent(jpan1)
        		.addGap(26)
        		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
        				.addComponent(sno)
        				.addComponent(jlabel2)
        				)
        		.addGap(26)
        		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
        				.addComponent(jbut1)
        				.addComponent(jbut2)
        				)
        		.addGap(26)		
        		);
        layout.setVerticalGroup(vGroup);
        pack();
    }
	
	public void InquestAct(){
		Object [][] object1=new Object [10][6];
		String number="";
		int i=0;
		number=sno.getText();
		boolean exist=false;
		if(number.length()>0){
        try{
        	
           con=connect.getConnection();
   		   Statement stmt=con.createStatement(); 
   		   ResultSet rs=stmt.executeQuery("select*from st where id='"+number+"'"
   		   		+ "or name='"+number+"'or class='"+number+"'");
		   
			   
			   while(rs.next()){
				    object1[i][0]=rs.getString("id");
	    			object1[i][1]=rs.getString("name");
	    			object1[i][2]=rs.getString("class");
	    			object1[i][3]=rs.getString("java");
	    			object1[i][4]=rs.getString("math");
	    			object1[i][5]=rs.getString("english");
	    			i=i+1;
			   }	
			   //创建Inquest类的对象将数组保存，再将该参数作为Show类构造函数的参数
			   Inquest inquest=new Inquest(object1);
			   Show show=new Show(inquest.object2);
			   show.setVisible(true);
			   
			   
			
        }catch(SQLException e1) {
			System.out.println("SQL Exception occur.Message is；");
			System.out.println(e1.getMessage());
		}finally {
			connect.closeConnection();
		}
	}
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==jbut1){
			InquestAct();
			
		}else if(e.getSource()==jbut2){
			new StuInfor().setVisible(true);
			this.setVisible(false);
		}
	}				
    
	
	public static void main(String[] args){
		try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
        	java.util.logging.Logger.getLogger(Inquest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inquest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inquest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inquest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
            	Inquest A =new Inquest();
            	A.setVisible(true);
            }
        });
        
    }
          
}

