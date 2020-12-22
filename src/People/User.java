package People;
import Software.*;

import java.io.Serializable;
import java.util.*;
public class User implements Serializable{
	public ArrayList<Build> builds;
	private String Username;
	private String Password;
	private String Currency;
	private String Email;
	private boolean SignedIn;
	public User() {
		builds = new ArrayList<Build>();
		Username = "";
		Password = "";
		Currency = "";
		Email = "";
		SignedIn = false;
	}
	public Boolean isSignedIn() {
		return SignedIn;
	}
	public void SignIn() {
		SignedIn = true;
	}
	public ArrayList<Build> getBuilds() {
		return builds;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getCurrency() {
		return Currency;
	}
	public void setCurrency(String currency) {
		Currency = currency;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public void addBuild(Build b) {
		this.builds.add(b);
	}
	public void CreateAccount(String username, String email, String password , String currency) {
		User account = new User();
		
		account.setCurrency(currency);
		account.setEmail(email);
		account.setPassword(password);
		account.setUsername(username);
		/// add user to the database file later///
	}
	public void printAccountinfo() {
		System.out.println("Name: "+Username);
		System.out.println("Email: "+Email);
		System.out.println("Currency: "+ Currency);
		System.out.println("Signed in: " + SignedIn);
		
	}
	public void SignOut() {
		SignedIn = false;
	}
	
}
