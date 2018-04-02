
public class Song {
	
	String name;
	String artist;
	int length;
	
	public Song(String name, String artist, int length) {
		this.name = name;
		this.artist = artist;
		this.length = length;
	}
	
	@Override
	public boolean equals(Object obj) {
		Song other = (Song) obj;
		if (name.equals(other.name) && artist.equals(other.artist) && length == other.length) {
			return true;
		}
		return false;
	}
}
