import java.util.ArrayList;

public class Player {

    private String name;
    private int score;
    private ArrayList<Card> hand;

    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.hand = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void addCardToHand(Card card) {
        this.hand.add(card);
    }


    public void takeCardFromDeck(Deck deck) {
        Card card = deck.removeCard();
        this.addCardToHand(card);
    }

    public void clearHand() {
        this.hand.clear();
    }

//    public void changeScore(int score){
//
//    }

    public void incrementScore() {
        this.score += 1;
    }

    public int getHandTotal() {
        int handTotal = 0;
        for (Card card: hand) {
            handTotal += card.getValueOfCard();
        }
        return handTotal;
    }
}
