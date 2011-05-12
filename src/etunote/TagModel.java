package etunote;

import java.util.ArrayList;

public class TagModel {
	
	static ArrayList<TagModel> tags = new ArrayList<TagModel>();

	private String name;

	public TagModel(String name) {
		super();
		this.name = name;
		TagModel.tags.add(this);
	}

	public static ArrayList<TagModel> getTags() {
		return tags;
	}

	public static void setTags(ArrayList<TagModel> tags) {
		TagModel.tags = tags;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
