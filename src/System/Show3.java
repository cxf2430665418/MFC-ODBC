package System;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
//ϵͳ������
public class Show3 extends JFrame {
    String str1,str2,str3;
	JDesktopPane jpan1;
	JLabel jlabel1;
	JLabel jlabel2;
	JLabel jlabel3;
	JLabel jlabel4;
	public Show3(String str1,String str2,String str3){
		this.str1=str1;
		this.str2=str2;
		this.str3=str3;
		initComponents();
	}
	private void initComponents(){	
	    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    	//this.setVisible(true);
    	jpan1=new JDesktopPane();
    	jlabel1=new JLabel();
    	jlabel2=new JLabel(str1);
    	jlabel3=new JLabel(str2);
    	jlabel4=new JLabel(str3);
    	
    	jlabel1.setFont(new Font("΢���ź�", 0, 24)); 
        jlabel1.setForeground(Color.black);
        jlabel1.setText("��߷�");

        jpan1.setLayer(jlabel1, JLayeredPane.DEFAULT_LAYER);
        
        GroupLayout layout2=new GroupLayout(jpan1);
        jpan1.setLayout(layout2);
        GroupLayout.ParallelGroup hGroup2 = layout2.createParallelGroup(GroupLayout.Alignment.LEADING);
        hGroup2.addGroup(layout2.createSequentialGroup()
        		.addComponent(jlabel1, GroupLayout.PREFERRED_SIZE, 600, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE));
        layout2.setHorizontalGroup(hGroup2);
        //����GroupLayout�Ĵ�ֱ�����飬��Խ�ȼ����ParallelGroup�����ȼ�����Խ�ߡ�
        GroupLayout.ParallelGroup vGroup2 = layout2.createParallelGroup(GroupLayout.Alignment.LEADING);
        vGroup2.addComponent(jlabel1, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE);
        layout2.setVerticalGroup(vGroup2);
        
        //ָ������
        GroupLayout layout=new GroupLayout(getContentPane());
        this.getContentPane().setLayout(layout);
        //����ˮƽ������
        GroupLayout.ParallelGroup hGroup = layout.createParallelGroup(GroupLayout.Alignment.LEADING);
        hGroup.addComponent(jpan1)
              .addComponent(jlabel2)
              .addComponent(jlabel3)        
              .addComponent(jlabel4).addGap(40);
 
        layout.setHorizontalGroup(hGroup);
        
        //����GroupLayout�Ĵ�ֱ�����飬��Խ�ȼ����ParallelGroup�����ȼ�����Խ�ߡ�
        GroupLayout.ParallelGroup vGroup = layout.createParallelGroup(GroupLayout.Alignment.LEADING);
        vGroup.addGroup(layout.createSequentialGroup()
        		.addComponent(jpan1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        		.addGap(66)
                .addComponent(jlabel2)
                .addGap(16)
                .addComponent(jlabel3)
                .addGap(16)
                .addComponent(jlabel4)
                .addGap(100)
        		);       
        layout.setVerticalGroup(vGroup);
        pack();
        
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
        	java.util.logging.Logger.getLogger(Show2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Show2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Show2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Show2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
        
    }
}
