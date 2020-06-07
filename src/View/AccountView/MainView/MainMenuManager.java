package View.AccountView.MainView;

import View.AccountView.ChangePasswordView.ChangePasswordMenu;
import View.AccountView.GameSetup.GameSetupMenu;
import View.AccountView.ScoreboardMenu;
import View.RegisterAndLoginView.FirstMenu.RegisterAndLoginMenu;
import View.MenuManager;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuManager extends MenuManager implements Initializable {
    public AnchorPane pane;
    {
        parentMenu = new RegisterAndLoginMenu();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String address = "resources\\background image\\Background_Image.jpeg";
        Image image = new Image(address);
        BackgroundImage backgroundimage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background background = new Background(backgroundimage);
        pane.setBackground(background);
    }

    public void changePassword() {
        try {
            new ChangePasswordMenu().start(stage);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void showScoreboard() {
        try {
            new ScoreboardMenu().start(null);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void startGame() {
        try {
            new GameSetupMenu().start(stage);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
