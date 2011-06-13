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

public class Title extends Content {

	private int level;
	private String name;

	public Title(int position) {
		super(position);
		this.level = 2;
		this.name = "";
	}

	public Title(int position, String name) {
		super(position);
		this.level = 1;
		this.name = name;
	}

	public Title(int position, int level) {
		super(position);
		this.level = level;
		this.name = "";
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void levelUp() {
		if (this.level < 6)
			this.level++;
	}

	public void levelDown() {
		if (this.level > 2)
			this.level--;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getHTML() {
		return "<h" + level + ">" + this.name + "</h" + level + ">";
	}

	public int getLevel() {
		return level;
	}

	public String getName() {
		return name;
	}

}
