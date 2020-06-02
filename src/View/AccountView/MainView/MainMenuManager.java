package View.AccountView.MainView;

import View.AccountView.ChangePasswordView.ChangePasswordManager;
import View.AccountView.ChangePasswordView.ChangePasswordMenu;
import View.RegisterAndLoginView.FirstMenu.RegisterAndLoginMenu;
import View.RegisterAndLoginView.MenuManager;

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
}
