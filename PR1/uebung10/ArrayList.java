package pr1.uebung10;
import static pr.MakeItSimple.*;
import java.util.*;

public class ArrayList implements OrderedList { 
	
	
	private String[] list;

	public ArrayList() {
		list = new String[0];
	}
	
	public void insert(SongImplementation song) {
		String[] newList = new String[list.length + 1];
		if(list.length == 0){
			newList[0] = song.getSongName() + ";" + song.getAlbumName();
			String[] artists = song.getArtists();
			for(int i = 0; i < artists.length; i++){
				newList[0] += ";" + artists[i];
			}
			} else {
			for (int i = 0; i < list.length; i++) {				
				if (list[i].compareTo(song.getSongName()) >= 0) {
					newList[i] = list[i];
				}		


				 else {
					newList[i] = song.getSongName() + ";" + song.getAlbumName() + ";";
					String[] artists = song.getArtists();
					for(int j = 0; j < artists.length; j++){
						newList[i] += ";" + artists[j];
					}

				}
			}
		}
		list = newList;
	}		
	
	
	public int indexOf(String songName) {
		String compare = "";
		for (int i = 0; i < list.length; i++) {
			for (int j = 0; list[i].charAt(j) != ';'; j++) {
				compare += list[i].charAt(j);
			}
			if (compare.equals(songName))
				return i;

		}
		return -1;		
	}

	public void delete(int position) throws PRException {
		String[] newList = new String[list.length - 1];
		if(list[0].equals(null) && position == 0){
			throw new PRException("Liste ist leer");
		}
		else{
		
		if(position >= 0){			
			int newListCounter = 0;
			for(int i = 0; i < list.length -1; i++){
				if(i != position)
				newList[newListCounter] = list[i];
				newListCounter++;
			}
		}	
		else
			throw new PRException("Positionseingabe ist ungültig");
		}
		list = newList;
	}

	public int size() {		
		return list.length;
	}

	public Song get(int position) throws PRException {
		
		if(position >= 0){
			String all = list[position];
			int numberArtists = 0;
			String name = "";
			String album = "";
			String[] artists;
			
			for(int i = 0; i < all.length(); i++){
				if(all.charAt(i) == ';')
					numberArtists++;
			}
			artists = new String[numberArtists -2];
						
			int a = 0;
			while (all.charAt(a) != ';'){
				name += all.charAt(a);
				a++;
			}
			a++;
			while (all.charAt(a) != ';'){
				album += all.charAt(a);
				a++;
			}
			
			int b = 0;
			
			while(a < all.length()){
				artists[0] = "";
				if(all.charAt(a)!= ';')
					artists[b] += all.charAt(a);
				else{
					b++;
					artists[b] = "";
				}
			}		
			return new SongImplementation(name, album, artists);
			
		}else
			throw new PRException("Positionseingabe ist ungültig");
		
	}

}
