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
import java.net.URL;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Tools {

	private static Hashtable<String, Color> colors = new Hashtable<String, Color>();
	private static String nomsCouleurs[] = { "Bleu", "Cyan", "Gris foncé",
			"Gris", "Vert", "Gris clair", "Magenta", "Orange", "Rose", "Rouge",
			"Blanc", "Jaune" };

	public static String[] getCouleurs() {
		return nomsCouleurs;
	}

	private static Color colorsCode[] = { Color.blue, Color.cyan,
			Color.darkGray, Color.gray, Color.green, Color.lightGray,
			Color.magenta, Color.orange, Color.pink, Color.red, Color.white,
			Color.yellow };

	public static String explode(ArrayList<String> inputArray, String separator) {

		if (inputArray.size() == 0) {
			return "";
		} else {
			StringBuffer sb = new StringBuffer();
			sb.append(inputArray.get(0));
			for (int i = 1; i < inputArray.size(); i++) {
				sb.append(separator);
				sb.append(inputArray.get(i));
			}
			return sb.toString();
		}
	}

	public static Color getColor(String color) {
		for (int i = 0; i < colorsCode.length; i++) {
			colors.put(nomsCouleurs[i], colorsCode[i]);
		}
		return colors.get(color);

	}

	public static void addIcon(JButton button, String icon) {
		button.setIcon(new ImageIcon(Tools.getPathToIcons(icon)));
		button.setOpaque(false);
		button.setFocusPainted(false);
		// button.setBorderPainted(false);
		button.setContentAreaFilled(false);
		// button.setBorder(null);
	}

	public static void addImageAsButton(JButton button, String icon) {
		button.setIcon(new ImageIcon(Tools.getPathToIcons(icon)));
		button.setOpaque(false);
		button.setFocusPainted(false);
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
		button.setBorder(null);
	}

	public static URL getPathToIcons(String icon) {
		return Tools.class.getResource("/data/icon/" + icon);
	}
	
	public static String getPathToCss() {
		return Tools.class.getResource("/data/styles/default/").getPath();
		
	}

}
