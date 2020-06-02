package View.RegisterAndLoginView.Register;

import Controller.RegisterAndLogin;
import View.RegisterAndLoginView.FirstMenu.RegisterAndLoginMenu;
import View.RegisterAndLoginView.MenuManager;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegisterManager extends MenuManager {
    public TextField usernameField;
    public PasswordField passwordField;
    public Label errorMessage;
    public Label successMessage;
    public Button registerButton;
    {
        parentMenu = new RegisterAndLoginMenu();
    }

    public void register() {
        try {
            RegisterAndLogin.getInstance().register(usernameField.getText(), passwordField.getText());
            errorMessage.setText("");
            successMessage.setText("You have successfully registered!");
            usernameField.setDisable(true);
            passwordField.setDisable(true);
            registerButton.setDisable(true);
        } catch (Exception e) {
            successMessage.setText("");
            errorMessage.setText(e.getMessage());
        }
    }
}