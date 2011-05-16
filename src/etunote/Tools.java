package etunote;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Hashtable;

public class Tools {
	
	private static Hashtable<String,Color> colors = new Hashtable<String,Color>();
	private static String nomsCouleurs[] = { "Noir", "Bleu", "Cyan", "Gris foncé", "Gris", "Vert", "Gris clair", "Magenta", "Orange", "Rose", "Rouge",	"Blanc", "Jaune" }; 
	private static Color colorsCode[] = { Color.black, Color.blue, Color.cyan, Color.darkGray, Color.gray, Color.green, Color.lightGray, Color.magenta, Color.orange, Color.pink, Color.red, Color.white, Color.yellow }; 
	
	

	public static String explode(ArrayList<String> inputArray, String separator){
		
		if (inputArray.size()==0) {
			return "";
		} 
		else {
			StringBuffer sb = new StringBuffer();
			sb.append(inputArray.get(0));
			for (int i=1;i<inputArray.size();i++) {
				sb.append(separator);
				sb.append(inputArray.get(i));
			}
			return sb.toString();
		}
	}
	
	public static Color getColor(String color){
		for(int i=0; i< colorsCode.length; i++){
			colors.put(nomsCouleurs[i],colorsCode[i]);
		}
		return colors.get(color);
			
	}


}
