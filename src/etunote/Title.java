package etunote;

public class Title extends Content {

	private int level;
	private String name;

	public Title(int position) {
		super(position);
		this.level = 1;
		this.name = "Nouveau titre";
	}

	public Title(int position, int level) {
		super(position);
		this.level = level;
		this.name = "Nouveau titre";
	}

}
