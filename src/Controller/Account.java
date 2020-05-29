package Controller;

import Model.Player;

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
}
