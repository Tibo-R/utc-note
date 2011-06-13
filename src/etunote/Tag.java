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

public class Tag {

	static ArrayList<Tag> tags = new ArrayList<Tag>();

	private String name;

	public Tag(String name) {
		super();
		this.name = name;
		Tag.tags.add(this);
	}

	public static ArrayList<Tag> getTags() {
		return tags;
	}

	public static void setTags(ArrayList<Tag> tags) {
		Tag.tags = tags;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
