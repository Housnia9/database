package najah;
import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import najah.guide;
import najah.RegularVisitor;
import najah.SeniorVisitor;
import najah.Admin;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class serviceshavetesttt {
	Admin admin;
	
	public serviceshavetesttt (Admin admin){
		
		this.admin=admin;
		
	}
	
	
	
	@Given("that the admin is logged insss")
	public void that_the_admin_is_logged_insss() {
		  admin.setLoggedin(true); 
	}



	
	
	@Then("the servises ba printed")
	public void the_servises_ba_printed() {
		assertTrue(admin.isLoggedin());       
	}
	
	@Given("that the admin is not logged insss")
	public void that_the_admin_is_not_logged_insss() {
		admin.setLoggedin(false);
	}



	@When("show servises in muesum")
	public void show_servises_in_muesum() {
	  admin.showsrv();
	}
	@Then("the servises printed faild")
	public void the_servises_printed_faild() {
		
		assertTrue(!admin.isLoggedin());       
	}





	
	
	
	
	
}