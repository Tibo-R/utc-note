package etunote;

public class SemesterModel {
	private String name;

	public SemesterModel(String name) {
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
