
public class Sorter {
	
	public static void main(String[] args) {
		
		//Setup playlists and songs for testing
		
		Playlist playlist1 = new Playlist();
		Playlist playlist2 = new Playlist();
		
		Song song1 = new Song("Light My Fire", "The Doors", 10);
		Song song2 = new Song("Black Dog", "Led Zeppelin", 10);
		Song song3 = new Song("Hey Jude", "The Beetles", 10);
		Song song4 = new Song("Black Dog", "Led Zeppelin", 10);
		Song song5 = new Song("Hey Jude", "The Beetles", 20);
		
		
		
		
		//Test 1. We check if song2 matches with song4 since the metadata matches
		
		playlist1.addSong(song2);
		
		playlist2.addSong(song4);
		
		System.out.println(playlist1.matches(playlist2));
		
		//Test 1 passes. Resetting.
		
		playlist1.clear();
		playlist2.clear();
		System.out.println("------------------------------------------------");
		System.out.println("\n");
		
		
		
		
		//Test 2. We check if song2 and song4 will avoid adding duplicates to the matched playlist
		
		playlist1.addSong(song2);
		playlist1.addSong(song4);
		
		playlist2.addSong(song2);
		playlist2.addSong(song4);
		
		System.out.println(playlist1.matches(playlist2));
		
		//Test 2 passes. Resetting.
		
		playlist1.clear();
		playlist2.clear();
		System.out.println("------------------------------------------------");
		System.out.println("\n");
		
		
		
		
		//Test 3. General matching test with songs 1, 2, and 3.
		
		playlist1.addSong(song1);
		playlist1.addSong(song2);
		playlist1.addSong(song3);
		
		playlist2.addSong(song1);
		playlist2.addSong(song2);
		
		System.out.println(playlist1.matches(playlist2));
		
		//Test 3 passes. Resetting.
		
		playlist1.clear();
		playlist2.clear();
		System.out.println("------------------------------------------------");
		System.out.println("\n");

		
		
		
		//Test 4. Song duration check for remix song detection with songs 3 and 5.
		
		playlist1.addSong(song3);
		
		playlist2.addSong(song5);
		
		System.out.println(playlist1.matches(playlist2));
		
		//Test 4 passes. Resetting.
		
		playlist1.clear();
		playlist2.clear();
		System.out.println("------------------------------------------------");
		System.out.println("\n");

		
		
		
		//Test 5. Duplicate playlists with duplicate songs test.
		
		playlist1.addSong(song1);
		playlist1.addSong(song2);
		playlist1.addSong(song3);
		playlist1.addSong(song4);
		playlist1.addSong(song5);
		
		playlist2.addSong(song1);
		playlist2.addSong(song2);
		playlist2.addSong(song3);
		playlist2.addSong(song4);
		playlist2.addSong(song5);
		
		System.out.println(playlist1.matches(playlist2));
		
		//Test 5 passes. Resetting.
		
		playlist1.clear();
		playlist2.clear();
		System.out.println("------------------------------------------------");
		System.out.println("\n");
	}
	
}
