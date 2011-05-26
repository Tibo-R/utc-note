package etunote;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;



public class Persistance {

	@SuppressWarnings("unused")
	private ArrayList<Note> notes;
	@SuppressWarnings("unused")
	private ArrayList<Semester> semesters;
	
	/* D�but s�rialisation et des�rialisation d'application */

	// S�rialisation

	public void SerialisationApplication(Application a) {
		SerialisationApplication(a, "application");		
	}

	public void SerialisationApplication(Application a, String f) {

		try {
			// Instanciation de la classe XStream
			XStream xstream = new XStream(new DomDriver());
			// Instanciation d'un fichier xml
			File fichier = new File(f+".xml");
			// Instanciation d'un flux de sortie fichier
			FileOutputStream fos = new FileOutputStream(fichier);
			try {
				// S�rialisation de l'objet dans le fichier xml
				xstream.toXML(a, fos);
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
	
	// Des�rialisation	

	public Application DeserialisationApplication(){
		Application app = DeserialisationApplication("application");
		return app;
	}

	public Application DeserialisationApplication(String f){
		Application app = null;
		try {
			XStream xstream = new XStream(new DomDriver());
			FileInputStream fis = new FileInputStream(new File(f+".xml"));
			try {
				// D�s�rialisation du fichier xml
				app = (Application) xstream.fromXML(fis);

			} finally {
				// On s'assure de fermer le flux quoi qu'il arrive
				fis.close();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		// On renvoie l'objet r�g�n�r�
		return app;
	}
	
	
	/* Fin s�rialisation et des�rialisation d'application */

	/*************************************************************************/
	

	/* D�but s�rialisation et des�rialisation de note(s) */

	// S�rialisation

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
				// S�rialisation de l'objet dans le fichier xml
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

	// Des�rialisation	

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
				// D�s�rialisation du fichier xml
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
		// On renvoie l'objet r�g�n�r�
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

	/* Fin s�rialisation et des�rialisation de note(s) */

	/*************************************************************************/

	/* D�but s�rialisation et des�rialisation de semestre(s) */

	// S�rialisation

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

	// Des�rialisation

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

	public void export(Application a) throws IOException{
		System.out.println("Export");
		File fa = new File("Application"); 
		fa.mkdirs();

		if(!a.isEmpty()){
			// Export des semestres
			ArrayList<Semester> listSemester = a.getSemesters();
			Iterator itSemester = listSemester.iterator();
			while (itSemester.hasNext()){
				Semester s = (Semester) itSemester.next();
				File fs = new File("Application/"+s.getName()); 
				fs.mkdirs();
				// Export des Uv
				ArrayList<Uv> listUv = s.getUvs();
				Iterator itUv = listUv.iterator();
				while (itUv.hasNext()){
					Uv u = (Uv) itUv.next();
					File fu = new File("Application/"+s.getName()+"/"+u.getName()); 
					fu.mkdirs();
					// Export des notes
					ArrayList<Note> listNotes = u.getNotes();
					Iterator itNote = listNotes.iterator();
					while (itNote.hasNext()){
						Note n = (Note) itNote.next();
						FileWriter writer = null;
						try{
							writer = new FileWriter("Application/"+s.getName()+"/"+u.getName()+"/"+n.getName()+".html");
							writer.write(n.getHTML());
							System.out.println("Application/"+s.getName()+"/"+u.getName()+"/"+n.getName()+".html");
						}catch(IOException ex){
							ex.printStackTrace();
						}finally{
							if(writer != null){
								writer.close();
							}
						}
					}
				}
			}
		}
		else{
			System.out.println("Else");
			return;
		}
	}
}
