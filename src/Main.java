import java.util.List;

public class Main {

    public static void main(String[] args) {
        PrintingDataFromDatasource printingDataFromDatasource = new PrintingDataFromDatasource();

        printingDataFromDatasource.printArtists();
        printingDataFromDatasource.printAlbums();
        printingDataFromDatasource.printSongs();
        printingDataFromDatasource.printAlbumsForArtist("Pixies");
        printingDataFromDatasource.printSongsForAlbum("Doolittle");
        printingDataFromDatasource.printAlbumForSong("Hey");
        printingDataFromDatasource.printSongsForArtist("Pixies");
        printingDataFromDatasource.printArtistForAlbum("Doolittle");
        printingDataFromDatasource.printArtistsBySearch("Met");

    }
}
