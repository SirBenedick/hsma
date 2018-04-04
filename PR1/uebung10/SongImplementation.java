package pr1.uebung10;
import java.util.*;

public class SongImplementation implements Song, Comparable<Song> {
	private String songName;
	private String albumName;
	private String[] artists;

	public SongImplementation(String songName, String albumName, String[] artists) {
		this.songName = songName;
		this.albumName = albumName;
		this.artists = artists;
	}

	public String getSongName() {
		return songName;
	}

	public String getAlbumName() {
		return albumName;
	}

	@Override
	public String[] getArtists() {
		return artists;
	}

	public String toString() {
		return ("Song: " + this.songName + "Albumname " + this.albumName + "Artists" + this.artists);
	}

	public int compareTo(Song o) {
		return this.songName.compareTo(o.getSongName());
		
	}
}
