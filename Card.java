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
        if (ourval == cval) { return 0; }
        if (ourval < cval)
            return -1;
        return 1;
    }

    @Override
    public String toString() {
        String first= value.numval > 9 ? value.rank.name().substring(0, 1) : "" + value.numval;
        String second= suit.name().substring(0, 1);
        return first + second + " ";
    }

    @Override
    public boolean equals(Object obj) {
        assert obj.getClass() == this.getClass();
        Card c= (Card) obj;
        return c.value.equals(value) && c.suit == suit;
    }

    public Suit getSuit() {
        return suit;
    }

    public Value getValue() {
        return value;
    }

}
