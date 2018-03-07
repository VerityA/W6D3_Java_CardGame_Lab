public class Card {

    private Rank rank;
    private Suit suit;


    public Card(Suit suit, Rank rank) {
       this.rank = rank;
       this.suit = suit;
    }


    public int getValueOfCard() {
        return this.rank.getValue();
    }
}
