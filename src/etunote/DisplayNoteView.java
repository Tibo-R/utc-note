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


import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

//import etunote.AddSemesterView;

//import EtuNoteTest.AddSemester;

import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop.Action;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Group;
import javax.swing.JToolBar;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**
 *
 * @author mbayemoh
 */
public class DisplayNoteView extends javax.swing.JFrame {

	JFileChooser fc = new JFileChooser();
	String file;
	JToolBar toolBar=new JToolBar();
	JScrollPane scrollpane=new JScrollPane();
	JButton OpenButton=new JButton();
	JButton SaveButton=new JButton();
	JButton SaveAsButton=new JButton();
	JButton ExportButton=new JButton();
	JButton CutButton=new JButton();
	JButton CopyButton=new JButton();
	JButton PasteButton=new JButton();
	JButton DeleteButton=new JButton();
	JButton UndoButton=new JButton();
	JButton RedoButton=new JButton();
	
	JButton Save=new JButton();
    /** Creates new form DisplayNote */
    public DisplayNoteView(Application app) {
    	this.appModel = app;
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SearchButton = new javax.swing.JButton();
        RechercheField = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        AddSemesterButton = new javax.swing.JButton();
        uvPanel = new javax.swing.JPanel();
        ViewByDate = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        OpenItem = new javax.swing.JMenuItem();
        SaveItem = new javax.swing.JMenuItem();
        SaveAsItem = new javax.swing.JMenuItem();
        QuitItem = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        UndoItem = new javax.swing.JMenuItem();
        RedoItem = new javax.swing.JMenuItem();
        CutItem = new javax.swing.JMenuItem();
        CopyItem = new javax.swing.JMenuItem();
        DeleteItem = new javax.swing.JMenuItem();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        SearchButton.setText("OK");
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });

        RechercheField.setText("Recherche");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("SEMESTRE");

        AddSemesterButton.setFont(new java.awt.Font("Tahoma", 1, 14));
        AddSemesterButton.setForeground(new java.awt.Color(0, 0, 204));
        AddSemesterButton.setText("+");
        AddSemesterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddSemesterButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(AddSemesterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(uvPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 883, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(AddSemesterButton))
                .addGap(18, 18, 18)
                .addComponent(uvPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("NOTES", jPanel1);

        ViewByDate.setForeground(new java.awt.Color(0, 0, 204));
        //ViewByDate.setText("Vue par date");
        ViewByDate.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        //Tools.addIcon(ViewByDate, "Calendar.png");
        ViewByDate.setIcon(new ImageIcon("Date.png"));
        ViewByDate.setOpaque(false);
        ViewByDate.setFocusPainted(false);
        ViewByDate.setBorderPainted(false);
        ViewByDate.setBorder(null);
        ViewByDate.setToolTipText("Vue par date");
        ViewByDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewByDateActionPerformed(evt);
            }
        });
        toolBar.setRollover(true);
        //OpenButton.setText("jButton1");
        OpenButton.setFocusable(false);
        OpenButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        OpenButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        OpenButton.setIcon(new ImageIcon("Open.png"));
        OpenButton.setOpaque(false);
        OpenButton.setFocusPainted(false);
        OpenButton.setBorderPainted(false);
        OpenButton.setBorder(null);
        OpenButton.setToolTipText("Open File");
        toolBar.add(OpenButton);
        
        
        //SaveButton.setText("jButton1");
        SaveButton.setFocusable(false);
        SaveButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        SaveButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        SaveButton.setIcon(new ImageIcon("Save.png"));
        SaveButton.setOpaque(false);
        SaveButton.setFocusPainted(false);
        SaveButton.setBorderPainted(false);
        SaveButton.setBorder(null);
        SaveButton.setToolTipText("Save File");
        toolBar.add(SaveButton);

        
        SaveAsButton.setFocusable(false);
        SaveAsButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        SaveAsButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        SaveAsButton.setIcon(new ImageIcon("SaveAs.png"));
        SaveAsButton.setOpaque(false);
        SaveAsButton.setFocusPainted(false);
        SaveAsButton.setBorderPainted(false);
        SaveAsButton.setBorder(null);
        SaveAsButton.setToolTipText("Save As File");
        toolBar.add(SaveAsButton);

        
        ExportButton.setFocusable(false);
        ExportButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ExportButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ExportButton.setIcon(new ImageIcon("HTML.png"));
        ExportButton.setOpaque(false);
        ExportButton.setFocusPainted(false);
        ExportButton.setBorderPainted(false);
        ExportButton.setBorder(null);
        ExportButton.setToolTipText("Export to HTML");
        toolBar.add(ExportButton);

        UndoButton.setFocusable(false);
        UndoButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        UndoButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        UndoButton.setIcon(new ImageIcon("Undo.png"));
        UndoButton.setOpaque(false);
        UndoButton.setFocusPainted(false);
        UndoButton.setBorderPainted(false);
        UndoButton.setBorder(null);
        UndoButton.setToolTipText("Undo");
        UndoButton.setEnabled(false);
        toolBar.add(UndoButton);
        
        RedoButton.setFocusable(false);
        RedoButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        RedoButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        RedoButton.setIcon(new ImageIcon("Redo.png"));
        RedoButton.setOpaque(false);
        RedoButton.setFocusPainted(false);
        RedoButton.setBorderPainted(false);
        RedoButton.setBorder(null);
        RedoButton.setToolTipText("Redo");
        RedoButton.setEnabled(false);
        toolBar.add(RedoButton);
        
        CopyButton.setFocusable(false);
        CopyButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        CopyButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        CopyButton.setIcon(new ImageIcon("Copy.png"));
        CopyButton.setOpaque(false);
        CopyButton.setFocusPainted(false);
        CopyButton.setBorderPainted(false);
        CopyButton.setBorder(null);
        CopyButton.setToolTipText("Copy");
        toolBar.add(CopyButton);
        
        PasteButton.setFocusable(false);
        PasteButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        PasteButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        PasteButton.setIcon(new ImageIcon("Paste.png"));
        PasteButton.setOpaque(false);
        PasteButton.setFocusPainted(false);
        PasteButton.setBorderPainted(false);
        PasteButton.setBorder(null);
        PasteButton.setToolTipText("Paste");
        toolBar.add(PasteButton);

        
        CutButton.setFocusable(false);
        CutButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        CutButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        CutButton.setIcon(new ImageIcon("Cut.png"));
        CutButton.setOpaque(false);
        CutButton.setFocusPainted(false);
        CutButton.setBorderPainted(false);
        CutButton.setBorder(null);
        CutButton.setToolTipText("Cut");
        toolBar.add(CutButton);



        DeleteButton.setFocusable(false);
        DeleteButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        DeleteButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        DeleteButton.setIcon(new ImageIcon("Delete.png"));
        DeleteButton.setOpaque(false);
        DeleteButton.setFocusPainted(false);
        DeleteButton.setBorderPainted(false);
        DeleteButton.setBorder(null);
        DeleteButton.setToolTipText("Trash");
        toolBar.add(DeleteButton);
        
        scrollpane.setViewportView(jPanel1);

        jTabbedPane1.addTab("Liste des UV", scrollpane);
        
        jMenu1.setText("File");

       

        OpenItem.setText("Open");
        OpenItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenItemActionPerformed(evt);
            }
        });
        jMenu1.add(OpenItem);

        SaveItem.setText("Save");
        SaveItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveItemActionPerformed(evt);
            }
        });
        jMenu1.add(SaveItem);

        SaveAsItem.setText("Save as");
        SaveAsItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveAsItemActionPerformed(evt);
            }
        });
        jMenu1.add(SaveAsItem);

        QuitItem.setText("Quit");
        QuitItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitItemActionPerformed(evt);
            }
        });
        jMenu1.add(QuitItem);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        UndoItem.setText("Undo");
        UndoItem.setEnabled(false);
        UndoItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UndoItemActionPerformed(evt);
            }
        });
        jMenu2.add(UndoItem);

        RedoItem.setText("Redo");
        RedoItem.setEnabled(false);
        RedoItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RedoItemActionPerformed(evt);
            }
        });
        jMenu2.add(RedoItem);

        CutItem.setText("Cut");
        CutItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CutItemActionPerformed(evt);
            }
        });
        jMenu2.add(CutItem);

        CopyItem.setText("Copy");
        CopyItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CopyItemActionPerformed(evt);
            }
        });
        jMenu2.add(CopyItem);

        DeleteItem.setText("Delete");
        DeleteItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteItemActionPerformed(evt);
            }
        });
        jMenu2.add(DeleteItem);

        jMenuBar1.add(jMenu2);

        
        
        
       
        
       
        
        setJMenuBar(jMenuBar1);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1014, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ViewByDate, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(RechercheField, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SearchButton))
                    .addComponent(toolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SearchButton)
                            .addComponent(RechercheField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ViewByDate)))
                    .addComponent(toolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 745, Short.MAX_VALUE))
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("NOTE");
        uvPanel = updateAppContent();
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchButtonActionPerformed

    private void AddSemesterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddSemesterButtonActionPerformed
        // TODO add your handling code here:
    	new AddSemesterView(this).setVisible(true);
    	
    }//GEN-LAST:event_AddSemesterButtonActionPerformed
    
    private void AddUvButtonActionPerformed(Semester s) {//GEN-FIRST:event_AddSemesterButtonActionPerformed
        // TODO add your handling code here:
    	new AddUvView(s, this).setVisible(true);
    }//GEN-LAST:event_AddSemesterButtonActionPerformed

    public Application getAppModel() {
		return appModel;
	}

	private void ViewByDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewByDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ViewByDateActionPerformed


    private void OpenItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenItemActionPerformed
        // TODO add your handling code here:
    	fc.setCurrentDirectory(new File("."));
		int returnVal = fc.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			try{
			file = fc.getSelectedFile().getAbsolutePath();
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(this, 
						"Probleme fichier",
						"Erreur",
						JOptionPane.ERROR_MESSAGE);
			}
		}
    }//GEN-LAST:event_OpenItemActionPerformed

    private void SaveItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SaveItemActionPerformed

    private void SaveAsItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveAsItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SaveAsItemActionPerformed

    private void QuitItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuitItemActionPerformed
        // TODO add your handling code here:
    	System.exit(0);
    }//GEN-LAST:event_QuitItemActionPerformed

    private void UndoItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UndoItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UndoItemActionPerformed

    private void RedoItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RedoItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RedoItemActionPerformed

    private void CutItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CutItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CutItemActionPerformed

    private void CopyItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CopyItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CopyItemActionPerformed

    private void DeleteItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DeleteItemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                //new DisplayNoteView().setVisible(true);
            }
        });
    }

    private Application appModel;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddSemesterButton;

    private javax.swing.JMenuItem CopyItem;
    private javax.swing.JMenuItem CutItem;
    private javax.swing.JMenuItem DeleteItem;
    private javax.swing.JMenuItem OpenItem;
    private javax.swing.JScrollPane PanScrollPaneUV;

    private javax.swing.JPanel uvPanel;

    private javax.swing.JMenuItem QuitItem;
    private javax.swing.JTextField RechercheField;
    private javax.swing.JMenuItem RedoItem;
    private javax.swing.JMenuItem SaveAsItem;
    private javax.swing.JMenuItem SaveItem;
    private javax.swing.JButton SearchButton;
    private javax.swing.JMenuItem UndoItem;
    private javax.swing.JButton ViewByDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables



    
    public JPanel updateAppContent(){
    	uvPanel.removeAll();
    	GroupLayout uvPanelLayout;
    	uvPanelLayout=new javax.swing.GroupLayout(uvPanel);
        //javax.swing.GroupLayout notePanelLayout = new javax.swing.GroupLayout(notePanel);
    	uvPanel.setLayout(uvPanelLayout);
    	uvPanelLayout.setAutoCreateGaps(true);

        
    	Group parallelGroup = uvPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING);
        Group verticalGroup = uvPanelLayout.createSequentialGroup();
        
        
        for (final Semester s : this.appModel.getSemesters()){
        	
        	JPanel semesterPan = new JPanel();
        	semesterPan.setName(s.getName());
        	TitledBorder title;
        	title = BorderFactory.createTitledBorder(s.getName());
        	semesterPan.setBorder(title);
        	
        	GroupLayout semPanelLayout;
        	semPanelLayout = new javax.swing.GroupLayout(semesterPan);
        	semesterPan.setLayout(semPanelLayout);
        	semPanelLayout.setAutoCreateGaps(true);
        	
        	Group semParallelGroup = semPanelLayout.createSequentialGroup();
            Group semVerticalGroup = semPanelLayout.createParallelGroup();
            
        	for (final Uv uv : s.getUvs()){
        		JButton uvButton = new JButton(uv.getName());
        		uvButton.setBackground(uv.getColorCode());
        		uvButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    showUv(uv);
                }
            });
        		semParallelGroup.addGroup(semPanelLayout.createParallelGroup()
                	.addGap(10, 10, 10)
                	.addComponent(uvButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE)
                	.addGap(10, 10, 10));
                	
          	
        		semVerticalGroup.addGroup(semPanelLayout.createParallelGroup()
                	.addGap(20, 20, 20)
                	.addComponent(uvButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE));
        	}
        	
        	JButton plusButton = new JButton(" + ");
        	plusButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    AddUvButtonActionPerformed(s);
                }
            });
    		semParallelGroup.addGroup(semPanelLayout.createParallelGroup()
            	.addGap(10, 10, 10)
            	.addComponent(plusButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE)
            	.addGap(10, 10, 10));
            	
      	
    		semVerticalGroup.addGroup(semPanelLayout.createParallelGroup()
            	.addGap(20, 20, 20)
            	.addComponent(plusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE));
        	
        	
        	semPanelLayout.setHorizontalGroup(semParallelGroup);
        	semPanelLayout.setVerticalGroup(semVerticalGroup);
        	
            parallelGroup.addGroup(uvPanelLayout.createSequentialGroup()
                	.addGap(10, 10, 10)
                	.addComponent(semesterPan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE)
                	.addGap(10, 10, 10));
                	
          	
            verticalGroup.addGroup(uvPanelLayout.createSequentialGroup()
                	.addGap(20, 20, 20)
                	.addComponent(semesterPan, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE));
            	
            uvPanel.add(semesterPan);
        }
        
        uvPanelLayout.setHorizontalGroup(parallelGroup);
        uvPanelLayout.setVerticalGroup(verticalGroup);
        
    	
		return uvPanel;
    }
	protected void showUv(Uv uv) {
		this.setVisible(false);
		UvView uvv = new UvView(uv);
		uvv.setVisible(true);
		
	}
    
}
