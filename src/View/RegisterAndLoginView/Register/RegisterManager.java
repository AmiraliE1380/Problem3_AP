package View.RegisterAndLoginView.Register;

import Controller.RegisterAndLogin;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegisterManager {
    private static Stage stage;
    public TextField usernameField;
    public PasswordField passwordField;
    public Label errorMessage;
    public Label successMessage;

    public void setStage(Stage stage) {
        this.stage = stage;
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
}
