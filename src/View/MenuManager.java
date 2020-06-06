package View;

import javafx.application.Application;
import javafx.stage.Stage;

public class MenuManager {
    protected static Stage stage;
    protected Application parentMenu;

    public static void setStage(Stage stage) {
        MenuManager.stage = stage;
    }

    public void exit() {
        System.exit(1);
    }

    public void back() {
        try {
            parentMenu.start(stage);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
