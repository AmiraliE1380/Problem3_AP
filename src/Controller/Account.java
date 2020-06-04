package Controller;

import Model.Player;
import com.sun.org.apache.bcel.internal.generic.RET;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Account {
    private static Account account = new Account();
    private Player player;

    private Account() {}

    public static Account getInstance() {
        return account;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void changePassword(String newPassword) throws Exception {
        if(newPassword.length() == 0) {
            throw new Exception("Enter a password!");
        }
        player.setPassword(newPassword);
    }

    //TODO: TEST COMPARATOR
    public ArrayList<Player> getPlayersBasedOnScore() {
        ArrayList<Player> players = new ArrayList<>(Player.getAllPlayers().values());
        Collections.sort(players, new PlayerComparator());
        return players;
    }

    public void startNewGame(String secondPlayerName, int numOfTurns, int totalUndo) throws Exception {
        if(!Player.getAllPlayers().containsKey(secondPlayerName)) {
            throw new Exception("No player exist with this username.");
        }
        Game.getInstance().startGame(player, Player.getPlayerByName(secondPlayerName), numOfTurns, totalUndo);
    }

    public void logout() {
        player = null;
    }
}
