package etunote;

import java.util.ArrayList;
import java.util.Iterator;

public class Application {
	
	private ArrayList<Semester> semesters;
	
	public Application(){
		semesters = new ArrayList<Semester>();
	}

	public ArrayList<Semester> getSemesters() {
		return semesters;
	}

	public void setSemesters(ArrayList<Semester> semesters) {
		this.semesters = semesters;
	}
	
	public boolean addSemester(Semester s){
		return(semesters.add(s));
	}
	
	public Semester getSemester(String n){
		Iterator it = semesters.iterator();
		while(it.hasNext()) {
		    Semester s = (Semester) it.next(); 
		    if(n.equals(s.getName())){
		    	return s;
		    }
		}
		return null;
	}
	
	public boolean isEmpty(){
		return (semesters.isEmpty());
	}
	
}
