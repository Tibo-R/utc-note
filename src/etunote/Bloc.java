package etunote;

import java.util.ArrayList;

public class Bloc extends Content {

	
	private static String[] types = {"info", "theoreme", "lemme", "formule", "code", "important"};
	
	
	private String text;
	private String type;
	
	public Bloc(int position, String type) {
		super(position);
		this.type = type;
		this.text = "";
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
		this.type = type;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	
	public String getHTML(){
		String s = "<p class=\"" + this.type + "\" ";
		s += ">" + this.text + "</p>";
		return s;
	}
	
	

}
