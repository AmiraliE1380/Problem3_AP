import View.RegisterAndLoginView.RegisterAndLoginMenu;
import javafx.application.Application;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            new RegisterAndLoginMenu().start(primaryStage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
