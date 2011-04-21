package etunote;

import java.util.Date;



public class Note{
	static int current_id = 0;
	
	
	private String name;
	private int id;
	private Date created_at;
	private Date modified_at;
	
	public Note(String name){
		this.name = name;
		this.created_at = new Date();
		this.modified_at = new Date();
		this.id = Note.current_id;
		Note.current_id++;
	}
	
	public int save(){
		this.modified_at = new Date();
		return 1;
	}
	
	public int delete(){
		//this.setVisible(false);
		return 1;
	}

}
