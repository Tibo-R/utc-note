package etunote;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DisplayNote.java
 *
 * Created on 5 mai 2011, 15:15:17
 */

//import etunote.AddSemesterView;

//import EtuNoteTest.AddSemester;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class MainView extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -186454403291347632L;

	private Application appModel;

	private javax.swing.JTextField RechercheField;
	private javax.swing.JButton SearchButton;
	private javax.swing.JButton ViewByDate;
	private JButton home;
	private JButton goPrevious;
	private JButton goNext;
	private JButton ExportButton;
	private JButton SaveButton;
	private JPanel mainPane;
	private JToolBar toolBar;
	private PanelView currentPanel;
	private Stack<String> previousPanels;
	private Stack<String> nextPanels;

	private String newPanelName;

	public MainView(Application app) {
		super("EtuNote");
		getContentPane().setBackground(Color.white);
		this.appModel = app;
		initComponents();
		output();
	}

	private void output() {
		setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		setSize(getToolkit().getScreenSize());
		setVisible(true);
	}

	private void initComponents() {

		SearchButton = new javax.swing.JButton();
		RechercheField = new javax.swing.JTextField();
		ViewByDate = new javax.swing.JButton();
		home = new javax.swing.JButton();
		ExportButton = new JButton();
		SaveButton = new JButton();
		mainPane = new JPanel(new CardLayout());
		toolBar = new JToolBar();
		goPrevious = new JButton();
		goNext = new JButton();
		previousPanels = new Stack<String>();
		nextPanels = new Stack<String>();

		Tools.addIcon(SearchButton, "search.png");
		SearchButton.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				SearchButtonActionPerformed(evt);
			}
		});

		RechercheField.setText("Recherche");

		toolBar.setRollover(true);

		Tools.addIcon(ExportButton, "HTML.png");
		ExportButton.setToolTipText("Export to HTML");
		ExportButton.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				Persistance pe = new Persistance();
				try {
					pe.export(appModel);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});


		Tools.addIcon(SaveButton, "Save.png");
		SaveButton.setToolTipText("Save File");
		SaveButton.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				Persistance pe = new Persistance();
				pe.SerialisationApplication(appModel);
			}
		});


		ViewByDate.setToolTipText("Vue par date");
		Tools.addIcon(ViewByDate, "Date.png");
		ViewByDate.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				showViewDate(appModel);
			}
		});

		home.setToolTipText("Accueil");
		Tools.addIcon(home, "go-home.png");
		home.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				showSemester(appModel);
			}
		});

		goPrevious.setToolTipText("Précédent");
		Tools.addIcon(goPrevious, "go-previous.png");
		goPrevious.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				showPreviousPanel();
			}
		});

		goNext.setToolTipText("Suivant");
		Tools.addIcon(goNext, "go-next.png");
		goNext.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				showNextPanel();
			}
		});
		
		this.addWindowListener(new WindowListener(){

			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosing(WindowEvent arg0) {
				String message = "Voulez vous sauvegarder avant de quitter ?";
			    String title = "Sauvegarder ?";
			    // display the JOptionPane showConfirmDialog
			    int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_CANCEL_OPTION);
			    if (reply == JOptionPane.YES_OPTION) {
			    	Persistance pe = new Persistance();
					pe.SerialisationApplication(appModel);
					System.exit(0); 
			    }
			    if (reply == JOptionPane.NO_OPTION) {
					System.exit(0); 
			    }
			    if (reply == JOptionPane.CANCEL_OPTION) {
			    	setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			    }
				
			}

			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});

		toolBar.add(home);
		toolBar.add(goPrevious);
		toolBar.add(goNext);

		toolBar.addSeparator();

		toolBar.add(ViewByDate);
		toolBar.add(SearchButton);

		toolBar.addSeparator();

		toolBar.add(SaveButton);
		toolBar.add(ExportButton);

		RechercheField.setPreferredSize(new Dimension(50, 50));

//		mainPane.getVerticalScrollBar().setUnitIncrement(16);

		getContentPane().setLayout(new BorderLayout());
		this.add(toolBar, BorderLayout.NORTH);
		this.add(mainPane, BorderLayout.CENTER);

		currentPanel = new SemesterView(this, appModel);
		mainPane.add(currentPanel, currentPanel.getName());
		((CardLayout) mainPane.getLayout()).last(mainPane);
//		mainPane.setViewportView(currentPanel);

	}

	private void SearchButtonActionPerformed(ActionEvent evt) {
		// TODO show a new Panel searchView
	}

	public Application getAppModel() {
		return appModel;
	}

	protected void showViewDate(Application app) {
		dateView dv = new dateView(this, app);
		setCurrentPanel(dv);
	}

	protected void showSemester(Application app) {
		SemesterView sv = new SemesterView(this, app);
		setCurrentPanel(sv);
	}

	protected void showUv(Uv uv) {
		UvView uvv = new UvView(this, uv);
		setCurrentPanel(uvv);
	}

	protected void showNote(Note n) {
		NoteView pn = new NoteView(n, this);
		setCurrentPanel(pn);

	}

	private void setCurrentPanel(PanelView newPanel) {
		previousPanels.push(currentPanel.getName());
		String cardName = newPanel.getName();
		currentPanel = newPanel;
		mainPane.add(currentPanel, cardName);
		((CardLayout) mainPane.getLayout()).show(mainPane, cardName);

	}

	protected void showPreviousPanel() {
		if (!previousPanels.isEmpty()) {
			nextPanels.push(currentPanel.getName());
			newPanelName = previousPanels.pop();
//			currentPanel = ((CardLayout) mainPane.getLayout()).;
			for(Component c : mainPane.getComponents()){
				System.out.println(c.getName());
				if(c.getName() == newPanelName){
					currentPanel = (PanelView) c;
				}
			}
			((CardLayout) mainPane.getLayout()).show(mainPane, newPanelName);
		}

	}

	protected void showNextPanel() {
		if (!nextPanels.isEmpty()) {
			previousPanels.push(currentPanel.getName());
			newPanelName = nextPanels.pop();
			for(Component c : mainPane.getComponents()){
				if(c.getName() == newPanelName){
					currentPanel = (PanelView) c;
				}
			}
			((CardLayout) mainPane.getLayout()).show(mainPane, newPanelName);
		}
		

	}

	public void updateContent() {
		currentPanel.updateContent();
	}
}
