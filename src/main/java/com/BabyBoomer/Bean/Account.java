package com.BabyBoomer.Bean;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account {
	
	private int id;
	
	private String firstname, lastname, username, email, password, mobile;
	
	
	
	
	

	public Account(String firstname, String lastname, String username, String email, String password,
			String mobile) throws Exception{
		
		super();
		if((validateWhiteSpace(firstname))  && (validateWhiteSpace(lastname)) && (validateWhiteSpace(username))  && (validateWhiteSpace(email))&& (valEmail(email))  && (validateWhiteSpace(password)) && (valPassword(password)) && (validateWhiteSpace(mobile)) && (valMobile(mobile)))
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
	}

	public Account(int id, String firstname, String lastname, String username, String email, String password,
			String mobile) throws Exception {
		super();
		if((validateWhiteSpace(firstname))  && (validateWhiteSpace(lastname)) && (validateWhiteSpace(username))  && (validateWhiteSpace(email))&& (valEmail(email))  && (validateWhiteSpace(password)) && (validateWhiteSpace(mobile)) && (valMobile(mobile)))
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) throws Exception{
		this.mobile = mobile;
	}
	
	
	public static Boolean validateWhiteSpace (String item) throws Exception {
		
		if(!(item.trim().isEmpty()) || !(item == null)) {
		return true;
		}
		
		throw new Exception();
	}
	
	
	public static Boolean valEmail(String item) {
		
		String regex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
		Pattern pat = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher matched =pat.matcher(item);
		
		return matched.find();
	}
	
	public static Boolean valMobile(String item) {
		
		String regex = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$" 
			      + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$" 
			      + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$";
		Pattern pat = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher match = pat.matcher(item);
		
		return match.find();
	}
	
	public static Boolean valPassword(String item) {
		
		String regex = "  ^[(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).*{8,20}$\n]";
		Pattern pat = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher match = pat.matcher(item);
		return match.find();
		
	}

	@Override
	public String toString() {
		return "Account [ Id = " + id + ", firstname = " + firstname + ", lastname=  " + lastname + ", username = " + username
				+ ", email = " + email + ", password = " + password + ", mobile = " + mobile + "]";
	}
	
	
	
	

}
