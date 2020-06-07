package View.AccountView.GameSetup;

import Controller.Account;
import View.AccountView.MainView.MainMenu;
import View.GameView.GameMenu;
import View.MenuManager;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class GameSetupManager extends MenuManager {
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
                e.printStackTrace();
            }
        }
    }

}
