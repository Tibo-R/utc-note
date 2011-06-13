/******************************************************************************************************
 * EtuNote Copyright (c) 2011 , Nicolas Mardesson, Mohamed Mbaye, Thibault Roucou All rights reserved.
 *  
 *   This program is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 *********************************************************************************************************/

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
