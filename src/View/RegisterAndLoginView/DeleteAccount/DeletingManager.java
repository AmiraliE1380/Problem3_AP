package View.RegisterAndLoginView.DeleteAccount;

import Controller.RegisterAndLogin;
import View.RegisterAndLoginView.FirstMenu.RegisterAndLoginMenu;
import View.MenuManager;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class DeletingManager extends MenuManager {
    public TextField usernameField;
    public PasswordField passwordField;
    public Label errorMessage;
    public Label successMessage;
    public Button deleteButton;
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
}
