package View.RegisterAndLoginView.FirstMenu;

import View.RegisterAndLoginView.Register.RegisterMenu;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class RegisterAndLoginManager {
    private static Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void goToRegisterMenu() {
        try {
            new RegisterMenu().start(stage);
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
