package poker;

import java.util.Arrays;

public class HoleCards implements Comparable<Object> {

    Card[] cards= new Card[2];

    public HoleCards(Card c1, Card c2) {
        if (c1.compareTo(c2) == 1) {
            cards[0]= c1;
            cards[1]= c2;
        } else {
            cards[0]= c2;
            cards[1]= c1;
        }

    }

    public HoleCards(Card[] c) {
        cards= new HoleCards(c[0], c[1]).getCards();
    }

    public Card[] getCards() {
        return cards;
    }

    @Override
    public String toString() {
        return "(" + cards[0] + ", " + cards[1] + ")";
    }

    @Override
    public int hashCode() {
        final int prime= 13;
        int result= 1;
        result= prime * result + Arrays.hashCode(cards);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        HoleCards other= (HoleCards) obj;
        if (!Arrays.equals(cards, other.cards)) return false;
        return true;
    }

    @Override
    public int compareTo(Object obj) {
        assert obj.getClass() == this.getClass();
        HoleCards other= (HoleCards) obj;
        int larger= cards[0].compareTo(other.getCards()[0]);
        int smaller= cards[1].compareTo(other.getCards()[1]);
        return larger == 0 ? smaller == 0 ? 0 : smaller : larger;
    }
}
