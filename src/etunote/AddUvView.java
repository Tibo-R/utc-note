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


public class AddUvView extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2834862291120741272L;
	
	private MainView parent;
	private Semester semester;
	private javax.swing.JTextField NameCourseField;
	private javax.swing.JButton ValidateCreateUV;
	private javax.swing.JComboBox jComboBox1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;


	public AddUvView(Semester semester, MainView mainView) {
		this.semester = semester;
		this.parent = mainView;
		initComponents();
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

	}

	
	private void initComponents() {
		this.setTitle("Creation UV");
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		NameCourseField = new javax.swing.JTextField();
		jComboBox1 = new javax.swing.JComboBox();
		ValidateCreateUV = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setForeground(new java.awt.Color(0, 0, 153));
		jLabel1.setText("Entrez le nom du cours");

		jLabel2.setForeground(new java.awt.Color(0, 0, 153));
		jLabel2.setText("Choix de la couleur");

		NameCourseField.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				NameCourseFieldActionPerformed(evt);
			}
		});

		jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(Tools
				.getCouleurs()));
		jComboBox1.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jComboBox1ActionPerformed(evt);
			}
		});

		ValidateCreateUV.setText("Valider");
		ValidateCreateUV.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				ValidateCreateUVActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(
														NameCourseField,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														193,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														jLabel1,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														174,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														jLabel2,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														174,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		jComboBox1,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		95,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																		74,
																		Short.MAX_VALUE)
																.addComponent(
																		ValidateCreateUV)))
								.addContainerGap()));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(jLabel1)
								.addGap(18, 18, 18)
								.addComponent(NameCourseField,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										28,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18)
								.addComponent(jLabel2)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(
														jComboBox1,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(ValidateCreateUV))
								.addContainerGap(
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void NameCourseFieldActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void ValidateCreateUVActionPerformed(java.awt.event.ActionEvent evt) {
		String s = NameCourseField.getText();
		if((s != null) && (s.length() > 0))
		{
			new Uv(s, this.semester,
					(String) jComboBox1.getSelectedItem());
			this.parent.updateContent();
			this.setVisible(false);
		}
		
	}

}
