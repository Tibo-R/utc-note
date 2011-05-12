package etunote;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;



public class Persistance2 {
	
	private ArrayList<Note> notes;

	public void SerialisationNote(Note n) {
		SerialisationNote(n, "note");		
	}

	public void SerialisationNote(Note n, String f) {

		try {
			// Instanciation de la classe XStream
			XStream xstream = new XStream(new DomDriver());
			// Instanciation d'un fichier c:/temp/article.xml
			File fichier = new File(f+".xml");
			// Instanciation d'un flux de sortie fichier
			FileOutputStream fos = new FileOutputStream(fichier);
			try {
				// Sérialisation de l'objet article dans article.xml
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
			// Instanciation de la classe XStream
			XStream xstream = new XStream(new DomDriver());
			// Instanciation d'un fichier c:/temp/article.xml
			File fichier = new File(f+".xml");
			// Instanciation d'un flux de sortie fichier
			FileOutputStream fos = new FileOutputStream(fichier);
			try {
				// Sérialisation de l'objet article dans article.xml
				xstream.toXML(ln, fos);
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
				// Désérialisation du fichier article.xml
				note = (Note) xstream.fromXML(fis);

				// Affichage sur la console du contenu de l'attribut note
				System.out.println(note);

			} finally {
				// On s'assure de fermer le flux quoi qu'il arrive
				fis.close();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return note;
	}
	
	public ArrayList<Note> DeserialisationNotes(){
		ArrayList<Note> notes = DeserialisationNotes("notes");
		return notes;
	}
	
	public ArrayList<Note> DeserialisationNotes(String f){
		ArrayList<Note> notes = null;
		try {
			XStream xstream = new XStream(new DomDriver());
			FileInputStream fis = new FileInputStream(new File(f+".xml"));
			try {
				// Désérialisation du fichier article.xml
				notes = (ArrayList<Note>) xstream.fromXML(fis);

				// Affichage sur la console du contenu de l'attribut note
				//System.out.println(note);

			} finally {
				// On s'assure de fermer le flux quoi qu'il arrive
				fis.close();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		return notes;
	}


}
