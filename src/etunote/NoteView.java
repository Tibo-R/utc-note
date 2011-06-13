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

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Iterator;

import javax.swing.AbstractAction;
import javax.swing.GroupLayout.Group;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.filechooser.FileSystemView;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.JOptionPane;

public class NoteView extends PanelView implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3521857038694619271L;
	// Variables declaration
	private JButton BlocButton;
	// private JButton CodeButton;
	// private JButton DrawButton;
	private JButton BoldButton;
	private JButton ImageButton;
	private JButton ItalicButton;
	// private JButton ListeButton;
	private JButton ParagraphButton;
	private JButton SoulignButton;
	// private JButton SurlignButton;
	private JButton TitleButton;
	private JPanel notePanel;
	private JScrollPane jTreePane;
	private JScrollPane noteScrollPane;
	private JTabbedPane jTabbedPane1;
	private JTree jTree;
	private DefaultMutableTreeNode racine;
	private DefaultTreeModel model;
	private JComponent lastComponentAdded;
	private JToolBar toolBar;
	private MainView main;

	int numerotationTitle[] = { 0, 0, 0, 0, 0, 0 };
	Note noteModel;
	Application app;
	Persistance pe;
	javax.swing.GroupLayout notePanelLayout;
	JFileChooser fc = new JFileChooser();
	String file;
	private JScrollPane scrollPane;
	private JButton PreviewButton;

	// End of variables declaration

	public NoteView(Note model) {
		super();
		this.noteModel = model;
		initComponents();
	}

	public NoteView(Note model, MainView mv) {
		super();
		this.noteModel = model;
		this.setName(this.noteModel.getName());
		initComponents();
		main=mv;
	}


	private void initComponents() {
		app = noteModel.getUvs().get(0).getSemesters().get(0).getApplication();
		pe = new Persistance();


		racine = new DefaultMutableTreeNode(noteModel.getUvs().get(0));

		Iterator<?> it = noteModel.getUvs().get(0).getNotes().iterator();
		while(it.hasNext()){
			Note n = (Note) it.next();
			DefaultMutableTreeNode dmn = new DefaultMutableTreeNode(n);
			racine.add(dmn);
		}
		scrollPane = new javax.swing.JScrollPane();
		jTreePane = new javax.swing.JScrollPane();
		jTree = new javax.swing.JTree();

		this.model = new DefaultTreeModel(this.racine);
		jTree.setModel(model);


		jTree.addTreeSelectionListener(new TreeSelectionListener(){

			public void valueChanged(TreeSelectionEvent event) {

				if(!(((DefaultMutableTreeNode) jTree.getLastSelectedPathComponent()).getUserObject() instanceof Uv)){	  
					if(jTree.getLastSelectedPathComponent() != null){
						DefaultMutableTreeNode node = (DefaultMutableTreeNode) jTree.getLastSelectedPathComponent();
						Note n = (Note) node.getUserObject();
						//System.out.println(n.getHTML());

						//MainView mw = new MainView(app);
						main.showNote(n); 

					}
				}
				else{
					System.out.println("Cest une uv");
				}

			}
		});



		jTabbedPane1 = new javax.swing.JTabbedPane();
		noteScrollPane = new javax.swing.JScrollPane();
		notePanel = new javax.swing.JPanel();
		BlocButton = new javax.swing.JButton();
		ParagraphButton = new javax.swing.JButton();
		TitleButton = new javax.swing.JButton();
		// CodeButton = new javax.swing.JButton();
		// DrawButton = new javax.swing.JButton();
		BoldButton = new javax.swing.JButton();
		SoulignButton = new javax.swing.JButton();
		ItalicButton = new javax.swing.JButton();
		// SurlignButton = new javax.swing.JButton();
		// ListeButton = new javax.swing.JButton();
		ImageButton = new javax.swing.JButton();
		PreviewButton = new javax.swing.JButton();

		toolBar = new JToolBar(SwingConstants.VERTICAL);
		toolBar.setRollover(true);

		jTreePane.setBackground(new java.awt.Color(0, 102, 102));
		jTreePane.setViewportView(jTree);

		// SHOW THE CONTENT OF THE NOTE
		notePanel = updateNoteContent();

		noteScrollPane.setViewportView(notePanel);
		noteScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );

		jTabbedPane1.addTab("Note de Cours", noteScrollPane);

		AbstractAction addTitle = new AbstractAction() {
			/**
			 * 
			 */
			private static final long serialVersionUID = -874797662980717104L;

			@Override
			public void actionPerformed(ActionEvent e) {
				addTitle();
			}
		};

		AbstractAction addBloc = new AbstractAction() {
			/**
			 * 
			 */
			private static final long serialVersionUID = -5735606433776507318L;

			@Override
			public void actionPerformed(ActionEvent e) {
				addBloc();
			}
		};

		AbstractAction addParagraph = new AbstractAction() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 408468056298302235L;

			@Override
			public void actionPerformed(ActionEvent e) {
				addParagraph();
			}
		};

		AbstractAction addImage = new AbstractAction() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 4103589973893104664L;

			@Override
			public void actionPerformed(ActionEvent e) {
				addImage();
			}
		};

		AbstractAction preview = new AbstractAction() {
			/**
			 * 
			 */
			private static final long serialVersionUID = -5452976028790739147L;

			@Override
			public void actionPerformed(ActionEvent e) {
				preview();
			}
		};

		getActionMap().put("addTitle", addTitle);
		getActionMap().put("addBloc", addBloc);
		getActionMap().put("addParagraph", addParagraph);
		getActionMap().put("addImage", addImage);
		getActionMap().put("preview", preview);

		InputMap[] inputMaps = new InputMap[] {
				getInputMap(JComponent.WHEN_FOCUSED),
				getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT),
				getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW) };
		for (InputMap i : inputMaps) {
			i.put(KeyStroke.getKeyStroke(KeyEvent.VK_T, Toolkit
					.getDefaultToolkit().getMenuShortcutKeyMask()), "addTitle");
			i.put(KeyStroke.getKeyStroke(KeyEvent.VK_B, Toolkit
					.getDefaultToolkit().getMenuShortcutKeyMask()), "addBloc");
			i.put(KeyStroke.getKeyStroke(KeyEvent.VK_P, Toolkit
					.getDefaultToolkit().getMenuShortcutKeyMask()),
			"addParagraph");
			i.put(KeyStroke.getKeyStroke(KeyEvent.VK_I, Toolkit
					.getDefaultToolkit().getMenuShortcutKeyMask()), "addImage");
			i.put(KeyStroke.getKeyStroke(KeyEvent.VK_M, Toolkit
					.getDefaultToolkit().getMenuShortcutKeyMask()), "addImage");
		}

		TitleButton.setToolTipText("Ajouter un titre");
		TitleButton.setIcon(new ImageIcon(Tools.getPathToIcons("title.png")));
		TitleButton.addActionListener(addTitle);

		BlocButton.setToolTipText("Ajouter un bloc de texte spécifique");
		BlocButton.setIcon(new ImageIcon(Tools.getPathToIcons("bloc.png")));
		BlocButton.addActionListener(addBloc);

		ParagraphButton.setToolTipText("Ajouter un paragraphe");
		ParagraphButton.setIcon(new ImageIcon(Tools
				.getPathToIcons("paragraph.png")));
		ParagraphButton.addActionListener(addParagraph);

		ImageButton.setToolTipText("Ajouter une image");
		ImageButton.setIcon(new ImageIcon(Tools.getPathToIcons("image.png")));
		ImageButton.addActionListener(addImage);

		PreviewButton
		.setIcon(new ImageIcon(Tools.getPathToIcons("preview.png")));
		PreviewButton.addActionListener(preview);

		// CodeButton.setText("+C");
		// CodeButton.setBackground(Color.red);
		// CodeButton.addActionListener(new java.awt.event.ActionListener() {
		// public void actionPerformed(java.awt.event.ActionEvent evt) {
		// CodeButtonActionPerformed(evt);
		// }
		// });

		// DrawButton.setText("+D");
		// DrawButton.setBackground(Color.red);
		// DrawButton.addActionListener(new java.awt.event.ActionListener() {
		// public void actionPerformed(java.awt.event.ActionEvent evt) {
		// DrawButtonActionPerformed(evt);
		// }
		// });

		BoldButton.setToolTipText("Mettre en gras");
		BoldButton.setIcon(new ImageIcon(Tools
				.getPathToIcons("format-text-bold.png")));

		SoulignButton.setToolTipText("Souligner");
		SoulignButton.setIcon(new ImageIcon(Tools
				.getPathToIcons("format-text-underline.png")));

		ItalicButton.setToolTipText("Mettre en italique");
		ItalicButton.setIcon(new ImageIcon(Tools
				.getPathToIcons("format-text-italic.png")));

		// SurlignButton.setText("Surlign");
		// SurlignButton.setBackground(Color.gray);
		// SurlignButton.addActionListener(new java.awt.event.ActionListener() {
		// public void actionPerformed(java.awt.event.ActionEvent evt) {
		// SurlignButtonActionPerformed(evt);
		// }
		// });

		// ListeButton.setFont(new java.awt.Font("Times New Roman", 0, 12));
		// ListeButton.setText("Liste");
		// ListeButton.setBackground(Color.gray);
		// ListeButton.addActionListener(new java.awt.event.ActionListener() {
		// public void actionPerformed(java.awt.event.ActionEvent evt) {
		// ListeButtonActionPerformed(evt);
		// }
		// });

		// Show the button of the left toolbar
		toolBar.add(TitleButton);
		toolBar.add(ParagraphButton);
		toolBar.add(BlocButton);
		toolBar.add(ImageButton);

		toolBar.addSeparator();

		toolBar.add(BoldButton);
		toolBar.add(ItalicButton);
		toolBar.add(SoulignButton);

		// toolBar.addSeparator();
		//
		// toolBar.add(PreviewButton);

		scrollPane.setViewportView(this);
		// Set a simple layout
		this.setLayout(new BorderLayout());
		this.add(jTreePane, BorderLayout.WEST);
		this.add(jTabbedPane1, BorderLayout.CENTER);
		this.add(toolBar, BorderLayout.EAST);

	}

	// private void CodeButtonActionPerformed(java.awt.event.ActionEvent evt)
	// {
	// 
	// }
	//
	// private void DrawButtonActionPerformed(java.awt.event.ActionEvent evt)
	// {
	// 
	// }

	// private void SurlignButtonActionPerformed(java.awt.event.ActionEvent evt)
	// {
	// 
	// }
	//
	// private void ListeButtonActionPerformed(java.awt.event.ActionEvent evt)
	// {
	// 
	// }

	private void addTitle() {
		Title title = new Title(this.noteModel.getLastPosition() + 1,
				this.noteModel.getLastTitleLevel());
		this.noteModel.addContent(title);
		notePanel = updateNoteContent();
	}

	private void addParagraph() {
		Paragraph p = new Paragraph(this.noteModel.getLastPosition() + 1);
		this.noteModel.addContent(p);
		notePanel = updateNoteContent();
	}

	private void addBloc() {
		Bloc b = new Bloc(this.noteModel.getLastPosition() + 1, "info");
		this.noteModel.addContent(b);
		notePanel = updateNoteContent();
	}

	private void addImage() {
		FileSystemView fw = fc.getFileSystemView();
		fc.setCurrentDirectory(fw.getDefaultDirectory());
		int returnVal = fc.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			try {
				file = fc.getSelectedFile().getAbsolutePath();
				Image img = new Image(this.noteModel.getLastPosition() + 1,
						file);
				this.noteModel.addContent(img);
				notePanel = updateNoteContent();

			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Probleme fichier",
						"Erreur", JOptionPane.ERROR_MESSAGE);
			}

		}
	}

	private void preview() {
		// System.out.println(noteModel.getHTML());
		// jTabbedPane1.setVisible(false);
		// JEditorPane jEditorPane = new JEditorPane();
		// jEditorPane.setEditable(false);
		// HTMLEditorKit kit = new HTMLEditorKit();
		// StyleSheet styleSheet = kit.getStyleSheet();
		//
		// jEditorPane.setEditorKit(kit);
		// Document doc = kit.createDefaultDocument();
		// jEditorPane.setDocument(doc);
		// jEditorPane.setText(noteModel.getHTML(true));
		// this.add(jEditorPane, BorderLayout.CENTER);
	}

	public JPanel updateNoteContent() {
		try {
			pe.export(app);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		for (int i = 0; i < 6; i++) {
			numerotationTitle[i] = 0;
		}
		notePanel.removeAll();
		notePanelLayout = new javax.swing.GroupLayout(notePanel);
		notePanel.setLayout(notePanelLayout);
//		notePanelLayout.setAutoCreateGaps(true);

		Group parallelGroup = notePanelLayout
		.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING);
		Group verticalGroup = notePanelLayout.createSequentialGroup();

		for (final Content c : this.noteModel.getContents()) {
			if (c instanceof Title) {
				final JTextField f = new JTextField();
				lastComponentAdded = f;
				f.setText(((Title) c).getName());

				f.addKeyListener(new KeyListener() {

					@Override
					public void keyTyped(KeyEvent arg0) {

					}

					@Override
					public void keyReleased(KeyEvent arg0) {
						saveTitle(f, (Title) c);

					}

					@Override
					public void keyPressed(KeyEvent arg0) {

					}
				});
				if (((Title) c).getLevel() == 1) {
					parallelGroup
					.addGroup(notePanelLayout
							.createSequentialGroup()
							.addGap(5, 5, 5)
							.addComponent(
									f,
									javax.swing.GroupLayout.PREFERRED_SIZE,
									600,
									javax.swing.GroupLayout.PREFERRED_SIZE));

					verticalGroup.addGroup(notePanelLayout
							.createParallelGroup()
							.addGap(50, 50, 50)
							.addComponent(f,
									javax.swing.GroupLayout.PREFERRED_SIZE, 29,
									javax.swing.GroupLayout.PREFERRED_SIZE)
							.addGap(50, 50, 50));
				} else {
					JButton levelDown = new JButton();

					Tools.addImageAsButton(levelDown, "go-previous.png");
					levelDown
					.addActionListener(new java.awt.event.ActionListener() {
						@Override
						public void actionPerformed(
								java.awt.event.ActionEvent evt) {
							downTitleLevel((Title) c);

						}
					});

					JButton levelUp = new JButton();
					Tools.addImageAsButton(levelUp, "go-next.png");
					levelUp.addActionListener(new java.awt.event.ActionListener() {
						@Override
						public void actionPerformed(
								java.awt.event.ActionEvent evt) {
							upTitleLevel((Title) c);
						}
					});
					f.setBorder(javax.swing.BorderFactory
							.createLineBorder(new java.awt.Color(0, 0, 0)));
					int level = ((Title) c).getLevel() - 1;
					int indent = level * 20;
					for (int i = level + 1; i < 6; i++) {
						numerotationTitle[i] = 0;
					}
					numerotationTitle[level]++;
					String num = "";
					for (int i = 1; i <= level; i++) {
						num += numerotationTitle[i] + ".";
					}
					JLabel number = new JLabel(num);
					number.setFont(new Font("arial", Font.BOLD, 18));
					parallelGroup
					.addGroup(notePanelLayout
							.createSequentialGroup()
							.addGap(indent, indent, indent)
							.addComponent(levelDown)
							.addComponent(number)
							.addComponent(
									f,
									javax.swing.GroupLayout.PREFERRED_SIZE,
									400,
									javax.swing.GroupLayout.PREFERRED_SIZE)
									.addComponent(levelUp));

					verticalGroup.addGroup(notePanelLayout
							.createParallelGroup()
							.addGap(20, 20, 20)
							.addComponent(levelDown)
							.addComponent(number)
							.addComponent(f,
									javax.swing.GroupLayout.PREFERRED_SIZE, 29,
									javax.swing.GroupLayout.PREFERRED_SIZE)
									.addComponent(levelUp)
									.addGap(20, 20, 20));

					if (level == 1) {
						levelDown.setVisible(false);
					}

					if (level == 5) {
						levelUp.setVisible(false);
					}
				}
			}

			else if (c instanceof Paragraph) {
				HTMLEditorKit editorkit = new HTMLEditorKit();
				final JTextPane textArea = new JTextPane();
				lastComponentAdded = textArea;
				textArea.setContentType("text/html");
				textArea.setEditable(true);
				textArea.setEditorKit(editorkit);
				textArea.setText(((Paragraph) c).getText());
				textArea.addFocusListener(new FocusListener() {

					@Override
					public void focusLost(FocusEvent e) {

					}

					@Override
					public void focusGained(FocusEvent e) {
						setActiveEditor(textArea);

					}
				});
				textArea.addKeyListener(new KeyListener() {

					@Override
					public void keyTyped(KeyEvent arg0) {

					}

					@Override
					public void keyReleased(KeyEvent arg0) {
						saveParagraph(textArea, (Paragraph) c);

					}

					@Override
					public void keyPressed(KeyEvent arg0) {

					}
				});

				if (c instanceof Bloc) {
					textArea.setBackground(((Bloc) c).getColor());
					final JComboBox typeComboBox = new JComboBox();
					typeComboBox.setModel(new javax.swing.DefaultComboBoxModel(
							Bloc.getTypes()));
					typeComboBox.setSelectedItem(((Bloc) c).getType());
					typeComboBox
					.addActionListener(new java.awt.event.ActionListener() {
						@Override
						public void actionPerformed(
								java.awt.event.ActionEvent evt) {
							((Bloc) c).setType((String) typeComboBox
									.getSelectedItem());
							textArea.setBackground(((Bloc) c)
									.getColor());
						}
					});
					parallelGroup.addGroup(notePanelLayout
							.createSequentialGroup()
							.addGap(10, 10, 10)
							.addComponent(typeComboBox,
									javax.swing.GroupLayout.DEFAULT_SIZE,
									200,
									200));

					verticalGroup.addGroup(notePanelLayout
							.createSequentialGroup().addComponent(typeComboBox,
									javax.swing.GroupLayout.PREFERRED_SIZE,
									javax.swing.GroupLayout.PREFERRED_SIZE,
									javax.swing.GroupLayout.PREFERRED_SIZE));

				}
				textArea.setBorder(javax.swing.BorderFactory
						.createLineBorder(new java.awt.Color(0, 0, 0)));
				parallelGroup.addGroup(notePanelLayout
						.createSequentialGroup()
						.addGap(10, 10, 10)
						.addComponent(textArea,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								noteScrollPane.getSize().width,
								javax.swing.GroupLayout.DEFAULT_SIZE)
								.addGap(10, 10, 10));

				verticalGroup.addGroup(notePanelLayout
						.createSequentialGroup()
						.addComponent(textArea,
								javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(20, 20, 20));

			}

			else if (c instanceof Image) {

				JLabel img = new JLabel(((Image) c).getImage());
				parallelGroup.addGroup(notePanelLayout
						.createSequentialGroup()
						.addGap(10, 10, 10)
						.addComponent(img,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE)
								.addGap(10, 10, 10));

				verticalGroup.addGroup(notePanelLayout
						.createSequentialGroup()
						.addGap(20, 20, 20)
						.addComponent(img,
								javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE));

			}
		}

		notePanelLayout.setHorizontalGroup(parallelGroup);
		notePanelLayout.setVerticalGroup(verticalGroup);

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				lastComponentAdded.requestFocus();
			}
		});

		// Scroll to the end of the panel to see the new component
		Rectangle visible = notePanel.getVisibleRect();
		Rectangle bounds = notePanel.getBounds();
		visible.y = bounds.height;
		notePanel.scrollRectToVisible(visible);

		noteScrollPane.getVerticalScrollBar().setUnitIncrement(16);
		return notePanel;

	}

	private void setActiveEditor(JTextPane textArea) {
		Action a = textArea.getActionMap().get("font-bold");
		if (a != null) {
			this.BoldButton.setAction(a);
			BoldButton.setText("");
			BoldButton.setToolTipText("Mettre en gras");
			BoldButton.setIcon(new ImageIcon(Tools
					.getPathToIcons("format-text-bold.png")));
		}

		a = textArea.getActionMap().get("font-italic");
		if (a != null) {
			this.ItalicButton.setAction(a);
			ItalicButton.setText("");
			ItalicButton.setToolTipText("Mettre en italique");
			ItalicButton.setIcon(new ImageIcon(Tools
					.getPathToIcons("format-text-italic.png")));
		}

		a = textArea.getActionMap().get("font-underline");
		if (a != null) {
			this.SoulignButton.setAction(a);
			SoulignButton.setText("");
			SoulignButton.setToolTipText("Souligner");
			SoulignButton.setIcon(new ImageIcon(Tools
					.getPathToIcons("format-text-underline.png")));
		}

	}

	public Note getNoteModel() {
		return noteModel;
	}

	public void setNoteModel(Note noteModel) {
		this.noteModel = noteModel;
	}

	protected void saveParagraph(JTextPane textArea, Paragraph p) {
		String text = textArea.getText().replaceAll("\\<.*head?>", "")
		.replaceAll("\\<.*html?>", "").replaceAll("\\<.*body?>", "");

		p.setText(text);

	}

	protected void saveTitle(JTextField f, Title t) {
		t.setName(f.getText());
	}

	protected void downTitleLevel(Title c) {
		c.levelDown();
		this.noteModel.downLastTitleLevel();
		notePanel = updateNoteContent();

	}

	protected void upTitleLevel(Title c) {
		c.levelUp();
		this.noteModel.upLastTitleLevel();
		notePanel = updateNoteContent();

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

	}

}
