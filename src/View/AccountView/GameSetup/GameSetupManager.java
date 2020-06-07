package View.AccountView.GameSetup;

import Controller.Account;
import View.AccountView.MainView.MainMenu;
import View.GameView.GameMenu;
import View.MenuManager;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.net.URL;
import java.util.ResourceBundle;

public class GameSetupManager extends MenuManager implements Initializable {
    public AnchorPane pane;
    public TextField usernameField;
    public TextField limitField;
    public TextField undoLimit;
    public Label errorMessage;
    {
        parentMenu = new MainMenu();
    }

    public void playGame() {
        try {
            Account.getInstance().startNewGame(usernameField.getText(), Integer.parseInt(limitField.getText()),
                    Integer.parseInt(undoLimit.getText()));
            new GameMenu().start(stage);
        } catch(NumberFormatException e) {
            errorMessage.setText("Enter a number for the undo and the limit field!");
        } catch (Exception e) {
            if(!(e instanceof NumberFormatException)) {
                errorMessage.setText(e.getMessage());
            }
        }
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
}
