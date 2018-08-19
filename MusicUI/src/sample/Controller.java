package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableView;
import jdk.management.resource.internal.inst.DatagramDispatcherRMHooks;
import sample.model.Album;
import sample.model.Artist;
import sample.model.Datasource;

import javax.sql.DataSource;


public class Controller {

    @FXML
    private TableView artistTable;

    @FXML
    private ProgressBar progressBar;

    @FXML
    public void listArtist(){
        Task<ObservableList<Artist> > task = new GEtAllArtists();
        artistTable.itemsProperty().bind(task.valueProperty());

        progressBar.progressProperty().bind(task.progressProperty());
        progressBar.setVisible(true);
        task.setOnSucceeded(event -> progressBar.setVisible(false));
        task.setOnFailed(event -> progressBar.setVisible(false) );

        new Thread(task).start();
    }

    public void ListAlbumsForArtist(){
        final Artist artist = (Artist) artistTable.getSelectionModel().getSelectedItem();
        if(artist == null ){
            System.out.println("no artist selected");
            return;
        }
        Task<ObservableList<Album>> task = new Task<ObservableList<Album>>() {
            @Override
            protected ObservableList<Album> call() throws Exception {
                return FXCollections.observableArrayList(Datasource.getInstance().queryAlbumsForArtistID(artist.getId()));

            }
        };
        artistTable.itemsProperty().bind(task.valueProperty());

        new Thread(task).start();
    }

    @FXML
    public void updateArtist(){
        final Artist artist = (Artist)artistTable.getItems().get(2);

        Task<Boolean> task = new Task<Boolean>() {
            @Override
            protected Boolean call() throws Exception {
                return Datasource.getInstance().updateArtistName(artist.getId(), "AC/DC");
            }
        };

        task.setOnSucceeded(event -> {
                if(task.valueProperty().get()){
                    artist.setName("AC/DC");
                    artistTable.refresh();
                }
        });

        new Thread(task).start();

    }

}





class GEtAllArtists extends Task{

    @Override
    protected ObservableList<Artist> call() throws Exception {
        return FXCollections.observableArrayList
                (Datasource.getInstance().queryArtist(Datasource.ORDER_BY_ASC));
    }
}
