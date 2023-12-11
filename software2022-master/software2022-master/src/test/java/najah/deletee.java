package najah;

import static org.junit.Assert.assertTrue;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class deletee {
	

guide guide;
Admin admin;
boolean check=false;
boolean nf=false;
int idg;
//String result = new String ();
//private Scanner inpot;

public deletee(Admin admin , guide guide) {
	this.admin=admin;
	this.guide=guide;
	
}

	@Given("that the admin is logged ins")
	public void that_the_admin_is_logged_ins() {
	    // Write code here that turns the phrase above into concrete actions
	  // throw new io.cucumber.java.PendingException();
		admin.setLoggedin(true);
	}
	@Given("Guide enter her id {int}")
	public void guide_enter_her_id(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
		idg=int1;
	}
	@Given("The guide ID  exist in the Museum")
	public void the_guide_id_exist_in_the_museum() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
		check=guide.guideExist11(idg);
	}
	@When("the admin try to Delete that guide")
	public void the_admin_try_to_delete_that_guide() {
	    // Write code here that turns the phrase above into concrete actions
	  //  throw new io.cucumber.java.PendingException();
		if (check==true) {
			guide.DeleteGuidee(idg);
			} 
		
	}
	@Then("Delete Failds")
	public void delete_failds() {
	    // Write code here that turns the phrase above into concrete actions
	  //  throw new io.cucumber.java.PendingException();

		assertTrue(!check);
	}


	@Then("Delete Guide sucssed")
	public void delete_guide_sucssed() {
	    // Write code here that turns the phrase above into concrete actions
	 //   throw new io.cucumber.java.PendingException();
		//assertTrue(!check);
		assertTrue(check);
	}




}
