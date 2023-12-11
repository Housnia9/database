package najah;
import io.cucumber.datatable.DataTable;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;

import najah.Admin;
import najah.OneTimeTicket;
import najah.MultiTimeTicket;
import najah.RegularVisitor;
import najah.SeniorVisitor;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class resptionsteps {
	RegularVisitor rv;
	 SeniorVisitor sv;
	 
	 OneTimeTicket ot;
	 boolean ato=false;
	 boolean atr=false;
	 boolean ats=false;
	 boolean ch=false;
	 boolean atrm=false;
	 boolean atsm=false;
	 boolean atom=false;
	 boolean chm=false;
	 boolean cheackage;
	 String subdate;
	 String dop;
	 int vid;
	 int hour;
	 int minute;
	 int tickid;
	 boolean cheackagem=false;
	 boolean avalible=false;
	 String subdatem;
	 boolean chvt=false;
	 String dopm;
	 int vidm;
	 int tickidm;
	 String dai;
	 String Wguide;
	 String lang;
	 String datg;
	 String tick;
	 int tickkid;
	 int vistorid;
	String ticktypebook;
	 MultiTimeTicket mt;
	 Admin admin;
	 guide guidee;
	
	   String dopmassage;
	   int vidmassage;
	   String massage;
	   boolean flagage=false;
	   boolean exrv=false;
	   boolean exsv=false;
	   String dopnotes;
	   String entringdatenotes;
	   int idnotes;
	   String mm;
	   String notes;
	   boolean flagagee=false;
	   boolean exrvv=false;
		  boolean exsvv=false;
		   boolean exov=false;
		   boolean exovs=false;
	   int emm;
	   int ym;
	  
	  
	  
	   boolean daym=false;
	   boolean cheageee=false;
	   
	   boolean notr=false;
	   boolean notv=false;

	public  resptionsteps(Admin admin,RegularVisitor rv,SeniorVisitor sv,OneTimeTicket ot,MultiTimeTicket mt,guide guidee) {
		
		this.admin=admin;
		this.mt=mt;
		this.ot=ot;
		this.rv=rv;
		this.sv=sv;
		this.guidee=guidee;
		
		
	}

	
	
	
	
	@Given("that the admin is logged inf")
	public void that_the_admin_is_logged_inf() {
		admin.setLoggedin(true);      
	}



	

	



	@Given("the visitor enter tickid {int} ,ticktype {string} ,visitorid {int} and subdate {string} , dop {string}")
	public void the_visitor_enter_tickid_ticktype_visitorid_and_subdate_dop(Integer int1, String string, Integer int2, String string2, String string3) throws ParseException {
	   




		ato=ot.checkconditions(string,string2);
		ch=ot.checkidd(int1);
	
		subdate=string2;
		vid=int2;
	dop=string3;
	cheackage=ot.chcage(dop);
		tickid=int1;
	}
	@Given("the visitor is already rigistered")
	public void the_visitor_is_already_rigistered() {
	
		atr=rv.checkid(vid);
	
		ats=sv.checkid(vid);
	}
	
	@When("isueeticket for one")
	public void isueeticket_for_one() {
	 if(ch==true) {
		if(atr==true&&ato==true&&cheackage==true) {
		ot.isueertick(tickid,vid,subdate,rv);
		}
	if(ats==true&&ato==true&&cheackage==false) {
		ot.isueestick(tickid,vid,subdate,sv);
		}
		  
		 
		 
	 }
	 if(ch==false) {
if(atr==true&&ato==true&&cheackage==true) {
	ot.isueerftick(tickid,vid,subdate,rv);	
		}
	if(ats==true&&ato==true&&cheackage==false) {
		ot.isueesftick(tickid,vid,subdate,sv);
		}
		
		
		
		
	}	
		
		
		
	}
	
	
	
	
	@Then("the visitor isueeticket succeeds")
	public void the_visitor_isueeticket_succeeds() {
	 
		assertTrue((((atr&&cheackage)||((ats&&cheackage)==false))&&ato));
	}


	

	

	@Then("the visitor isueeticket fails for one")
	public void the_visitor_isueeticket_fails_for_one() {
		assertTrue(!(((atr&&cheackage)||((ats&&cheackage)==false))&&ato)); 
	}

	

	
	
	@Given("the visitor enter tickid {int} ,ticktype {string} ,visitorid {int} , subdate {string} ,dop {string} and multytype  {string}")
	public void the_visitor_enter_tickid_ticktype_visitorid_subdate_dop_and_multytype1(Integer int1, String string, Integer int2, String string2, String string3, String string4) throws ParseException {


		atom=mt.checkconditions(string,string2);
		chm=mt.checkidd(int1);
	
		subdatem=string2;
		vidm=int2;
	dopm=string3;
	cheackagem=mt.chcage(dopm);
		tickidm=int1;
		 dai= string4;
	}




	
	@Given("the visitor enter tickid {int} ,ticktype {string} ,visitorid {int} , subdate {string} ,dop {string} and multytype {string}")
	public void the_visitor_enter_tickid_ticktype_visitorid_subdate_dop_and_multytype(Integer int1, String string, Integer int2, String string2, String string3, String string4) throws ParseException {
	   


		atom=mt.checkconditions(string,string2);
		chm=mt.checkidd(int1);
	
		subdatem=string2;
		vidm=int2;
	dopm=string3;
	cheackagem=mt.chcage(dopm);
		tickidm=int1;
		 dai= string4;
		
		
	}
	@Given("the visitor is already rigistered for multy")
	public void the_visitor_is_already_rigistered_for_multy() {
		atrm=rv.checkid(vidm);
		
		atsm=sv.checkid(vidm);
	}
	@When("isueeticket for multy and make discount")
	public void isueeticket_for_multy_and_make_discount() {
		 if(chm==true) {
				if(atrm==true&&atom==true&&cheackagem==true) {
				mt.isueertick(tickidm,vidm,subdatem,rv,dai);
				}
			if(atsm==true&&atom==true&&cheackagem==false) {
				mt.isueestick(tickidm,vidm,subdatem,sv,dai);
				}
				  
				 
				 
			 }
			if(chm==false) {
		if(atrm==true&&atom==true&&cheackagem==true) {
			mt.isueerftick(tickidm,vidm,subdatem,rv,dai);	
				}
			if(atsm==true&&atom==true&&cheackagem==false) {
				mt.isueesftick(tickidm,vidm,subdatem,sv,dai);
				}
				
				
				
				
			}	  
	}
	@Then("the visitor isueeticket succeeds for multy")
	public void the_visitor_isueeticket_succeeds_for_multy() {
		assertTrue((((atrm&&cheackagem)||(atsm&&cheackagem==false))&&atom));	
	}



	


	
	@Then("the visitor isueeticket fails for multy")
	public void the_visitor_isueeticket_fails_for_multy() {
		assertTrue(!(((atrm&&cheackagem)||(atsm&&cheackagem==false))&&atom));  
	}






	
	
	
	
	
	
	
	
	



	
	
	
	
	@Given("the visitor enter tickid {int} ,ticktype {string} ,visitorid {int} and datewante {string} , dop {string} ,and langusge you want for guide {string} ,and want guide {string} ,hour {int} .minuite {int}")
	public void the_visitor_enter_tickid_ticktype_visitorid_and_datewante_dop_and_langusge_you_want_for_guide_and_want_guide_hour_minuite(Integer int1, String string, Integer int2, String string2, String string3, String string4, String string5, Integer int3, Integer int4) {
	 
		
		Wguide=string5;
		
		
		this.datg=string2;
		this.lang=string4;
		
		this.vistorid=int2;
		this.tickkid=int1;
		this.ticktypebook=string;
		this.hour=int3;
				this.minute=int4;
		mm=string3;
		
	}
	@Given("the ticket is already exist for visitor")
	public void the_ticket_is_already_exist_for_visitor()  {
		
		
		
		
				if(ticktypebook.toUpperCase().equals("ONE")) {
					
					this.chvt=ot.checkvti(tickkid,vistorid);
					
					
				}
	
if(ticktypebook.toUpperCase().equals("MULTY")) {
					
	this.chvt=mt.checkvti(tickkid,vistorid);	
					
					
				}
	
		
		
		
	   
	}
	@Given("have avaliable guide if want guide")
	public void have_avaliable_guide_if_want_guide() throws ParseException {
		if(Wguide.toUpperCase().equals("YES")) {
			
			this.avalible=	this.guidee.avalableguide(datg,lang);
					
					
					
				}
		if(Wguide.toUpperCase().equals("NO")) {
					
					
				this.avalible=true;	
					
					
				}
				
	}
	@Given("the dat for to in muesum")
	public void the_dat_for_to_in_muesum() throws ParseException {
	   
		
		this.daym=guidee.checday(datg);
		
		
		
		
		
		
		
	}
	
	@When("booktour for visitor")
	public void booktour_for_visitor() throws ParseException {
		
		
		
		if(mt.chcage(mm)==true&&daym==true&&avalible==true&&chvt==true) {
			
			rv.booktour(hour,minute,datg,vistorid);
			
			
			
		}
		
		
		
		
		if(mt.chcage(mm)==false&&daym==true&&avalible==true&&chvt==true) {
			
			sv.booktour(hour,minute,datg,vistorid);
			
			
			
			
		}
		
		
		
		
		
		
		
		
	   
	}
	
	
	
	
	
	@Then("the visitor book tour succeeds")
	public void the_visitor_book_tour_succeeds() {
		assertTrue(daym==true&&avalible==true&&chvt==true);
	}


	
	
	@Then("the visitor book tour fails")
	public void the_visitor_book_tour_fails() {
		assertTrue(!(daym==true&&avalible==true&&chvt==true));
	}






	
	@Given("admin enter visitor id {int} ,dop {string} ,massage {string}")
	public void admin_enter_visitor_id_dop_massage(Integer int1, String string, String string2) {
	   this.vidmassage=int1;
	   this.dopmassage=string;
	   this.massage=string2;
	}
	@Given("the visitor is already exist")
	public void the_visitor_is_already_exist() throws ParseException {
	  this.flagage=mt.chcage(dopmassage);

		
		if(flagage==true) {
			
			this.exov=rv.checkid(vidmassage);
			
			
		}
		
if(flagage==false) {
			
		this.exovs=sv.checkid(vidmassage)	;
			
			
		}
		
		
		
		
	}
	@When("admin send massage")
	public void admin_send_massage() {
	  if(exov==true) {
		  rv.recivemassage(vidmassage, massage);
		  
		  
		  
	  }
		if(exovs==true) {
			
		sv.recivemassage(vidmassage, massage);	
			
			
			
		}
	}
	@Then("massage send fails")
	public void massage_send_fails() {
		assertTrue(!(exov==true||exovs==true));
	}
	
	@Then("massage send sucssed")
	public void massage_send_sucssed() {
		assertTrue(exov==true||exovs==true);
	 
	}



	
	@Given("visitor enter the date of viisit {string} ,dop {string} mvisitorid {int} ,notes {string}")
	public void visitor_enter_the_date_of_viisit_dop_mvisitorid_notes(String string, String string2, Integer int1, String string3) {
	    this.idnotes=int1;
	    this.dopnotes=string2;
	    this.notes=string3;
	    this.entringdatenotes=string;
	}
	@Given("the visitor is already existn")
	public void the_visitor_is_already_existn() throws ParseException {
	  
		  this.flagagee=mt.chcage(dopnotes);

			
			if(flagagee==true) {
				
				this.exrvv=rv.checkid(idnotes);
				
				
			}
			
	if(flagagee==false) {
				
			this.exsvv=sv.checkid(idnotes)	;
				
				
			}
			
		
		
		
		
	}
	@Given("the visit is already exist for visitor")
	public void the_visit_is_already_exist_for_visitor() {
	  
		
		if(exrvv==true) {
			
	 emm=rv.checkids(idnotes);
	 notr=rv.chck(idnotes, entringdatenotes, emm);
	 
	 
			
		}
		
		if(exsvv==true) {
			
		ym=sv.checkids(idnotes)	;
		
		notv=sv.chck(idnotes, entringdatenotes, ym);
		}
		
		
		
	}
	@When("visitor add notes for visit")
	public void visitor_add_notes_for_visit() {
	if(exrvv==true&&notr==true)	{
	rv.addnotes(idnotes, entringdatenotes, dopnotes, emm);	
		
	}
		
		
		
if(exsvv==true&&notv==true)	{
		
	sv.addnotes(idnotes, entringdatenotes, dopnotes, ym);	
	}
			
		
		
		
	}
	@Then("visitor notes sucssed")
	public void visitor_notes_sucssed() {
		assertTrue((exrvv==true&&notr==true)||(exsvv==true&&notv==true));  
	}

	@Then("visitor notes fails")
	public void visitor_notes_fails() {
		assertTrue(!((exrvv==true&&notr==true)||(exsvv==true&&notv==true)));  
	}



	









	
	
	
	
	
	
	
	


	
	
	
	
	
	
	
	
	

	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}