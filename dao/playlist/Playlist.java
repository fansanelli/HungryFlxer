package dao.playlist;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Playlist {
	String name;
	String path;
	List<Mov> mov;

	public String getName() {
		return name;
	}

	@XmlAttribute
	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	@XmlAttribute
	public void setPath(String path) {
		this.path = path;
	}

	public List<Mov> getMov() {
		return mov;
	}

	@XmlElement
	public void setMov(List<Mov> mov) {
		this.mov = mov;
	}
}
