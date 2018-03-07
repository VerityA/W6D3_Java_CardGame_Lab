import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CardTest {

    Card card;

    @Before
    public void before() {
        card = new Card(Suit.HEARTS, Rank.QUEEN);
    }

    @Test
    public void canGetValueOfCard() {
        assertEquals(12, card.getValueOfCard());
    }
}
