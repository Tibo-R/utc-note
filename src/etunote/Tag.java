package etunote;

import java.util.ArrayList;

public class Tag {
	
	static ArrayList<Tag> tags = new ArrayList<Tag>();

	private String name;

	public Tag(String name) {
		super();
		this.name = name;
		Tag.tags.add(this);
	}
	
	
	
	
}
