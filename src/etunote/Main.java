package etunote;

import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class Main {
	public static void main(String[] args) throws IOException {
		// UvView uv = new UvView();

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
		System.out.println(osName);
		System.out.println(path);

	}
}
