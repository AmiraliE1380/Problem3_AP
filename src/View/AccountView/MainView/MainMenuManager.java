package View.AccountView.MainView;

import View.AccountView.ChangePasswordView.ChangePasswordManager;
import View.AccountView.ChangePasswordView.ChangePasswordMenu;
import View.RegisterAndLoginView.MenuManager;

public class MainMenuManager extends MenuManager {

    public void changePassword() {
        try {
            ChangePasswordManager.setParentMenu(managersMenu);
            new ChangePasswordMenu().start(stage);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
