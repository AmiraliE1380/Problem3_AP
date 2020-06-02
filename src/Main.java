import View.RegisterAndLoginView.FirstMenu.RegisterAndLoginMenu;
import View.RegisterAndLoginView.MenuManager;
import javafx.application.Application;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        MenuManager.setStage(primaryStage);
        try {
            new RegisterAndLoginMenu().start(primaryStage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
