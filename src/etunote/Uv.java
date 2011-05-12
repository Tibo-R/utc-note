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
	
	public ArrayList<Semester> getSemesters() {
		return semesters;
	}

	public void setSemesters(ArrayList<Semester> semesters) {
		this.semesters = semesters;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
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
