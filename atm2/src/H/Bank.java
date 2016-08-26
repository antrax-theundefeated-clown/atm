package H;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

import Database.DB;

public class Bank {

	private String name;

	private ArrayList<User> users;

	private ArrayList<Account> accounts;

	public Bank(String name) {

		this.name = name;
		users = new ArrayList<User>();
		accounts = new ArrayList<Account>();

	}

	public String getNewUserUUID() {
		try {
			String uuid;
			Random rng = new Random();
			int len = 6;
			boolean nonUnique;
			Statement st = new DB().createConnection();
			ResultSet resultSet = st.executeQuery("select count(*) from customer_details");
			int size = 0;
			if(resultSet.next())
			size = resultSet.getInt(1);
		
			int[] accNo = new int[size];
			size = 0;
			ResultSet rs;
			rs = st.executeQuery("select acc_no from customer_details");
			while (rs.next()) {
				accNo[size] = rs.getInt(1);
				size++;
			}
					
			do {

				uuid = "";
				for (int c = 0; c < len; c++) {
					uuid += ((Integer) rng.nextInt(10)).toString();
				}

				int id = Integer.parseInt(uuid);
				nonUnique = false;
				
				for (int i : accNo) {
					if (id==i) {
						nonUnique = true;
						break;
					}else nonUnique = false;
				}

			} while (nonUnique);

			return uuid;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public String getNewAccountUUID() {

		String uuid;
		Random rng = new Random();
		int len = 10;
		boolean nonUnique = false;

		do {

			uuid = "";
			for (int c = 0; c < len; c++) {
				uuid += ((Integer) rng.nextInt(10)).toString();
			}

			for (Account a : this.accounts) {
				if (uuid.compareTo(a.getUUID()) == 0) {
					nonUnique = true;
					break;
				}
			}

		} while (nonUnique);

		return uuid;

	}

	public User addUser(String firstName, String lastName, String pin) {

		User newUser = new User(firstName, lastName, pin, this);
		this.users.add(newUser);

		Account newAccount = new Account("Savings", newUser, this);
		newUser.addAccount(newAccount);
		this.accounts.add(newAccount);

		return newUser;

	}

	public void addAccount(Account newAccount) {
		this.accounts.add(newAccount);
	}

	public User userLogin(String userID, String pin) {

		for (User u : this.users) {

			if (u.getUUID().compareTo(userID) == 0 && u.validatePin(pin)) {
				return u;
			}
		}

		return null;

	}

	public String getName() {
		return this.name;
	}

}