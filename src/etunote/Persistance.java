package etunote;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;



public class Persistance {

	@SuppressWarnings("unused")
	private ArrayList<Note> notes;
	@SuppressWarnings("unused")
	private ArrayList<Semester> semesters;

	/* Début sérialisation et desérialisation de note(s) */

	// Sérialisation

	public void SerialisationNote(Note n) {
		SerialisationNote(n, "note");		
	}

	public void SerialisationNote(Note n, String f) {

		try {
			// Instanciation de la classe XStream
			XStream xstream = new XStream(new DomDriver());
			// Instanciation d'un fichier xml
			File fichier = new File(f+".xml");
			// Instanciation d'un flux de sortie fichier
			FileOutputStream fos = new FileOutputStream(fichier);
			try {
				// SÔøΩrialisation de l'objet dans le fichier xml
				xstream.toXML(n, fos);
			} finally {
				// On s'assure de fermer le flux quoi qu'il arrive
				fos.close();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public void SerialisationNotes(ArrayList<Note> ln) {
		SerialisationNotes(ln, "notes");
	}

	public void SerialisationNotes(ArrayList<Note> ln, String f) {
		try {
			XStream xstream = new XStream(new DomDriver());
			File fichier = new File(f+".xml");
			FileOutputStream fos = new FileOutputStream(fichier);
			try {
				xstream.toXML(ln, fos);
			} finally {
				fos.close();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	// Desérialisation	

	public Note DeserialisationNote(){
		Note note = DeserialisationNote("note");
		return note;
	}

	public Note DeserialisationNote(String f){
		Note note = null;
		try {
			XStream xstream = new XStream(new DomDriver());
			FileInputStream fis = new FileInputStream(new File(f+".xml"));
			try {
				// DÔøΩsÔøΩrialisation du fichier xml
				note = (Note) xstream.fromXML(fis);

			} finally {
				// On s'assure de fermer le flux quoi qu'il arrive
				fis.close();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		// On renvoie l'objet régénéré
		return note;
	}

	public ArrayList<Note> DeserialisationNotes(){
		ArrayList<Note> notes = DeserialisationNotes("notes");
		return notes;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Note> DeserialisationNotes(String f){
		ArrayList<Note> notes = null;
		try {
			XStream xstream = new XStream(new DomDriver());
			FileInputStream fis = new FileInputStream(new File(f+".xml"));
			try {
				notes = (ArrayList<Note>) xstream.fromXML(fis);
			} finally {
				fis.close();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return notes;
	}

	/* Fin sérialisation et desérialisation de note(s) */

	/*************************************************************************/

	/* Début sérialisation et desérialisation de semestre(s) */

	// Sérialisation

	public void SerialisationSemester(Semester s) {
		SerialisationSemester(s, "smester");		
	}

	public void SerialisationSemester(Semester s, String f) {

		try {
			XStream xstream = new XStream(new DomDriver());
			File fichier = new File(f+".xml");
			FileOutputStream fos = new FileOutputStream(fichier);
			try {
				xstream.toXML(s, fos);
			} finally {
				fos.close();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public void SerialisationSemesters(ArrayList<Note> ls) {
		SerialisationSemesters(ls, "smester");		
	}

	public void SerialisationSemesters(ArrayList<Note> ls, String f) {

		try {
			XStream xstream = new XStream(new DomDriver());
			File fichier = new File(f+".xml");
			FileOutputStream fos = new FileOutputStream(fichier);
			try {
				xstream.toXML(ls, fos);
			} finally {
				fos.close();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	// Desérialisation

	public Semester DeserialisationSemester(){
		Semester semester = DeserialisationSemester("semester");
		return semester;
	}

	public Semester DeserialisationSemester(String f){
		Semester semester = null;
		try {
			XStream xstream = new XStream(new DomDriver());
			FileInputStream fis = new FileInputStream(new File(f+".xml"));
			try {
				semester = (Semester) xstream.fromXML(fis);
			} finally {
				fis.close();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return semester;
	}

	public ArrayList<Semester> DeserialisationSemesters(){
		ArrayList<Semester> semesters = DeserialisationSemesters("semester");
		return semesters;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Semester> DeserialisationSemesters(String f){
		ArrayList<Semester> semesters = null;
		try {
			XStream xstream = new XStream(new DomDriver());
			FileInputStream fis = new FileInputStream(new File(f+".xml"));
			try {
				semesters = (ArrayList<Semester>) xstream.fromXML(fis);
			} finally {
				fis.close();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		return semesters;
	}
}
