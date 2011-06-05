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

	public static ArrayList<Tag> getTags() {
		return tags;
	}

	public static void setTags(ArrayList<Tag> tags) {
		Tag.tags = tags;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
