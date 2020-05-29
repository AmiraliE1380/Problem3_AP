package Controller;

import Model.Player;

import java.util.Comparator;

public class PlayerComparator implements Comparator<Player> {
    @Override
    public int compare(Player player1, Player player2) {
        int scoreCompare = player2.calculateScore().compareTo(player1.calculateScore());
        int winsCompare = ((Integer)(player2.getNumOfWins() + player2.getNumOfRivalForfeits())).
                compareTo(player1.getNumOfWins() + player1.getNumOfRivalForfeits());
        int drawsCompare = player2.getNumOfDraws().compareTo(player1.getNumOfDraws());
        int loosesCompare = ((Integer)(player1.getNumOfLooses() + player1.getNumOfOwnForfeits())).
                compareTo(player2.getNumOfLooses() + player2.getNumOfOwnForfeits());
        int nameCompare = player1.getUsername().compareTo(player2.getUsername());

        if(scoreCompare != 0) {
            return scoreCompare;
        }else if(winsCompare != 0) {
            return 	winsCompare;
        }else if(drawsCompare != 0){
            return drawsCompare;
        }else if(loosesCompare != 0) {
            return loosesCompare;
        }else {
            return nameCompare;
        }
    }
}
