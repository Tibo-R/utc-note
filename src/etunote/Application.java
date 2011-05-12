package etunote;

import java.util.ArrayList;

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
	
}
