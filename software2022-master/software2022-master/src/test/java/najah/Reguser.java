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
public class Reguser {
	Admin admin;
	SeniorVisitor sv;
	RegularVisitor rv;
	guide guide;
	OneTimeTicket onetick;
	MultiTimeTicket  multy;
	boolean age =false;
	boolean age2 =false;
	boolean exist=false;
	boolean nan=false;
	boolean bb=false;
	
	public  Reguser(Admin admin,guide guide,OneTimeTicket onetick,MultiTimeTicket  multy ,SeniorVisitor sv,RegularVisitor rv){
		this.admin=admin;
		this.sv=sv;
		this.rv=rv;
		this.guide=guide;
		this.onetick=onetick;
		this.multy=multy;
		
		
	}
	


	String resultd = new String ();
	String result = new String ();
	String result2=new String();
	String result3=new String();
	String result4=new String();
	String results=new String();
	String resultv=new String();
	
	
	

	@Given("that admin  not logged in")
	public void that_admin_not_logged_in() {
		admin.setLoggedin(false);
	}
	@Given("that admin logged in")
	public void that_admin_logged_in() {
		admin.setLoggedin(true);  
	}
	
	
	@Given("that the admin is logged in")
	public void that_the_admin_is_logged_in() {
		admin.setLoggedin(true);    
	}
	
	
	@Given("there is a user with ID {int}, name {string}, email {string} ,Address {string} , postal code {string} , dob {string} ,visitsount {int} , visitorflag {int},discount {double} ,enterindate {string} , hour {int} and minute {int}")
	public void there_is_a_user_with_id_name_email_address_postal_code_dob_visitsount_visitorflag_discount_enterindate_hour_and_minute1(Integer int1, String string, String string2, String string3, String string4, String string5, Integer int2, Integer int3, Double double1, String string6, Integer int4, Integer int5) {
		ArrayList<VisitorRecord> o = new ArrayList<VisitorRecord>();  
		VisitorRecord s;
		s=new VisitorRecord(int4,int5,string6);
		s.hour=int4;
		s.minute=int5;
		s.entringdate=string6;
		s=new VisitorRecord(int4,int5,string6);
	//	o.add(s);
		
		sv=new SeniorVisitor( int1,  string,  string2,  string3,  string4,  string5,  int2,  int3,  double1,o) ;
		
		//rv=new RegularVisitor(int1,  string,  string2,  string3,  string4,  string5,  int2,  int3,o) ;
		 resultd=string5;
		
	

	}
	
	
	@Given("there is a user with ID {int}, name {string}, email {string} ,Address {string} , postal code {string} , dob {string} ,visitsount {int} , visitorflag {int} ,discount {double} ,enterindate {string} , hour {int} and minute {int}")
	public void there_is_a_user_with_id_name_email_address_postal_code_dob_visitsount_visitorflag_discount_enterindate_hour_and_minute(Integer int1, String string, String string2, String string3, String string4, String string5, Integer int2, Integer int3, Double double1, String string6, Integer int4, Integer int5) {
		
	}   
	
	

	@Given("his age is more than {int}")
	public void his_age_is_more_than(Integer int1) throws ParseException {
		
	this.age=this.sv.checkage(this.sv,int1,sv.dob);

		
		
	
	}

	
	@When("the user is added to the system")
	public void the_user_is_added_to_the_system() {
	 
		  results=	this.sv.addseniors(admin,sv);
		  
		  
		  
	
		  
		  
		  
	  }
	
	@Then("the already exist message  {string} is displayed")
	public void the_already_exist_message_is_displayed(String string) {
		assertEquals(results,string);
	}
	@Then("the user added successfully to the system")
	public void the_user_added_successfully_to_the_system() {
		assertTrue(results.equals( "User added successfully to the system") &&sv.sengExist(sv) &&sv.issReg()&&age);		
		     
	}
	

	@Then("the error message {string} is displayed")
	public void the_error_message_is_displayed(String string) {
		assertEquals(results,string);    
	}

	

	
	
	
	
	@Then("the message add user appears {string}")
	public void the_message_add_user_appears(String string) {assertEquals(results,string);
	   
	}

	


	
	
	
	
	
	@Given("that admin logged in regular visitos")
	public void that_admin_logged_in_regular_visitos() {admin.setLoggedin(true);
	   
	}
	@Given("that admin  not logged in for regular visitor")
	public void that_admin_not_logged_in_for_regular_visitor() {
		admin.setLoggedin(false);
	}
	@Given("that the admin is logged in regular visitos")
	public void that_the_admin_is_logged_in_regular_visitos() {admin.setLoggedin(true);
	   
	}
	@Given("his age is less than {int}")
	public void his_age_is_less_than(Integer int1) throws ParseException {
		this.age2=this.rv.checkage(this.rv,int1,rv.dob);
	}
	@Given("there is a regular visitos with ID {int}, name {string}, email {string} ,Address {string} , postal code {string} , dob {string} ,visitsount {int} , visitorflag {int} ,enterindate {string} , hour {int} and minute {int}")
	public void there_is_a_regular_visitos_with_id_name_email_address_postal_code_dob_visitsount_visitorflag_enterindate_hour_and_minute(Integer int1, String string, String string2, String string3, String string4, String string5, Integer int2, Integer int3, String string6, Integer int4, Integer int5) {
		ArrayList<VisitorRecord> o = new ArrayList<VisitorRecord>();  
		VisitorRecord s;
		s=new VisitorRecord(int4,int5,string6);
		s.hour=int4;
		s.minute=int5;
		s.entringdate=string6;
		s=new VisitorRecord(int4,int5,string6);
		//o.add(s);
		
		//sv=new SeniorVisitor( int1,  string,  string2,  string3,  string4,  string5,  int2,  int3,  double1,o) ;
		
		rv=new RegularVisitor(int1,  string,  string2,  string3,  string4,  string5,  int2,  int3,o) ;
		 resultd=string5;   
	}

	
	@When("the regular visitor is added to the system")
	public void the_regular_visitor_is_added_to_the_system() {
		resultv=  this.rv.addregulars(admin,rv);    
	}
	@Then("the error message {string} is displayed for regular visitor")
	public void the_error_message_is_displayed_for_regular_visitor(String string) {
		assertEquals(resultv,string);
	}

	
	@Then("the regular visitos  added successfully to the system")
	public void the_regular_visitos_added_successfully_to_the_system() {
		assertTrue(resultv.equals( "User added successfully to the system") &&rv.regExist(rv) &&rv.issReg()&&age2);		 
	}
	@Then("the message add regular visitos  appears {string}")
	public void the_message_add_regular_visitos_appears(String string) {
		assertEquals(resultv,string);  
	}

@Then("the already exist message  {string} is displayed regular visitos")
	public void the_already_exist_message_is_displayed_regular_visitos(String string) {
	assertEquals(resultv,string); 
	}



	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	





	
	
	
	
	
	
	
	
	
	

	
	
	

	

	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


	
	
	
	
	@Given("that admin  not logged in for guide")
	public void that_admin_not_logged_in_for_guide() {admin.setLoggedin(false);
		
	    
	}
	
	@Given("that admin logged in for guide")
	public void that_admin_logged_in_for_guide() {admin.setLoggedin(true);
	    
	}
	@Given("that the admin is logged in for guide")
	public void that_the_admin_is_logged_in_for_guide() {admin.setLoggedin(true);
	   
	}

	

	@Given("there is a Guide with ID {int}, name {string}, email {string} ,dob {string} ,Address {string} , toursperday {int}, postal code {string} , hiredate {string}  and")
	public void there_is_a_guide_with_id_name_email_dob_address_toursperday_postal_code_hiredate_and1(Integer int1, String string, String string2, String string3, String string4, Integer int2, String string5, String string6, io.cucumber.datatable.DataTable dataTable) {
		String u;
		String lang;
		ArrayList<MuseumWorkingDays> workdays = new ArrayList<MuseumWorkingDays>();	
	for(int i=0;i<=4;i++) {
	u=	dataTable.cell(1, i);
	if (u.toUpperCase().equals("SATURDAY")) {
	workdays.add(MuseumWorkingDays.Saturday);
	
		
	} else if (u.toUpperCase().equals("SUNDAY")) {
		workdays.add(MuseumWorkingDays.Sunday);
	
	} else if (u.toUpperCase().equals("MONDAY")) {
		
	workdays.add(MuseumWorkingDays.Monday);
	
		
	} else if (u.toUpperCase().equals("TUESDAY")) {
	workdays.add(MuseumWorkingDays.Tuesday);
	
		
	} else if (u.toUpperCase().equals("WEDNESDAY")) {
		workdays.add(MuseumWorkingDays.Wednesday);
		
		
	}
	
		
	
		
	}
	
	ArrayList<languages> t = new ArrayList<languages>();
	for(int i=0;i<=4;i++) {
lang=	dataTable.cell(3, i);
	if (lang.toUpperCase().equals("ARABIC")) {
	t.add(languages.ARABIC);
	
	} else if (lang.toUpperCase().equals("ENGLISH")) {
		t.add(languages.ENGLISH);
		
	} else if (lang.toUpperCase().equals("FRENCH")) {
		t.add(languages.FRENCH);
		
	} else if (lang.toUpperCase().equals("ESPANISH")) {
		t.add(languages.Espanish);
		
	} else {
	t.add(languages.Others);
	
	}
		
		
		
}
	
	
	guide=new guide( int1,  string,  string2,  string3,  string4,  int2,  string5,  string6,workdays ,t);	
	
	
		   
	}



	
	
	@Given("there is a Guide with ID {int}, name {string}, email {string} ,dob {string} ,Address {string} , toursperday {int}, postal code {string} , hiredate {string} and")
	public void there_is_a_guide_with_id_name_email_dob_address_toursperday_postal_code_hiredate_and(Integer int1, String string, String string2, String string3, String string4, Integer int2, String string5, String string6, DataTable dataTable) {
		String u;
		String lang;
		ArrayList<MuseumWorkingDays> workdays = new ArrayList<MuseumWorkingDays>();	
	for(int i=0;i<=4;i++) {
	u=	dataTable.cell(1, i);
	if (u.toUpperCase().equals("SATURDAY")) {
	workdays.add(MuseumWorkingDays.Saturday);
	
		
	} else if (u.toUpperCase().equals("SUNDAY")) {
		workdays.add(MuseumWorkingDays.Sunday);
		
		
	} else if (u.toUpperCase().equals("MONDAY")) {
		
	workdays.add(MuseumWorkingDays.Monday);
	
		
	} else if (u.toUpperCase().equals("TUESDAY")) {
	workdays.add(MuseumWorkingDays.Tuesday);

		
	} else if (u.toUpperCase().equals("WEDNESDAY")) {
		workdays.add(MuseumWorkingDays.Wednesday);
		
		
	}
	
		
	
		
	}
	
	ArrayList<languages> t = new ArrayList<languages>();
	for(int i=0;i<=4;i++) {
lang=	dataTable.cell(3, i);
	if (lang.toUpperCase().equals("ARABIC")) {
	t.add(languages.ARABIC);

	} else if (lang.toUpperCase().equals("ENGLISH")) {
		t.add(languages.ENGLISH);
		
	} else if (lang.toUpperCase().equals("FRENCH")) {
		t.add(languages.FRENCH);
		
	} else if (lang.toUpperCase().equals("ESPANISH")) {
		t.add(languages.Espanish);
		
	} else {
	t.add(languages.Others);
	
	}
		
		
		
}
	
	
	guide=new guide( int1,  string,  string2,  string3,  string4,  int2,  string5,  string6,workdays ,t);	
	
	
		
		
	
		
		
	}
			
		
		
	
	
	
	
		
		
	
	

	

	



	




	
	

	
	@When("the Guide is added to the system")
	public void the_guide_is_added_to_the_system() {
		
		result2 = guide.addGuide(admin,guide);
	    
	}
	
	
	
	@Then("the already exist message  {string} is displayedf")
	public void the_already_exist_message_is_displayedf(String string) {
		assertEquals(result2,string);
	}




	@Then("the error message {string} is displayed for guide")
	public void the_error_message_is_displayed_for_guide(String string) {
		assertEquals(result2,string);
	}
	



	@Then("the Guide added successfully to the system")
	public void the_guide_added_successfully_to_the_system() {
		assertTrue(result2.equals("Guide added successfully to the system") && guide.guideExist(guide) && guide.issReg());		
	}



	
	
	
	
	@Then("the message add Guide appears {string} for guide")
	public void the_message_add_guide_appears_for_guide(String string) {
		assertEquals(result2,string);	
		   	
	}
	
	
	
	

	@Given("that admin  not logged in for add one ticket")
	public void that_admin_not_logged_in_for_add_one_ticket() { admin.setLoggedin(false);
	    
	}
	@Given("that admin logged in for oneticket")
	public void that_admin_logged_in_for_oneticket() {admin.setLoggedin(true);
	  
	}
	@Given("that the admin is logged in for oneticket")
	public void that_the_admin_is_logged_in_for_oneticket() {
		admin.setLoggedin(true);
	}
	

	
	@Given("there is a Ticket with ID {int}, idvisitor {int},duedate {string} and price {int}")
	public void there_is_a_ticket_with_id_idvisitor_duedate_and_price(Integer int1, Integer int2, String string, Integer int3) {
		onetick=new OneTimeTicket( int1,  int2, string,  int3);
	}

	
	@When("the Ticket is added to the system")
	public void the_ticket_is_added_to_the_system() {
		result3=onetick.add(admin,onetick);
	    
	}
	

	@Then("the error message {string} is displayed for Ticket")
	public void the_error_message_is_displayed_for_ticket(String string) {
		assertEquals(result3,string);
	}


	

	@Then("the already exist message  {string} is diplayed oneticket")
	public void the_already_exist_message_is_diplayed_oneticket(String string) {
		assertEquals(result3,string);
		}



	




	
	
	
	@Then("the ticket added successfully to the system")
	public void the_ticket_added_successfully_to_the_system() {
		assertTrue(result3.equals("oneTicket added successfully to the system") &&onetick.tickExist(onetick) &&onetick .isReg());		
	    
	}
	@Then("the message addoneticket appears {string} for Ticket")
	public void the_message_addoneticket_appears_for_ticket(String string) {
		assertEquals(result3,string);
	}

	


	

	@Given("that admin  not logged in for add multy ticket")
	public void that_admin_not_logged_in_for_add_multy_ticket() {
		admin.setLoggedin(false);
	}
	@Given("that admin logged in for multyticket")
	public void that_admin_logged_in_for_multyticket() {
		admin.setLoggedin(true);
	   
	}
	@Given("that the admin is logged in for multyticket")
	public void that_the_admin_is_logged_in_for_multyticket() {
		admin.setLoggedin(true);  
	}
	
	
	
	@Given("there is a Ticket with ID {int}, idvisitor {int},duedate {string} , price {int} and discount {double}")
	public void there_is_a_ticket_with_id_idvisitor_duedate_price_and_discount1(Integer int1, Integer int2, String string, Integer int3, Double double1, io.cucumber.datatable.DataTable dataTable) {
ArrayList<TicketType> p = new ArrayList<TicketType>();
		
		String u;
		for(int i=0;i<=0;i++) {
		u=	dataTable.cell(1, i);
		if (u.toUpperCase().equals("DAILY")) {
			
			p.add(TicketType.DAILY);	
			
		}
	 if(u.toUpperCase().equals("MONTHLY")){
			p.add(TicketType.MONTHLY);		
		}
		
 if(u.toUpperCase().equals("YEARLY")){
			p.add(TicketType.YEARLY);		
		}
		
		}
		
		
		
		
		
		
		
		
		multy=new MultiTimeTicket(int1,int2,string,int3,double1,p); 
	}




	@Given("there is a Ticket with ID {int}, idvisitor {int} ,duedate {string} , price {int} and discount {double}")
	public void there_is_a_ticket_with_id_idvisitor_duedate_price_and_discount(Integer int1, Integer int2, String string, Integer int3, Double double1, io.cucumber.datatable.DataTable dataTable) {
	   

		ArrayList<TicketType> p = new ArrayList<TicketType>();
		
		String u;
		for(int i=0;i<=0;i++) {
		u=	dataTable.cell(1, i);
		if (u.toUpperCase().equals("DAILY")) {
			
			p.add(TicketType.DAILY);	
			
		}
	 if(u.toUpperCase().equals("MONTHLY")){
			p.add(TicketType.MONTHLY);		
		}
		
 if(u.toUpperCase().equals("YEARLY")){
			p.add(TicketType.YEARLY);		
		}
		
		}
		
		
		
		
		
		
		
		
		multy=new MultiTimeTicket(int1,int2,string,int3,double1,p);  
	}
	@When("the multyTicket is added to the system")
	public void the_multy_ticket_is_added_to_the_system() {
	result4=  multy.addmulty( admin,multy); 
	}

	

	

	@Then("the error message {string} is displayed for multyTicket")
	public void the_error_message_is_displayed_for_multy_ticket(String string) {
		assertEquals(result4,string);   
	}


	@Then("the already exist message  {string} is diplayed multyticket")
	public void the_already_exist_message_is_diplayed_multyticket(String string) {
		assertEquals(result4,string);  
	}


	
	@Then("the multyticket added successfully to the system")
	public void the_multyticket_added_successfully_to_the_system() {
		
		
		assertTrue(result4.equals("multyTicket added successfully to the system") &&multy.tickExist(multy) &&multy .isReg());		
	    
		
	  
	}
	
	@Then("the message addmultyticket appears {string} for Ticket")
	public void the_message_addmultyticket_appears_for_ticket(String string) {
		assertEquals(result4,string);   
	}
	


}
	
	

	

	



	




	