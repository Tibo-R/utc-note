package etunote;

public class Start {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TextEditor etunote = new TextEditor();
		Semester sem1 = new Semester("P11");
		Uv uv1 = new Uv("NF28", sem1);
		Note note1 = new Note("Cours 1", uv1);
		System.out.println(note1);

	}

}
