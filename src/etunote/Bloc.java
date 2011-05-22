package etunote;

import java.util.ArrayList;

public class Bloc extends Paragraph {

	
	private static String[] types = {"info", "theoreme", "lemme", "formule", "code", "important"};
	
	
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
		String s = "<p class=\"" + this.type + "\" ";
		s += ">" + this.getText() + "</p>";
		return s;
	}
	
	

}
