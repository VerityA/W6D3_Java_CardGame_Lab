import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> cards;

    public Deck(){
        this.cards = new ArrayList<>();
    }


    public ArrayList<Card> getCards() {
        return cards;
    }

    public void refillDeck() {
        Suit[] suits = Suit.values();
        Rank[] ranks = Rank.values();

        for (Suit suit: suits) {
            for (Rank rank : ranks) {
                this.cards.add(new Card(suit,rank));
            }
        }
    }

    public void shuffleDeck() {
        Collections.shuffle(this.cards);
                
    }

    public Card removeCard() {
        return this.cards.remove(0);
    }
}
