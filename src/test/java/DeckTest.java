import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class DeckTest {

    Deck deck;

    @Before
    public void before() {
        deck = new Deck();
    }

    @Test
    public void canGetCards() {
        assertEquals(0, deck.getCards().size());
    }

    @Test
    public void canCountFullDeck() {
        deck.refillDeck();
        assertEquals(52, deck.getCards().size());
    }

    @Test
    public void canShuffleDeck() {
        deck.refillDeck();
        deck.shuffleDeck();
        Card firstCard = deck.getCards().get(0);
        System.out.println(firstCard.getValueOfCard());
        assertTrue(deck.getCards().contains(firstCard));
    }

    @Test
    public void canRemoveCard() {
        deck.refillDeck();
        deck.removeCard();
        assertEquals(51, deck.getCards().size());
    }

}
