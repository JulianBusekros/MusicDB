import java.util.ArrayList;
import java.util.List;

public class PrintingDataFromDatasource {

    private final Datasource datasource = new Datasource();

    public void printArtists(){
        datasource.openConnection();
        List<Artist> artists = datasource.queryArtists();
        if(artists == null){
            System.out.println("No artists");
            return;
        }

        for(Artist artist : artists){
            System.out.println(artist.getId() + " | " + artist.getName());
        }
        datasource.closeConnection();
    }

    public void printSongs(){
        datasource.openConnection();
        List<Song> songs = datasource.querySongs();
        if(songs == null){
            System.out.println("No songs");
            return;
        }

        for(Song song : songs){
            System.out.println(song.getId() + " | " + song.getTitle());
        }
        datasource.closeConnection();
    }

    public void printAlbums(){
        datasource.openConnection();
        List<Albums> albums = datasource.queryAlbums();
        if(albums == null){
            System.out.println("No albums");
            return;
        }

        for(Albums album : albums){
            System.out.println(album.getId() + " | " + album.getName());
        }
        datasource.closeConnection();
    }

    public void printAlbumsForArtist(String artistName){
        datasource.openConnection();
        List<String> albumsForArtist = datasource.queryAlbumsForArtists(artistName);
        for (String album : albumsForArtist){
            System.out.println(album);
        }
        datasource.closeConnection();
    }
}
