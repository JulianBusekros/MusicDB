import java.util.List;

public class Main {

    public static void main(String[] args) {
	    Data data = new Data();
        data.openConnection();

        List<Artist> artists = data.queryArtists();
        if(artists == null){
            System.out.println("No artists");
            return;
        }

        for(Artist artist : artists){
            System.out.println(artist.getId() + " | " + artist.getName());
        }

        List<Song> songs = data.querySongs();
        if(songs == null){
            System.out.println("No songs");
            return;
        }

        for(Song song : songs){
            System.out.println(song.getId() + " | " + song.getTitle());
        }

        List<Albums> albums = data.queryAlbums();
        if(albums == null){
            System.out.println("No albums");
            return;
        }

        for(Albums album : albums){
            System.out.println(album.getId() + " | " + album.getName());
        }

        data.closeConnection();

    }
}
