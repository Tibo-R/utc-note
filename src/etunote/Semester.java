package etunote;

import java.util.ArrayList;

public class Semester {
	private String name;
	private ArrayList<Uv> uvs;

	public Semester(String name) {
		super();
		this.name = name;
		this.uvs = new ArrayList<Uv>();
	}

	@Override
	public String toString() {
		return name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Uv> getUvs() {
		return uvs;
	}

	public void setUvs(ArrayList<Uv> uvs) {
		this.uvs = uvs;
	}

	
	

}
