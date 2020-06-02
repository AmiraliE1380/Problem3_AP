package View.RegisterAndLoginView.Register;

import Controller.RegisterAndLogin;
import View.RegisterAndLoginView.FirstMenu.RegisterAndLoginMenu;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class RegisterManager {
    private static RegisterAndLoginMenu parentMenu;
    private static Stage stage;
    public TextField usernameField;
    public PasswordField passwordField;
    public Label errorMessage;
    public Label successMessage;

    public static void setStage(Stage stage) {
        RegisterManager.stage = stage;
    }

    public static void setParentMenu(RegisterAndLoginMenu parentMenu) {
        RegisterManager.parentMenu = parentMenu;
    }

    public void register() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        try {
            RegisterAndLogin.getInstance().register(username, password);
            errorMessage.setText("");
            successMessage.setText("You have successfully registered!");
        } catch (Exception e) {
            successMessage.setText("");
            errorMessage.setText("This username has been used!");
        }
    }

    public void back() {
        try {
            parentMenu.start(stage);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}