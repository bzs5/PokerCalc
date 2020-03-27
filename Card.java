package poker;

public class Card implements Comparable<Object> {
    private Suit suit;
    private Value value;

    public Card(Suit s, Value v) {
        suit= s;
        value= v;
    }

    public Card(Suit s, int v) {
        suit= s;
        value= new Value(v);
    }

    @Override
    public int compareTo(Object obj) {
        assert obj.getClass() == this.getClass();
        Card c= (Card) obj;
        int cval= c.value.numval;
        int ourval= value.numval;
        if (ourval == cval)
        // Helps for starting hands to order by suit, even if there's no real value to them.
        // We're not using this method to value hands
        {
            int oursuit= getSuit().ordinal();
            int csuit= c.getSuit().ordinal();
            if (oursuit == csuit) { return 0; }
            return oursuit < csuit ? -1 : 1;
        }
        return ourval < cval ? -1 : 1;
    }

    @Override
    public String toString() {
        String first= value.numval > 9 ? value.rank.name().substring(0, 1) : "" + value.numval;
        String second= suit.name().substring(0, 1);
        return first + second;
    }

    @Override
    public int hashCode() {
        final int prime= 11;
        int result= 1;
        result= prime * result + (suit == null ? 0 : suit.hashCode());
        result= prime * result + (value == null ? 0 : value.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Card other= (Card) obj;
        if (suit != other.suit) return false;
        if (value == null) {
            if (other.value != null) return false;
        } else if (!value.equals(other.value)) return false;
        return true;
    }

    public Suit getSuit() {
        return suit;
    }

    public Value getValue() {
        return value;
    }

}
