import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Datasource {

    public static final String CONNECTION_STRING = "jdbc:sqlite:/Users/jbusekros/IdeaProjects/demo/MusicDB/music.db";

    private Connection connection;

    public boolean openConnection(){
        try{
            connection = DriverManager.getConnection(CONNECTION_STRING);
            return true;
        } catch (SQLException e){
            System.out.println("Couldn't connect to database: " + e.getMessage());
            return false;
        }
    }

    public void closeConnection(){
        try{
            if(connection != null){
                connection.close();
            }
        } catch (SQLException e){
            System.out.println("Couldn't close connection " + e.getMessage());
        }
    }

    public List<Artist> queryArtists(){
        String sql = "SELECT * FROM artists";

        try(Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(sql)){

            List<Artist> artists = new ArrayList<>();

            while(results.next()){
                Artist artist = new Artist();
                artist.setId(results.getInt("_id"));
                artist.setName(results.getString("name"));
                artists.add(artist);
            }
            return artists;
        } catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Song> querySongs(){
        String sql = "SELECT * FROM songs";

        try(Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(sql)){

            List<Song> songs = new ArrayList<>();

            while(results.next()){
                Song song = new Song();
                song.setId(results.getInt("_id"));
                song.setTitle(results.getString("title"));
                song.setTrack(results.getInt("track"));
                song.setAlbumID(results.getInt("album"));
                songs.add(song);
            }
            return songs;
        } catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Albums> queryAlbums() {
        String sql = "SELECT * FROM albums";

        try (Statement statement = connection.createStatement();
             ResultSet results = statement.executeQuery(sql)) {

            List<Albums> albums = new ArrayList<>();

            while (results.next()) {
                Albums album = new Albums();
                album.setId(results.getInt("_id"));
                album.setName(results.getString("name"));
                album.setArtistID(results.getInt("artist"));
                albums.add(album);
            }
            return albums;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<String> queryAlbumsForArtists(String artistName){
        String sql = "SELECT albums.name FROM albums INNER JOIN artists ON albums.artist = artists._id WHERE artists.name = '" + artistName + "'";

        try (Statement statement = connection.createStatement();
             ResultSet results = statement.executeQuery(sql)){

            List<String> albums = new ArrayList<>();
            while(results.next()){
                albums.add(results.getString(1));
            }

            return albums;
        } catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<String> querySongsForAlbum(String albumName){
        String sql = "SELECT songs.title FROM songs INNER JOIN albums ON songs.album = albums._id WHERE albums.name = '" + albumName + "'";

        try (Statement statement = connection.createStatement();
             ResultSet results = statement.executeQuery(sql)){

            List<String> songs = new ArrayList<>();
            while(results.next()){
                songs.add(results.getString(1));
            }

            return songs;
        } catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
        }

    }
}
