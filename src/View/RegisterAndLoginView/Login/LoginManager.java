package View.RegisterAndLoginView.Login;

import Controller.RegisterAndLogin;
import View.AccountView.MainView.*;
import View.RegisterAndLoginView.FirstMenu.RegisterAndLoginMenu;
import View.RegisterAndLoginView.MenuManager;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginManager extends MenuManager {
    public TextField usernameField;
    public PasswordField passwordField;
    public Label errorMessage;

    public static void setParentMenu(RegisterAndLoginMenu parentMenu) {
        LoginManager.parentMenu = parentMenu;
    }


    public void login() {
        try {
            RegisterAndLogin.getInstance().login(usernameField.getText(), passwordField.getText());
            MainMenuManager.setParentMenu(parentMenu);
            new MainMenu().start(stage);
        } catch (Exception e) {
            errorMessage.setText(e.getMessage());
        }
    }
}
