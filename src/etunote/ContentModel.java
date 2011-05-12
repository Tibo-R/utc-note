/**
 * 
 */
package etunote;


public abstract class ContentModel implements Comparable{

	private int position;

	public ContentModel(int position) {
		super();
		this.position = position;
	}

	public final int compareTo(Object cont)
	{
		int result = 0;
		if(cont instanceof ContentModel){
			if (this.position > ((ContentModel)cont).position)
				result = 1;
			if (this.position < ((ContentModel)cont).position)
				result = -1;
		}

		return result;
	}

	public String getHTML(){
		return "";
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
	
	


}
