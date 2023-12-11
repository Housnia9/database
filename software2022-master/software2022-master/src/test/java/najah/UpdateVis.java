package najah;

import static org.junit.Assert.assertTrue;


import java.text.ParseException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import najah.MultiTimeTicket;

public class UpdateVis {
	Admin admin;
	MultiTimeTicket mult;
	//MultiTimeTicket mult;
	OneTimeTicket ticket;
	RegularVisitor rigv;
	SeniorVisitor senv;
	int ids;
	String dobb;
	int flag=0;
	boolean checkv=false;
	boolean checki=false;
	boolean result=false;
	String namesen;
	String namerig;
	
	public UpdateVis(Admin admin , MultiTimeTicket mult,RegularVisitor rigv,SeniorVisitor senv,OneTimeTicket ticket) {
		this.admin=admin;
		this.mult=mult;
		this.rigv=rigv;
		this.senv=senv;
		this.ticket=ticket;
		
	}
	
	@Given("that the Admin is logged invs")
	public void that_the_admin_is_logged_invs() {
	    // Write code here that turns the phrase above into concrete actions
	  //  throw new io.cucumber.java.PendingException();
		admin.setLoggedin(true);
	}
	@Given("Visitor enter her dobb {string}")
	public void visitor_enter_her_dobb(String string) {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
		dobb=string;
	}
	@Given("Visitor enter her idss {int}")
	public void visitor_enter_her_idss(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	  //  throw new io.cucumber.java.PendingException();
		ids=int1;
	}
	@Given("The Visitor dobb Exist in the Museuam")
	public void the_visitor_dobb_exist_in_the_museuam() throws ParseException {
	    // Write code here that turns the phrase above into concrete actions
	  //  throw new io.cucumber.java.PendingException();
		checkv=mult.chcage(dobb);
	}
	
	@Given("The Visitor IDs  Exists in the Museum")
	public void the_visitor_i_ds_exists_in_the_museum() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
		if(checkv==true) {
			checki=rigv.checkid(ids);
			
			
			
			result=true;
		
		}
	
		checki=senv.checkid(ids);
	}
	
	
	@Given("update Senior Visitor name  to {string}")
	public void update_senior_visitor_name_to(String string) {
	    // Write code here that turns the phrase above into concrete actions
	  //  throw new io.cucumber.java.PendingException();
		namesen=string;
	}
	

	@Given("update Regular Visitor names to {string}")
	public void update_regular_visitor_names_to(String string) {
	    // Write code here that turns the phrase above into concrete actions
	  //  throw new io.cucumber.java.PendingException();
		namerig=string;
	}









	@When("the admin try to Updatee that Visitor")
	public void the_admin_try_to_updatee_that_visitor() {
	    // Write code here that turns the phrase above into concrete actions
	  //  throw new io.cucumber.java.PendingException();
		if(result==false) {
			flag=1;
			senv.Updatenamesen(ids, namesen);
			
		}
		else {
			rigv.updatenamerigv(ids,namerig);
		}
		
	}
	@Then("Update Sucssedd")
	public void update_sucssedd() {
	    // Write code here that turns the phrase above into concrete actions
	  //  throw new io.cucumber.java.PendingException();
		assertTrue(checki);
	}
	
	

	

	@Then("Updatee Visitor faild")
	public void updatee_visitor_faild() {
	    // Write code here that turns the phrase above into concrete actions
	  //  throw new io.cucumber.java.PendingException();
		assertTrue(!checki);
	}










}
