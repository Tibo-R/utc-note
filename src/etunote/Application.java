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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class Application {

	private ArrayList<Semester> semesters;

	public Application() {
		semesters = new ArrayList<Semester>();
	}

	public ArrayList<Semester> getSemesters() {
		return semesters;
	}

	public void setSemesters(ArrayList<Semester> semesters) {
		this.semesters = semesters;
	}

	public boolean addSemester(Semester s) {
		return (semesters.add(s));
	}

	public Semester getSemester(String n) {
		Iterator<Semester> it = semesters.iterator();
		while (it.hasNext()) {
			Semester s = (Semester) it.next();
			if (n.equals(s.getName())) {
				return s;
			}
		}
		return null;
	}

	public boolean isEmpty() {
		return (semesters.isEmpty());
	}

	public ArrayList<Note> getAllNotes() {
		ArrayList<Note> notes = new ArrayList<Note>();
		for (Semester semester : this.getSemesters()) {
			for (final Uv uv : semester.getUvs()) {
				for (final Note note : uv.getNotes()) {
					notes.add(note);
				}
			}
		}
		return notes;

	}

	public ArrayList<Note> getAllNotesByDate() {
		ArrayList<Note> notes = this.getAllNotes();
		Collections.sort(notes, new Comparator<Note>() {

			@Override
			public int compare(Note arg0, Note arg1) {
				int result = 0;
				if (arg0.getModified_at().before(arg1.getModified_at()))
					result = 1;
				if (arg0.getModified_at().after(arg1.getModified_at()))
					result = -1;
				return result;
			}

		});

		return notes;

	}

}
