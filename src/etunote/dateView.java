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

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Group;
import javax.swing.border.TitledBorder;

public class dateView extends PanelView {

	/**
	 * 
	 */
	private static final long serialVersionUID = -708406665345293557L;
	// Variables declaration
	private Application app;
	private javax.swing.JScrollPane notesScrollPane;

	// End of variables declaration

	public dateView(Application app) {
		super();
		this.app = app;
		initComponents();
	}

	private void initComponents() {

		notesScrollPane = new javax.swing.JScrollPane();
		notesScrollPane.setViewportView(this);
		this.setName("Date");
		this.updateContent();
	}

	public Application getApp() {
		return app;
	}

	public void setApp(Application app) {
		this.app = app;
	}

	@Override
	public void updateContent() {
		this.removeAll();
		BoxLayout notesPanelLayout;
		notesPanelLayout = new BoxLayout(this, BoxLayout.PAGE_AXIS);
		// javax.swing.GroupLayout notePanelLayout = new
		// javax.swing.GroupLayout(notePanel);
		this.setLayout(notesPanelLayout);
		// notesPanelLayout.setAutoCreateGaps(true);

		GridLayout gridLayout = new GridLayout(0, 5, 5, 5);
		gridLayout.setHgap(15);
		gridLayout.setVgap(15);

		JPanel todayPanel = new JPanel();
		TitledBorder title;
		title = BorderFactory.createTitledBorder("Aujourd'hui");
		title.setTitleFont(new java.awt.Font("Tahoma", 1, 18));
		todayPanel.setBorder(title);
		todayPanel.setLayout(gridLayout);
		this.add(todayPanel);
		this.add(Box.createVerticalGlue());

		JPanel weekPanel = new JPanel();
		title = BorderFactory.createTitledBorder("Cette semaine");
		title.setTitleFont(new java.awt.Font("Tahoma", 1, 18));
		weekPanel.setBorder(title);
		weekPanel.setLayout(gridLayout);
		this.add(weekPanel);
		this.add(Box.createVerticalGlue());

		JPanel lastWeekPanel = new JPanel();
		title = BorderFactory.createTitledBorder("La semaine dernière");
		title.setTitleFont(new java.awt.Font("Tahoma", 1, 18));
		lastWeekPanel.setBorder(title);
		lastWeekPanel.setLayout(gridLayout);
		this.add(lastWeekPanel);
		this.add(Box.createVerticalGlue());

		JPanel monthPanel = new JPanel();
		title = BorderFactory.createTitledBorder("Ce mois");
		title.setTitleFont(new java.awt.Font("Tahoma", 1, 18));
		monthPanel.setBorder(title);
		monthPanel.setLayout(gridLayout);
		this.add(monthPanel);
		this.add(Box.createVerticalGlue());

		JPanel oldPanel = new JPanel();
		title = BorderFactory.createTitledBorder("Plus ancien");
		title.setTitleFont(new java.awt.Font("Tahoma", 1, 18));
		oldPanel.setBorder(title);
		oldPanel.setLayout(gridLayout);
		this.add(oldPanel);
		this.add(Box.createVerticalGlue());

		// Group parallelGroup = notesPanelLayout.createSequentialGroup();
		// Group verticalGroup = notesPanelLayout.createParallelGroup();

		for (final Note note : this.app.getAllNotesByDate()) {

			JButton noteButton = new JButton(
					"<html><body style='text-align:center'>" + note.getName()
							+ "<br><div style='font-size:8px;'>" + "("
							+ note.getUvs().get(0).getName()
							+ ")</div></body></html>");
			noteButton.setBackground(note.getUvs().get(0).getColorCode());
			noteButton.setMinimumSize(new Dimension(80, 80));
			noteButton.setPreferredSize(new Dimension(80, 80));
			noteButton.addActionListener(new java.awt.event.ActionListener() {
				@Override
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					showNote(note);
				}
			});

			Calendar cal = Calendar.getInstance();
			int week = cal.get(Calendar.WEEK_OF_YEAR);
			int year = cal.get(Calendar.YEAR);

			cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			Date today = cal.getTime();

			cal.clear();
			cal.setFirstDayOfWeek(Calendar.MONDAY);
			cal.set(Calendar.WEEK_OF_YEAR, week);
			cal.set(Calendar.YEAR, year);
			// cal.add(Calendar.WEEK_OF_MONTH, -1);
			Date thisWeek = cal.getTime();

			cal.add(Calendar.WEEK_OF_YEAR, -1);
			Date lastWeek = cal.getTime();

			cal = Calendar.getInstance();
			cal.add(Calendar.MONTH, -1);
			cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);

			// cal.add(Calendar.WEEK_OF_MONTH, -1);
			Date thisMonth = cal.getTime();

			// System.out.println("aujourd'hui " + today);
			// System.out.println("Début de semaine " + thisWeek);
			// System.out.println("Début de semaine dernière " + lastWeek);
			// System.out.println("Début du mois " + thisMonth);

			if (note.getModified_at().after(today)) {
				todayPanel.add(noteButton);
			} else if (note.getModified_at().after(thisWeek)) {
				weekPanel.add(noteButton);
			} else if (note.getModified_at().after(lastWeek)) {
				lastWeekPanel.add(noteButton);
			} else if (note.getModified_at().after(thisMonth)) {
				monthPanel.add(noteButton);
			} else {
				oldPanel.add(noteButton);
			}

		}

		// notesPanelLayout.setHorizontalGroup(parallelGroup);
		// notesPanelLayout.setVerticalGroup(verticalGroup);
	}

	protected void showNote(Note note) {
		System.out.print("\n Pour Note \n");

		NoteView pn = new NoteView(note);
		pn.setVisible(true);
		this.removeAll();
		GroupLayout panLayout = new javax.swing.GroupLayout(this);
		this.setLayout(panLayout);
		panLayout.setAutoCreateGaps(true);

		Group parallelGroup = panLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING);
		Group verticalGroup = panLayout.createSequentialGroup();

		parallelGroup.addGroup(panLayout.createSequentialGroup()

		.addComponent(pn, javax.swing.GroupLayout.PREFERRED_SIZE,
				javax.swing.GroupLayout.PREFERRED_SIZE,
				javax.swing.GroupLayout.PREFERRED_SIZE));

		verticalGroup.addGroup(panLayout.createParallelGroup()

		.addComponent(pn, javax.swing.GroupLayout.PREFERRED_SIZE,
				javax.swing.GroupLayout.PREFERRED_SIZE,
				javax.swing.GroupLayout.PREFERRED_SIZE));

		panLayout.setHorizontalGroup(parallelGroup);
		panLayout.setVerticalGroup(verticalGroup);

	}
	
}
