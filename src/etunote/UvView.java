/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * UvView.java
 *
 * Created on 17 mai 2011, 16:48:28
 */
package etunote;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
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
	private JLabel uvLabel;

	/** Creates new form UvView */
	public UvView(MainView mainView, Uv uvModel) {
		this.mainView = mainView;
		this.uvModel = uvModel;
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
		title = BorderFactory.createTitledBorder("COURS");
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
