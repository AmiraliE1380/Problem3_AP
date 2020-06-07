package View.RegisterAndLoginView.FirstMenu;

import View.RegisterAndLoginView.DeleteAccount.DeletingMenu;
import View.RegisterAndLoginView.Login.LoginMenu;
import View.MenuManager;
import View.RegisterAndLoginView.Register.RegisterMenu;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class RegisterAndLoginManager extends MenuManager implements Initializable {
    private static Stage stage;
    public AnchorPane pane;

    public static void setStage(Stage stage) {
        RegisterAndLoginManager.stage = stage;
    }

    public void goToRegisterMenu() {
        try {
            new RegisterMenu().start(stage);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void goToLoginMenu() {
        try {
            new LoginMenu().start(stage);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void goToDeleteAccountMenu() {
        try {
            new DeletingMenu().start(stage);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String address = "resources\\background image\\Background_Image.jpeg";
        Image image = new Image(address);
        BackgroundImage backgroundimage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background background = new Background(backgroundimage);
        pane.setBackground(background);
    }
}
