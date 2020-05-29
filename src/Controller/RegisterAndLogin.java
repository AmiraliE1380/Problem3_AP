package Controller;

import Model.Player;

public class RegisterAndLogin {
    private static RegisterAndLogin registerAndLogin = new RegisterAndLogin();

    private RegisterAndLogin() {}

    public static RegisterAndLogin getInstance() {
        return registerAndLogin;
    }

    public void login(String username, String password) throws Exception {
        if(Player.getAllPlayers().containsKey(username)) {
            Player player = Player.getPlayerByName(username);
            if(player.getPassword().equals(password)) {
                Account.getInstance().setPlayer(player);
            } else {
                throw new Exception("Wrong password");
            }
        } else {
            throw new Exception("No user Exist with this username.");
        }
    }

    public void register(String username, String password) throws Exception {
        if(Player.getAllPlayers().containsKey(username)) {
            throw new Exception("Username has been used by another user.");
        }
        Player.getAllPlayers().put(username, new Player(username, password));
    }

    public void remove(String username, String password) throws Exception {
        if(Player.getAllPlayers().containsKey(username)) {
            Player player = Player.getPlayerByName(username);
            if(player.getPassword().equals(password)) {
                Player.getAllPlayers().remove(username);
            } else {
                throw new Exception("Wrong password");
            }
        } else {
            throw new Exception("No user Exist with this username.");
        }
    }
}
