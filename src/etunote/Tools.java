package etunote;

import java.awt.Color;
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

	public static String getPathToIcons(String icon) {
		return "data/icon/" + icon;
	}

}
