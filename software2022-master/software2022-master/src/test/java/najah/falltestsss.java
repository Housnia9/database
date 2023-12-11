
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
public class falltestsss {
	
	

		Admin admin;
		SeniorVisitor sv;
		RegularVisitor rv;
		guide guide;
		OneTimeTicket onetick;
		MultiTimeTicket  multy;
	
	
		public  falltestsss(Admin admin,guide guide,OneTimeTicket onetick,MultiTimeTicket  multy ,SeniorVisitor sv,RegularVisitor rv){
			this.admin=admin;
			this.sv=sv;
			this.rv=rv;
			this.guide=guide;
			this.onetick=onetick;
			this.multy=multy;
			
			
		}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Given("that the admin is logged inss")
	public void that_the_admin_is_logged_inss() {
	  admin.setLoggedin(true); 
	}
	@When("show information in muesum")
	public void show_information_in_muesum() {
	 
		admin.showinf(onetick,rv,sv,multy,guide);
		
		
		
		
		
		
		
	}
	@Then("the informatin ba printed")
	public void the_informatin_ba_printed() {
		assertTrue(admin.isLoggedin());     
	}

	
	@Given("that the admin isnot logged ins")
	public void that_the_admin_isnot_logged_ins() {
	admin.setLoggedin(false);   
	}
	
	@Then("the informatin ba printed faild")
	public void the_informatin_ba_printed_faild() {
		assertTrue(!admin.isLoggedin());     
	}




	
	
	
	
	
	
	
	
}