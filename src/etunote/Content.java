/**
 * 
 */
package etunote;

public abstract class Content implements Comparable<Object> {

	private int position;

	public Content(int position) {
		super();
		this.position = position;
	}

	@Override
	public final int compareTo(Object cont) {
		int result = 0;
		if (cont instanceof Content) {
			if (this.position > ((Content) cont).position)
				result = 1;
			if (this.position < ((Content) cont).position)
				result = -1;
		}

		return result;
	}

	public String getHTML() {
		return "";
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

}
