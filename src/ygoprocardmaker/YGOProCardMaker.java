package ygoprocardmaker;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Simão Reis <dracostriker@hotmail.com>
 */
public class YGOProCardMaker extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("YGOProCardMaker.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("YGOProCardMaker");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("resource/pics/icon.png")));
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
