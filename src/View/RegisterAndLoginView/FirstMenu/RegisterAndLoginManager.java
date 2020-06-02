package View.RegisterAndLoginView.FirstMenu;

import View.RegisterAndLoginView.Register.RegisterManager;
import View.RegisterAndLoginView.Register.RegisterMenu;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class RegisterAndLoginManager {
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
            RegisterManager.setStage(stage);
            RegisterMenu registerMenu = new RegisterMenu();
            registerMenu.start(stage);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void goToLoginMenu(MouseEvent mouseEvent) {
    }

    public void goToDeleteAccountMenu(MouseEvent mouseEvent) {
    }

    public void exit() {
        System.exit(1);
    }
}
