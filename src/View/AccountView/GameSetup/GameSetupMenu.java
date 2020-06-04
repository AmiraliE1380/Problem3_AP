package View.AccountView.GameSetup;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameSetupMenu extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("GameSetupMenuDesign.fxml"));
        primaryStage.setTitle("Ebi's chess");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }
}
