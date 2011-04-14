package etunote;

import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.html.HTML;

public final class Editor {
	
	
	public static void setTitle(JTextPane viewer, int level){
		HTML.Tag htmlTag;
		
		switch (level) {
			case 1 : htmlTag = HTML.Tag.H1;break;
			case 2 : htmlTag = HTML.Tag.H2;break;
			case 3 : htmlTag = HTML.Tag.H3;break;
			case 4 : htmlTag = HTML.Tag.H4;break;
			case 5 : htmlTag = HTML.Tag.H5;break;
			case 6 : htmlTag = HTML.Tag.H6;break;
			default: htmlTag = HTML.Tag.H1;
		}
		
		Hashtable htmlAttribs = new Hashtable();
		String selText = viewer.getSelectedText();
		int selStart = viewer.getSelectionStart();
		int textLength = selText.length();
		String myAnchor = "";
		viewer.select(selStart, selStart + textLength);
		SimpleAttributeSet sasTag = new SimpleAttributeSet();
		SimpleAttributeSet sasAttr = new SimpleAttributeSet();
		//String newAnchor = "http://www.bsf-qc.com";
		//htmlAttribs.put("href",newAnchor);
		Enumeration attribEntries = htmlAttribs.keys();
		while (attribEntries.hasMoreElements())
		{
			Object entryKey = attribEntries.nextElement();
			Object entryValue = htmlAttribs.get(entryKey);
			sasAttr.addAttribute(entryKey,entryValue);
			htmlAttribs.remove(entryKey);
		}
		sasTag.addAttribute(htmlTag,sasAttr);
		viewer.setCharacterAttributes(sasTag,false);
		viewer.setText(viewer.getText());
		viewer.select(selStart, selStart + textLength);
	}
}
