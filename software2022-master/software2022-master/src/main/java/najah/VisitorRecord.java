package najah;

import java.util.ArrayList;

public class VisitorRecord {

	public int hour;
	public int minute;
	public String entringdate;

	ArrayList<String> notes = new ArrayList<String>(); 
VisitorRecord(){
	
	super();
	
}


public VisitorRecord(int hour, int minute, String entringdate) {
	this.hour=hour;
	this.minute=minute;
	this.entringdate=entringdate;
}

@Override
public String toString() {
	// TODO Auto-generated method stub
	return "entring date" + "      " + this.entringdate +  "   hour" + this.hour+"    minuite"
			+ this.minute;
}






}