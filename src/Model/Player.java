package Model;

import java.util.HashMap;

public class Player {
    private static HashMap<String, Player> allPlayers = new HashMap<String, Player>();
    private String username;
    private String password;
    private int numOfWins;
    private int numOfRivalForfeits;
    private int numOfOwnForfeits;
    private int numOfDraws;
    private int numOfLooses;
    private int score;
    private boolean login;

    public Player(String username, String password) {
        allPlayers.put(username, this);
        this.username = username;
        this.password = password;
        this.numOfWins = 0;
        this.numOfDraws = 0;
        this.numOfLooses = 0;
        this.numOfRivalForfeits = 0;
        this.numOfOwnForfeits = 0;
        this.login = false;
    }

    public static HashMap<String, Player> getAllPlayers() {
        return allPlayers;
    }

    public static Player getPlayerByName(String username) {
        return allPlayers.get(username);
    }

    public static void remove(String username) {
        allPlayers.remove(username);
    }

    public static void adjustScores() {
        for(Player player: allPlayers.values()) {
            player.score = player.calculateScore();
        }
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Integer getNumOfWins() {
        return numOfWins;
    }

    public Integer getNumOfRivalForfeits() {
        return numOfRivalForfeits;
    }

    public Integer getNumOfOwnForfeits() {
        return numOfOwnForfeits;
    }

    public Integer getNumOfDraws() {
        return numOfDraws;
    }

    public Integer getNumOfLooses() {
        return numOfLooses;
    }

    public int getScore() {
        return score;
    }

    public boolean isLogin() {
        return login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNumOfWins(int numOfWins) {
        this.numOfWins = numOfWins;
    }

    public void setNumOfRivalForfeits(int numOfRivalForfeits) {
        this.numOfRivalForfeits = numOfRivalForfeits;
    }

    public void setNumOfOwnForfeits(int numOfOwnForfeits) {
        this.numOfOwnForfeits = numOfOwnForfeits;
    }

    public void setNumOfDraws(int numOfDraws) {
        this.numOfDraws = numOfDraws;
    }

    public void setNumOfLooses(int numOfLooses) {
        this.numOfLooses = numOfLooses;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }

    public Integer calculateScore() {
        return 3 * numOfWins + numOfDraws + 2 * numOfRivalForfeits - numOfOwnForfeits;
    }
}
