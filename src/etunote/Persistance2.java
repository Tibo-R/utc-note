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
	
	private ArrayList<NoteModel> notes;

	public void SerialisationNote(NoteModel n) {
		SerialisationNote(n, "note");		
	}

	public void SerialisationNote(NoteModel n, String f) {

		try {
			// Instanciation de la classe XStream
			XStream xstream = new XStream(new DomDriver());
			// Instanciation d'un fichier c:/temp/article.xml
			File fichier = new File(f+".xml");
			// Instanciation d'un flux de sortie fichier
			FileOutputStream fos = new FileOutputStream(fichier);
			try {
				// S�rialisation de l'objet article dans article.xml
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
	
	public void SerialisationNotes(ArrayList<NoteModel> ln) {
		SerialisationNotes(ln, "notes");
	}

	public void SerialisationNotes(ArrayList<NoteModel> ln, String f) {
		try {
			// Instanciation de la classe XStream
			XStream xstream = new XStream(new DomDriver());
			// Instanciation d'un fichier c:/temp/article.xml
			File fichier = new File(f+".xml");
			// Instanciation d'un flux de sortie fichier
			FileOutputStream fos = new FileOutputStream(fichier);
			try {
				// S�rialisation de l'objet article dans article.xml
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
	
	public NoteModel DeserialisationNote(){
		NoteModel note = DeserialisationNote("note");
		return note;
	}

	public NoteModel DeserialisationNote(String f){
		NoteModel note = null;
		try {
			XStream xstream = new XStream(new DomDriver());
			FileInputStream fis = new FileInputStream(new File(f+".xml"));
			try {
				// D�s�rialisation du fichier article.xml
				note = (NoteModel) xstream.fromXML(fis);

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
	
	public ArrayList<NoteModel> DeserialisationNotes(){
		ArrayList<NoteModel> notes = DeserialisationNotes("notes");
		return notes;
	}
	
	public ArrayList<NoteModel> DeserialisationNotes(String f){
		ArrayList<NoteModel> notes = null;
		try {
			XStream xstream = new XStream(new DomDriver());
			FileInputStream fis = new FileInputStream(new File(f+".xml"));
			try {
				// D�s�rialisation du fichier article.xml
				notes = (ArrayList<NoteModel>) xstream.fromXML(fis);

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
