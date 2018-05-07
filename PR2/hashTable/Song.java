package hashTable;

public class Song {
	private String songName;
	private String albumName;
	private String artists;

	public Song(String songName, String albumName, String artists) {
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

	public String getArtists() {
		return artists;
	}

	@Override
	public int hashCode(){
		return new StringElement(songName).hashCode();
	}
	
	@Override
	public String toString() {
		return (this.songName + ", " + this.albumName + ", " + this.artists);
	}

	public int compareTo(Song o) {
		return this.songName.compareTo(o.getSongName());
	}

	@Override
	public boolean equals(Object o) {
		Song song = (Song) o;
		boolean equals = true;
		if (songName != song.getSongName())
			equals = false;
		if (albumName != song.getAlbumName())
			equals = false;
		if (artists != song.getArtists())
			equals = false;
		return equals;
	}
}
