package View.GameView;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameMenu extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("GameDesign.fxml"));
        primaryStage.setTitle("Ebi's chess");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();


  /*
        VBox vBox = new VBox();
        primaryStage.setScene(new Scene(vBox));
        primaryStage.setMaximized(true);
        primaryStage.show();

   */
    }
}
