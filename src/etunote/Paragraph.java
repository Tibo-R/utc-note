package etunote;

import java.util.ArrayList;

public class Paragraph extends Content {

	private String text;
	private ArrayList<String> classes;
	
	public Paragraph(int position) {
		super(position);
		this.classes = new ArrayList<String>();
		this.text = "Votre texte ici...";
	}

	public void setClasses(ArrayList<String> classes) {
		this.classes = classes;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public ArrayList<String> getClasses() {
		return classes;
	}

	public void addClass(String _class) {
		this.classes.add(_class);
	}
	
	public String getHTML(){
		String s = "<p";
		if(this.classes.size() > 0)
			s += " class=\"" + Tools.explode(this.classes, " ") + "\" ";
		s += ">" + this.text + "</p>";
		return s;
	}
	
	

}
