package etunote;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
 

/**
 * @author 
 *
 */
public class Note{
	static int current_id = 0;
	
	private String name;
	private int id;
	private Date created_at;
	private Date modified_at;
	
	private ArrayList<Uv> uvs;
	private ArrayList<Tag> tags;
	private ArrayList<Content> contents;
	
	/**
	 * @param uv
	 */
	public Note(Uv uv){
		this.name = "Nouvelle Note";
		this.uvs = new ArrayList<Uv>();
		this.contents = new ArrayList<Content>();
		this.uvs.add(uv);
		this.created_at = new Date();
		this.modified_at = new Date();
		this.id = Note.current_id;
		Note.current_id++;
	}
	
	/**
	 * @param name
	 * @param uv
	 */
	public Note(String name, Uv uv){
		this.name = name;
		this.uvs = new ArrayList<Uv>();
		this.contents = new ArrayList<Content>();
		this.uvs.add(uv);
		this.created_at = new Date();
		this.modified_at = new Date();
		this.id = Note.current_id;
		Note.current_id++;
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


	public ArrayList<Uv> getUvs() {
		return uvs;
	}

	public void addUv(Uv uv) {
		this.uvs.add(uv);
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

}
