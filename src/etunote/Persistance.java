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

	// Début de l'arborescence en créant la racine XML "etunote"
	private Element racine;
	// Création d'un nouveau Document JDOM basé sur la racine "etunote"
	private static org.jdom.Document documentSave;
	private static org.jdom.Document documentLoad;

	public Persistance(){
		racine = new Element("etunote");
		documentSave = new Document(racine);
	}

	public void SaveNote(Note n){
		SaveNote(n, "save");
	}

	public void SaveNote(Note n, String f){
		// Création d'un nouvel Element note que l'on ajoute en tant qu'Element de racine
		Element note = new Element("note");
		racine.addContent(note);		

		// Création d'un nouvel Attribut classe que l'on ajoute à note
		// grâce à la méthode setAttribute
		Attribute name = new Attribute("name", n.getName());
		note.setAttribute(name);

		Attribute id = new Attribute("id", String.valueOf(n.getId()));
		note.setAttribute(id);

		Attribute created_at = new Attribute("created_at", String.valueOf(n.getCreated_at()));
		note.setAttribute(created_at);

		Attribute modified_at = new Attribute("modified_at", String.valueOf(n.getModified_at()));
		note.setAttribute(modified_at);

		// Création des contenus
		// Récupération de la listes contenus + itérateur
		ArrayList contenus = n.getContents() ;
		System.out.println(contenus);
		Iterator iter = contenus.iterator() ;

		// Parcours du contenu de la note
		Element contenu = null;
		while (iter.hasNext()){
			Content c = (Content) iter.next();
			if (c instanceof Title){
				contenu = new Element("title");
				Attribute level = new Attribute("level", String.valueOf(((Title) c).getLevel()));
				contenu.setAttribute(level);
				Attribute position = new Attribute("position", String.valueOf(((Title) c).getPosition()));
				contenu.setAttribute(position);
				contenu.setText(((Title) c).getName());
				note.addContent(contenu);
			}
			else{
				contenu = new Element("paragraph");
				Attribute position = new Attribute("position", String.valueOf(((Paragraph) c).getPosition()));
				contenu.setAttribute(position);
				contenu.setText(((Paragraph) c).getText());
				note.addContent(contenu);
			}
		}

		save(f+".xml");	
	}

	public void SaveListNote(ArrayList<Note> an){
		SaveListNote(an, "save");
	}

	public void SaveListNote(ArrayList<Note> an, String f){

	}

	public void LoadNote(){
		LoadNote("titi");
	}
	
	public void LoadNote(String f){
		//On crée une instance de SAXBuilder
	      SAXBuilder sxb = new SAXBuilder();
	      try {
	         //On crée un nouveau document JDOM avec en argument le fichier XML
	         documentLoad = sxb.build(new File(f+".xml"));
	      }
	      catch(Exception e){}

	      //On initialise un nouvel élément racine avec l'élément racine du document.
	      racine = documentLoad.getRootElement();
	      
	      
	      // On crée une Liste contenant tous les noeuds "note" de l'Element racine
	      List listNotes = racine.getChildren("note");

	      System.out.println("\n\n\nAffichage de");
	      //On crée un Iterator sur notre liste
	      Iterator it = listNotes.iterator();
	      while(it.hasNext()) {
	         //On recrée l'Element courant à chaque tour de boucle afin de
	         //pouvoir utiliser les méthodes propres aux Element comme :
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
			//Remarquez qu'il suffit simplement de créer une instance de FileOutputStream
			//avec en argument le nom du fichier pour effectuer la sérialisation.
			sortie.output(documentSave, new FileOutputStream(fichier));
		}
		catch (java.io.IOException e){}
	}

}
