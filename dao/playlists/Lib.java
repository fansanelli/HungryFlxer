package dao.playlists;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Lib {
	String m;

	public String getM() {
		return m;
	}

	@XmlAttribute
	public void setM(String m) {
		this.m = m;
	}
}
