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
			DisplayNoteView ds=new DisplayNoteView();
		}
		

//	public static void main(String[] args) {
//		//DisplayNoteView ds=new DisplayNoteView();
//		new PriseNoteView().setVisible(true);
////		TextEditor etunote = new TextEditor();
////		Semester sem1 = new Semester("P11");
////		Uv uv1 = new Uv("NF28", sem1);
////		Note note1 = new Note("Cours 1", uv1);
//////		
//////		try {
//////			System.out.println(note1.getHTML());
//////		} catch (BadLocationException e) {
//////			// TODO Auto-generated catch block
//////			e.printStackTrace();
//////		}
////		
//////		Title t = new Title(1);
////		Title t2 = new Title(2, 2);
////		Paragraph p = new Paragraph(2);
////		p.addClass("class1");
////		p.addClass("class2");
////		p.addClass("class3");
//////		note1.addContent(t);
////		note1.addContent(p);
////		note1.addContent(t2);
////		System.out.println(note1.getHTML());
//
//	}

}
