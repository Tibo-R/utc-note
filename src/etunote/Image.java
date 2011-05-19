package etunote;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Image extends Content {

	private ImageIcon image;
	private String link;
	
	public Image(int position, String link) {
		super(position);
		this.link = link;
		this.image = new ImageIcon(link);
	}
	
	public String getHTML(){
		String s = "<img src=\"" + this.link + "\" />";
		return s;
	}
	
	public ImageIcon getImage() {
		return image;
	}

	public void setImage(ImageIcon image) {
		this.image = image;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public String toString() {
		return "Image [link=" + link + "]";
	}
	
	
	

}
