package etunote;

import java.awt.Color;
import java.util.ArrayList;

public class Uv {

	private ArrayList<Semester> semesters;
	private ArrayList<Note> notes;

	private String name;
	private String color;
	private String Type;

	public Uv(String name, Semester sem) {
		super();
		init(name, sem, "");
	}

	public Uv(String name, Semester sem, String color) {
		super();
		init(name, sem, color);
	}

	private void init(String name, Semester sem, String color) {
		this.name = name;
		this.semesters = new ArrayList<Semester>();
		this.notes = new ArrayList<Note>();
		this.semesters.add(sem);
		this.color = color;
		sem.getUvs().add(this);
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

	@Override
	public String toString() {
		return name;
	}

	public Color getColorCode() {
		return Tools.getColor(color);
	}

	public ArrayList<Note> getNotes() {
		return notes;
	}

	public void setNotes(ArrayList<Note> notes) {
		this.notes = notes;
	}

}
