import java.util.ArrayList;

public class Game {

    private Deck deck;
    private ArrayList<Player> players;

    public Game(ArrayList<Player> players) {
        this.players = players;
        this.deck = new Deck();
    }


    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void startGame() {
        deck.refillDeck();
        deck.shuffleDeck();
        for (Player player: players) {
            player.takeCardFromDeck(deck);
            player.takeCardFromDeck(deck);
        }
    }

//    public void comparePlayerHands() {
//        Card card1 = players.get(0).getHand().get(0);
//        int value1 = card1.getValueOfCard();
//        Card card2 = players.get(1).getHand().get(0);
//        int value2 = card2.getValueOfCard();
//        if (value1 == value2) {
//            players.get(0).incrementScore();
//            players.get(1).incrementScore();
//        } else
//            if (value1 > value2) {
//                players.get(0).incrementScore();
//        } else {
//                players.get(1).incrementScore();
//            }
//    }

    public void findWinningPlayer() {
        int winningScore = 0;
        ArrayList<Player> winningPlayers = new ArrayList<>();
        for (Player player: players) {
            int handTotal = player.getHandTotal();
            if (handTotal > winningScore) {
                winningPlayers.clear();
                winningPlayers.add(player);
                winningScore = handTotal;
            }
            else {
                if (handTotal == winningScore) {
                    winningPlayers.add(player);
                }
            }
        }
        for (Player player: winningPlayers) {
            player.incrementScore();
        }
    }


    public void playGame() {
        this.startGame();
        this.findWinningPlayer();
    }
}
