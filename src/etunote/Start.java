package etunote;

import javax.swing.text.BadLocationException;

public class Start {

	/**
	 * @param args
	 */

		public static void main(String[] args) {
			init();
		}
		public static void init() {

			
			Application app = new Application();
			
			Semester sem1 = new Semester("P11");
			app.addSemester(sem1);
			Uv uv1 = new Uv("NF28", sem1, "Vert");
			Note note = new Note("Cours 1", uv1);
			
			Title t2 = new Title(2, 2);
			Paragraph p = new Paragraph(2);
			p.addClass("class1");
			p.addClass("class2");
			p.addClass("class3");
			note.addContent(p);
			note.addContent(t2);
//			System.out.println(note.getHTML());
			
			
			DisplayNoteView ds=new DisplayNoteView(app);
			ds.setVisible(true);
//			PriseNoteView ps=new PriseNoteView(note);
//			ps.setVisible(true);
		}

}
