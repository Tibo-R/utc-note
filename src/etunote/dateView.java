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

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Group;

public class dateView extends javax.swing.JPanel {
	
	// Variables declaration
	private Application app;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel notesPanel;
    // End of variables declaration

    public dateView(Application app) {
    	this.app = app;
        initComponents();
    }
    
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        notesPanel =  new javax.swing.JPanel();
        jTabbedPane1.addTab("NOTES", jScrollPane1);

        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(notesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(notesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                .addContainerGap())
        );

        notesPanel = updateAppContent();
    }

    public Application getApp() {
		return app;
	}

	public void setApp(Application app) {
		this.app = app;
	}

    public JPanel updateAppContent(){
    	notesPanel.removeAll();
    	GroupLayout notesPanelLayout;
    	notesPanelLayout=new javax.swing.GroupLayout(notesPanel);
        //javax.swing.GroupLayout notePanelLayout = new javax.swing.GroupLayout(notePanel);
    	notesPanel.setLayout(notesPanelLayout);
    	notesPanelLayout.setAutoCreateGaps(true);

        
    	Group parallelGroup = notesPanelLayout.createSequentialGroup();
        Group verticalGroup = notesPanelLayout.createParallelGroup();
        
        for (final Note note : this.app.getAllNotesByDate()){
            
    		JButton noteButton = new JButton(note.getName());
    		noteButton.setBackground(note.getUvs().get(0).getColorCode());
    		noteButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    
                	showNote(note);
                }
            });
    		parallelGroup.addGroup(notesPanelLayout.createParallelGroup()
            	.addGap(10, 10, 10)
            	.addComponent(noteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE)
            	.addGap(10, 10, 10));
            	
      	
    		verticalGroup.addGroup(notesPanelLayout.createParallelGroup()
            	.addGap(20, 20, 20)
            	.addComponent(noteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE));
        }
        	
        	
        notesPanelLayout.setHorizontalGroup(parallelGroup);
        notesPanelLayout.setVerticalGroup(verticalGroup);
        
    	
		return notesPanel;
    	
    }

	protected void showNote(Note note) {
		System.out.print("\n Pour Note \n");

		PriseNoteView pn = new PriseNoteView(note);
		pn.setVisible(true);
		notesPanel.removeAll();
		GroupLayout panLayout=new javax.swing.GroupLayout(notesPanel);
		notesPanel.setLayout(panLayout);
		panLayout.setAutoCreateGaps(true);
		
		Group parallelGroup = panLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING);
        Group verticalGroup = panLayout.createSequentialGroup();
        
        parallelGroup.addGroup(panLayout.createSequentialGroup()

            	.addComponent(pn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE));
        
        verticalGroup.addGroup(panLayout.createParallelGroup()

            	.addComponent(pn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE));            	      
        
        panLayout.setHorizontalGroup(parallelGroup);
        panLayout.setVerticalGroup(verticalGroup);
	
	}
}
