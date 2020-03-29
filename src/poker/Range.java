package poker;

import java.util.HashSet;

public class Range {

    protected HashSet<HoleCards> cards;

    public Range() {
        cards= new HashSet<>();
    }

    public Range(int n) {
        assert n > 0 && n <= 100;
        cards= new HashSet<>();
        switch (n) {
        case 100:
            add(7, 2, false); // Worst hand in no-limit hold-em (3+ players)
            add(3, 2, false); // Worst hand in heads up NLHE
        case 99:
            add(4, 2, false);
        case 98:
            add(6, 2, false);
        case 97:
            add(5, 2, false);
        case 96:
            add(8, 2, false);
        case 95:
            add(8, 3, false);
        case 94:
            add(4, 3, false);
        case 93:
            add(7, 3, false);
        case 92:
            add(6, 3, false);
        case 91:
            add(9, 2, false);
            add(5, 3, false);
        case 90:
            add(9, 3, false);
        case 89:
            add(7, 4, false);
        case 88:
            add(8, 4, false);
        case 87:
            add(9, 4, false);
        case 86:
            add(10, 2, false);
        case 85:
            add(6, 4, false);
        case 84:
            add(5, 4, false);
        case 83:
            add(10, 3, false);
        case 82:
            add(10, 4, false);
        case 81:
            add(11, 2, false);
            add(8, 5, false);
        case 80:
            add(9, 5, false);
        case 79:
            add(6, 5, false);
        case 78:
            add(7, 5, false);
        case 77:
            add(11, 3, false);
        case 76:
            add(10, 5, false);
            add(3, 2, true);
        case 75:
            add(7, 2, true);
            add(4, 2, true);
        case 74:
            add(11, 4, false);
        case 73:
            add(9, 6, false);
            add(6, 2, true);
            add(5, 2, true);
        case 72:
            add(12, 2, false);
        case 71:
            add(7, 6, false);
        case 70:
            add(8, 6, false);
        case 69:
            add(11, 5, false);
            add(8, 2, true);
        case 68:
            add(10, 6, false);
        case 67:
            add(12, 3, false);
        case 66:
            add(8, 3, true);
            add(6, 3, true);
            add(4, 3, true);
        case 65:
            add(7, 3, true);
            add(11, 6, false);
        case 64:
            add(5, 3, true);
            add(9, 2, true);
        case 63:
            add(12, 4, false);
        case 62:
            add(8, 7, false);
            add(9, 3, true);
        case 61:
            add(13, 2, false);
        case 60:
            add(9, 7, false);
        case 59:
            add(12, 5, false);
            add(8, 4, true);
        case 58:
            add(7, 4, true);
            add(6, 4, true);
            add(5, 4, true);
        case 57:
            add(13, 3, false);
        case 56:
            add(10, 7, false);
            add(9, 4, true);
        case 55:
            add(12, 6, false);
        case 54:
            add(11, 7, false);
            add(10, 3, true);
            add(10, 2, true);
        case 53:
            add(13, 4, false);
        case 52:
            add(9, 5, true);
            add(8, 5, true);
        case 51:
            add(9, 8, false);
            add(6, 5, true);
            add(10, 4, true);
        case 50:
            add(12, 7, false);// Median hand in NLHE
            add(7, 5, true);
        case 49:
            add(10, 5, true);
        case 48:
            add(13, 5, false);
            add(11, 2, true);
        case 47:
            add(10, 8, false);
            add(11, 3, true);
        case 46:
            add(13, 6, false);
        case 45:
            add(11, 8, false);
        case 44:
            add(8, 6, true);
            add(11, 4, true);
        case 43:
            add(7, 6, true);
            add(14, 2, false);
        case 42:
            add(10, 6, true);
            add(9, 6, true);
            addPair(2);
        case 41:
            add(11, 5, true);
            add(12, 3, true);
            add(12, 2, true);
        case 40:
            add(12, 8, false);
        case 39:
            add(14, 3, false);
            add(13, 7, false);
        case 38:
            add(14, 4, false);
        case 37:
            add(11, 6, true);
        case 36:
            add(10, 9, false);
        case 35:
            add(12, 4, true);
            add(8, 7, true);
            addPair(3);
        case 34:
            add(13, 8, false);
            add(9, 7, true);
        case 33:
            add(11, 9, false);
        case 32:
            add(14, 6, false);
        case 31:
            add(12, 5, true);
            add(14, 5, false);
        case 30:
            add(12, 9, false);
            add(10, 7, true);
            add(13, 2, true);
        case 29:
            add(13, 3, true);
        case 28:
            add(12, 6, true);
            add(11, 7, true);
            add(14, 7, false);
        case 27:
            addPair(4);
            add(9, 8, true);
        case 26:
            add(13, 4, true);
            add(12, 7, true);
            add(10, 8, true);
        case 25:
            add(13, 5, true);
            add(13, 9, false);
        case 24:
            add(14, 8, false);
        case 23:
            add(11, 8, true);
            add(11, 10, false);
        case 22:
            add(13, 6, true);
            add(14, 2, true);
        case 21:
            add(12, 10, false);
        case 20:
            addPair(5);
            add(14, 3, true);
            add(12, 8, true);
        case 19:
            add(14, 9, false);
            add(10, 9, true);
            add(13, 7, true);
        case 18:
            add(14, 4, true);
            add(11, 9, true);
        case 17:
            add(13, 8, true);
            add(13, 10, false);
        case 16:
            add(12, 11, false);
        case 15:
            add(12, 9, true);
            add(14, 6, true);
            add(14, 5, true);
        case 14:
            add(13, 11, false);
        case 13:
            addPair(6);
            add(14, 10, false);
        case 12:
            add(11, 10, true);
            add(14, 7, true);
        case 11:
            add(12, 10, true);
            add(13, 9, true);
            add(14, 8, true);
        case 10:
            add(13, 12, false);
            add(14, 11, false);
        case 9:
            add(14, 9, true);
        case 8:
            addPair(7);
            add(12, 11, true);
            add(13, 10, true);
        case 7:
            add(14, 12, false);
        case 6:
            addPair(8);
            add(13, 11, true);
            add(14, 10, true);
        case 5:
            add(14, 13, false);
        case 4:
            addPair(9);
            add(14, 12, true);
            add(13, 12, true);
            add(14, 11, true);
        case 3:
            addPair(10);
            add(14, 13, true);
        case 2:
            addPair(12);
            addPair(11);
        case 1:
            addPair(14);// Pocket Aces, best hand in NLHE
            addPair(13);

        }

    }

    public void add(int CardOneVal, int CardTwoVal, boolean suited) {
        assert CardOneVal != CardTwoVal;
        for (Suit s1 : Suit.values()) {
            for (Suit s2 : Suit.values()) {
                if (suited ? s1 == s2 : s1 != s2) {
                    HoleCards iter= new HoleCards(new Card(s1, CardOneVal),
                        new Card(s2, CardTwoVal));
                    cards.add(iter);
                }
            }
        }
    }

    public void addPair(int cardVal) {
        for (Suit s1 : Suit.values()) {
            for (Suit s2 : Suit.values()) {
                if (s2.ordinal() > s1.ordinal()) {
                    HoleCards iter= new HoleCards(new Card(s1, cardVal), new Card(s2, cardVal));
                    cards.add(iter);
                }
            }
        }
    }

    public void remove(int CardOneVal, int CardTwoVal, boolean suited) {
        assert CardOneVal != CardTwoVal;
        for (Suit s1 : Suit.values()) {
            for (Suit s2 : Suit.values()) {
                if (suited ? s1 == s2 : s1 != s2) {
                    HoleCards iter= new HoleCards(new Card(s1, CardOneVal),
                        new Card(s2, CardTwoVal));
                    cards.remove(iter);
                }
            }
        }
    }

    public void removePair(int cardVal) {
        for (Suit s1 : Suit.values()) {
            for (Suit s2 : Suit.values()) {
                if (s2.ordinal() > s1.ordinal()) {
                    HoleCards iter= new HoleCards(new Card(s1, cardVal), new Card(s2, cardVal));
                    cards.remove(iter);
                }
            }
        }
    }

    public void removeOpposing(HoleCards hc) {
        deadCard(hc.getCards()[0]);
        deadCard(hc.getCards()[1]);
    }

    public void deadCard(Card c) {
        Deck list= new Deck();
        for (Card each : list.getCards()) {
            if (!c.equals(each)) {
                cards.remove(new HoleCards(c, each));
            }
        }
    }

    @SuppressWarnings("unchecked")
    public HashSet<HoleCards> getCards() {
        return (HashSet<HoleCards>) cards.clone();
    }

    public int size() {
        return cards.size();
    }

    @Override
    public String toString() {
        if (cards.size() == 0) { return "[]"; }
        String result= "[";
        for (HoleCards pair : cards) {
            result+= pair + ", ";
        }
        return result.substring(0, result.length() - 2) + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Range other= (Range) obj;
        if (cards == null) {
            if (other.cards != null) return false;
        } else if (!cards.equals(other.cards)) return false;
        return true;
    }

}
