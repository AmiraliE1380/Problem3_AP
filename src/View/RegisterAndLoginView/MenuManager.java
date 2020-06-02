package View.RegisterAndLoginView;

import View.RegisterAndLoginView.Register.RegisterManager;
import javafx.application.Application;
import javafx.stage.Stage;

public class MenuManager {
    protected static Stage stage;
    protected static Application parentMenu;

    public static void setStage(Stage stage) {
        MenuManager.stage = stage;
    }

    public void exit() {
        System.exit(1);
    }

    public void setParentMenu(Application parentMenu) {
        MenuManager.parentMenu = parentMenu;
    }

    public void back() {
        try {
            parentMenu.start(stage);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
