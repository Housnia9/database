package najah;


import najah.Admin;
import najah.SeniorVisitor;


import java.util.*;
import java.text.*;
import java.time.*;





import javax.swing.plaf.basic.BasicScrollPaneUI.VSBChangeListener;

import java.util.*;
import java.text.*;
import java.time.*;


public class SeniorVisitor {

	int id;
	String name;
	String email;
	
	String address;

String postalCode;
String dob;
int vcou;
	int visf;
	boolean rr=false;
	boolean exs=false;
	double discount;
	ArrayList<VisitorRecord> o = new ArrayList<VisitorRecord>(); 
	static ArrayList<service> servise = new ArrayList<service>(); 
int flagsen=1;
	
	int flags=0;
	
	public static	List<SeniorVisitor> seniors=new ArrayList<SeniorVisitor>(); 
	private boolean isLoggedin=false;
	private boolean reg2=false;
	 boolean isLog=false;
	boolean exist=false;
	private	boolean ex=false;
	
	ArrayList<String> massages = new ArrayList<String>(); 
	
	
	public boolean issReg() {
		return reg2;
	}
	public SeniorVisitor() {
		
		
		super();
	}
	public SeniorVisitor(int id, String name, String email, String address, String postalCode, String dob,
			int vcou, int vsif, double discount, ArrayList<VisitorRecord> o) {
		super();
		this.id=id;
		this.name=name;
		this.email=email;
		this.address=address;
		this.postalCode=postalCode;
		this.dob=dob;
		this.vcou=vcou;
		this.visf=vsif;
		this.o=o;
	}
	public String getEmail() {
		return email;
	}
	
	
	public boolean checkage(SeniorVisitor sv, int int1, String m) throws ParseException {
		
		SimpleDateFormat d1 = new SimpleDateFormat("dd/MM/yyyy");
		
		Date dq = d1.parse(dob);
	
		Date da = new Date();
		SimpleDateFormat f = new SimpleDateFormat("yyyy");
		int yearnow = Integer.parseInt(f.format(da));
		int yearBd = Integer.parseInt(f.format(dq));
		int age = yearnow - yearBd;
		if (age >= int1) {
			
			sv.visf=0;
			rr=true;
		
        
		}
		return rr;
		}
	public String addseniors(Admin admin, SeniorVisitor sv) {
		String result2=null;
		boolean exist=sv.sengExist(sv);
		if (!admin.isLoggedin()) {
			result2= "Admin login is required";
		}
		else if (exist) {
			result2=" This  user is already registered";
		}
		else {
			reg2=true;
			seniors.add(sv);
			result2= "User added successfully to the system";
		
		}
		return result2;
		
	}
	public boolean sengExist(SeniorVisitor sv) {
		 exist=false;
			for (int i = 0; i < seniors.size(); i++) {
				if (seniors.get(i).id==sv.id) {
					exist= true;
					break;
				}
			}
			
			return exist;	  
	}
	public boolean checknameandpass(String namr, String passr) {
		isLog=false;
		for (int i = 0; i < seniors.size(); i++) {
			
			
			if(seniors.get(i).name.equals(namr) && seniors.get(i) .postalCode.equals(passr)) {
				
			 	 isLog=true;
			 	 break;
			 	 }
			 	
				
				
				
			
			
			
		
			else isLog=false;
			
	}
	
		
		
		return isLog;
		
	}
	public boolean sengexist(SeniorVisitor sv) {
		ex=false;
		for (int i = 0; i < seniors.size(); i++) {
			if (this.id==sv.id) {
				ex= true;
				break;
			}
		
		}
		
		return ex;
	}
	public boolean checkid(int int2) {
	
		 exs=false;
			for (int i = 0; i < seniors.size(); i++) {
				if (seniors.get(i).id==int2) {
					exs= true;
					break;
				}
			}
			
			return exs;	
		
		
		
		
		
		
	}
	public void booktour(int hour, int minute, String datg, int vistorid) throws ParseException {
		VisitorRecord m =new VisitorRecord();
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");
		Date dff = d.parse(datg);
		Calendar c1 = new GregorianCalendar();
		c1.setTime(dff);
		m.entringdate=datg;

	
		c1.set(Calendar.HOUR, hour);
	
		c1.set(Calendar.MINUTE, minute);
		c1.set(Calendar.SECOND, 0);
		m.hour=hour;
		m.minute=minute;
		for (int i = 0; i < seniors.size(); i++) {
				if (seniors.get(i).id==vistorid) {
					seniors.get(i).o.add(m);
				seniors.get(i)	.vcou=seniors.get(i).o.size();
		
	}}}
	

	 public void recivemassage(int vidmassage, String massage) {
	      for(int i = 0; i < seniors.size(); ++i) {
	         if ((seniors.get(i)).id == vidmassage) {
	            (seniors.get(i)).massages.add(massage);
	         }
	      }

	   }

	   public boolean chck(int idnotes, String entringdatenotes, int ym) {
	      boolean record = false;

	      for(int i = 0; i < (seniors.get(ym)).o.size(); ++i) {
	         if (seniors.get(ym).o.get(i).entringdate.equals(entringdatenotes)) {
	            record = true;
	            break;
	         }
	      }

	      return record;
	   }

	   public void addnotes(int idnotes, String entringdatenotes, String notes, int ym) {
	      for(int i = 0; i < (seniors.get(ym)).o.size(); ++i) {
	         if (seniors.get(ym).o.get(i).entringdate.equals(entringdatenotes)) {
	            (seniors.get(ym)).o.get(i).notes.add(notes);
	            break;
	         }
	      }

	   }

	   public int checkids(int idnotes) {
	      int m = 0;

	      for(int i = 0; i < seniors.size(); ++i) {
	         if ((seniors.get(i)).id == idnotes) {
	            m = i;
	            break;
	         }
	      }

	      return m;
	   }










	public void addserv(int idd, String servicee) {
	service m=new service(servicee,800)	;
	for(int i=0;i<seniors.size();i++) {
	if(	seniors.get(i).id==idd) {
		
		seniors.get(i).servise.add(m);	
		
		
	}	
		
		
		
		
		
	}
	}
		
		
		
		


	   @Override
		public String toString() {
			// TODO Auto-generated method stub
			return  " visitorid:"+this.id+"  visitor name " +this.name+" email:"  + this.email + " address : " + this.address+" postalcode"+this.postalCode+"   dop"+this.dob+
					"    visitscount"+this.vcou+"    visflag"+this.visf+"    visitorrecords"+this.o;
		}




	
	

	public void searchvissss(int idv,	MultiTimeTicket mlti) {
		// TODO Auto-generated method stub
		boolean flagss = false;
	//ticket.typeevisitorFlag=0;
		for (int e = 0; e < seniors.size(); e++) {


			if (seniors.get(e).id==idv) {
				flagss = true;
				flagsen=0;
			///	ticket.showticket(idv,flagsen);
				
				//System.out.println();
				//System.out.println(guides.get(e));
				
				
				System.out.println();
				//System.out.println("tt");
				System.out.println("**********************************************************************");
			System.out.println("Senior is :");
				System.out.println(seniors.get(e));
				
			
				System.out.println("**********************************************************************");
				//ticket.showticket(idv,flagsen);
				
					
				break;
			}
		}	
		
	}
	public void Updatenamesen(int ids, String namesen) {
		// TODO Auto-generated method stub
		boolean flagup=false;
		for(int e=0;e<seniors.size();e++) {
			if(seniors.get(e).id==ids) {
				//flagup=true;
				seniors.get(e).name=namesen;
				System.out.println("**********************************************************************");
				System.out.println("New Senior Visitor is :");
				
		
				System.out.println(seniors.get(e));
			
				System.out.println("**********************************************************************");
				flagup=true;
				
				break;
			}
		}
		
		
	}
	
	}


		
		
	
	
	
	


	
	

