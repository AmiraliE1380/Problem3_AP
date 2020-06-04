package View.AccountView.GameSetup;

import Controller.Account;
import View.AccountView.MainView.MainMenu;
import View.RegisterAndLoginView.MenuManager;
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
        } catch(NumberFormatException e) {
            errorMessage.setText("Enter a number for the undo and the limit field!");
        } catch (Exception e) {
            if(!(e instanceof NumberFormatException)) {
                errorMessage.setText(e.getMessage());
            }
        }
    }

}
