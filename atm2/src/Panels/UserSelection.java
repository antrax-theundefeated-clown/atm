package Panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UserSelection extends javax.swing.JPanel {

	private JButton jButton1;
    private JButton jButton2;
    private JLabel jLabel1;
    
    
    public UserSelection() {
        initComponents();
    }

                        
    private void initComponents() {

        jButton1 = new JButton();
        jButton2 = new JButton();
        jLabel1 = new JLabel();

        setPreferredSize(new Dimension(1368, 765));
        setLayout(null);

        jButton1.setFont(new Font("Tahoma", 1, 36)); 
        jButton1.setText("Existing User");
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                
            	
            	
            	
            }
        });
        add(jButton1);
        jButton1.setBounds(560, 280, 310, 80);

        jButton2.setFont(new Font("Tahoma", 1, 36));
        jButton2.setText("New User");
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                
            	JFrame jf = new JFrame();
            	jf.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            	jf.setUndecorated(true);
            	jf.setResizable(false);
        		NewUser us = new NewUser();
        		jf.add(us);
        		jf.setExtendedState(JFrame.MAXIMIZED_BOTH);
				jf.setVisible(true);
            	
            }
        });
        add(jButton2);
        jButton2.setBounds(560, 400, 310, 80);

        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setIcon(new ImageIcon("C:\\Users\\Akshay\\Documents\\NetBeansProjects\\ATM\\blue_1.jpg"));
        jLabel1.setIconTextGap(0);
        jLabel1.setMaximumSize(new Dimension(1368, 765));
        jLabel1.setPreferredSize(new Dimension(1368, 765));
        add(jLabel1);
        jLabel1.setBounds(0, 0, 1368, 765);
    }                     

                       
            
}
