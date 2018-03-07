import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class GameTest {

    Game game;
    Player player1;
    Player player2;
    Player player3;
    Deck deck;
    ArrayList<Player> players;


    @Before
    public void before() {
        player1 = new Player("Malcolm");
        player2 = new Player("Verity");
        player3 = new Player("Darren");
        ArrayList<Player> players = new ArrayList<>(Arrays.asList(player1, player2, player3));
        game = new Game(players);
        deck = new Deck();
    }

    @Test
    public void canStartGameWithPlayers() {
       assertEquals(3, game.getPlayers().size());
    }

    @Test
    public void canDealPlayerCards() {
        game.startGame();
        ArrayList<Player> testPlayers = game.getPlayers();
        for (Player player : testPlayers) {
            assertEquals(2, player.getHand().size());
        }
    }


    @Test
    public void canFindWinningPlayerWhenOneWinner() {
        Card card1 = new Card(Suit.HEARTS, Rank.ACE);
        Card card2 = new Card(Suit.CLUBS, Rank.EIGHT);
        Card card3 = new Card(Suit.SPADES, Rank.KING);
        Card card4 = new Card(Suit.HEARTS, Rank.SEVEN);
        Card card5 = new Card(Suit.CLUBS, Rank.SIX);
        Card card6 = new Card(Suit.SPADES, Rank.QUEEN);
        player1.addCardToHand(card1);
        player2.addCardToHand(card2);
        player3.addCardToHand(card3);
        player1.addCardToHand(card4);
        player2.addCardToHand(card5);
        player3.addCardToHand(card6);
        game.findWinningPlayer();
        assertEquals(0, player1.getScore());
        assertEquals(0, player2.getScore());
        assertEquals(1, player3.getScore());
    }

    @Test
    public void canFindWinningPlayerWhenTwoWinners() {
        Card card1 = new Card(Suit.HEARTS, Rank.ACE);
        Card card2 = new Card(Suit.CLUBS, Rank.EIGHT);
        Card card3 = new Card(Suit.SPADES, Rank.EIGHT);
        player1.addCardToHand(card1);
        player2.addCardToHand(card2);
        player3.addCardToHand(card3);
        game.findWinningPlayer();
        assertEquals(0, player1.getScore());
        assertEquals(1, player2.getScore());
        assertEquals(1, player3.getScore());
    }

//    @Test
//    public void canPlayGame() {
//        game.playGame();
//        assertEquals();
//    }
}

