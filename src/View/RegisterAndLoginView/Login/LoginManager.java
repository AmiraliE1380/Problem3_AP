package View.RegisterAndLoginView.Login;

import Controller.RegisterAndLogin;
import View.AccountView.MainView.*;
import View.RegisterAndLoginView.FirstMenu.RegisterAndLoginMenu;
import View.MenuManager;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginManager extends MenuManager {
    public TextField usernameField;
    public PasswordField passwordField;
    public Label errorMessage;
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
}
