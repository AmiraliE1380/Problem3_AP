package View.RegisterAndLoginView.Login;

import Controller.RegisterAndLogin;
import View.AccountView.MainMenu.MainMenu;
import View.AccountView.MainMenu.MainMenuManager;
import View.RegisterAndLoginView.FirstMenu.RegisterAndLoginMenu;
import View.RegisterAndLoginView.MenuManager;
import View.RegisterAndLoginView.Register.RegisterManager;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

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
            //TODO: GO TO ACCOUNT MENU
            MainMenuManager.setParentMenu(parentMenu);
            new MainMenu().start(stage);
        } catch (Exception e) {
            errorMessage.setText(e.getMessage());
        }
    }
}
