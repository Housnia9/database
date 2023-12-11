package najah;

public class Admin {
	
	private boolean isLoggedin=false;

	public boolean login(String passpord) {
		if(passpord.equals("valid")) {
			isLoggedin=true;
		}
		else isLoggedin=false;
	
		return isLoggedin;
	}
	public boolean isLoggedin() {
		return isLoggedin;
	}
	public void setLoggedin(boolean isLoggedin) {
		this.isLoggedin = isLoggedin;
	}	
	
	public void showinf(OneTimeTicket onetick, RegularVisitor rv, SeniorVisitor sv, MultiTimeTicket multy,
			guide guide) {
		onetick=new OneTimeTicket ();
	int monym=0;
	int monyo=0;
	int monys=0;
	int monysm=0;
	int recv=0;
	int recs=0;
		if(this.isLoggedin ==true) {
			System.out.println("**********************************************************************");
		System.out.println("Welcome in Muesuem System");
		System.out.println("FALL REPORT FOR MUESUEM");
		System.out.println( "Guides in muesum our team" );
		for(int l=0;l<guide.guides.size();l++) {
			
			System.out.println(guide.guides.get(l));
			
			
			
			
		}
		System.out.println("**********************************************************************");
		System.out.println("Show information for all visitors seniors and regulars:");
		System.out.println("regulars");
	for(int i=0;i<rv.regulars.size();i++) {
		
		System.out.println(rv.regulars.get(i));
		recv=recv+rv.regulars.get(i).o.size();
		System.out.println("**********************************************************************");
		System.out.println(" multy Tickets for regulars with discount for each type");
		for(int j=0;j<multy.tickets.size();j++) {
		if((rv.regulars.get(i).id==multy.tickets.get(j).vid)&&multy.tickets.get(j).typevestorflag==1) {
		System.out.println(multy.tickets.get(j));
		monym=monym+multy.tickets.get(j).price;
		}
		
		}
		System.out.println("**********************************************************************");
		System.out.println(" one Tickets for regulars this from our servises");
		for(int k=0;k<onetick.tickets.size();k++) {
		if((rv.regulars.get(i).id==onetick.tickets.get(k).vid)&&onetick.tickets.get(k).typevestorflag==1) {
		System.out.println(onetick.tickets.get(k));
		
		monyo=monyo+onetick.tickets.get(k).price;
		}
		
		}
		
		System.out.println("**********************************************************************");
		
		
	}
	
	
	
	
	System.out.println("**********************************************************************");
	
	System.out.println("seniors");
		
		
for(int i=0;i<sv.seniors.size();i++) {
	if(this.isLoggedin ==true) {
		System.out.println(sv.seniors.get(i));
		recs=recs+sv.seniors.get(i).o.size();
		System.out.println(" multy Tickets for seniors with discount for each type");	

		for(int j=0;j<multy.tickets.size();j++) {
		if((sv.seniors.get(i).id==multy.tickets.get(j).vid)&&multy.tickets.get(j).typevestorflag==0) {
		System.out.println(multy.tickets.get(j));}
		monysm=monysm+multy.tickets.get(j).price;
		}
		
		System.out.println("**********************************************************************");
		System.out.println(" one Tickets for seniors this from our servises with discount for age >50");
		for(int k=0;k<onetick.tickets.size();k++) {
		if((sv.seniors.get(i).id==onetick.tickets.get(k).vid)&&onetick.tickets.get(k).typevestorflag==0) {
		System.out.println(onetick.tickets.get(k));
		monys=monys+onetick.tickets.get(k).price;
		
		}
		
		}
		
		
		
	}
		
		
	}




System.out.println("Total income from the expenses of the  mueseum");
System.out.println( monym+ monyo+monys+monysm);
System.out.println("Total visits in muesuem");	
System.out.println( recv+recs);
System.out.println("**********************************************************************");
		
		}
		
		
		
	

		
	}
	public void showsrv() {
		System.out.println("**********************************************************************");
		System.out.println("Welcome we have in our meusuem many serveses such as:");
		
		System.out.println("any visitor can isuee a ticket then he can make tours with our guides that have diffrent languages and working days ");
		
		System.out.println("if you want multy time ticket we have three types and evry type have discount");

		System.out.println("if your age is more than 50 we make to you discounts for one and multy tickets");
		
		System.out.println("**********************************************************************");
		
		
		
		
		
	}
	
		
		
		
	}
		
		
		