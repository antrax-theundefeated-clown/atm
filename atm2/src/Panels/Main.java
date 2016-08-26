package Panels;

import javax.swing.*;
import java.awt.*;
import H.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main extends JFrame {

	private JLabel jLabel1;
    private JLabel jLabel2;
	
    public Main() {
        initComponents();
    }

static String arg[];                              
    private void initComponents() {

        jLabel2 = new JLabel();
        jLabel1 = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        jLabel2.setFont(new Font("Tahoma", 1, 48));
        jLabel2.setText("Welcome to K&A's Bank");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(380, 260, 640, 150);
        jLabel1.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent me)
        	{
        		ATM.main(arg);
        	}
        	
		});
        
        jLabel1.setIcon(new ImageIcon("C:\\Users\\Akshay\\Documents\\NetBeansProjects\\ATM\\blue_1.jpg"));
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1368, 765);

        pack();
    }                       

    
    public static void main(String args[]) {
      
    	arg = args;
    	
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                Main main = new Main();
                main.setExtendedState(JFrame.MAXIMIZED_BOTH);
                main.setVisible(true);
            }
        });
    }
                 
}
