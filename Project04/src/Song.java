/**
 * Class that constructs, accesses, and modifies a Song object, consisting
 * of a title, artist, album, and length.
 * 
 * @author Caren Briones <carenpbriones@gmail.com>
 *
 */
public class Song {
	
	//data members
	/** Title of the Song */
	private String title;
	/** Name of the artist */
	private String artist;
	/** Album title */
	private String album;
	/** Length of the song */
	private String length;
	
	/**
	 * Constructs a Song object with a title, artist, album name, and length
	 * @param t title of song
	 * @param art name of the artist
	 * @param al name of the album
	 * @param leng length of the song
	 */
	public Song(String t, String art, String al, String leng){
		title = t;
		artist = art;
		album = al;
		length = leng;
	}
	
	/**
	 * Returns the title of the song
	 * @return song title
	 */
	public String getTitle(){
		return title;
	}
	
	/**
	 * Returns the name of the artist of the song
	 * @return artist name
	 */
	public String getArtist(){
		return artist;
	}
	
	/**
	 * Returns the name of the album
	 * @return album name
	 */
	public String getAlbum(){
		return album;
	}
	
	/**
	 * Returns the length of the song
	 * @return
	 */
	public String getLength(){
		return length;
	}
	
	/**
	 * Sets the name of the song title
	 * @param s song title to change the name to
	 */
	public void setTitle(String s){
		title = s;
	}
	
	/**
	 * Sets the name of the Artist
	 * @param s name the change the artist to
	 */
	public void setArtist(String s){
		artist = s;
	}
	
	/**
	 * Sets the name of the album
	 * @param s name to change the album to
	 */
	public void setAlbum(String s){
		album = s;
	}
	
	/**
	 * Sets the length of the song
	 * @param s time to change the length to
	 */
	public void setLength(String s){
		length = s;
	}
	
	/**
	 * Uses the String class compareTo() method to return an integer
	 * that indicates whether the compared song is equal to, or
	 * before or after this song
	 * @param s song to compare to
	 * @return integer indicating what order the songs should be in
	 */
	public int compareTo(Song s){
		if (artist.compareTo(s.getArtist()) == 0){
			return 0;
		} else if(artist.compareTo(s.getArtist()) > 0){
			return 1;
		} else{
			return -1;
		}
	}
	
	/**
	 * Converts the Song to a string to be printed out
	 * @return the string equivalent of the song
	 */
	@Override
	public String toString(){
		String s = "Title: " + title + "\n" + "Artist: " + artist +
				"\n" + "Album: " + album + "\n" + "Length: " + length + "\n\n";
		return s;
	}
}