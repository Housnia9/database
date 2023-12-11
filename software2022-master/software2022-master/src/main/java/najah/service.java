package najah;

public class service {
	
	int price;
	
	String name;
	
public service() {
		
		
		super();
	}

	public service(String servicee, int i) {
		super();
		
		this.price=i;
		
		this.name=servicee;
		
		
	}

	
	 @Override
		public String toString() {
			// TODO Auto-generated method stub
			return  "  service name:"+this.name+"   serviceprice " +this.price;
					}


	
	
}