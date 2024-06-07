package hust.soict.ict.aims.screen.customer.controller;
import hust.soict.ict.aims.cart.Cart;
import hust.soict.ict.aims.media.Media;
import hust.soict.ict.aims.media.Playable;
import hust.soict.ict.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;


public class CartController {

    private Cart cart;
    private Store store;
    public CartController(Store store, Cart cart){
        this.cart =  cart;

    }
    @FXML
    public void initialize(){
        colMediaId.setCellValueFactory(new PropertyValueFactory<Media, Integer>("id"));
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        if (cart.getItemsOrdered()== null){
            tblMedia.setItems(cart.getItemsOrdered());
        }
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);
        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>(){
            @Override
                    public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue){
                updateButtonBar(newValue);
            }
        });
    }
    void updateButtonBar(Media media){
        if (media ==null){
            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
        }
        else{
            btnRemove.setVisible(true);
            if (media instanceof Playable){
                btnPlay.setVisible(true);
            }
            else{
                btnPlay.setVisible(false);
            }
        }
    }

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, String> colMediaCost;

    @FXML
    private TableColumn<Media, Integer> colMediaId;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private Label costLabel;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    void btnPlayPressed(ActionEvent event) {
        System.out.println("Playing");

    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media =  tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
        try {
            final String STORE_FXML_FILE_PATH = "/hust/soict/ict/aims/screen/customer/view/Store.fxml";
            FXMLLoader fxmlLoader =  new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
            fxmlLoader.setController(new ViewStoreController(store,cart));
            Parent root = fxmlLoader.load();
            Node a =  (Node) event.getSource();
            Stage stage =  (Stage) a.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("STORE");
            stage.show();
        } catch (IOException e){
            e.printStackTrace();
        }

    }

}