package View.RegisterAndLoginView.FirstMenu;

import View.RegisterAndLoginView.DeleteAccount.DeletingManager;
import View.RegisterAndLoginView.DeleteAccount.DeletingMenu;
import View.RegisterAndLoginView.Login.LoginManager;
import View.RegisterAndLoginView.Login.LoginMenu;
import View.RegisterAndLoginView.MenuManager;
import View.RegisterAndLoginView.Register.RegisterManager;
import View.RegisterAndLoginView.Register.RegisterMenu;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class RegisterAndLoginManager extends MenuManager {
    private static Stage stage;
    private static RegisterAndLoginMenu menu;

    public static void setStage(Stage stage) {
        RegisterAndLoginManager.stage = stage;
    }

    public static void setMenu(RegisterAndLoginMenu menu) {
        RegisterAndLoginManager.menu = menu;
    }

    public void goToRegisterMenu() {
        try {
            RegisterManager.setParentMenu(menu);
            new RegisterMenu().start(stage);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void goToLoginMenu() {
        try {
            LoginManager.setParentMenu(menu);
            new LoginMenu().start(stage);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void goToDeleteAccountMenu() {
        try {
            DeletingManager.setParentMenu(menu);
            new DeletingMenu().start(stage);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
