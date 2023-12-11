
package najah;


import io.cucumber.java.en.Given;
import java.text.SimpleDateFormat;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.*;

public class OneTimeTicket {
	int tickid;
	int vid;
	String duedate;
	int price;
	

	public static List<OneTimeTicket> tickets=new ArrayList<OneTimeTicket>(); 
	private boolean reg=false;
	boolean type=false;
	boolean day=false;
	boolean cond=false;
	boolean rr=false;
	int typeevisitorFlag=1;
	double pricenew;
 int 	typevestorflag=1;
	public boolean isReg() {
		return reg;
	}
	
	public OneTimeTicket () {
		super();
	}
	public OneTimeTicket(int tickid, int vid, String duedate, int price) {
		super();
		this.tickid=tickid;
		this.vid=vid;
		this.duedate=duedate;
		this.price=price;
		
		
		
		
	}
	

	public String add(Admin admin, OneTimeTicket onetick) {
		
		String result=null;
		boolean exist=onetick.tickExist(onetick);
		if (!admin.isLoggedin()) {
			result= "Admin login is required";
		}
		else if (exist) {
			result=" This  oneticket is already exist" ;
		}
		else {
			reg=true;
			tickets.add(onetick);
			result= "oneTicket added successfully to the system";
		}
		return result;	
		
		
		
	}
	public boolean tickExist(OneTimeTicket onetick) {
		boolean exist=false;
		for (int i = 0; i < tickets.size(); i++) {
			if (tickets.get(i).tickid==onetick.tickid) {
				exist= true;
				break;
			}
		}
		
		return exist;
	}

	public boolean checkconditions(String ticktype, String muesumdays) throws ParseException {
		
	if(ticktype.toUpperCase().equals("ONE")) {
		
		
		type=true;
		
		}	
		
	String date = muesumdays;
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
		
		boolean exist=false;
		for (int i = 0; i < tickets.size(); i++) {
			if (tickets.get(i).tickid==int1) {
				exist= true;
				break;
			}
		}
		
		return exist;	
		
		
		
		
		
		
	}

	public void isueertick(int tickid2, int vid2, String subdate, RegularVisitor rv) {
		for (int i = 0; i < tickets.size(); i++) {
			
			if (tickets.get(i).tickid==tickid2) {
				tickets.get(i).vid=vid2;
				tickets.get(i).duedate=subdate;
				tickets.get(i).typevestorflag=1;
				
				
				
				
			}
			
			
			
		}
		
	}

	public void isueestick(int tickid2, int vid2, String subdate, SeniorVisitor sv2) {
for (int i = 0; i < tickets.size(); i++) {
			
			if (tickets.get(i).tickid==tickid2) {
				tickets.get(i).vid=vid2;
				tickets.get(i).duedate=subdate;
				pricenew=(tickets.get(i).price)*0.50;
				tickets.get(i).price=(int)(pricenew);
				tickets.get(i).typevestorflag=0;
				
			}
			
			
			
		}
		
	}

	public void isueerftick(int tickid2, int vid2, String subdate, RegularVisitor rv) {
		OneTimeTicket k= new OneTimeTicket();
		k.vid=vid2;
		k.tickid=tickid2;
		k.duedate=subdate;
		k.price=2984754;
		k.typevestorflag=1;
		tickets.add(k);
		
	
		
	}

	public void isueesftick(int tickid2, int vid2, String subdate, SeniorVisitor sv2) {
		OneTimeTicket k= new OneTimeTicket();
		k.vid=vid2;
		k.tickid=tickid2;
		k.duedate=subdate;
		
		pricenew=2984754*0.50;
		k.price=(int)(pricenew);
		k.typevestorflag=0;
		tickets.add(k);
		
		
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

	
		
		
		
		
	

	public boolean one(int ids, RegularVisitor rv) {
		boolean f=false;
		for(int i=0;i<tickets.size();i++) {
			
			if(tickets.get(i).vid==ids&&tickets.get(i).typevestorflag==1 ) {
				
				
				f=true;
				
				break;
				
				
				
				}
			
			
		
			
			
			}
			
			
		return f;		
	}

	public boolean ones(int ids, SeniorVisitor sv) {
		boolean f=false;
		for(int i=0;i<tickets.size();i++) {
			
			if(tickets.get(i).vid==ids &&tickets.get(i).typevestorflag==0 ) {
				
				
				f=true;
				
				break;
				
				
				
				}
			
			
		
			
			
			}
			
			
		return f;		
	}
	
	
	
	
		
	
	public void billinonr(RegularVisitor rv, int ids) {
		int pricee=0;
		int priceserv=0;
		System.out.println("**********************************************************************");
		System.out.println("billing for one tickets for visitor and his services");
		for(int k=0;k<tickets.size();k++) {
			
			if(tickets.get(k).vid==ids &&tickets.get(k).typevestorflag==1 ) {
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

	public void billinodoness(SeniorVisitor sv, int ids) {
		
		int pricee=0;
		int priceserv=0;
		System.out.println("**********************************************************************");
		System.out.println("billing for daily tickets for senior visitor and his services");
		for(int k=0;k<tickets.size();k++) {
			
			if(tickets.get(k).vid==ids &&tickets.get(k).typevestorflag==0 ) {
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
			
		
		
		
		}}
		
		System.out.println("so the final price is:    ");
		System.out.println(priceserv+pricee);
		System.out.println("**********************************************************************");
	}	
		
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return  " tickid:"+this.tickid+"  visitor that have it " +this.vid+" subDate :"  + this.duedate + " Price : " + price;
	}
	
	

	
	


	public void showticket(int idv, int flag) {
		// TODO Auto-generated method stub
		
		boolean flagss = false;
		//ticket.typeevisitorFlag=0;
			for (int i= 0; i < tickets.size(); i++) {


				if (tickets.get(i).vid==idv && flag==1) {
					flagss = true;
					System.out.println();
					System.out.println("**********************************************************************");
					System.out.println("The Senior Visitor  has one Time ticket:");
					System.out.println(tickets.get(i));
				
					System.out.println("**********************************************************************");
					break;
				
					
					//ticket.showticket(idv,flagsen);
					
						
				
				}
				System.out.println();
				System.out.println("**********************************************************************");
				System.out.println("The Regular Visitor  has one Time ticket:");
				System.out.println(tickets.get(i));
			
				System.out.println("**********************************************************************");
				break;
				
			

				}
	}
		

		
	

/*	public void showticket(int idv, int flagsen) {
		// TODO Auto-generated method stub
		boolean t=false;
		//typeevisitorFlag=1;
		for (int i = 0; i < tickets.size(); i++) {
			
			if(tickets.get(i).vid==idv && flagsen==0) {
				t=true;

				System.out.println();
				System.out.println("The visitor has one Time ticket:");
				System.out.println(tickets.get(i).tickid);
				System.out.println(tickets.get(i).vid);
				System.out.println(tickets.get(i).duedate);
				System.out.println(tickets.get(i).price);
				break;
			
				
			}
			System.out.println();
			
			System.out.println("The Senior Visitor doesn't has One Time Ticket");
		}
		
		
	}
	*/

	
		
		
		
		
		
		
		
		
	

	
	}


