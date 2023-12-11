package najah;

import static org.junit.Assert.assertTrue;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import najah.RegularVisitor;

public class search {
	guide guide;
	Admin admin;
	RegularVisitor rvis;
	int ids;
	int idv;
	boolean checks=false;
	boolean checkv=false;
	public search(Admin admin , guide guide,RegularVisitor rvis) {
		this.admin=admin;
		this.guide=guide;
		this.rvis=rvis;
		
	}
	
	@Given("that the admin is logged inssv")
	public void that_the_admin_is_logged_inssv() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		admin.setLoggedin(true);
	}




	@Given("Guide enter her id  {int}")
	public void guide_enter_her_id(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		ids=int1;
		
		
	}
	
	@Given("The guide IDs  exists in the Museum")
	public void the_guide_i_ds_exists_in_the_museum() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
		checks=guide.guideExist11(ids);
	}



	@When("the admin try to search that guide")
	public void the_admin_try_to_search_that_guide() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		if (checks==true) {
			guide.searchguide(ids);
			} 
		
	}
		
	
	@Then("search sucssed")
	public void search_sucssed() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
		assertTrue(checks);
	}

	

	@Then("search Guide fail")
	public void search_guide_fail() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
		assertTrue(!checks);
	}
}
/*
	
	
	@Given("That the Admin is logged inv")
	public void that_the_admin_is_logged_inv() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
		admin.setLoggedin(true);
	}
	@Given("Visitor enter her idv {int}")
	public void visitor_enter_her_idv(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	  //  throw new io.cucumber.java.PendingException();
		idv=int1;
	}
	@Given("The Visitor IDv  Exists in the Museum")
	public void the_visitor_i_dv_exists_in_the_museum() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
		//checkv=.guideExist11(idv);
	}
	@When("the admin try to Search that Visitor")
	public void the_admin_try_to_search_that_visitor() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
	
		
	}
	@Then("Searchss sucssed")
	public void searchss_sucssed() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
	}


	@Then("Searchss Visitor faild")
	public void searchss_visitor_faild() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
	}







	
}

/*@Given("The Visitor IDv  exists in the Museum")
	public void the_visitor_i_dv_exists_in_the_museum() {
	    // Write code here that turns the phrase above into concrete actions
	  //  throw new io.cucumber.java.PendingException();
		checkv=guide.guideExist11(idv);
	}
	@When("the admin try to search that Visitor")
	public void the_admin_try_to_search_that_visitor() {
	    // Write code here that turns the phrase above into concrete actions
	 //   throw new io.cucumber.java.PendingException();
		if (checkv==true) {
			guide.searchvisitors(id);
			} 
		
	}


	@Then("search Visitor faild")
	public void search_visitor_faild() {
	    // Write code here that turns the phrase above into concrete actions
	 //   throw new io.cucumber.java.PendingException();
	


	

}
*/
