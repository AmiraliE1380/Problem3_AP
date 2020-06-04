package View.AccountView.GameSetup;

import Controller.Account;
import View.RegisterAndLoginView.MenuManager;
import javafx.scene.control.TextField;

public class GameSetupManager extends MenuManager {
    public TextField usernameField;
    public TextField limitField;
    public TextField undoLimit;

    public void playGame() {
        try {
            Account.getInstance().startNewGame(usernameField.getText(), Integer.parseInt(limitField.getText()),
                    Integer.parseInt(undoLimit.getText()));
        } catch(Exception e) {
            System.out.println(e.getClass());
            System.err.println(e.getMessage());
        }
    }

}
