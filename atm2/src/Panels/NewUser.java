package Panels;

import javax.swing.*;

import Database.DB;
import H.ATM;

import java.awt.*;
import java.awt.event.*;
import java.security.NoSuchAlgorithmException;

public class NewUser extends javax.swing.JPanel {

	private JComboBox<String> accType;
    private JLabel acc_no;
    private JTextField dob;
    private JTextField fname;
    private JButton submit;
    private JButton cancel;
    private JLabel jLabel1;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JTextField lname;
    private JTextField pin;
   
    public NewUser() {
        initComponents();
    }

                            
    private void initComponents() {

        acc_no = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        lname = new JTextField();
        dob = new JTextField();
        pin = new JTextField();
        fname = new JTextField();
        accType = new JComboBox<>();
        submit = new JButton();
        cancel = new JButton();
        jLabel1 = new JLabel();

        setLayout(null);

        acc_no.setFont(new Font("Tahoma", 0, 24)); 
        add(acc_no);
        acc_no.setBounds(670, 120, 210, 60);
        acc_no.setText(new H.Bank("").getNewUserUUID());

        jLabel3.setFont(new Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("First Name :");
        add(jLabel3);
        jLabel3.setBounds(420, 210, 210, 60);

        jLabel4.setFont(new Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Last Name :");
        add(jLabel4);
        jLabel4.setBounds(420, 300, 210, 60);

        jLabel5.setFont(new Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("Date of Birth :");
        add(jLabel5);
        jLabel5.setBounds(420, 380, 210, 60);

        jLabel6.setFont(new Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setText("Pin :");
        add(jLabel6);
        jLabel6.setBounds(420, 560, 210, 60);

        jLabel7.setFont(new Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setText("Account Number :");
        add(jLabel7);
        jLabel7.setBounds(420, 120, 210, 60);

        jLabel8.setFont(new Font("Tahoma", 0, 24)); // NOI18N
        jLabel8.setText("Account Type :");
        add(jLabel8);
        jLabel8.setBounds(420, 470, 210, 60);

        lname.setFont(new Font("Tahoma", 0, 18)); 
        add(lname);
        lname.setBounds(670, 310, 210, 30);

        dob.setFont(new Font("Tahoma", 0, 18)); 
        add(dob);
        dob.setBounds(670, 390, 210, 30);

        pin.setFont(new Font("Tahoma", 0, 18)); 
        add(pin);
        pin.setBounds(670, 570, 210, 30);

        fname.setFont(new Font("Tahoma", 0, 18)); 
        add(fname);
        fname.setBounds(670, 220, 210, 30);

        accType.setFont(new Font("Tahoma", 0, 18)); 
        accType.setModel(new DefaultComboBoxModel<>(new String[] { "Current", "Savings" }));
        add(accType);
        accType.setBounds(670, 490, 210, 30);

        submit.setFont(new Font("Tahoma", 0, 24)); // NOI18N
        submit.setText("Create");
        submit.setContentAreaFilled(false);
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                
            	try {
            		         		
					new DB().createAccount(Integer.parseInt(acc_no.getText()), fname.getText(), lname.getText(), dob.getText(), accType.getSelectedItem().toString(), pin.getText());
				} catch (NumberFormatException | NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	String [] args = {};
            	ATM.main(args);
            }
        });
        add(submit);
        submit.setBounds(480, 680, 140, 40);

        cancel.setFont(new Font("Tahoma", 0, 24)); // NOI18N
        cancel.setText("Cancel");
        cancel.setContentAreaFilled(false);
        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

            	
            	System.exit(0);
            	
            }
        });
        add(cancel);
        cancel.setBounds(700, 680, 130, 40);

        jLabel1.setIcon(new ImageIcon("C:\\Users\\Akshay\\Documents\\NetBeansProjects\\ATM\\blue_1.jpg")); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setPreferredSize(new java.awt.Dimension(1368, 765));
        add(jLabel1);
        jLabel1.setBounds(0, 0, 1368, 765);
    }                       

                                         
                
}
