package View.RegisterAndLoginView.DeleteAccount;

import Controller.RegisterAndLogin;
import View.RegisterAndLoginView.FirstMenu.RegisterAndLoginMenu;
import View.MenuManager;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.net.URL;
import java.util.ResourceBundle;

public class DeletingManager extends MenuManager implements Initializable {
    public TextField usernameField;
    public PasswordField passwordField;
    public Label errorMessage;
    public Label successMessage;
    public Button deleteButton;
    public AnchorPane pane;
    {
        parentMenu = new RegisterAndLoginMenu();
    }

    public void delete() {
        try {
            RegisterAndLogin.getInstance().remove(usernameField.getText(), passwordField.getText());
            errorMessage.setText("");
            successMessage.setText("Account successfully deleted!");
            usernameField.setDisable(true);
            passwordField.setDisable(true);
            deleteButton.setDisable(true);
        } catch (Exception e) {
            successMessage.setText("");
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
