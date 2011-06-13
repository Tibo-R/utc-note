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
import java.util.Hashtable;

public class Bloc extends Paragraph {

	private static Hashtable<String, Color> colors = new Hashtable<String, Color>();
	private static String[] types = { "info", "important", "question",
			"theoreme" };
	private static Color colorsCode[] = { new Color(198, 249, 208),
			new Color(255, 221, 177), new Color(208, 219, 253),
			new Color(249, 198, 201) };

	private String type;

	public Bloc(int position, String type) {
		super(position);
		this.type = type;
	}

	public static String[] getTypes() {
		return types;
	}

	public static void setTypes(String[] types) {
		Bloc.types = types;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		System.out.println("Bloc type set to : " + type);
		this.type = type;
	}

	@Override
	public String getHTML() {
		String s = "<div class=\"" + this.type + "\" ";
		s += ">" + this.getText() + "</div>";
		return s;
	}

	public Color getColor() {
		for (int i = 0; i < types.length; i++) {
			colors.put(types[i], colorsCode[i]);
		}
		return colors.get(this.type);

	}

}
