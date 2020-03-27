package poker;

import java.util.HashSet;

public class Range {

    public HashSet<HoleCards> cards;

    public Range() {
        cards= new HashSet<>();
    }

    public Range(int n) {
        assert n > 0 && n <= 100;
        cards= new HashSet<>();
        switch (n) {
        case 100:
            Add(7, 2, false); // Worst hand in no-limit hold-em (3+ players)
            Add(3, 2, false); // Worst hand in heads up NLHE
        case 99:
            Add(4, 2, false);
        case 98:
            Add(6, 2, false);
        case 97:
            Add(5, 2, false);
        case 96:
            Add(8, 2, false);
        case 95:
            Add(8, 3, false);
        case 94:
            Add(4, 3, false);
        case 93:
            Add(7, 3, false);
        case 92:
            Add(6, 3, false);
        case 91:
            Add(9, 2, false);
            Add(5, 3, false);
        case 90:
            Add(9, 3, false);
        case 89:
            Add(7, 4, false);
        case 88:
            Add(8, 4, false);
        case 87:
            Add(9, 4, false);
        case 86:
            Add(10, 2, false);
        case 85:
            Add(6, 4, false);
        case 84:
            Add(5, 4, false);
        case 83:
            Add(10, 3, false);
        case 82:
            Add(10, 4, false);
        case 81:
            Add(11, 2, false);
            Add(8, 5, false);
        case 80:
            Add(9, 5, false);
        case 79:
            Add(6, 5, false);
        case 78:
            Add(7, 5, false);
        case 77:
            Add(11, 3, false);
        case 76:
            Add(10, 5, false);
            Add(3, 2, true);
        case 75:
            Add(7, 2, true);
            Add(4, 2, true);
        case 74:
            Add(11, 4, false);
        case 73:
            Add(9, 6, false);
            Add(6, 2, true);
            Add(5, 2, true);
        case 72:
            Add(12, 2, false);
        case 71:
            Add(7, 6, false);
        case 70:
            Add(8, 6, false);
        case 69:
            Add(11, 5, false);
            Add(8, 2, true);
        case 68:
            Add(10, 6, false);
        case 67:
            Add(12, 3, false);
        case 66:
            Add(8, 3, true);
            Add(6, 3, true);
            Add(4, 3, true);
        case 65:
            Add(7, 3, true);
            Add(11, 6, false);
        case 64:
            Add(5, 3, true);
            Add(9, 2, true);
        case 63:
            Add(12, 4, false);
        case 62:
            Add(8, 7, false);
            Add(9, 3, true);
        case 61:
            Add(13, 2, false);
        case 60:
            Add(9, 7, false);
        case 59:
            Add(12, 5, false);
            Add(8, 4, true);
        case 58:
            Add(7, 4, true);
            Add(6, 4, true);
            Add(5, 4, true);
        case 57:
            Add(13, 3, false);
        case 56:
            Add(10, 7, false);
            Add(9, 4, true);
        case 55:
            Add(12, 6, false);
        case 54:
            Add(11, 7, false);
            Add(10, 3, true);
            Add(10, 2, true);
        case 53:
            Add(13, 4, false);
        case 52:
            Add(9, 5, true);
            Add(8, 5, true);
        case 51:
            Add(9, 8, false);
            Add(6, 5, true);
            Add(10, 4, true);
        case 50:
            Add(12, 7, false);// Median hand in NLHE
            Add(7, 5, true);
        case 49:
            Add(10, 5, true);
        case 48:
            Add(13, 5, false);
            Add(11, 2, true);
        case 47:
            Add(10, 8, false);
            Add(11, 3, true);
        case 46:
            Add(13, 6, false);
        case 45:
            Add(11, 8, false);
        case 44:
            Add(8, 6, true);
            Add(11, 4, true);
        case 43:
            Add(7, 6, true);
            Add(14, 2, false);
        case 42:
            Add(10, 6, true);
            Add(9, 6, true);
            AddPair(2);
        case 41:
            Add(11, 5, true);
            Add(12, 3, true);
            Add(12, 2, true);
        case 40:
            Add(12, 8, false);
        case 39:
            Add(14, 3, false);
            Add(13, 7, false);
        case 38:
            Add(14, 4, false);
        case 37:
            Add(11, 6, true);
        case 36:
            Add(10, 9, false);
        case 35:
            Add(12, 4, true);
            Add(8, 7, true);
            AddPair(3);
        case 34:
            Add(13, 8, false);
            Add(9, 7, true);
        case 33:
            Add(11, 9, false);
        case 32:
            Add(14, 6, false);
        case 31:
            Add(12, 5, true);
            Add(14, 5, false);
        case 30:
            Add(12, 9, false);
            Add(10, 7, true);
            Add(13, 2, true);
        case 29:
            Add(13, 3, true);
        case 28:
            Add(12, 6, true);
            Add(11, 7, true);
            Add(14, 7, false);
        case 27:
            AddPair(4);
            Add(9, 8, true);
        case 26:
            Add(13, 4, true);
            Add(12, 7, true);
            Add(10, 8, true);
        case 25:
            Add(13, 5, true);
            Add(13, 9, false);
        case 24:
            Add(14, 8, false);
        case 23:
            Add(11, 8, true);
            Add(11, 10, false);
        case 22:
            Add(13, 6, true);
            Add(14, 2, true);
        case 21:
            Add(12, 10, false);
        case 20:
            AddPair(5);
            Add(14, 3, true);
            Add(12, 8, true);
        case 19:
            Add(14, 9, false);
            Add(10, 9, true);
            Add(13, 7, true);
        case 18:
            Add(14, 4, true);
            Add(11, 9, true);
        case 17:
            Add(13, 8, true);
            Add(13, 10, false);
        case 16:
            Add(12, 11, false);
        case 15:
            Add(12, 9, true);
            Add(14, 6, true);
            Add(14, 5, true);
        case 14:
            Add(13, 11, false);
        case 13:
            AddPair(6);
            Add(14, 10, false);
        case 12:
            Add(11, 10, true);
            Add(14, 7, true);
        case 11:
            Add(12, 10, true);
            Add(13, 9, true);
            Add(14, 8, true);
        case 10:
            Add(13, 12, false);
            Add(14, 11, false);
        case 9:
            Add(14, 9, true);
        case 8:
            AddPair(7);
            Add(12, 11, true);
            Add(13, 10, true);
        case 7:
            Add(14, 12, false);
        case 6:
            AddPair(8);
            Add(13, 11, true);
            Add(14, 10, true);
        case 5:
            Add(14, 13, false);
        case 4:
            AddPair(9);
            Add(14, 12, true);
            Add(13, 12, true);
            Add(14, 11, true);
        case 3:
            AddPair(10);
            Add(14, 13, true);
        case 2:
            AddPair(12);
            AddPair(11);
        case 1:
            AddPair(14);// Pocket Aces, best hand in NLHE
            AddPair(13);

        }

    }

    public void Add(int CardOneVal, int CardTwoVal, boolean suited) {
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

    public void AddPair(int cardVal) {
        for (Suit s1 : Suit.values()) {
            for (Suit s2 : Suit.values()) {
                if (s2.ordinal() > s1.ordinal()) {
                    HoleCards iter= new HoleCards(new Card(s1, cardVal), new Card(s2, cardVal));
                    cards.add(iter);
                }
            }
        }
    }

    public void Add(HoleCards hc) {
        if (!cards.contains(hc)) {
            cards.add(hc);
        }
    }

    public void RemoveSpecific(HoleCards hc) {
        cards.remove(hc);
    }

    public void Remove(HoleCards hc) {
        DeadCard(hc.getCards()[0]);
        DeadCard(hc.getCards()[1]);
    }

    public void DeadCard(Card c) {
        Deck list= new Deck();
        for (Card each : list.cards) {
            if (!c.equals(each)) {
                RemoveSpecific(new HoleCards(c, each));
            }
        }
    }

    public HashSet<HoleCards> getCards() {
        return cards;
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

}
