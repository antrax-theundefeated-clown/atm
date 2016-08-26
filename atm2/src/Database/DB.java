package Database;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class DB {
	
	Connection con;
	Statement st;
	
	public Statement createConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.104:1521:xe", "system", "akshay");
			st = con.createStatement();
			return st;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;				

	}
	
	public boolean verifyUser(int user, int pin)
	{
		try {
			ResultSet rs = st.executeQuery("select acc_no, pin from customer_details");
			while(rs.next())
			{
				if(rs.getInt(1)==user && rs.getInt(2)==pin)
					return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public void createAccount(int acc_no, String fname, String lname, String dob, String acc_type,
			String pin) throws NoSuchAlgorithmException { 
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] pinn = md.digest(pin.getBytes());
	
		try {
			createConnection();
			st.execute("insert into customer_details values (" + acc_no + ",'" + fname  + "','" + lname + "','"	+ acc_type + "','" + dob + "', 0 ,'" + pinn.toString() + "')");
           JOptionPane.showMessageDialog(null, "Account Created");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
		
}
