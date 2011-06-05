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

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Group;
import javax.swing.border.TitledBorder;

public class SemesterView extends PanelView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4596446456120603843L;
	private Application appModel;
	private JLabel semesterLabel;
	private JButton AddSemesterButton;
	private MainView mainView;

	/** Creates new form UvView */
	public SemesterView(MainView main, Application app) {
		super();
		this.mainView = main;
		this.appModel = app;
		updateContent();
	}

	@Override
	public void updateContent() {
		this.removeAll();
		semesterLabel = new JLabel();
		semesterLabel.setFont(new java.awt.Font("Tahoma", 1, 20));
		semesterLabel.setText("SEMESTRES");

		AddSemesterButton = new JButton();
		Tools.addIcon(AddSemesterButton, "add.png");
		AddSemesterButton
				.addActionListener(new java.awt.event.ActionListener() {
					@Override
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						showAddSemesterDialog();
					}
				});

		this.add(AddSemesterButton);
		GroupLayout layout;
		layout = new GroupLayout(this);
		// javax.swing.GroupLayout notePanelLayout = new
		// javax.swing.GroupLayout(notePanel);
		this.setLayout(layout);
		layout.setAutoCreateGaps(true);

		Group parallelGroup = layout
				.createParallelGroup(GroupLayout.Alignment.LEADING);
		Group verticalGroup = layout.createSequentialGroup();

		parallelGroup.addGroup(layout
				.createSequentialGroup()
				.addGap(20, 20, 20)
				.addComponent(semesterLabel,
						javax.swing.GroupLayout.DEFAULT_SIZE, 40,
						javax.swing.GroupLayout.DEFAULT_SIZE)
				.addGap(10, 10, 10)
				.addComponent(AddSemesterButton,
						javax.swing.GroupLayout.DEFAULT_SIZE, 40,
						javax.swing.GroupLayout.DEFAULT_SIZE)
				.addGap(10, 10, 10));

		verticalGroup.addGroup(layout
				.createParallelGroup()
				.addGap(20, 20, 20)
				.addComponent(semesterLabel,
						javax.swing.GroupLayout.PREFERRED_SIZE, 40,
						javax.swing.GroupLayout.PREFERRED_SIZE)
				.addGap(20, 20, 20)
				.addComponent(AddSemesterButton,
						javax.swing.GroupLayout.PREFERRED_SIZE, 40,
						javax.swing.GroupLayout.PREFERRED_SIZE));

		for (final Semester s : this.appModel.getSemesters()) {

			JPanel semesterPan = new JPanel();
			semesterPan.setName(s.getName());
			TitledBorder title;
			title = BorderFactory.createTitledBorder(s.getName());
			title.setTitleFont(new java.awt.Font("Tahoma", 1, 18));
			semesterPan.setBorder(title);

			GroupLayout semPanelLayout;
			semPanelLayout = new javax.swing.GroupLayout(semesterPan);
			semesterPan.setLayout(semPanelLayout);
			semPanelLayout.setAutoCreateGaps(true);

			Group semParallelGroup = semPanelLayout.createSequentialGroup();
			Group semVerticalGroup = semPanelLayout.createParallelGroup();

			for (final Uv uv : s.getUvs()) {
				JButton uvButton = new JButton(uv.getName());
				uvButton.setBackground(uv.getColorCode());
				uvButton.addActionListener(new java.awt.event.ActionListener() {
					@Override
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						mainView.showUv(uv);
					}
				});
				semParallelGroup.addGroup(semPanelLayout
						.createParallelGroup()
						.addGap(10, 10, 10)
						.addComponent(uvButton,
								javax.swing.GroupLayout.DEFAULT_SIZE, 80,
								javax.swing.GroupLayout.DEFAULT_SIZE)
						.addGap(10, 10, 10));

				semVerticalGroup.addGroup(semPanelLayout
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
					AddUvButtonActionPerformed(s);
				}
			});
			semParallelGroup.addGroup(semPanelLayout
					.createParallelGroup()
					.addGap(10, 10, 10)
					.addComponent(plusButton,
							javax.swing.GroupLayout.DEFAULT_SIZE, 80,
							javax.swing.GroupLayout.DEFAULT_SIZE)
					.addGap(10, 10, 10));

			semVerticalGroup.addGroup(semPanelLayout
					.createParallelGroup()
					.addGap(20, 20, 20)
					.addComponent(plusButton,
							javax.swing.GroupLayout.PREFERRED_SIZE, 80,
							javax.swing.GroupLayout.PREFERRED_SIZE));

			semPanelLayout.setHorizontalGroup(semParallelGroup);
			semPanelLayout.setVerticalGroup(semVerticalGroup);

			parallelGroup.addGroup(layout
					.createSequentialGroup()
					.addGap(10, 10, 10)
					.addComponent(semesterPan,
							javax.swing.GroupLayout.DEFAULT_SIZE,
							javax.swing.GroupLayout.DEFAULT_SIZE,
							javax.swing.GroupLayout.DEFAULT_SIZE)
					.addGap(10, 10, 10));

			verticalGroup.addGroup(layout
					.createSequentialGroup()
					.addGap(20, 20, 20)
					.addComponent(semesterPan,
							javax.swing.GroupLayout.PREFERRED_SIZE, 150,
							javax.swing.GroupLayout.PREFERRED_SIZE));

			this.add(semesterPan);
		}

		layout.setHorizontalGroup(parallelGroup);
		layout.setVerticalGroup(verticalGroup);

	}

	protected void showAddSemesterDialog() {
		String s = JOptionPane.showInputDialog(this.mainView,
				"Entrez le nom du nouveau semestre", "Ajouter un semestre",
				JOptionPane.PLAIN_MESSAGE);

		// If a string was returned, add the semester
		if ((s != null) && (s.length() > 0)) {
			Semester sem = new Semester(s, appModel);
			appModel.addSemester(sem);
			updateContent();
		}

	}

	private void AddUvButtonActionPerformed(Semester s) {
		new AddUvView(s, mainView).setVisible(true);
		this.updateContent();
	}
}
