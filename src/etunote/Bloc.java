package etunote;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Hashtable;

public class Bloc extends Paragraph {

	private static Hashtable<String,Color> colors = new Hashtable<String,Color>();
	private static String[] types = {"info", "important", "question", "theoreme"};
	private static Color colorsCode[] = { new Color(198, 249, 208), new Color(255, 221, 177), new Color(208, 219, 253), new Color(249, 198, 201) }; 
	
	
	
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

	
	public String getHTML(){
		String s = "<div class=\"" + this.type + "\" ";
		s += ">" + this.getText() + "</div>";
		return s;
	}
	
	public Color getColor(){
		for(int i=0; i< types.length; i++){
			colors.put(types[i],colorsCode[i]);
		}
		return colors.get(this.type);
			
	}
	
	

}
