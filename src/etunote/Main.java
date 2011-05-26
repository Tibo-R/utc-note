package etunote;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class Main {
	public static void main(String[] args) throws IOException {
		//UvView uv = new UvView();
		
		JFileChooser fr = new javax.swing.JFileChooser(); 
		FileSystemView fw = fr.getFileSystemView(); 
		File userDirectory = fw.getDefaultDirectory(); 

		System.out.println(userDirectory);
		
		/*Application a = new Application();
		
		File f = new File("sauvegarde.xml");
		if ( f.exists() ) {
			Persistance pe = new Persistance();
			a = pe.DeserialisationApplication();
		}
		DisplayNoteView ds=new DisplayNoteView(a);
		ds.setVisible(true);*/
	}
}
