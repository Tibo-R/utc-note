package etunote;

import java.util.ArrayList;

public class UvModel {
	
	private ArrayList<SemesterModel> semesters;
	private String name;
	private String color;
	private String Type;
	
	public UvModel(String name, SemesterModel sem) {
		super();
		this.name = name;
		this.semesters = new ArrayList<SemesterModel>();
		this.semesters.add(sem);
		this.color = "#FFF";
	}
	
	public ArrayList<SemesterModel> getSemesters() {
		return semesters;
	}

	public void setSemesters(ArrayList<SemesterModel> semesters) {
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

	public UvModel(String name, SemesterModel sem, String color) {
		super();
		this.name = name;
		this.semesters = new ArrayList<SemesterModel>();
		this.semesters.add(sem);
		this.color = color;
	}
	
	@Override
	public String toString() {
		return name;
	}

}
