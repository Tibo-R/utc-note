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

public abstract class Content implements Comparable<Object> {

	private int position;

	public Content(int position) {
		super();
		this.position = position;
	}

	@Override
	public final int compareTo(Object cont) {
		int result = 0;
		if (cont instanceof Content) {
			if (this.position > ((Content) cont).position)
				result = 1;
			if (this.position < ((Content) cont).position)
				result = -1;
		}

		return result;
	}

	public String getHTML() {
		return "";
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

}
