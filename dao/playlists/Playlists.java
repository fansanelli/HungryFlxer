package dao.playlists;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Playlists {
	String path;
	List<Lib> lib;

	public String getPath() {
		return path;
	}

	@XmlAttribute
	public void setPath(String path) {
		this.path = path;
	}

	public List<Lib> getLib() {
		return lib;
	}

	@XmlElement
	public void setLib(List<Lib> lib) {
		this.lib = lib;
	}
}
