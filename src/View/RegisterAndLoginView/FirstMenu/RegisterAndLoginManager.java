package View.RegisterAndLoginView.FirstMenu;

import View.RegisterAndLoginView.DeleteAccount.DeletingMenu;
import View.RegisterAndLoginView.Login.LoginMenu;
import View.RegisterAndLoginView.MenuManager;
import View.RegisterAndLoginView.Register.RegisterMenu;
import javafx.stage.Stage;

public class RegisterAndLoginManager extends MenuManager {
    private static Stage stage;

    public static void setStage(Stage stage) {
        RegisterAndLoginManager.stage = stage;
    }

    public void goToRegisterMenu() {
        try {
            new RegisterMenu().start(stage);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void goToLoginMenu() {
        try {
            new LoginMenu().start(stage);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void goToDeleteAccountMenu() {
        try {
            new DeletingMenu().start(stage);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
