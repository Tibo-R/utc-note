package etunote;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.Reader;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyledEditorKit;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;

public class Etunote extends JFrame implements ActionListener
{
	//Composant Swing permettant de visualiser un document
	public JTextPane viewer = new JTextPane();
	public JEditorPane sourcePane = new JEditorPane();
	public JPanel panel = new JPanel();
	public HTMLEditorKit k = new HTMLEditorKit();
	public HTMLDocument doc = (HTMLDocument)k.createDefaultDocument();

	public Etunote()
	{
		setTitle("EtuNote");
		init();
		output();
	}

	private void init() {
		//Construction de l'Interface Graphique
		//Panel en haut avec un label et le champ de saisie
		viewer.setContentType("text/html");
		viewer.setEditable (true);
		viewer.setEditorKit(k);
		viewer.setDocument(doc);
		viewer.setText("<p></p>");

		sourcePane.setContentType("text/plain");
		sourcePane.setEditable (false);
		showTree();

		//Zone scrollee au centre avec le document
		JScrollPane scrollPane = new JScrollPane (viewer);
		JScrollPane scrollPane2 = new JScrollPane (sourcePane);
		JPanel panel2 = new JPanel();
		panel2.add(scrollPane, null);
		panel2.add(scrollPane2, null);
		panel2.setSize(200,200);

		//Ajout des composants a la fenetre
		setJMenuBar(createMenuBar());
		panel.add(createToolBar(), BorderLayout.SOUTH);
		getContentPane().add(scrollPane2, BorderLayout.SOUTH);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		getContentPane().add(panel, BorderLayout.NORTH);
		
	}

	public JMenuBar createMenuBar()
	{
		JMenuBar menubar = new JMenuBar();

		JMenu color = new JMenu("Color");
		color.add(new StyledEditorKit.ForegroundAction("Noir", Color.black));
		color.add(new StyledEditorKit.ForegroundAction("Bleu", Color.blue));
		color.add(new StyledEditorKit.ForegroundAction("Rouge", Color.red));
		color.add(new StyledEditorKit.ForegroundAction("Jaune", Color.yellow));
		menubar.add(color);

		return menubar;
	}

	public JToolBar createToolBar()
	{
		JToolBar bar = new JToolBar();
		JButton boldButton = new JButton();
		JButton italicButton = new JButton();
		JButton underlineButton = new JButton();
		JButton colorButton = new JButton();
		JButton cutButton = new JButton();
		JButton copyButton = new JButton();
		JButton pasteButton = new JButton();
		JButton leftButton = new JButton();
		JButton centerButton = new JButton();
		JButton rightButton = new JButton();
		JButton testButton = new JButton();
		JButton linkButton = new JButton();
		JButton imageButton = new JButton();
		JButton h1Button = new JButton();
		JButton h2Button = new JButton();
		JButton h3Button = new JButton();
		JButton h4Button = new JButton();
		JButton h5Button = new JButton();
		JButton h6Button = new JButton();

		Action a = viewer.getActionMap().get("font-bold");
		if (a != null)
		{
			boldButton = bar.add(a);
			boldButton.setText("G");
		}
		a = viewer.getActionMap().get("font-italic");
		if (a != null)
		{
			italicButton = bar.add(a);
			italicButton.setText("I");
		}
		a = viewer.getActionMap().get("font-underline");
		if (a != null)
		{
			underlineButton = bar.add(a);
			underlineButton.setText("S");
		}
		bar.addSeparator();
		a = viewer.getActionMap().get(StyledEditorKit.cutAction);
		if (a != null)
		{
			cutButton = bar.add(a);
			cutButton.setText("X");
		}
		a = viewer.getActionMap().get(StyledEditorKit.copyAction);
		if (a != null)
		{
			copyButton = bar.add(a);
			copyButton.setText("C");
		}
		a = viewer.getActionMap().get(StyledEditorKit.pasteAction);
		if (a != null)
		{
			pasteButton = bar.add(a);
			pasteButton.setText("V");
		}
		bar.addSeparator();
		a = new StyledEditorKit.AlignmentAction("left",0);
		if (a != null)
		{
			leftButton = bar.add(a);
			leftButton.setText("<");
		}
		a = new StyledEditorKit.AlignmentAction("center",1);
		if (a != null)
		{
			centerButton = bar.add(a);
			centerButton.setText("-");
		}
		a = new StyledEditorKit.AlignmentAction("right",2);
		if (a != null)
		{
			rightButton = bar.add(a);
			rightButton.setText(">");
		}
		bar.addSeparator();
		h1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try
				{
					Editor.setTitle(viewer, 1);
				}
				catch (Exception ignoredForNow) {}
			}

		});
		h1Button.setText("T1");
		bar.add(h1Button);
		
		
		h2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try
				{
					Editor.setTitle(viewer, 2);
				}
				catch (Exception ignoredForNow) {}
			}

		});
		h2Button.setText("T2");
		bar.add(h2Button);
		
		h3Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try
				{
					Editor.setTitle(viewer, 3);
				}
				catch (Exception ignoredForNow) {}
			}

		});
		h3Button.setText("T3");
		bar.add(h3Button);
		
		h4Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try
				{
					Editor.setTitle(viewer, 4);
				}
				catch (Exception ignoredForNow) {}
			}

		});
		h4Button.setText("T4");
		bar.add(h4Button);
		
		h5Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try
				{
					Editor.setTitle(viewer, 5);
				}
				catch (Exception ignoredForNow) {}
			}

		});
		h5Button.setText("T5");
		bar.add(h5Button);
		
		h6Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try
				{
					Editor.setTitle(viewer, 6);
				}
				catch (Exception ignoredForNow) {}
			}

		});
		h6Button.setText("T6");
		bar.add(h6Button);

		testButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				showTree();
			}
		});
		bar.add(testButton);
		testButton.setText("Show Tree");

		return bar;
	}

	public void actionPerformed (ActionEvent event)
	{
	}

	public void showTree()
	{
		Reader reader = null;
		char[] chars = getSource();
		reader = new CharArrayReader(chars);
		Document docum = new PlainDocument();
		try
		{
			sourcePane.getEditorKit().read(reader, docum, 0);
		}
		catch (Exception ignoredForNow) {}
		sourcePane.setDocument(docum);
	}

	public char[] getSource()
	{
		CharArrayWriter writer = null;
		writer = new CharArrayWriter();
		try{
			viewer.getEditorKit().write(writer, viewer.getDocument(), 0, viewer.getDocument().getLength());
		}
		catch (Exception ignoredForNow) {}
		return writer.toCharArray();
	}

	public String getTree()
	{
		return sourcePane.getText();
	}
	
	private void output() {
		setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setVisible(true);		
	}

}