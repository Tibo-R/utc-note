/******************************************************************************************************
 * EtuNote Copyright (c) 2011 , Nicolas Mardesson, Mohamed Mbaye, Thibault Roucou All rights reserved.
 *  
 *   This program is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 *********************************************************************************************************/

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
