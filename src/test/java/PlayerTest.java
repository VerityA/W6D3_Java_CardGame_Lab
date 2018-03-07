import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    Player player;
    Deck deck;
    Card card;

    @Before
    public void before() {
        this.player = new Player("Alan");
        this.deck = new Deck();
        deck.refillDeck();
        this.card = new Card(Suit.HEARTS, Rank.ACE);
    }

    @Test
    public void canGetName() {
        assertEquals("Alan", player.getName());
    }

    @Test
    public void canGetScore(){
        assertEquals(0, player.getScore());
    }

    @Test
    public void canAddCardToHand(){
        assertEquals(0, player.getHand().size());
        player.addCardToHand(card);
        assertEquals(1, player.getHand().size());
    }

    @Test
    public void canTakeCardFromDeck(){
        assertEquals(0, player.getHand().size());
        assertEquals(52, deck.getCards().size());
        player.takeCardFromDeck(deck);
        assertEquals(1, player.getHand().size());
        assertEquals(51, deck.getCards().size());
    }

    @Test
    public void canClearHand(){
        assertEquals(0, player.getHand().size());
        player.takeCardFromDeck(deck);
        assertEquals(1, player.getHand().size());
        player.clearHand();
        assertEquals(0, player.getHand().size());
    }

    @Test
    public void canChangeScore(){
        assertEquals(0, player.getScore());
        player.incrementScore();
        assertEquals(1, player.getScore());
    }

    @Test
    public void canGetHandTotal(){
        assertEquals(0, player.getHand().size());
        player.addCardToHand(card);
        player.addCardToHand(card);
        assertEquals(2, player.getHandTotal());
    }

}
