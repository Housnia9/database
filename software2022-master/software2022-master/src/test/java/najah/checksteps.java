
package najah;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import najah.Admin;
import najah.guide;
import najah.RegularVisitor;
import najah.SeniorVisitor;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class checksteps {
	Admin admin;
	guide guide;
	RegularVisitor rv;
	SeniorVisitor sv;
	public checksteps(Admin admin,guide guide,RegularVisitor rv,SeniorVisitor sv) {
		super();
		this.admin=admin;
		this.guide=guide;
		this.sv=sv;
		this.rv=rv;
	}
	boolean isLoggedin=false;
	boolean islog=false;
	String password;
	String nam;
	String pass;
	String namr;
	String passr;
	boolean regg=false;
	boolean exist=false;
	boolean nan=false;
	boolean bb=false;
	boolean r=false;
	boolean s=false;
	boolean v=false;
	boolean ss=false;
	@Given("that the admin is not logged in")
	public void thatTheAdminIsNotLoggedIn() {
		
	}
	@Given("the password is {string}")
	public void thePasswordIs(String string) {
		this.password = string;
	    this.isLoggedin = admin.login(this.password);
	    
	}
	   
	@Then("the admin login succeeds")
	public void theAdminLoginSucceeds() {
		 assertTrue(this.isLoggedin); 
	}
	@Then("the admin is logged in")
	public void theAdminIsLoggedIn() {
		assertTrue(this.isLoggedin);   
	}

	

	
	@Then("the admin login fails")
	public void theAdminLoginFails() {assertTrue(!this.isLoggedin);  
		
	}
	@Then("the admin is not logged in")
	public void theAdminIsNotLoggedIn() {assertTrue(!this.isLoggedin);  
		
	}

	
	
	@Given("that the User is not logged in")
	public void that_the_user_is_not_logged_in() {
	   
	}
	@Given("the username is {string} ,password {string} for user")
	public void the_username_is_password_for_user(String string, String string2) {
this.nam=string;
this.pass=string2;
	this.bb=guide.checknameandpass(nam,pass);
		
	
		
		
		
	}
	
	@Given("the user is already rigisterd")
	public void the_user_is_already_rigisterd() {
		
this.nan=guide.eguideex(guide);
	
	}
	
	



	@Then("the user login succeeds")
	public void the_user_login_succeeds() {
		
		assertTrue(bb&&nan);   
	}
	@Then("the user is logged in")
	public void the_user_is_logged_in() {
		
		assertTrue(bb&&nan);    
	}


	
	
	@Then("the User login fails")
	public void the_user_login_fails() { 	
		assertTrue(!(bb&&nan));   
	
		  
	}
	@Then("the User is not logged in")
	public void the_user_is_not_logged_in() {  
		assertTrue(!(bb&&nan));   
	}



	
	@Given("that the visitor is not logged in")
	public void that_the_visitor_is_not_logged_in() {
	  
	}
	@Given("the visitor is already rigisterd")
	public void the_visitor_is_already_rigisterd() {
		this.r=rv.regexist(rv);
	    this.s=sv.sengexist(sv);
	  
	}
	@Given("the username is {string} ,password {string} for visitor")
	public void the_username_is_password_for_visitor(String string, String string2) {
	namr=string;
	passr=string2;
	
	this.v=rv.checknameandpass(namr,passr);	
	this.ss=sv.	checknameandpass(namr,passr);	
		
		
	  
	}
	@Then("the visitor login succeeds")
	public void the_visitor_login_succeeds() {assertTrue((r&&v)||(s&&ss));    
	   
	}
	@Then("the visitor is logged in")
	public void the_visitor_is_logged_in() {
		assertTrue((r&&v)||(s&&ss));   
	}



	
	
	@Then("the visitor login fails")
	public void the_visitor_login_fails() {assertTrue(!((r&&v)||(s&&ss)));    
	   
	}
	@Then("the visitor is not logged in")
	public void the_visitor_is_not_logged_in() {assertTrue(!((r&&v)||(s&&ss)));   
	    
	}



	
	

	
	
	
	
	
	
	
	
	








}	

	
	
	
	
	
	
	
	
	








