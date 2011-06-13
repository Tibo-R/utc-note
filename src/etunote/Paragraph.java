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

public class Paragraph extends Content {

	private String text;
	private ArrayList<String> classes;

	public Paragraph(int position) {
		super(position);
		this.classes = new ArrayList<String>();
		this.text = "";
	}

	public void setClasses(ArrayList<String> classes) {
		this.classes = classes;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public ArrayList<String> getClasses() {
		return classes;
	}

	public void addClass(String _class) {
		this.classes.add(_class);
	}

	@Override
	public String getHTML() {
		String s = "<div";
		if (this.classes.size() > 0)
			s += " class=\"" + Tools.explode(this.classes, " ") + "\" ";
		s += ">" + this.text + "</div>";
		return s;
	}

}
