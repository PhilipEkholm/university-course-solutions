package laboration13;

public class CD extends Media{
	private String 	artist;
	private String[] songs;
	
	public CD(long id, String title, String artist, String[] songs){
		super(id, title);
		this.artist = artist;
		this.songs = songs;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String[] getSongs() {
		return songs;
	}

	public void setSongs(String[] songs) {
		this.songs = songs;
	}
	
	public String toString(){
		String res = "Artist: " + this.artist + "\n" + "Album: " + this.getTitle() + "\n" + "Melodier: " + "\n";
		for(int i = 0; i < songs.length; i++){
			res += (i + 1) + ". " + this.songs[i] + "\n";
		}
		
		return res;
	}
}
