package View.AccountView.ChangePasswordView;

import Controller.Account;
import View.RegisterAndLoginView.MenuManager;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

public class ChangePasswordManager extends MenuManager {
    public PasswordField passwordField;
    public Label successMessage;
    public Button changePasswordButton;

    public void changePassword() {
        Account.getInstance().changePassword(passwordField.getText());
        passwordField.setDisable(true);
        changePasswordButton.setDisable(true);
        successMessage.setText("You have successfully changed tour password!");
    }
}
