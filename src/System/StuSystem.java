package System;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
//ϵͳ������
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
    	
    	jlabel1.setFont(new Font("΢���ź�", 0, 24)); 
        jlabel1.setForeground(Color.black);
        jlabel1.setText("ѧ���ɼ�����ϵͳ");
        jlabel2.setText("����ѡ��");
        jbut1.setText("�鿴ѧ����Ϣ");
        jbut2.setText("����ѧ����Ϣ");
        

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
        
        //����GroupLayout�Ĵ�ֱ�����飬��Խ�ȼ����ParallelGroup�����ȼ�����Խ�ߡ�
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