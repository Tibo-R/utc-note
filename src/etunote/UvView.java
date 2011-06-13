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

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Group;
import javax.swing.border.TitledBorder;

public class UvView extends PanelView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3622807719630088056L;
	private MainView mainView;
	private Uv uvModel;
	private javax.swing.JScrollPane scrollPane;

	/** Creates new form UvView */
	public UvView(MainView mainView, Uv uvModel) {
		this.mainView = mainView;
		this.uvModel = uvModel;
		this.setName(this.uvModel.getName());
		initComponents();
	}

	private void initComponents() {

		scrollPane = new javax.swing.JScrollPane();
		scrollPane.setViewportView(this);
		this.updateContent();
	}

	private void showAddNoteDialog() {
		String s = JOptionPane.showInputDialog(this.mainView,
				"Entrez le nom de la note", "Ajouter une note",
				JOptionPane.PLAIN_MESSAGE);

		// If a string was returned, add the semester
		if ((s != null) && (s.length() > 0)) {
			Note note = new Note(s, uvModel);
			updateContent();
			mainView.showNote(note);
		}

	}

	public Uv getUvModel() {
		return uvModel;
	}

	public void setUvModel(Uv uvModel) {
		this.uvModel = uvModel;
	}

	@Override
	public void updateContent() {
		this.removeAll();

		GroupLayout layout;
		layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setAutoCreateGaps(true);

		Group parallelGroup = layout.createSequentialGroup();
		Group verticalGroup = layout.createParallelGroup();
		
		TitledBorder title;
		title = BorderFactory.createTitledBorder(this.uvModel.getName());
		title.setTitleFont(new java.awt.Font("Tahoma", 1, 20));
		this.setBorder(title);

		for (final Note note : this.uvModel.getNotes()) {

			JButton uvButton = new JButton(note.getName());
			uvButton.setBackground(note.getColorCode());
			uvButton.addActionListener(new java.awt.event.ActionListener() {
				@Override
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					mainView.showNote(note);
				}
			});
			parallelGroup.addGroup(layout
					.createSequentialGroup()
					.addGap(10, 10, 10)
					.addComponent(uvButton,
							javax.swing.GroupLayout.DEFAULT_SIZE,
							javax.swing.GroupLayout.DEFAULT_SIZE,
							javax.swing.GroupLayout.DEFAULT_SIZE)
					.addGap(10, 10, 10));

			verticalGroup.addGroup(layout
					.createParallelGroup()
					.addGap(20, 20, 20)
					.addComponent(uvButton,
							javax.swing.GroupLayout.PREFERRED_SIZE, 80,
							javax.swing.GroupLayout.PREFERRED_SIZE));
		}

		JButton plusButton = new JButton();
		Tools.addIcon(plusButton, "add.png");
		plusButton.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				showAddNoteDialog();
			}
		});
		parallelGroup.addGroup(layout
				.createParallelGroup()
				.addGap(10, 10, 10)
				.addComponent(plusButton, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE)
				.addGap(10, 10, 10));

		verticalGroup.addGroup(layout
				.createParallelGroup()
				.addGap(20, 20, 20)
				.addComponent(plusButton,
						javax.swing.GroupLayout.PREFERRED_SIZE, 80,
						javax.swing.GroupLayout.PREFERRED_SIZE));

		layout.setHorizontalGroup(parallelGroup);
		layout.setVerticalGroup(verticalGroup);

	}

}
