package etunote;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

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
		SerialisationApplication(a, "sauvegarde");
	}

	public void SerialisationApplication(Application a, String f) {
		String path = System.getProperty("user.dir" );
		System.out.println(path);
		File fa = new File(path + "/Sauvegarde");
		fa.mkdirs();

		try {
			// Instanciation de la classe XStream
			XStream xstream = new XStream(new DomDriver());
			// Instanciation d'un fichier xml
			File fichier = new File(path + "/Sauvegarde/" + f + ".xml");
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

	public Application DeserialisationApplication() {
		Application app = DeserialisationApplication("sauvegarde");
		return app;
	}

	public Application DeserialisationApplication(String f) {
		String path = System.getProperty("user.dir" );
		if(new File(path + "/Sauvegarde/" + f + ".xml").exists()){
			Application app = null;
			try {
				XStream xstream = new XStream(new DomDriver());
				FileInputStream fis = new FileInputStream(new File("Sauvegarde/" + f + ".xml"));
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
		else{
			System.out.println("pas de fichier existant");
			return(new Application());
		}
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
			File fichier = new File(f + ".xml");
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
			File fichier = new File(f + ".xml");
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

	public Note DeserialisationNote() {
		Note note = DeserialisationNote("note");
		return note;
	}

	public Note DeserialisationNote(String f) {
		Note note = null;
		try {
			XStream xstream = new XStream(new DomDriver());
			FileInputStream fis = new FileInputStream(new File(f + ".xml"));
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

	public ArrayList<Note> DeserialisationNotes() {
		ArrayList<Note> notes = DeserialisationNotes("notes");
		return notes;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Note> DeserialisationNotes(String f) {
		ArrayList<Note> notes = null;
		try {
			XStream xstream = new XStream(new DomDriver());
			FileInputStream fis = new FileInputStream(new File(f + ".xml"));
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
			File fichier = new File(f + ".xml");
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
			File fichier = new File(f + ".xml");
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

	public Semester DeserialisationSemester() {
		Semester semester = DeserialisationSemester("semester");
		return semester;
	}

	public Semester DeserialisationSemester(String f) {
		Semester semester = null;
		try {
			XStream xstream = new XStream(new DomDriver());
			FileInputStream fis = new FileInputStream(new File(f + ".xml"));
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

	public ArrayList<Semester> DeserialisationSemesters() {
		ArrayList<Semester> semesters = DeserialisationSemesters("semester");
		return semesters;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Semester> DeserialisationSemesters(String f) {
		ArrayList<Semester> semesters = null;
		try {
			XStream xstream = new XStream(new DomDriver());
			FileInputStream fis = new FileInputStream(new File(f + ".xml"));
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

	public void export(Application a) throws IOException {

		String path;
		JFileChooser fr = new javax.swing.JFileChooser();
		FileSystemView fw = fr.getFileSystemView();
		File userDirectory = fw.getDefaultDirectory();

		System.out.println(userDirectory);
		String osName = System.getProperty("os.name").toLowerCase();
		if (osName.startsWith("mac") || osName.startsWith("lin")
				|| osName.startsWith("un")) {
			path = userDirectory.getAbsolutePath() + "/Documents";
		} else {
			path = userDirectory.getAbsolutePath();
		}

		File sourceCSS;
		try {
			sourceCSS = new File(Tools.getPathToCss());
			File destCSS = new File(path + "/EtuNote/styles/default");
			destCSS.mkdirs();

			copyDirectory(sourceCSS, destCSS);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		File fa = new File(path + "/EtuNote");
		fa.mkdirs();

		if (!a.isEmpty()) {
			// Export des semestres
			ArrayList<Semester> listSemester = a.getSemesters();
			Iterator<Semester> itSemester = listSemester.iterator();
			
			String listeUv = "<html>\n<head>\n<title> Liste des UV </title>\n";
			listeUv += "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n";
			listeUv += "</head>\n\t<body>\n";
			listeUv += "<div id=\"content\">\n";
			

			while (itSemester.hasNext()) {
				Semester s = (Semester) itSemester.next();
				listeUv += "<BR><BR>\n" + s.getName()+"\n";
				File fs = new File(path + "/EtuNote/" + s.getName());
				fs.mkdirs();
				// Export des Uv
				ArrayList<Uv> listUv = s.getUvs();
				Iterator<Uv> itUv = listUv.iterator();
				while (itUv.hasNext()) {
					Uv u = (Uv) itUv.next();
					File fu = new File(path + "/EtuNote/" + s.getName() + "/"
							+ u.getName());
					fu.mkdirs();
					listeUv.concat("<BR> <A HREF=\"\n");
					listeUv = listeUv + "<BR> <A HREF=\"" + s.getName() + "/"
					+ u.getName() + "/" + u.getName()
					+ ".html\" target=\"gauche_bas\">" + u.getName()
					+ "</A>\n";
					String listeNote = "Liste des notes de " + u.getName()
					+ "<BR>\n";

					// Export des notes
					ArrayList<Note> listNotes = u.getNotes();
					Iterator<Note> itNote = listNotes.iterator();
					
					listeNote = "<html>\n<head>\n<title> Liste des notes </title>\n";
					listeNote += "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n";
					listeNote += "</head>\n\t<body>\n";
					listeNote += "<div id=\"content\">\n";
					
					while (itNote.hasNext()) {
						Note n = (Note) itNote.next();
						
						listeNote = listeNote + "<BR> <A HREF=\"" + n.getName()
						+ ".html\" target=\"droite\">" + n.getName()
						+ "</A>\n";
						FileWriter writer = null;
						try {
							writer = new FileWriter(path + "/EtuNote/"
									+ s.getName() + "/" + u.getName() + "/"
									+ n.getName() + ".html");
							writer.write(n.getHTML());
							// System.out.println(path+"/EtuNote/"+s.getName()+"/"+u.getName()+"/"+n.getName()+".html");
						} catch (IOException ex) {
							ex.printStackTrace();
						} finally {
							if (writer != null) {
								writer.close();
							}
						}
					}
					

					listeNote += "</div>";
					listeNote += "\n\t</body>\n</html>";

					FileWriter writerListeNote = null;
					try {
						writerListeNote = new FileWriter(path + "/EtuNote/"
								+ s.getName() + "/" + u.getName() + "/"
								+ u.getName() + ".html");
						writerListeNote.write(listeNote);
					} catch (IOException ex) {
						ex.printStackTrace();
					} finally {
						if (writerListeNote != null) {
							writerListeNote.close();
						}
					}

				}
			}


			listeUv += "</div>";
			listeUv += "\n\t</body>\n</html>";
			
			FileWriter writerListeUv = null;
			try {
				writerListeUv = new FileWriter(path + "/EtuNote/uv.html");
				writerListeUv.write(listeUv);
			} catch (IOException ex) {
				ex.printStackTrace();
			} finally {
				if (writerListeUv != null) {
					writerListeUv.close();
				}
			}

			FileWriter writerIndex = null;
			try {
				writerIndex = new FileWriter(path + "/EtuNote/index.html");
				writerIndex
				.write("<FRAMESET COLS=\"12%,88%\"> <FRAMESET ROWS=\"30%, 70%\"> <FRAME SRC=\"uv.html\" NAME=\"gauche_haut\"> <FRAME NAME=\"gauche_bas\"> </FRAMESET> <FRAME NAME=\"droite\"> </FRAMESET> ");
			} catch (IOException ex) {
				ex.printStackTrace();
			} finally {
				if (writerIndex != null) {
					writerIndex.close();
				}
			}

		} else {
			System.out.println("Else");
			return;
		}
	}

	public void export(Application a, String path) throws IOException {
		File fa = new File(path + "/EtuNote");
		fa.mkdirs();

		if (!a.isEmpty()) {
			// Export des semestres
			ArrayList<Semester> listSemester = a.getSemesters();
			Iterator<Semester> itSemester = listSemester.iterator();
			while (itSemester.hasNext()) {
				Semester s = (Semester) itSemester.next();
				File fs = new File(path + "/EtuNote/" + s.getName());
				fs.mkdirs();
				// Export des Uv
				ArrayList<Uv> listUv = s.getUvs();
				Iterator<Uv> itUv = listUv.iterator();
				while (itUv.hasNext()) {
					Uv u = (Uv) itUv.next();
					File fu = new File(path + "/EtuNote/" + s.getName() + "/"
							+ u.getName());
					fu.mkdirs();
					// Export des notes
					ArrayList<Note> listNotes = u.getNotes();
					Iterator<Note> itNote = listNotes.iterator();
					while (itNote.hasNext()) {
						Note n = (Note) itNote.next();
						FileWriter writer = null;
						try {
							writer = new FileWriter(path + "/EtuNote/"
									+ s.getName() + "/" + u.getName() + "/"
									+ n.getName() + ".html");
							writer.write(n.getHTML());
							System.out.println(path + "/EtuNote/" + s.getName()
									+ "/" + u.getName() + "/" + n.getName()
									+ ".html");
						} catch (IOException ex) {
							ex.printStackTrace();
						} finally {
							if (writer != null) {
								writer.close();
							}
						}
					}
				}
			}
		} else {
			System.out.println("Else");
			return;
		}
	}

	public static void copyDirectory(File sourceLocation, File targetLocation)
	throws IOException {

		if (sourceLocation.isDirectory()) {
			if (!targetLocation.exists()) {
				targetLocation.mkdir();
			}

			String[] children = sourceLocation.list();
			for (int i = 0; i < children.length; i++) {
				copyDirectory(new File(sourceLocation, children[i]), new File(
						targetLocation, children[i]));
			}
		} else {
			InputStream in = new FileInputStream(sourceLocation);
			OutputStream out = new FileOutputStream(targetLocation);

			// Copy the bits from instream to outstream
			byte[] buf = new byte[1024];
			int len;
			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}
			in.close();
			out.close();
		}
	}

}