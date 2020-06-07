package View.RegisterAndLoginView.Login;

import Controller.RegisterAndLogin;
import View.AccountView.MainView.*;
import View.RegisterAndLoginView.FirstMenu.RegisterAndLoginMenu;
import View.MenuManager;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginManager extends MenuManager implements Initializable {
    public TextField usernameField;
    public PasswordField passwordField;
    public Label errorMessage;
    public AnchorPane pane;
    {
        parentMenu = new RegisterAndLoginMenu();
    }

    public void login() {
        try {
            RegisterAndLogin.getInstance().login(usernameField.getText(), passwordField.getText());
            new MainMenu().start(stage);
        } catch (Exception e) {
            errorMessage.setText(e.getMessage());
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
