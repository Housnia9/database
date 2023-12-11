package najah;

import java.util.*;
import java.text.*;
import java.time.*;

public class guide {
	private ArrayList<languages> t = new ArrayList<languages>();
	public ArrayList<MuseumWorkingDays> workdays = new ArrayList<MuseumWorkingDays>();
	int id;
	String name;
	String email;
	String dob;
	String address;
	int tourperday;
	String postalCode;
	String hiredate;
	
	boolean exist=false;
	private	boolean ex=false;
	
 boolean isLog=false;
 boolean avalible=false;

	

	
	public static List<guide> guides=new ArrayList<guide>(); 
	
	
	
	private boolean reg2=false;
	
	

	
	
	
	
	public boolean issReg() {
		return reg2;
	}
	
	public guide() {
		super();
	}
	
	
	
	

	
	public guide(int id, String name, String email, String dob, String address, int tourperday,
				String postalCode, String hiredate, ArrayList<MuseumWorkingDays> workdays, ArrayList<languages> t) {
			
			super();
			this.id = id;
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.address = address;
		this.tourperday = tourperday;
		this.postalCode = postalCode;
		this.hiredate = hiredate;
		this.workdays = workdays;
		this.t=t;
			
			
			
			
			
		}
	
	
	
	
	
	public String addGuide(Admin admin, guide guide) {
		String result2=null;
		boolean exist=guide.guideExist(guide);
		if (!admin.isLoggedin()) {
			result2= "Admin login is required";
		}
		else if (exist) {
			result2= " This  guide is already registered";
		}
		else {
			reg2=true;
			guides.add(guide);
			result2= "Guide added successfully to the system";
		
		}
		return result2;
		
	}
	
	
	public boolean guideExist(guide guide) {
		 exist=false;
		for (int i = 0; i < guides.size(); i++) {
			if (guides.get(i).id==guide.id) {
				exist= true;
				break;
			}
			
		}
		
		return exist;
	}
	public boolean checknameandpass(String string, String string2) {
		isLog=false;
		for (int i = 0; i < guides.size(); i++) {
			
			
			if(guides.get(i).name.equals(string) && guides.get(i) .postalCode.equals(string2)) {
				
			 	 isLog=true;
			 	 break;
			 	 }
			 	
				
				
				
			
			
			
		
			else isLog=false;
			
	}
	
		
	
		return isLog;
		
		
		
		
		
		
		
		
	}
	public boolean eguideex(guide guide) {
		 ex=false;
			for (int i = 0; i < guides.size(); i++) {
				if (this.id==guide.id) {
					ex= true;
					break;
				}
			
			}
			
			return ex;
	}
	public boolean avalableguide(String datg, String lang) throws ParseException {
		ArrayList<guide> ag = new ArrayList<guide>();
		int y = 0;
		int m = 0;
		
		SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");
		Date ds = d.parse(datg);
		
		Calendar c3 = new GregorianCalendar();
		c3.setTime(ds);
		int ww = c3.get(Calendar.DAY_OF_WEEK);

		for (int r = 0; r < guides.size(); r++) {
			if (lang.toUpperCase().equals("ARABIC")) {
				if (guides.get(r).t.contains(languages.ARABIC)) {

					m = 1;
				}

			}
			if (lang.toUpperCase().equals("ENGLISH")) {
				if (guides.get(r).t.contains(languages.ENGLISH)) {
					m = 1;

				}
			}
			if (lang.toUpperCase().equals("ESPANISH")) {
				if (guides.get(r).t.contains(languages.Espanish)) {
					m = 1;

				}
			}
			if (lang.toUpperCase().equals("FRENCH")) {
				if (guides.get(r).t.contains(languages.FRENCH)) {
					m = 1;

				}
			}

			if (ww == 1) {
				if (guides.get(r).workdays.contains(MuseumWorkingDays.Sunday)) {
					y = 1;

				}
			}
			if (ww == 2) {
				if (guides.get(r).workdays.contains(MuseumWorkingDays.Monday)) {
					y = 1;

				}
			}
			if (ww == 3) {
				if (guides.get(r).workdays.contains(MuseumWorkingDays.Tuesday)) {
					y = 1;
				}
			}
			if (ww == 4) {
				if (guides.get(r).workdays.contains(MuseumWorkingDays.Wednesday)) {
					y = 1;
				}
			}

			if (ww == 7) {
				if (guides.get(r).workdays.contains(MuseumWorkingDays.Saturday)) {
					y = 1;

				}
			}

			if (y == 1 && m == 1 && guides.get(r).tourperday > 0 && guides.get(r).tourperday <= 6) {
				avalible=true;
				guides.get(r).tourperday=guides.get(r).tourperday-1;
ag.add(guides.get(r));
			}

		}
		System.out.println("avalible guides for the request date and language");
		System.out.println(datg);
		System.out.println(lang);
		
           System.out.println(ag);
		return avalible;
		
	}
	public boolean checday(String datg) throws ParseException {
		boolean day=false;
		boolean cond=false;
		String date = datg;
		SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");
		Date ds = d.parse(date);
		Calendar c = new GregorianCalendar();
		c.setTime(ds);
		int ww = c.get(Calendar.DAY_OF_WEEK);
		int y = 0;
		if (ww == 2) {
			y = 1;
		}

		if (ww == 7) {
			y = 1;
		}
		if (ww == 1) {
			y = 1;
		}

		if (ww == 4) {
			y = 1;
		}
		if (ww == 3) {
			y = 1;
		}
		if (y == 1) {
			day=true;
			
		}
		if (y == 0) {
		day=false;
		}
		
		
	if(day==true)	{
		cond=true;
		
		
		
		
	}
		
	return cond;	
			
		
		
		
		
		
		
		
		
		
	}


	
	public String toString() {
		// TODO Auto-generated method stub
		return "guide id: " + "     " + this.id + "    " + " guidename : " + "   " + this.name + "    "
				+ "adress" + "    " + this.address + "    " + "languages" + "    " + this.t + "    "
				+ "workdays" + "   " + this.workdays + "   " + "date of brith" + "    " + this.dob + "   "
				+ "hire date" + "   " + this.hiredate + "    " + "tour per day" + "     " + this.tourperday;
	}

	public boolean guideExist11(int idg) {
		// TODO Auto-generated method stub
		boolean exsim=false;
		
		for (int i = 0; i < guides.size(); i++) {
			if (guides.get(i).id==idg) {
				exsim= true;
				break;
			}
		}
		
		return exsim;
	}

	public void DeleteGuidee(int idg) {
		// TODO Auto-generated method stub
		boolean flag = false;
		
		
		for (int h = 0; h < guides.size(); h++) {
			
			if (guides.get(h).id==idg) {
				guides.remove(guides.get(h));
				flag = true;
			//	result3="Guide removed successfully";
				break;
			}
	}
	
	
	
}

	public void searchguide(int ids) {
		// TODO Auto-generated method stub
		//System.out.println("enter  id to show information");
		
		boolean flags = false;
		for (int e = 0; e < guides.size(); e++) {


			if (guides.get(e).id==ids) {
				flags = true;
				
				//System.out.println();
				//System.out.println(guides.get(e));
				
			//	System.out.println();
				//System.out.println( ids);
				//System.out.println(guides.get(e).name);
				
				System.out.println("**********************************************************************");
				System.out.println("Guide is :");
				System.out.println(guides.get(e));
			//	System.out.println("kkkkkkkkkkkkkkkkkk");
				/*System.out.println(guides.get(e).address);
				System.out.println(guides.get(e).email);
				System.out.println(guides.get(e).hiredate);
				System.out.println(guides.get(e).dob);
				System.out.println(guides.get(e).hiredate);
				System.out.println(guides.get(e).workdays);
				System.out.println(guides.get(e).tourperday);
				System.out.println(guides.get(e).postalCode);
				System.out.println();
				System.out.println("End");
				*/
				System.out.println("**********************************************************************");
				break;
			}
		}	

		
	}



	public void Updateguide(String nameup, int idup) {
		// TODO Auto-generated method stub
		boolean flagup=false;
		for(int e=0;e<guides.size();e++) {
			if(guides.get(e).id==idup) {
				//flagup=true;
				guides.get(e).name=nameup;
			//	System.out.println();
				//System.out.println("New Guide is: ");
				//System.out.println( idup);
			//	System.out.println(guides.get(e).name);
				System.out.println("**********************************************************************");
				System.out.println("New Guide is :");
				System.out.println(guides.get(e));
				/*System.out.println(guides.get(e).address);
				System.out.println(guides.get(e).email);
				System.out.println(guides.get(e).hiredate);
				System.out.println(guides.get(e).dob);
				System.out.println(guides.get(e).hiredate);
				System.out.println(guides.get(e).workdays);
				System.out.println(guides.get(e).tourperday);
				System.out.println(guides.get(e).postalCode);
				System.out.println();
				*/
				System.out.println("**********************************************************************");
				flagup=true;
				
				break;
			}
		}
		
	}

	
}