package etunote;

import java.util.ArrayList;

public class Uv {
	
	private ArrayList<Semester> semesters;
	private String name;
	private String color;
	private String Type;
	
	public Uv(String name, Semester sem) {
		super();
		this.name = name;
		this.semesters = new ArrayList<Semester>();
		this.semesters.add(sem);
		this.color = "#FFF";
	}
	
	public Uv(String name, Semester sem, String color) {
		super();
		this.name = name;
		this.semesters = new ArrayList<Semester>();
		this.semesters.add(sem);
		this.color = color;
	}
	
	@Override
	public String toString() {
		return name;
	}

}
