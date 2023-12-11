package najah;

import static org.junit.Assert.assertTrue;


import java.text.ParseException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import najah.MultiTimeTicket;

public class searchVisitor {
	Admin admin;
	MultiTimeTicket mult;
	OneTimeTicket ticket;
	RegularVisitor rigv;
	SeniorVisitor senv;
	int idv;
	String dob;
	boolean checkv=false;
	boolean checki=false;
	boolean result=false;
	
	int flag=0;
	
	
	
	public searchVisitor(Admin admin , MultiTimeTicket mult,RegularVisitor rigv,SeniorVisitor senv,OneTimeTicket ticket) {
		this.admin=admin;
		this.mult=mult;
		this.rigv=rigv;
		this.senv=senv;
		this.ticket=ticket;
		//this.flag=flag;
	}

	@Given("That the Admin is logged inv")
	public void that_the_admin_is_logged_inv() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
		admin.setLoggedin(true);
	}
	@Given("Visitor enter her dob {string}")
	public void visitor_enter_her_dob(String string) {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
		dob=string;
		//System.out.println(dob);
		//System.out.println("here ");
	}
	@Given("Visitor enter her idv {int}")
	public void visitor_enter_her_idv(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
		idv=int1;
		//System.out.println(idv);
	}
	
	




	@Given("The Visitor dob Exist in the Museuam")
	public void the_visitor_dob_exist_in_the_museuam() throws ParseException {
	    // Write code here that turns the phrase above into concrete actions
	  //  throw new io.cucumber.java.PendingException();
		checkv=mult.chcage(dob);
		//System.out.println(checkv);
	}
	@Given("The Visitor IDv  Exists in the Museum")
	public void the_visitor_i_dv_exists_in_the_museum() {
	    // Write code here that turns the phrase above into concrete actions
	  //  throw new io.cucumber.java.PendingException();
		if(checkv==true) {
			checki=rigv.checkid(idv);
			
			//System.out.println(checki);
			result=true;
		
		}
		checki=senv.checkid(idv);
		//System.out.println("llllll");
		//System.out.println(result);
	
	}
	@When("the admin try to Search that Visitor")
	public void the_admin_try_to_search_that_visitor() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
	//	if(resau)
		if(result==false) {
			flag=1;
			senv.searchvissss(idv, mult);
			//flag=1;
			ticket. showticket(idv,flag);
			mult.showtickett(idv,flag);
			//System.out.println("kkkkkkkkkkkkkk");
			//System.out.println(idv);
			
			
		}
		else {
			rigv.searchh(idv);
			ticket. showticket(idv,flag);
			mult.showtickett(idv,flag);
			
			
			
		}
		
	}
	@Then("Searchss sucssed")
	public void searchss_sucssed() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
		assertTrue(checki);
	}
	
	
	@Then("Searchss Visitor faild")
	public void searchss_visitor_faild() {
	    // Write code here that turns the phrase above into concrete actions
	  //  throw new io.cucumber.java.PendingException();
		assertTrue(!checki);
	}










}
