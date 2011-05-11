package etunote;

import java.awt.Color;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.TransferHandler;

public class TitleSpecificButton extends JButton  {
	
	DragSource source;
	JButton  TitleButton;
	TransferHandler t;
	
	public  TitleSpecificButton()
	{
		TitleButton = new javax.swing.JButton();
        TitleButton.setFont(new java.awt.Font("Times New Roman", 0, 14));
        TitleButton.setText("+T");
        TitleButton.setBackground(Color.red);
      
        source=new DragSource();
        
        t = new TransferHandler(){
        public Transferable createTransferable(JComponent c){
        	return (Transferable) new TitleSpecificButton();
        	}
         };
        this.setTransferHandler(t);
         
        //source.createDefaultDragGestureRecognizer(this, TitleSpecificButton.ACTION_COPY, this);
        
	};
}
	
	
