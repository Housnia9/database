
package najah;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class RegularVisitor {
	int id;
	String name;
	String email;
	
	String address;
	
String postalCode;
String dob;
int vcou;
	int visf;
	boolean rr=false;
	private boolean reg2=false;
	
	private boolean isLoggedin=false;
	boolean exist=false;
	 boolean isLog=false;
	 boolean exs=false;
		private	boolean ex=false;
	static	ArrayList<service> servise = new ArrayList<service>(); 
			
	public boolean issReg() {
		return reg2;
	}
	
	public static List<RegularVisitor> regulars=new ArrayList<RegularVisitor>(); 
	ArrayList<VisitorRecord> o = new ArrayList<VisitorRecord>(); 
	ArrayList<String> massages = new ArrayList<String>(); 
	
	
	public RegularVisitor() {
		
		
		super();
	}
	
	public RegularVisitor(int id, String name, String email, String address, String postalCode, String dob,
			int vcou, int vsif, ArrayList<VisitorRecord> o) {
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

	public String addregulars(Admin admin, RegularVisitor rv) {
		String result2=null;
		boolean exist=rv.regExist(rv);
		if (!admin.isLoggedin()) {
			result2= "Admin login is required";
		}
		else if (exist) {
			result2=" This  user is already registered";
		}
		else {
			reg2=true;
			regulars.add(rv);
			result2= "User added successfully to the system";
			
		}
		
		return result2;
		
	}
	public boolean regExist(RegularVisitor rv) {
		
		 exist=false;
			for (int i = 0; i < regulars.size(); i++) {
				if (regulars.get(i).id==rv.id) {
					exist= true;
					break;
				}
			}
			
			return exist;	 
	}
	public boolean checkage(RegularVisitor rv, Integer int1, String dob2) throws ParseException {
SimpleDateFormat d1 = new SimpleDateFormat("dd/MM/yyyy");
		
		Date dq = d1.parse(dob2);
	
		Date da = new Date();
		SimpleDateFormat f = new SimpleDateFormat("yyyy");
		int yearnow = Integer.parseInt(f.format(da));
		int yearBd = Integer.parseInt(f.format(dq));
		int age = yearnow - yearBd;
		if (age < int1) {
			
			rv.visf=1;
			rr=true;
		
        
		}
		return rr;
		
	}
	public boolean checknameandpass(String namr, String passr) {
		isLog=false;
		for (int i = 0; i < regulars.size(); i++) {
			
			
			if(regulars.get(i).name.equals(namr) && regulars.get(i) .postalCode.equals(passr)) {
				
			 	 isLog=true;
			 	 break;
			 	 }
			 	
				
				
				
			
			
			
		
			else isLog=false;
			
	}
	
		
	
		return isLog;
		
	}
	public boolean regexist(RegularVisitor rv) {
		ex=false;
		for (int i = 0; i < regulars.size(); i++) {
			if (this.id==rv.id) {
				ex= true;
				break;
			}
			
		}
		
		return ex;
	}
	public boolean checkid(int int2) {
		 exs=false;
			for (int i = 0; i < regulars.size(); i++) {
				if (regulars.get(i).id==int2) {
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
		for (int i = 0; i < regulars.size(); i++) {
				if (regulars.get(i).id==vistorid) {
					regulars.get(i).o.add(m);
					regulars.get(i)	.vcou=regulars.get(i).o.size();
					break;
				}
		
	}
	}
	



	 public void recivemassage(int vidmassage, String massage) {
	      for(int i = 0; i < regulars.size(); ++i) {
	         if (regulars.get(i).id == vidmassage) {
	            (regulars.get(i)).massages.add(massage);
	         }
	      }

	   }

	   public boolean chck(int idnotes, String entringdatenotes, int emm) {
	      boolean record = false;

	      for(int i = 0; i < (regulars.get(emm)).o.size(); ++i) {
	         if (regulars.get(emm).o.get(i).entringdate.equals(entringdatenotes)) {
	            record = true;
	            break;
	         }
	      }

	      return record;
	   }

	   public void addnotes(int idnotes, String entringdatenotes, String notes, int emm) {
	      for(int i = 0; i < (regulars.get(emm)).o.size(); ++i) {
	         if (regulars.get(emm).o.get(i).entringdate.equals(entringdatenotes)) {
	            (regulars.get(emm)).o.get(i).notes.add(notes);
	            break;
	         }
	      }

	   }

	   public int checkids(int idnotes) {
	      int m = 0;

	      for(int i = 0; i < regulars.size(); ++i) {
	         if (regulars.get(i).id == idnotes) {
	            m = i;
	            break;
	         }
	      }

	      return m;
	   }









	  

	public void addserv(int idd, String servicee) {
		service m=new service(servicee,800)	;
		for(int i=0;i<regulars.size();i++) {
		if(	regulars.get(i).id==idd) {


			
			regulars.get(i).servise.add(m);	
		
		}	
			
		}	
			
		
	}
		
		
		
	 @Override
		public String toString() {
			// TODO Auto-generated method stub
			return  "  visitorid:"+this.id+"   visitor name " +this.name+"  email:"  + this.email + "  address : " + this.address+"  postalcode"+this.postalCode+"  dop"+this.dob+
					"   visitscount"+this.vcou+"   visflag"+this.visf+"    visitorrecords"+this.o;
		}	


















	public void searchh(int idv) {
		// TODO Auto-generated method stub
		boolean flagssss = false;
		for (int v = 0; v < regulars.size(); v++) {


			if (regulars.get(v).id==idv) {
			//	flagssss = true;
				
				//System.out.println();
				//System.out.println(guides.get(e));
				
				System.out.println();
				//System.out.println("tt");
			
				System.out.println("**********************************************************************");
				System.out.println("Regular visitor is :");
				System.out.println( regulars.get(v));
				System.out.println("**********************************************************************");
				flagssss = true;
				
				
				
				
				break;
			}
		}	
		
		
	}

	public void updatenamerigv(int ids, String namerig) {
		// TODO Auto-generated method stub
		boolean flagup=false;
		for(int v=0;v<regulars.size();v++) {
			if(regulars.get(v).id==ids) {
				//flagup=true;
				regulars.get(v).name=namerig;
				System.out.println("**********************************************************************");
				System.out.println("New Regular Visitor is :");
				
				System.out.println( regulars.get(v));
				System.out.println("**********************************************************************");
				System.out.println();
				
				flagup=true;
				
				break;
			}
		}
		
		
	}

	
	}



