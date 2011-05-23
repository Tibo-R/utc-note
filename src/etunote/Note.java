package etunote;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import javax.swing.text.BadLocationException;
import javax.swing.text.Element;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
 

/**
 * @author 
 *
 */
public class Note{
	static int current_id = 0;

	private String name;
	private int id;
	private int lastPosition;
	private Date created_at;
	private Date modified_at;
	private String color;
	
	private ArrayList<Uv> uvs;
	private ArrayList<Tag> tags;
	private ArrayList<Content> contents;

	private int lastTitleLevel;
	
	/**
	 * @param uv
	 */
	public Note(Uv uv){
		this.init("Nouvelle Note", uv, "");
	}
	
	/**
	 * @param name
	 * @param uv
	 */
	public Note(String name, Uv uv){
		this.init(name, uv, "");
	}
	
	public Note(String name, Uv uv, String color){
		this.init(name, uv, color);
	}
	
	public void init(String name, Uv uv, String color){
		this.name = name;
		this.color = color;
		this.uvs = new ArrayList<Uv>();
		this.contents = new ArrayList<Content>();
		this.uvs.add(uv);
		this.created_at = new Date();
		this.modified_at = new Date();
		this.lastPosition = 1;
		this.setLastTitleLevel(2);
		this.id = Note.current_id;
		Note.current_id++;
		
		Title t = new Title(0, name);
		this.contents.add(t);
		
		uv.getNotes().add(this);
		
		
	}
	

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Note [name=" + name + ", created_at=" + created_at + ", uvs="
				+ uvs + ", contents=" + contents + "]";
	}

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}

	
	public Date getCreated_at() {
		return created_at;
	}

	
	public Date getModified_at() {
		return modified_at;
	}



	public void setModified_at(Date modified_at) {
		this.modified_at = modified_at;
	}
	
	public int getId(){
		return this.id;
	}


	public ArrayList<Uv> getUvs() {
		return uvs;
	}
	
	public ArrayList<Content> getContents() {
		return contents;
	}

	public void addUv(Uv uv) {
		this.uvs.add(uv);
	}
	
	public static int getCurrent_id() {
		return current_id;
	}

	public static void setCurrent_id(int current_id) {
		Note.current_id = current_id;
	}

	public ArrayList<Tag> getTags() {
		return tags;
	}

	public void setTags(ArrayList<Tag> tags) {
		this.tags = tags;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public void setUvs(ArrayList<Uv> uvs) {
		this.uvs = uvs;
	}

	public void setContents(ArrayList<Content> contents) {
		this.contents = contents;
	}

	public int save(){
		this.modified_at = new Date();
		//Write in XML
		return 1;
	}
	
	public int delete(){
		//this.setVisible(false);
		return 1;
	}
	
	public void addContent(Content c){
		if(c.getPosition() <= contents.size()){
			for (Content content : contents){
				int position = content.getPosition();
				if(position <= c.getPosition())
					content.setPosition(position++);
			}
		}
		contents.add(c);
		this.lastPosition++;
		
		Collections.sort(contents, new Comparator<Content>(){
			 
            public int compare(Content c1, Content c2) {
               return c1.compareTo(c2);
            }
 
        });
	}
	
	public int getLastPosition() {
		return lastPosition;
	}

	public void setLastPosition(int lastPosition) {
		this.lastPosition = lastPosition;
	}

	public String getHTML(){
		
		String s = "<html>\n<head>\n<title>" + this.name + "</title>\n";
		s += "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n";
		s += "<link rel=\"stylesheet\" media=\"screen\" type=\"text/css\" title=\"Design\" href=\"../../../data/styles/default/style.css\" />\n";
		
		
		s+="</head>\n\t<body>\n";
		
		s+="<div id=\"content\">\n";

		for (Content c : contents){
			s += c.getHTML() + "\n";
		}

		s+="</div>";
		s += "\n\t</body>\n</html>";
		return s;
	}

	public void setLastTitleLevel(int lastTitleLevel) {
		this.lastTitleLevel = lastTitleLevel;
	}

	public int getLastTitleLevel() {
		return lastTitleLevel;
	}
	
	public void upLastTitleLevel() {
		this.lastTitleLevel++;
	}
	
	public void downLastTitleLevel() {
		this.lastTitleLevel--;
	}
	
	public Color getColorCode() {
		return Tools.getColor(color);
	}

}
