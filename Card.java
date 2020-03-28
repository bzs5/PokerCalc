package poker;

public class Card implements Comparable<Object> {
    private final Suit CARDSUIT;
    private final Rank CARDRANK;
    private final int CARDVALUE;

    public Card(Suit s, Rank r) {
        CARDSUIT= s;
        CARDRANK= r;
        CARDVALUE= r.ordinal() + 1;
    }

    public Card(Suit s, int v) {
        CARDSUIT= s;
        CARDRANK= Rank.values()[v - 1];
        CARDVALUE= v;
    }

    @Override
    public int compareTo(Object obj) {
        assert obj.getClass() == this.getClass();
        Card other= (Card) obj;
        int otherval= other.CARDVALUE;
        int ourval= CARDVALUE;
        if (ourval == otherval)
        // Helps for starting hands to order by suit, even if there's no real VALUE to them.
        // We're not using this method to VALUE hands
        {
            int oursuit= getSuit().ordinal();
            int othersuit= other.getSuit().ordinal();
            if (oursuit == othersuit) { return 0; }
            return oursuit < othersuit ? -1 : 1;
        }
        return ourval < otherval ? -1 : 1;
    }

    @Override
    public String toString() {
        String first= CARDVALUE > 9 ? CARDRANK.name().substring(0, 1) :
            "" + CARDVALUE;
        String second= CARDSUIT.name().substring(0, 1);
        return first + second;
    }

    @Override
    public int hashCode() {
        final int prime= 11;
        int result= 1;
        result= prime * result + (CARDSUIT == null ? 0 : CARDSUIT.hashCode());
        result= prime * result + (CARDRANK == null ? 0 : CARDRANK.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Card other= (Card) obj;
        if (CARDSUIT != other.CARDSUIT) return false;
        if (CARDRANK == null) {
            if (other.CARDRANK != null) return false;
        } else if (!CARDRANK.equals(other.CARDRANK)) return false;
        return true;
    }

    public Suit getSuit() {
        return CARDSUIT;
    }

    public int getValue() {
        return CARDVALUE;
    }

    public Rank getRank() {
        return CARDRANK;
    }

}
