package View.AccountView.ChangePasswordView;

import Controller.Account;
import View.AccountView.MainView.MainMenu;
import View.MenuManager;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

public class ChangePasswordManager extends MenuManager {
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
}
