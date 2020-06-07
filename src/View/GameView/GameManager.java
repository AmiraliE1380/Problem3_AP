package View.GameView;

import Controller.Game;
import View.AccountView.MainView.MainMenu;
import View.MenuManager;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class GameManager extends MenuManager implements Initializable {
    public Label showPlayers;
    private Game game = Game.getInstance();
    {
        parentMenu = new MainMenu();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showPlayers.setText(game.getPlayer1() + " vs " + game.getPlayer2());
    }

    public void forfeit() {
    }

    public void move() {
    }

    public void undo() {
    }
}
