package etunote;

public class Title extends Content {

	private int level;
	private String name;

	public Title(int position) {
		super(position);
		this.level = 2;
		this.name = "";
	}
	
	public Title(int position, String name) {
		super(position);
		this.level = 1;
		this.name = name;
	}

	public Title(int position, int level) {
		super(position);
		this.level = level;
		this.name = "";
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public void levelUp(){
		if (this.level < 6)
			this.level++;
	}
	
	public void levelDown(){
		if (this.level > 2)
			this.level--;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHTML(){
		return "<h" + level + ">" + this.name + "</h" + level + ">";
	}
	

	
	public int getLevel(){
		return level;
	}
	public String getName(){
		return name;
	}

}
