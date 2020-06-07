package View.AccountView.ChangePasswordView;

import Controller.Account;
import View.AccountView.MainView.MainMenu;
import View.MenuManager;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.net.URL;
import java.util.ResourceBundle;

public class ChangePasswordManager extends MenuManager implements Initializable {
    public AnchorPane pane;
    public PasswordField passwordField;
    public Label successMessage;
    public Label errorMessage;
    public Button changePasswordButton;
    {
        parentMenu = new MainMenu();
    }

    public void changePassword() {
        try {
            Account.getInstance().changePassword(passwordField.getText());
            passwordField.setDisable(true);
            changePasswordButton.setDisable(true);
            errorMessage.setText("");
            successMessage.setText("You have successfully changed tour password!");
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
