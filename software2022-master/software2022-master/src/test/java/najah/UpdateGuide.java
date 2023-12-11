package najah;

import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import najah.guide;
import najah.Admin;

public class UpdateGuide {
	private Admin admin;
	private guide guide;
int idup;
String nameup;
boolean checkidup=false;
	public UpdateGuide(Admin admin , guide guide) {
		this.admin=admin;
		this.guide=guide;
		
		
	}


	@Given("that the Admin is logged insu")
	public void that_the_admin_is_logged_insu() {
	    // Write code here that turns the phrase above into concrete actions
	 //   throw new io.cucumber.java.PendingException();
		admin.setLoggedin(true);
	}
	@Given("Guide enter herr id {int}")
	public void guide_enter_herr_id(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	  //  throw new io.cucumber.java.PendingException();
		idup=int1;
	}
	@Given("The guide IDu  exist in the Museum")
	public void the_guide_i_du_exist_in_the_museum() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
		checkidup=guide.guideExist11(idup);
	}


	
	@Given("update her name to {string}")
	public void update_her_name_to(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		nameup=string;
	}




	@When("the admin try to Update that guide")
	public void the_admin_try_to_update_that_guide() {
	    // Write code here that turns the phrase above into concrete actions
	  //  throw new io.cucumber.java.PendingException();
		if (checkidup==true) {
			guide.Updateguide(nameup,idup);
			
			}
	}
	



@Then("Update Sucssed")
	public void update_sucssed() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
	assertTrue(checkidup);
	}

	
	@Then("Updatee Guide faild")
	public void updatee_guide_faild() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		assertTrue(!checkidup);
	}










	

}
