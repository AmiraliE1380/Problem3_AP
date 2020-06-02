package View.AccountView.ChangePasswordView;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ChangePasswordMenu extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("ChangePasswordDesign.fxml"));
        primaryStage.setTitle("Ebi's chess");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }
}
