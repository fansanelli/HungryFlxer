import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class HungryFlxer {
	public static void main(String[] args) throws Exception {
		if (args.length == 0) {
			System.out.println("missing src parameter");
			System.exit(1);
		}

		String path = args[0];
		if (!new File(path).isDirectory()) {
			System.out.println("src must be a directory");
			System.exit(1);
		}

		List<dao.playlist.Lib> libs = new ArrayList<dao.playlist.Lib>();
		playlistDirectory(libs, path);
		if (libs.size() == 0) {
			System.out.println("no library found");
			System.exit(1);
		}

		dao.playlists.Playlists playlists = new dao.playlists.Playlists();
		playlists.setPath("playlists/");
		for (dao.playlist.Lib lib : libs) {
			File file = new File(lib.getPlaylist().getName() + ".xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(dao.playlist.Lib.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(lib, file);

			dao.playlists.Lib l = new dao.playlists.Lib();
			l.setM(lib.getPlaylist().getName());
			if (playlists.getLib() == null) {
				playlists.setLib(new ArrayList<dao.playlists.Lib>());
			}
			playlists.getLib().add(l);
		}
		File file = new File("playlists.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(dao.playlists.Playlists.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		jaxbMarshaller.marshal(playlists, file);
		System.out.println("done");
	}

	public static void playlistDirectory(List<dao.playlist.Lib> libs, String path) {
		dao.playlist.Playlist playlist = new dao.playlist.Playlist();
		File f = new File(path);
		playlist.setPath(path);
		playlist.setName(f.getName());

		String[] list = f.list();
		for (String item : list) {
			if (new File(path + item).isDirectory()) {
				playlistDirectory(libs, path + item);
			} else {
				dao.playlist.Mov mov = new dao.playlist.Mov();
				mov.setM(item);
				if (playlist.getMov() == null) {
					playlist.setMov(new ArrayList<dao.playlist.Mov>());
				}
				playlist.getMov().add(mov);
			}
 		}
		if (playlist.getMov() != null && playlist.getMov().size() > 0) {
			dao.playlist.Lib lib = new dao.playlist.Lib();
			lib.setPlaylist(playlist);
			libs.add(lib);
		}
	}
}
