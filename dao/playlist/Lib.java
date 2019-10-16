package dao.playlist;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Lib {
	Playlist playlist;

	public Playlist getPlaylist() {
		return playlist;
	}

	@XmlElement
	public void setPlaylist(Playlist playlist) {
		this.playlist = playlist;
	}
}
