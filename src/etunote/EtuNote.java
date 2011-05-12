/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package etunote;

import java.util.ArrayList;

/**
 *
 * @author mbayemoh
 */
public class EtuNote {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//		// TextEditor etunote = new TextEditor();
//		Semester sem1 = new Semester("P11");
//		Semester sem2 = new Semester("P10");
//		
//		Uv uv1 = new Uv("NF28", sem1);
//		Uv uv2 = new Uv("NF26", sem1);
//		Uv uv3 = new Uv("NF28", sem2);
//		
//		Note note1 = new Note("Cours 1", uv2);
//		Note note2 = new Note("Cours 2", uv3);
//		
//		ArrayList<Note> ListNotes = new ArrayList<Note>();
//		ListNotes.add(note1);
//		ListNotes.add(note2);
//		
//		
//		//		
//		// try {
//		// System.out.println(note1.getHTML());
//		// } catch (BadLocationException e) {
//		// TODO Auto-generated catch block
//		// e.printStackTrace();
//		// }
//
//		// Title t = new Title(1);
//		Title t2 = new Title(2, 2);
//		Paragraph p = new Paragraph(2);
//		p.addClass("class1");
//		p.addClass("class2");
//		p.addClass("class3");
//		// note1.addContent(t);
//		note1.addContent(p);
//		note1.addContent(t2);
//		System.out.println(note1.getHTML());
//
//
//
//		/*Persistance per = new Persistance();
//		per.SaveNote(note1, "coucou");
//		Persistance per1 = new Persistance();
//		per1.SaveNote(note1);
//		Persistance per2 = new Persistance();
//		per2.LoadNote("titi");*/
//		
//		
//		
//		Persistance2 pe = new Persistance2();
//		pe.SerialisationNote(note1);
//		
//		Persistance2 pe1 = new Persistance2();
//		pe.SerialisationNotes(ListNotes);
		
		Persistance2 pe = new Persistance2();
		NoteModel note = pe.DeserialisationNote();
		ArrayList<NoteModel> notes = pe.DeserialisationNotes();
		pe.SerialisationNote(note, "tutu");
		pe.SerialisationNotes(notes, "tutus");
    }
}
