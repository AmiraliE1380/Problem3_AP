package View.RegisterAndLoginView.FirstMenu;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class RegisterAndLoginMenu extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        RegisterAndLoginManager.setStage(primaryStage);
        Parent root = FXMLLoader.load(getClass().getResource("RegisterAndLoginMenuDesign.fxml"));
        primaryStage.setTitle("Ebi's chess");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }
}
