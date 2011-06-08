package etunote;

import java.io.IOException;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Start {

	/**
	 * @param args
	 * @throws IOException
	 */

	public static void main(String[] args) throws IOException {
		
		Application a = new Application();
		Persistance pe = new Persistance();
		a = pe.DeserialisationApplication();
		MainView fr = new MainView(a);
		fr.setVisible(true);
		try {
			   UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			   SwingUtilities.updateComponentTreeUI(fr);
			   //force chaque composant de la fenêtre à appeler sa méthode updateUI
			} catch (InstantiationException e) {
			} catch (ClassNotFoundException e) {
			} catch (UnsupportedLookAndFeelException e) {
			} catch (IllegalAccessException e) {}
			
	}

}