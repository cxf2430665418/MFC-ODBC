package System;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

//添加学生信息界面类
public class Increase extends JFrame implements ActionListener{
	private JDesktopPane jpan1;
	private JLabel jlabel1,jlabel2,jlabel3,jlabel4,jlabel5,jlabel6,jlabel7;
	private JTextField sno,sname,sclass,sjava,smath,senglish;
	private JButton jbut1,jbut2;
	private JDBCConnection connect=new JDBCConnection();
 	private java.sql.Connection con=null;
	
	public Increase(){
		initComponents();
	}
	private void initComponents(){
		jpan1=new JDesktopPane();
		jlabel1=new JLabel();
		jlabel2=new JLabel("学       号");
		jlabel3=new JLabel("姓       名");
		jlabel4=new JLabel("班       级");
		jlabel5=new JLabel("面向对象");
		jlabel6=new JLabel("高       数");
		jlabel7=new JLabel("大学英语");
		sno=new JTextField();
		sname=new JTextField();
		sclass=new JTextField();
		sjava=new JTextField();
		smath=new JTextField();
		senglish=new JTextField();
		jbut1=new JButton("添加");
		jbut1.addActionListener(this);
		jbut2=new JButton("返回上一级");
		jbut1.addActionListener(this);
		jlabel1.setFont(new Font("微软雅黑", 0, 24)); 
        jlabel1.setForeground(Color.black);
        jlabel1.setText("增加学生成绩");
        
        
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
        		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        				.addComponent(jlabel2)
        				.addComponent(jlabel3)
        				.addComponent(jlabel4)
        				.addComponent(jlabel5)
        				.addComponent(jlabel6)
        				.addComponent(jlabel7)
        				)
        		.addGap(18)		
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        				.addComponent(sno)
        				.addComponent(sname)
        				.addComponent(sclass)
        				.addComponent(sjava)
        				.addComponent(smath)
        				.addComponent(senglish)
        				)
        		.addGap(200)		
        		);
        hGroup.addGroup(GroupLayout.Alignment.TRAILING,layout.createSequentialGroup()       		
        		.addGap(100)
                .addComponent(jbut1)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 334, Short.MAX_VALUE)
                .addComponent(jbut2)
                .addGap(100));
        layout.setHorizontalGroup(hGroup);
        
        GroupLayout.ParallelGroup vGroup=layout.createParallelGroup(GroupLayout.Alignment.LEADING);
        vGroup.addGroup(GroupLayout.Alignment.TRAILING,layout.createSequentialGroup()
        		.addComponent(jpan1)
        		.addGap(26)
        		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
        				.addComponent(sno)
        				.addComponent(jlabel2)
        				)
        		.addGap(5)
        		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
        				.addComponent(sname)
        				.addComponent(jlabel3)
        				)
        		.addGap(5)
        		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
        				.addComponent(sclass)
        				.addComponent(jlabel4)
        				)
        		.addGap(5)
        		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
        				.addComponent(sjava)
        				.addComponent(jlabel5)
        				)
        		.addGap(5)
        		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
        				.addComponent(smath)
        				.addComponent(jlabel6)
        				)
        		.addGap(5)
        		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
        				.addComponent(senglish)
        				.addComponent(jlabel7)
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
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==jbut1){
			IncreaseAct();
		}else if(e.getSource()==jbut2){
			new StuEdit().setVisible(true);
			this.setVisible(false);
		}
    }
	
	public void IncreaseAct(){
		String number="";
		number=sno.getText();
		boolean exist=false;
		if(number.length()>0){
        try{  
           con=connect.getConnection();
   		   Statement stmt=con.createStatement(); 
   		   ResultSet rs=stmt.executeQuery("select*from st where id='"+number+"'");
		   if(rs.next()){
			   exist=true;
		   }
		   if(exist) {
			   String warning="该学号已存在，请修改您的学号！";
			   JOptionPane.showMessageDialog(null,warning,"警告",JOptionPane.WARNING_MESSAGE);
		   }else {
			try {
				String sql = "insert into st(id,name,class,java,math,english) values(?,?,?,?,?,?)"; 
        
                PreparedStatement parepare=con.prepareStatement(sql); 
                
                
                parepare.setString(1, sno.getText());  
                parepare.setString(2, sname.getText());  
                parepare.setString(3, sclass.getText());  
                parepare.setString(4, sjava.getText());  
                parepare.setString(5, smath.getText());  
                parepare.setString(6, senglish.getText()); 
                
                parepare.executeUpdate();  
                
                String ok="操作成功";
				JOptionPane.showMessageDialog(null,ok,"确认",JOptionPane.WARNING_MESSAGE);
                 
                this.dispose();  
			}catch (SQLException e1) {
				String warning="姓名和班级不能为空";
				 JOptionPane.showMessageDialog(null,warning,"警告",JOptionPane.WARNING_MESSAGE);
				System.out.println("SQL Exception occur.Message is；");
				System.out.println(e1.getMessage());
				
			}
			 		}
		}catch(SQLException e1) {
			System.out.println("SQL Exception occur.Message is；");
			System.out.println(e1.getMessage());
		}finally {
			connect.closeConnection();
		}
		
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
        	java.util.logging.Logger.getLogger(Increase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Increase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Increase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Increase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Increase().setVisible(true);
            }
        });
        
    }

}
