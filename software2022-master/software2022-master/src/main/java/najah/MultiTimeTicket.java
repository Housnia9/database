package najah;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class MultiTimeTicket {
	int tickid;
	int vid;
	String duedate;
	int price;
	double discount;
	double pricenem;
	double	pricenewm;
	int typevestorflag=1;
	public ArrayList<TicketType> p = new ArrayList<TicketType>();
	
	public static List<MultiTimeTicket>tickets =new ArrayList<MultiTimeTicket>(); 
	
	
	
	private boolean reg=false;
	boolean rr=false;
	 boolean day=false;
	 boolean type=false;
	 boolean cond=false;
	public MultiTimeTicket () {
		super();
	}
	
	
	public MultiTimeTicket(int tickid, int vid, String duedate, int price, double discount,
			ArrayList<TicketType> p) {
		super();
		
		this.tickid=tickid;
		this.vid=vid;
		this.duedate=duedate;
		this.price=price;
		this.discount=discount;
		this.p=p;
		
		
	}

	public String addmulty(Admin admin, MultiTimeTicket multy) {
		String result=null;
		boolean exist=multy.tickExist(multy);
		if (!admin.isLoggedin()) {
			result= "Admin login is required";
		}
		else if (exist) {
			result= " This  multyticket is already exist" ;
		}
		else {
			reg=true;
			tickets.add(multy);
			result= "multyTicket added successfully to the system" ;
		}
		return result;
		
		
	}

	public boolean tickExist(MultiTimeTicket multy) {
		
		boolean exist=false;
		for (int i = 0; i < tickets.size(); i++) {
			if (tickets.get(i).tickid==multy.tickid) {
				exist= true;
				break;
			}
		}
		
		return exist;
	}

	public boolean isReg() {
		
		return reg;
	}


	public boolean chcage(String dop) throws ParseException {
SimpleDateFormat d1 = new SimpleDateFormat("dd/MM/yyyy");
		
		Date dq = d1.parse(dop);
	
		Date da = new Date();
		SimpleDateFormat f = new SimpleDateFormat("yyyy");
		int yearnow = Integer.parseInt(f.format(da));
		int yearBd = Integer.parseInt(f.format(dq));
		int age = yearnow - yearBd;
		if (age < 50) {
			
		
			rr=true;
		
        
		}
		
		return rr;
	}


	public boolean checkconditions(String string, String string2) throws ParseException {
		type=false;
		if(string.toUpperCase().equals("MULTY")) {
			
			
			type=true;
			
			}	

			
		String date = string2;
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
		
		
	if(day==true&&type==true)	{
		cond=true;
		
		
		
		
	}
		
	return cond;	
			
	}


	public boolean checkidd(int int1) {
		boolean exsim=false;
		for (int i = 0; i < tickets.size(); i++) {
			if (tickets.get(i).tickid==int1) {
				exsim= true;
				break;
			}
		}
		
		return exsim;	
		
			
	}


	public void isueertick(int tickidm, int vidm, String subdatem, RegularVisitor rv, String dai) {
		
	for (int i = 0; i < tickets.size(); i++) {
			
			if (tickets.get(i).tickid==tickidm) {
				tickets.get(i).vid=vidm;
				tickets.get(i).duedate=subdatem;
				
				if(dai.toUpperCase().equals("YEARLY")) {
					pricenewm=tickets.get(i).price*(0.50);
					tickets.get(i).price=(int)(pricenewm);
					tickets.get(i).typevestorflag=1;}
				else if (dai.toUpperCase().equals("MONTHLY")) {
					pricenewm=tickets.get(i).price*(0.60);
					tickets.get(i).price=(int)(pricenewm);
					tickets.get(i).typevestorflag=1;}
				
				else if (dai.toUpperCase().equals("DAILY")) {
					pricenewm=tickets.get(i).price*(0.70);
					tickets.get(i).price=(int)(pricenewm);}
			tickets.get(i).typevestorflag=1;
				
				
			
			
			
			
			}}
	
	
	
	
	}


	public void isueestick(int tickidm, int vidm, String subdatem, SeniorVisitor sv, String dai) {
for (int i = 0; i < tickets.size(); i++) {
			
			if (tickets.get(i).tickid==tickidm) {
				tickets.get(i).vid=vidm;
				tickets.get(i).duedate=subdatem;
				
				
				if(dai.toUpperCase().equals("YEARLY")) {
					pricenewm=(tickets.get(i).price)*(0.10);
					tickets.get(i).typevestorflag=0;

					tickets.get(i).price=(int)(pricenewm);
					
				
			}
				else if (dai.toUpperCase().equals("MONTHLY")) {
					pricenewm=(tickets.get(i).price)*(0.20);
					tickets.get(i).price=(int)(pricenewm);
					tickets.get(i).typevestorflag=0;

					}
				
			else if (dai.toUpperCase().equals("DAILY")) {
				pricenewm=(tickets.get(i).price)*(0.30);
					tickets.get(i).price=(int)(pricenewm);
					tickets.get(i).typevestorflag=0;

			
			}
				
				
				
				
				
				
			
				
			}
			
			
			
		}
		
	}


	public void isueerftick(int tickidm, int vidm, String subdatem, RegularVisitor rv, String dai) {
		MultiTimeTicket	 k= new MultiTimeTicket ();
		
		
		k.vid=vidm;
		k.tickid=tickidm;
		k.duedate=subdatem;
		if(dai.toUpperCase().equals("YEARLY")) {
			pricenem=2984754*0.50;
			k.price=(int)(pricenem);
			k.p.add(TicketType.YEARLY);
			k.typevestorflag=1;

		}
		else if (dai.toUpperCase().equals("MONTHLY")) {
			pricenem=2984754*0.60;
			k.price=(int)(pricenem);
	k.p.add(TicketType.MONTHLY);
	k.typevestorflag=1;

		}
	else if	(dai.toUpperCase().equals("DAILY")) {
			
			pricenem=2984754*0.70;
			k.price=(int)(pricenem);
			k.typevestorflag=1;

		k.p.add(TicketType.DAILY);

	
	}
		
		
			
		
		
		tickets.add(k);
		
	}


	public void isueesftick(int tickidm, int vidm, String subdatem, SeniorVisitor sv, String dai) {
		
		MultiTimeTicket	 k= new MultiTimeTicket ();
		
		k.vid=vidm;
		k.tickid=tickidm;
		k.duedate=subdatem;
	if(dai.toUpperCase().equals("YEARLY")) {
		pricenem=2984754*(0.10);
		k.price=(int)(pricenem);
		k.typevestorflag=0;
		k.p.add(TicketType.YEARLY);}
	else if (dai.toUpperCase().equals("MONTHLY")) {
		pricenem=2984754*(0.20);
		k.price=(int)(pricenem);
k.p.add(TicketType.MONTHLY);
k.typevestorflag=0;
	}
	else if (dai.toUpperCase().equals("DAILY")) {
		pricenem=2984754*(0.30);
		k.price=(int)(pricenem);
		k.p.add(TicketType.DAILY);
		k.typevestorflag=0;}

	
		tickets.add(k);
	}


	public boolean checkvti(int tickkid, int vistorid) {
		boolean tic=false;
		for (int i = 0; i < tickets.size(); i++) {
			if(tickets.get(i).tickid==tickkid&&tickets.get(i).vid==vistorid)	{
				tic=true;
				
				break;
				
				
			}
		}
		
	
		
		return tic;
	}

	
	
	
	


	public boolean dail(int ids, RegularVisitor rv) {
		boolean f=false;
	for(int i=0;i<tickets.size();i++) {
		
		if(tickets.get(i).vid==ids && tickets.get(i).p.get(0).equals(TicketType.DAILY)&&tickets.get(i).typevestorflag==1 ) {
			
			
			f=true;
			
			break;
			
			
			
			}
		
		
	
		
		
		}
		
		
	return f;	
		
		
		
		
	}


	public boolean month(int ids, RegularVisitor rv) {
		boolean f=false;
		for(int i=0;i<tickets.size();i++) {
			
			if(tickets.get(i).vid==ids && tickets.get(i).p.get(0).equals(TicketType.MONTHLY)&&tickets.get(i).typevestorflag==1 ) {
				
				
				f=true;
				
				break;
				
				
				
				}
			
			
		
			
			
			}
			
			
		return f;	
	}


	public boolean year(int ids, RegularVisitor rv) {
		boolean f=false;
		for(int i=0;i<tickets.size();i++) {
			
			if(tickets.get(i).vid==ids && tickets.get(i).p.get(0).equals(TicketType.YEARLY)&&tickets.get(i).typevestorflag==1 ) {
				
				
				f=true;
				
				break;
				
				
				
				}
			
			
		
			
			
			}
			
			
		return f;	
			
	}


	public boolean dails(int ids, SeniorVisitor sv) {
		boolean f=false;
		for(int i=0;i<tickets.size();i++) {
			
			if(tickets.get(i).vid==ids && tickets.get(i).p.get(0).equals(TicketType.DAILY)&&tickets.get(i).typevestorflag==0 ) {
				
				
				f=true;
				
				break;
				
				
				
				}
			
			
		
			
			
			}
			
			
		return f;	
				
	}


	public boolean months(int ids, SeniorVisitor sv) {
		boolean f=false;
		for(int i=0;i<tickets.size();i++) {
			
			if(tickets.get(i).vid==ids && tickets.get(i).p.get(0).equals(TicketType.MONTHLY)&&tickets.get(i).typevestorflag==0 ) {
				
				
				f=true;
				
				break;
				
				
				
				}
			
			
		
			
			
			}
			
			
		return f;	
	}


	public boolean years(int ids, SeniorVisitor sv) {
		boolean f=false;
		for(int i=0;i<tickets.size();i++) {
			
			if(tickets.get(i).vid==ids && tickets.get(i).p.get(0).equals(TicketType.YEARLY)&&tickets.get(i).typevestorflag==0 ) {
				
				
				f=true;
				
				break;
				
				
				
				}
			
			
		
			
			
			}
			
			
		return f;		
	}
	
	



	public void billingdr(RegularVisitor rv, int ids) {
		int pricee=0;
		int priceserv=0;
	int count=0;
		System.out.println("**********************************************************************");
		System.out.println("billing for daily tickets for visitor and his services");
		for(int k=0;k<tickets.size();k++) {
			
			if(tickets.get(k).vid==ids && tickets.get(k).p.get(0).equals(TicketType.DAILY)&&tickets.get(k).typevestorflag==1 ) {
				 {
					System.out.print(tickets.get(k)); 
			pricee=	pricee+tickets.get(k).price;
			
			}
			
				 for(int i=0;i<rv.regulars.size();i++)	{
						
						if(rv.regulars.get(i).id==ids) {
						System.out.println(rv.regulars.get(i));
						
					System.out.println	(	rv.regulars.get(i).servise.size());
						for(int m=0;m<rv.regulars.get(i).servise.size();m++) {
							
							System.out.println(rv.regulars.get(i).servise);
							
							priceserv=	priceserv+rv.regulars.get(i).servise.get(m).price;	}	}}
		
		 }
			
		
		
		}
		
		
		System.out.println("so the final price  is:    ");
		System.out.println(priceserv+pricee);
		System.out.println("**********************************************************************");
	}


	public void biillingmr(RegularVisitor rv, int ids) {
		int pricee=0;
		int priceserv=0;
		System.out.println("**********************************************************************");
		System.out.println("billing for monthly tickets for visitor and his services");
		for(int k=0;k<tickets.size();k++) {
			
			if(tickets.get(k).vid==ids && tickets.get(k).p.get(0).equals(TicketType.MONTHLY)&&tickets.get(k).typevestorflag==1 ) {
				 {
					System.out.print(tickets.get(k)); 
			pricee=	pricee+tickets.get(k).price;
		
			}
			
		for(int i=0;i<rv.regulars.size();i++)	{
			
			if(rv.regulars.get(i).id==ids) {
				System.out.println(rv.regulars.get(i));
			
				
			for(int m=0;m<rv.regulars.get(i).servise.size();m++) {
				
				System.out.println(rv.regulars.get(i).servise);
				
				priceserv=	priceserv+rv.regulars.get(i).servise.get(m).price;	}	}} }}
			
		
		
		
		
		
		System.out.println("so the final price is:    ");
		System.out.println(priceserv+pricee);
		System.out.println("**********************************************************************");
		
	}


	public void billinoyear(RegularVisitor rv, int ids) {
		int pricee=0;
		int priceserv=0;
		System.out.println("**********************************************************************");
		System.out.println("billing for yearly tickets for visitor and his services");
		for(int k=0;k<tickets.size();k++) {
			
			if(tickets.get(k).vid==ids && tickets.get(k).p.get(0).equals(TicketType.YEARLY)&&tickets.get(k).typevestorflag==1 ) {
				 {
					System.out.print(tickets.get(k)); 
			pricee=	pricee+tickets.get(k).price;
		
			}
			
		for(int i=0;i<rv.regulars.size();i++)	{
			
			if(rv.regulars.get(i).id==ids) {
				System.out.println(rv.regulars.get(i));
				
				
			for(int m=0;m<rv.regulars.get(i).servise.size();m++) {
				
				System.out.println(rv.regulars.get(i).servise);
				
				priceserv=	priceserv+rv.regulars.get(i).servise.get(m).price;	}	}} }
			
		
		
		
		}
		
		System.out.println("so the final price is:    ");
		System.out.println(priceserv+pricee);
		System.out.println("**********************************************************************");
		
	}


	public void billinodayss(SeniorVisitor sv, int ids) {
		
		int pricee=0;
		int priceserv=0;
		System.out.println("**********************************************************************");
		System.out.println("billing for daily tickets for senior visitor and his services");
		for(int k=0;k<tickets.size();k++) {
			
			if(tickets.get(k).vid==ids && tickets.get(k).p.get(0).equals(TicketType.DAILY)&&tickets.get(k).typevestorflag==0 ) {
				 {
					System.out.print(tickets.get(k)); 
			pricee=	pricee+tickets.get(k).price;
		
			}
			
		for(int i=0;i<sv.seniors.size();i++)	{
			
			if(sv.seniors.get(i).id==ids) {
				System.out.println(sv.seniors.get(i));
				
				
			for(int m=0;m<sv.seniors.get(i).servise.size();m++) {
				
				System.out.println(sv.seniors.get(i).servise);
				
				priceserv=	priceserv+sv.seniors.get(i).servise.get(m).price;	}	}} }
			
		
		
		
		}
		
		System.out.println("so the final price is:    ");
		System.out.println(priceserv+pricee);
		System.out.println("**********************************************************************");
	}


	


	public void billinodmontss(SeniorVisitor sv, int ids) {
		int pricee=0;
		int priceserv=0;
		System.out.println("**********************************************************************");
		System.out.println("billing for monthly tickets for senior visitor and his services");
		for(int k=0;k<tickets.size();k++) {
			
			if(tickets.get(k).vid==ids && tickets.get(k).p.get(0).equals(TicketType.MONTHLY)&&tickets.get(k).typevestorflag==0 ) {
				 {
					System.out.print(tickets.get(k)); 
			pricee=	pricee+tickets.get(k).price;
		
			}
			
		for(int i=0;i<sv.seniors.size();i++)	{
			
			if(sv.seniors.get(i).id==ids) {
				System.out.println(sv.seniors.get(i));
				
				
			for(int m=0;m<sv.seniors.get(i).servise.size();m++) {
				
				System.out.println(sv.seniors.get(i).servise);
				
				priceserv=	priceserv+sv.seniors.get(i).servise.get(m).price;	}	}} 
			
		
		
			}
		}
		
		System.out.println("so the final price is:    ");
		System.out.println(priceserv+pricee);
		System.out.println("**********************************************************************");
		
	}


	public void bllingyearsss(SeniorVisitor sv, int ids) {
		int pricee=0;
		int priceserv=0;
		System.out.println("**********************************************************************");
		System.out.println("billing for yearly tickets for senior visitor and his services");
		for(int k=0;k<tickets.size();k++) {
			
			if(tickets.get(k).vid==ids && tickets.get(k).p.get(0).equals(TicketType.YEARLY)&&tickets.get(k).typevestorflag==0 ) {
				 {
					System.out.print(tickets.get(k)); 
			pricee=	pricee+tickets.get(k).price;
		
			}
			
		for(int i=0;i<sv.seniors.size();i++)	{
			
			if(sv.seniors.get(i).id==ids) {
				System.out.println(sv.seniors.get(i));
			
				
			for(int m=0;m<sv.seniors.get(i).servise.size();m++) {
				
				System.out.println(sv.seniors.get(i).servise);
				
				priceserv=	priceserv+sv.seniors.get(i).servise.get(m).price;	}	}} 
			
		
		
			}
		}
		
		System.out.println("so the final price is:    ");
		System.out.println(priceserv+pricee);
		System.out.println("**********************************************************************");
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return  " tickid:"+this.tickid+"  visitor that have it " +this.vid+" subDate :"  + this.duedate + " Price : " + price+" tickettype"+this.p;
	}



	
		
	



	public void showtickett(int idv, int flag) {
		// TODO Auto-generated method stub
		boolean flagss = false;
		//ticket.typeevisitorFlag=0;
			for (int i= 0; i < tickets.size(); i++) {


				if (tickets.get(i).vid==idv && flag==1) {
					flagss = true;
					System.out.println();
					System.out.println("**********************************************************************");
					System.out.println("The Senior Visitor  has Multi Time ticket:");
					System.out.println(tickets.get(i));
				
					System.out.println("**********************************************************************");
					
					break;
				
					
		
	}
				System.out.println();
				System.out.println("**********************************************************************");
				System.out.println("The Regular Visitor  has Multi Time ticket:");
				System.out.println(tickets.get(i));
				
				System.out.println("**********************************************************************");
				break;
				
			}
	}

	
	
	
	
	
	
	
	
	
	
	
	

}
