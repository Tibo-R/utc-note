package etunote;

import java.io.IOException;
import java.util.ArrayList;

public class Start {

	/**
	 * @param args
	 * @throws IOException
	 */

	public static void main(String[] args) throws IOException {
		// try {
		// // Set System L&F
		// UIManager.setLookAndFeel(
		// UIManager.getSystemLookAndFeelClassName());
		// }
		// catch (UnsupportedLookAndFeelException e) {
		// // handle exception
		// }
		// catch (ClassNotFoundException e) {
		// // handle exception
		// }
		// catch (InstantiationException e) {
		// // handle exception
		// }
		// catch (IllegalAccessException e) {
		// // handle exception
		// }
		init();
	}

	public static void init() throws IOException {

		// Application app = new Application();
		//
		// Semester sem1 = new Semester("P11", app);
		// app.addSemester(sem1);
		// Uv uv1 = new Uv("NF28", sem1, "Vert");
		// Note note = new Note("Cours 1", uv1);
		//
		// Title t2 = new Title(2, 2);
		// Paragraph p = new Paragraph(2);
		// p.addClass("class1");
		// p.addClass("class2");
		// p.addClass("class3");
		// note.addContent(p);
		// note.addContent(t2);
		// System.out.println(note.getHTML());

		//
		// MainView ds=new MainView(app);
		// ds.setVisible(true);
		// MainView ps=new MainView(app);
		// ps.setVisible(true);

		// JFrame main = new JFrame();
		// PriseNoteView ps=new PriseNoteView(note);
		// main.setTitle("Prise de Note");
		// main.setSize(1024, 600);
		// main.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		// main.add(ps);
		// main.setVisible(true);

		// PriseNoteView ds=new PriseNoteView(note);
		Application a = new Application();
		// //
		//
		Semester s1 = new Semester("P10", a);

		Uv u1 = new Uv("NF17", s1);
		Note n1 = new Note("Note 1", u1);
		Note n2 = new Note("Note 2", u1);
		ArrayList<Note> notes1 = new ArrayList<Note>();
		notes1.add(n1);
		notes1.add(n2);
		u1.setNotes(notes1);

		Uv u2 = new Uv("NF16", s1);
		Note n3 = new Note("Note 1", u2);
		Note n4 = new Note("Note 2", u2);
		Note n5 = new Note("Note 3", u2);
		ArrayList<Note> notes2 = new ArrayList<Note>();
		notes2.add(n3);
		notes2.add(n4);
		notes2.add(n5);
		u2.setNotes(notes2);

		Uv u3 = new Uv("SR02", s1);
		Note n6 = new Note("Note 1", u3);
		Note n7 = new Note("Note 2", u3);
		Note n8 = new Note("Note 3", u3);
		ArrayList<Note> notes3 = new ArrayList<Note>();
		notes3.add(n6);
		notes3.add(n7);
		notes3.add(n8);
		u3.setNotes(notes3);

		ArrayList<Uv> uvp10 = new ArrayList<Uv>();
		uvp10.add(u1);
		uvp10.add(u2);
		uvp10.add(u3);
		s1.setUvs(uvp10);

		Semester s2 = new Semester("A10", a);

		Uv u4 = new Uv("NF26", s2);
		Note n9 = new Note("Note 1", u4);
		Note n10 = new Note("Note 2", u4);
		Note n11 = new Note("Note 3", u4);
		ArrayList<Note> notes4 = new ArrayList<Note>();
		notes4.add(n9);
		notes4.add(n10);
		notes4.add(n11);
		u4.setNotes(notes4);

		Uv u5 = new Uv("NF28", s2);
		Note n12 = new Note("Note 1", u5);
		Note n13 = new Note("Note 2", u5);
		Note n14 = new Note("Note 3", u5);
		ArrayList<Note> notes5 = new ArrayList<Note>();
		notes5.add(n12);
		notes5.add(n13);
		notes5.add(n14);
		u5.setNotes(notes5);

		Uv u6 = new Uv("SR03", s2);
		Note n15 = new Note("Note 1", u6);
		Note n16 = new Note("Note 2", u6);
		Note n17 = new Note("Note 3", u6);
		ArrayList<Note> notes6 = new ArrayList<Note>();
		notes6.add(n15);
		notes6.add(n16);
		notes6.add(n17);
		u6.setNotes(notes6);

		ArrayList<Uv> uva10 = new ArrayList<Uv>();
		uva10.add(u4);
		uva10.add(u5);
		uva10.add(u6);
		s2.setUvs(uva10);

		Semester s3 = new Semester("P11", a);

		Uv u7 = new Uv("MP03", s3);
		Note n18 = new Note("Note 1", u7);
		Note n19 = new Note("Note 2", u7);
		Note n20 = new Note("Note 3", u7);
		ArrayList<Note> notes7 = new ArrayList<Note>();
		notes7.add(n18);
		notes7.add(n19);
		notes7.add(n20);
		u7.setNotes(notes7);

		Uv u8 = new Uv("SR04", s3);
		Note n21 = new Note("Note 1", u8);
		Note n22 = new Note("Note 2", u8);
		Note n23 = new Note("Note 3", u8);
		ArrayList<Note> notes8 = new ArrayList<Note>();
		notes8.add(n21);
		notes8.add(n22);
		notes8.add(n23);
		u8.setNotes(notes8);

		Uv u9 = new Uv("RO06", s3);
		Note n24 = new Note("Note 1", u9);
		Note n25 = new Note("Note 2", u9);
		Note n26 = new Note("Note 3", u9);
		ArrayList<Note> notes9 = new ArrayList<Note>();
		notes9.add(n24);
		notes9.add(n25);
		notes9.add(n26);
		u9.setNotes(notes9);

		ArrayList<Uv> uvp11 = new ArrayList<Uv>();
		uvp11.add(u7);
		uvp11.add(u8);
		uvp11.add(u9);
		s3.setUvs(uvp11);

		a.addSemester(s1);
		a.addSemester(s2);
		a.addSemester(s3);

		Persistance pe = new Persistance();
		pe.SerialisationApplication(a);
		pe.export(a);

		// PriseNoteView Notev=new PriseNoteView(note);
		// Notev.setVisible(true);
		MainView fr = new MainView(a);
		fr.setVisible(true);
	}

}
