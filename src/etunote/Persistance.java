package etunote;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class Persistance {

	// D�but de l'arborescence en cr�ant la racine XML "etunote"
	private Element racine;
	// Cr�ation d'un nouveau Document JDOM bas� sur la racine "etunote"
	private static org.jdom.Document documentSave;
	private static org.jdom.Document documentLoad;

	public Persistance(){
		racine = new Element("etunote");
		documentSave = new Document(racine);
	}

	public void SaveNote(NoteModel n){
		SaveNote(n, "save");
	}

	public void SaveNote(NoteModel n, String f){
		// Cr�ation d'un nouvel Element note que l'on ajoute en tant qu'Element de racine
		Element note = new Element("note");
		racine.addContent(note);		

		// Cr�ation d'un nouvel Attribut classe que l'on ajoute � note
		// gr�ce � la m�thode setAttribute
		Attribute name = new Attribute("name", n.getName());
		note.setAttribute(name);

		Attribute id = new Attribute("id", String.valueOf(n.getId()));
		note.setAttribute(id);

		Attribute created_at = new Attribute("created_at", String.valueOf(n.getCreated_at()));
		note.setAttribute(created_at);

		Attribute modified_at = new Attribute("modified_at", String.valueOf(n.getModified_at()));
		note.setAttribute(modified_at);

		// Cr�ation des contenus
		// R�cup�ration de la listes contenus + it�rateur
		ArrayList contenus = n.getContents() ;
		System.out.println(contenus);
		Iterator iter = contenus.iterator() ;

		// Parcours du contenu de la note
		Element contenu = null;
		while (iter.hasNext()){
			ContentModel c = (ContentModel) iter.next();
			if (c instanceof TitleModel){
				contenu = new Element("title");
				Attribute level = new Attribute("level", String.valueOf(((TitleModel) c).getLevel()));
				contenu.setAttribute(level);
				Attribute position = new Attribute("position", String.valueOf(((TitleModel) c).getPosition()));
				contenu.setAttribute(position);
				contenu.setText(((TitleModel) c).getName());
				note.addContent(contenu);
			}
			else{
				contenu = new Element("paragraph");
				Attribute position = new Attribute("position", String.valueOf(((ParagraphModel) c).getPosition()));
				contenu.setAttribute(position);
				contenu.setText(((ParagraphModel) c).getText());
				note.addContent(contenu);
			}
		}

		save(f+".xml");	
	}

	public void SaveListNote(ArrayList<NoteModel> an){
		SaveListNote(an, "save");
	}

	public void SaveListNote(ArrayList<NoteModel> an, String f){

	}

	public void LoadNote(){
		LoadNote("titi");
	}
	
	public void LoadNote(String f){
		//On cr�e une instance de SAXBuilder
	      SAXBuilder sxb = new SAXBuilder();
	      try {
	         //On cr�e un nouveau document JDOM avec en argument le fichier XML
	         documentLoad = sxb.build(new File(f+".xml"));
	      }
	      catch(Exception e){}

	      //On initialise un nouvel �l�ment racine avec l'�l�ment racine du document.
	      racine = documentLoad.getRootElement();
	      
	      
	      // On cr�e une Liste contenant tous les noeuds "note" de l'Element racine
	      List listNotes = racine.getChildren("note");

	      System.out.println("\n\n\nAffichage de");
	      //On cr�e un Iterator sur notre liste
	      Iterator it = listNotes.iterator();
	      while(it.hasNext()) {
	         //On recr�e l'Element courant � chaque tour de boucle afin de
	         //pouvoir utiliser les m�thodes propres aux Element comme :
	         //selectionner un noeud fils, modifier du texte, etc...
	         Element courant = (Element)it.next();
	         //On affiche le nom de l'element courant
	         System.out.println(courant.getChild("title").getText());
	      }
	}

	public void LoadListNote(String f){

	}


	static void save(String fichier) {
		try {
			//On utilise ici un affichage classique avec getPrettyFormat()
			XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
			//Remarquez qu'il suffit simplement de cr�er une instance de FileOutputStream
			//avec en argument le nom du fichier pour effectuer la s�rialisation.
			sortie.output(documentSave, new FileOutputStream(fichier));
		}
		catch (java.io.IOException e){}
	}

}
