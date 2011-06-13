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

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;


public class Note {
	static int current_id = 0;

	private String name;
	private int id;
	private int lastPosition;
	private Date created_at;
	private Date modified_at;
	private String color;

	private ArrayList<Uv> uvs;
	private ArrayList<Tag> tags;
	private ArrayList<Content> contents;

	private int lastTitleLevel;

	/**
	 * @param uv
	 */
	public Note(Uv uv) {
		this.init("Nouvelle Note", uv);
	}

	/**
	 * @param name
	 * @param uv
	 */
	public Note(String name, Uv uv) {
		this.init(name, uv);
	}

	public void init(String name, Uv uv) {
		this.name = name;
		this.uvs = new ArrayList<Uv>();
		this.color = uv.getColor();
		this.contents = new ArrayList<Content>();
		this.uvs.add(uv);
		this.created_at = new Date();
		this.modified_at = new Date();
		this.lastPosition = 1;
		this.setLastTitleLevel(2);
		this.id = Note.current_id;
		Note.current_id++;

		Title t = new Title(0, name);
		this.contents.add(t);

		uv.getNotes().add(this);

	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		/*return "Note [name=" + name + ", created_at=" + created_at + ", uvs="
				+ uvs + ", contents=" + contents + "]";*/
		return name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public Date getModified_at() {
		return modified_at;
	}

	public void setModified_at(Date modified_at) {
		this.modified_at = modified_at;
	}

	public int getId() {
		return this.id;
	}

	public ArrayList<Uv> getUvs() {
		return uvs;
	}

	public ArrayList<Content> getContents() {
		return contents;
	}

	public void addUv(Uv uv) {
		this.uvs.add(uv);
	}

	public static int getCurrent_id() {
		return current_id;
	}

	public static void setCurrent_id(int current_id) {
		Note.current_id = current_id;
	}

	public ArrayList<Tag> getTags() {
		return tags;
	}

	public void setTags(ArrayList<Tag> tags) {
		this.tags = tags;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public void setUvs(ArrayList<Uv> uvs) {
		this.uvs = uvs;
	}

	public void setContents(ArrayList<Content> contents) {
		this.contents = contents;
	}

	public int save() {
		this.modified_at = new Date();
		// Write in XML
		return 1;
	}

	public int delete() {
		// this.setVisible(false);
		return 1;
	}

	public void addContent(Content c) {
		if (c.getPosition() <= contents.size()) {
			for (Content content : contents) {
				int position = content.getPosition();
				if (position <= c.getPosition())
					content.setPosition(position++);
			}
		}
		contents.add(c);
		this.lastPosition++;

		Collections.sort(contents, new Comparator<Content>() {

			@Override
			public int compare(Content c1, Content c2) {
				return c1.compareTo(c2);
			}

		});
	}

	public int getLastPosition() {
		return lastPosition;
	}

	public void setLastPosition(int lastPosition) {
		this.lastPosition = lastPosition;
	}

	public String getHTML() {
		return getHTML(false);
	}

	public String getHTML(boolean viewInApp) {

		String s = "<html>\n<head>\n<title>" + this.name + "</title>\n";

		if (!viewInApp) {
			s += "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n";
			s += "<link rel=\"stylesheet\" media=\"screen\" type=\"text/css\" title=\"Design\" href=\"../../styles/default/style.css\" />\n";
		}

		s += "</head>\n\t<body>\n";

		s += "<div id=\"content\">\n";

		for (Content c : contents) {
			s += c.getHTML() + "\n";
		}

		s += "</div>";
		s += "\n\t</body>\n</html>";
		return s;
	}

	public void setLastTitleLevel(int lastTitleLevel) {
		this.lastTitleLevel = lastTitleLevel;
	}

	public int getLastTitleLevel() {
		return lastTitleLevel;
	}

	public void upLastTitleLevel() {
		this.lastTitleLevel++;
	}

	public void downLastTitleLevel() {
		this.lastTitleLevel--;
	}

	public Color getColorCode() {
		return Tools.getColor(color);
	}
	

}
