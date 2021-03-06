package View.GameView;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GameMenu extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root =  FXMLLoader.load(getClass().getResource("GameDesign.fxml"));
        primaryStage.setTitle("Ebi's chess");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
