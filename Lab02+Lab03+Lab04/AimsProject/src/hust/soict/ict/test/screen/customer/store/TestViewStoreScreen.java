package hust.soict.ict.test.screen.customer.store;

import hust.soict.ict.aims.cart.Cart;
import hust.soict.ict.aims.screen.customer.controller.ViewStoreController;
import hust.soict.ict.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewStoreScreen extends Application {
    private static Store store;
    private static Cart cart;
    @Override
    public void start(Stage primaryStage) throws Exception{
        final String STORE_FXML_FILE_PATH =  "/hust/soict/ict/aims/screen/customer/view//Store.fxml";
        FXMLLoader fxmlLoader =  new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
        ViewStoreController viewStoreController =  new ViewStoreController(store,cart);
        Parent root =  fxmlLoader.load();

        primaryStage.setTitle("Store");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }

    public static void main(String[] args){
        store = new Store();
        launch(args);
    }

}
