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
        System.out.println("==================");
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
        System.out.println("==================");
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
        System.out.println("==================");
        datasource.closeConnection();
    }

    public void printAlbumsForArtist(String artistName){
        datasource.openConnection();
        List<String> albumsForArtist = datasource.queryAlbumsForArtists(artistName);
        if(albumsForArtist == null){
            System.out.println("Artist does not exist");
            return;
        }
        for (String album : albumsForArtist){
            System.out.println(album);
        }
        System.out.println("==================");
        datasource.closeConnection();
    }

    public void printSongsForAlbum(String albumName){
        datasource.openConnection();
        List<String> songsForAlbum = datasource.querySongsForAlbum(albumName);
        if(songsForAlbum == null){
            System.out.println("Album does not exist");
            return;
        }
        for(String song : songsForAlbum){
            System.out.println(song);
        }
        System.out.println("==================");
        datasource.closeConnection();
    }

    public void printAlbumForSong(String songName){
        datasource.openConnection();
        List<String> albumForSong = datasource.queryAlbumForSong(songName);
        if(albumForSong == null){
            System.out.println("Song does not exist");
            return;
        }
        for(String album : albumForSong){
            System.out.println(album);
        }
        System.out.println("==================");
        datasource.closeConnection();
    }

    public void printSongsForArtist(String artistName){
        datasource.openConnection();
        List<String> songsForArtist = datasource.querySongsForArtist(artistName);
        if(songsForArtist == null){
            System.out.println("Song does not exist");
            return;
        }
        for(String songs : songsForArtist){
            System.out.println(songs);
        }
        System.out.println("==================");
        datasource.closeConnection();
    }

    public void printArtistForAlbum(String albumName){
        datasource.openConnection();
        List<String> artistForAlbum = datasource.queryArtistForAlbum(albumName);
        if(artistForAlbum == null){
            System.out.println("Album does not exist");
            return;
        }
        for(String artist : artistForAlbum){
            System.out.println(artist);
        }
        System.out.println("==================");
        datasource.closeConnection();
    }

    public void printArtistsBySearch(String input){
        datasource.openConnection();
        List<ArtistInfos> artists = datasource.queryInfosForArtistsBySearch(input);
        if(artists == null){
            System.out.println("No artists");
            return;
        }

        for(ArtistInfos artist : artists){
            System.out.println(artist.getName() + " | " + artist.getAlbum() + " | " + artist.getSongTitle() + " | " + artist.getTrackNumber());
        }
        System.out.println("==================");
        datasource.closeConnection();
    }
}
