import java.util.List;

public class Main {

    public static void main(String[] args) {
        PrintingDataFromDatasource printingDataFromDatasource = new PrintingDataFromDatasource();

        printingDataFromDatasource.printArtists();
        printingDataFromDatasource.printAlbums();
        printingDataFromDatasource.printSongs();
        printingDataFromDatasource.printAlbumsForArtist("Pixies");

    }
}
