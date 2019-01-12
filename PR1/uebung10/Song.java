package pr1.uebung10;
import java.util.*;

public interface Song { 
	/**
	* Liefert den Namen des Songs
	*/
	String getSongName();
	/**
	* Liefert den Namen des zum Song gehoerigen Albums.
	* Die Methode wird nur zu Testzwecken benoetigt!
	*/
	String getAlbumName();
	/**
	* Liefert ein passend dimensioniertes Array mit einem oder mehreren Kuenstlern/Bands.
	* Die Methode wird nur zu Testzwecken benoetigt!
	*/
	String[] getArtists();
	/**
	* Liefert eine gut lesbare Darstellung der Daten des Songs
	*/
	String toString();
}
