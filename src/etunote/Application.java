package etunote;

import java.util.ArrayList;
import java.util.Iterator;

public class Application {
	
	private ArrayList<Semester> semestres;
	
	public Application(){
		semestres = new ArrayList<Semester>();
	}

	public ArrayList<Semester> getSemestres() {
		return semestres;
	}

	public void setSemestres(ArrayList<Semester> semestres) {
		this.semestres = semestres;
	}
	
	public boolean addSemester(Semester s){
		return(semestres.add(s));
	}
	
	public Semester getSemester(String n){
		Iterator it = semestres.iterator();
		while(it.hasNext()) {
		    Semester s = (Semester) it.next(); 
		    if(n.equals(s.getName())){
		    	return s;
		    }
		}
		return null;
	}
	
	public boolean isEmpty(){
		return (semestres.isEmpty());
	}
	
}
