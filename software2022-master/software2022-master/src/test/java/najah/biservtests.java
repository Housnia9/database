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
public class  biservtests{
	
	String service;
	String want;
	int idd;
	String dopp;
	boolean flagageser;
	boolean exr=false;
	boolean exs=false;
	Admin admin;
	SeniorVisitor sv;
	RegularVisitor rv;
	guide guide;
	OneTimeTicket onetick;
	MultiTimeTicket  multy;
	String dop;
	String type;
	int ids;
	boolean flagage =false;
	boolean flagday =false;
	boolean flagyear =false;
	boolean flagone =false;
	boolean flagmanth =false;
	boolean flagdays =false;
	boolean flagyears =false;
	boolean flagones =false;
	boolean flagmanths =false;
	boolean flagexistr=false;
	boolean flagexists=false;
	public biservtests (Admin admin,guide guide,OneTimeTicket onetick,MultiTimeTicket  multy ,SeniorVisitor sv,RegularVisitor rv){
		this.admin=admin;
		this.sv=sv;
		this.rv=rv;
		this.guide=guide;
		this.onetick=onetick;
		this.multy=multy;
		
		
	}
	
	
	
	@Given("that the admin is logged inscc")
	public void that_the_admin_is_logged_inscc() {
	 admin.setLoggedin(true);   
	}
	@Given("the visitor enter {string} ,the name of service {string} ,visitorid {int} ,dop {string}")
	public void the_visitor_enter_the_name_of_service_visitorid_dop(String string, String string2, Integer int1, String string3) {
		want=string;
		service=string2;
		idd=int1;
		dopp=string3;
		
		
	}
	@Given("the visitor is exist")
	public void the_visitor_is_exist() throws ParseException {
		
		flagageser	=multy.chcage(dopp);
		
		if(flagageser==true) {
			
			
			exr=rv.checkid(idd);
			
			
			
		}
		
		if(this.flagageser==false) {
			
		exs=sv.checkid(idd)	;
			
			
			
		}
	   
	}
	@When("add the service to visitor")
	public void add_the_service_to_visitor() {
		
		if(want.equals("yes")&&exr==true) {
			
			rv.addserv(idd,service);
			
			
			
		}
		
		if(want.equals("yes")&&exs==true) {
			
			sv.addserv(idd,service);
			
			
			
		}
		
		
		
		
		
      if(want.equals("No")||(exr==false&&exs==false)) {
			
			
			
			
			
		}
		
		
		
		
	    
	}
	@Then("service added to visitor")
	public void service_added_to_visitor() {
	  
		
		
		
		assertTrue((want.equals("yes")&&exr==true||want.equals("yes")&&exs==true));
	}

	
	
	
	
	
	
	
	@Then("service not added to visitor")
	public void service_not_added_to_visitor() {
		assertTrue(!(want.equals("yes")&&exr==true||want.equals("yes")&&exs==true));  
	}

	
	
	
	
	@Given("enter visitor id {int} and type {string} and dob {string}")
	public void enter_visitor_id_and_type_and_dob(Integer int1, String string, String string2) {
	  dop=string2;
	  type=string;
	  ids=int1;
	  
	}
	@Given("the visitor is exist and this type exist for this visitor")
	public void the_visitor_is_exist_and_this_type_exist_for_this_visitor() throws ParseException {
	this.flagage= multy.chcage(dop) ; 
	if(flagage==true) {
		
	this.flagexistr=rv.checkid(ids)	;
	if(flagexistr==true) {
if(type.toUpperCase().equals("DAILY")) {
		this.flagday=multy.dail(ids,rv);
		
		
	}
	
 if(type.toUpperCase().equals("MONTHLY")) {
		this.flagmanth=multy.month(ids,rv);
		
		
		
	}
 if(type.toUpperCase().equals("ONE")) {
		
		this.flagone=onetick.one(ids,rv);
		
		
	}
	
	
 if(type.toUpperCase().equals("YEARLY")) {
	this.flagyear=multy.year(ids,rv);
	
	
	
}}	
		
	}
	 if(flagage==false) {
		
		this.flagexists=sv.checkid(ids);
		if(flagexists==true) {
		if(type.toUpperCase().equals("DAILY")) {
			this.flagdays=multy.dails(ids, sv);
			
			
		}
		
	 if(type.toUpperCase().equals("MONTHLY")) {
			this.flagmanths=multy.months(ids, sv);
			
			
			
		}
	 if(type.toUpperCase().equals("ONE")) {
			
			this.flagones=onetick.ones(ids, sv);
			
			
		}
		
		
	 if(type.toUpperCase().equals("YEARLY")) {
		this.flagyears=multy.years(ids, sv);
		
		
		
	}	}
		
	}
	



	
	
	
	
	
	}
	@When("bbiling")
	public void bbiling() {
	
		if(flagage==true) {
			
			
			if(flagday==true) {
		
		multy.billingdr(rv,ids);	
				
			}
			
		 if(flagmanth==true) {
				
			multy.biillingmr(rv,ids);
				
				
			}
		 if(flagone==true) {
				
			onetick .billinonr(rv,ids);	
				
			}
			
			
		 if(flagyear==true) {
			
			 multy.billinoyear(rv,ids);	
					
			
		}
		 
		
		
		
		
		
		
		}	
				
			
			 if(flagage==false) {
				
				
				if(flagdays==true) {
				
					 multy.billinodayss(sv,ids);		
					
				}
				
			 if(flagmanths) {
					
				 multy.billinodmontss(sv,ids);			
					
				}
			 if(flagones==true) {
					
				 onetick.billinodoness(sv,ids);			
					
					
				}
				
				
			 if(flagyears==true) {
				
				multy.bllingyearsss(sv,ids);
				
				
			}	
					
		
			 }
		
		
		
		
	}
	@Then("the billing ba printed")
	public void the_billing_ba_printed() {
	  
	}

	
	@Then("the billing ba printed failed")
	public void the_billing_ba_printed_failed() {
	  
	}



	
	
	
}