package etunote;

public class Semester {
	private String name;

	public Semester(String name) {
		super();
		this.name = name;
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
	
	

}
