package System;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
//系统界面类
public class StuSystem extends JFrame implements ActionListener{

	JDesktopPane jpan1;
	JLabel jlabel1;
	JLabel jlabel2;
	JButton jbut1;
	JButton jbut2;
	public StuSystem() {
        initComponents();
    }
    public void initComponents() {
    	setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    	//this.setVisible(true);
    	
    	jpan1=new JDesktopPane();
    	jlabel1=new JLabel();
    	jlabel2=new JLabel();
        jbut1=new JButton();
        jbut1.addActionListener( this);
        jbut2=new JButton();
        jbut2.addActionListener(this);
    	
    	jlabel1.setFont(new Font("微软雅黑", 0, 24)); 
        jlabel1.setForeground(Color.black);
        jlabel1.setText("学生成绩管理系统");
        jlabel2.setText("功能选择");
        jbut1.setText("查看学生信息");
        jbut2.setText("管理学生信息");
        

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
        
        //指定布局
        GroupLayout layout=new GroupLayout(getContentPane());
        this.getContentPane().setLayout(layout);
        //创建水平连续组
        GroupLayout.ParallelGroup hGroup = layout.createParallelGroup(GroupLayout.Alignment.LEADING);
        hGroup.addComponent(jpan1);
        hGroup.addGroup(layout.createSequentialGroup()
        		.addGroup(layout.createSequentialGroup()
                        .addGap(42)
                        .addComponent(jlabel2))
        		.addGap(118)
                .addComponent(jbut1)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbut2));
        layout.setHorizontalGroup(hGroup);
        
        //创建GroupLayout的垂直连续组，，越先加入的ParallelGroup，优先级级别越高。
        GroupLayout.ParallelGroup vGroup = layout.createParallelGroup(GroupLayout.Alignment.LEADING);
        vGroup.addGroup(layout.createSequentialGroup()
        		.addComponent(jpan1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        		.addGap(66)
                .addComponent(jlabel2)
                .addGap(16)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jbut1)
                        .addComponent(jbut2)).addGap(80)
        		);       
        layout.setVerticalGroup(vGroup);
        pack();
        
    }
    public void actionPerformed(ActionEvent e){
		if(e.getSource()==jbut1){
			StuInfor chu=new StuInfor();
			chu.setVisible(true);
			this.setVisible(false);
		}else if(e.getSource()==jbut2){
			StuEdit stu=new StuEdit();
			stu.setVisible(true);
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
        	java.util.logging.Logger.getLogger(System.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(System.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(System.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(System.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StuSystem().setVisible(true);
            }
        });
        
    }
}