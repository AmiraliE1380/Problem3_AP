package View.AccountView.MainView;

import View.AccountView.ChangePasswordView.ChangePasswordMenu;
import View.AccountView.GameSetup.GameSetupMenu;
import View.AccountView.ScoreboardMenu;
import View.RegisterAndLoginView.FirstMenu.RegisterAndLoginMenu;
import View.MenuManager;

public class MainMenuManager extends MenuManager {
    {
        parentMenu = new RegisterAndLoginMenu();
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
