package poker;

import java.util.ArrayList;
import java.util.Random;

public class Deck {

    public ArrayList<Card> cards= new ArrayList<>();

    public Deck() {
        for (Suit s : Suit.values()) {
            for (int v= 2; v <= 14; v++ ) {
                cards.add(new Card(s, new Value(v)));
            }
        }
    }

    public Deck(Card[] exclude) {
        for (Suit s : Suit.values()) {
            for (int v= 2; v <= 14; v++ ) {
                Card curr= new Card(s, new Value(v));
                boolean used= false;
                for (Card c : exclude) {
                    if (curr.equals(c)) {
                        used= true;
                    }
                }
                if (!used) {
                    cards.add(curr);
                }
            }
        }
    }

    public Deck copy() {
        Deck copy= new Deck();
        copy.cards= (ArrayList<Card>) cards.clone();
        return copy;
    }

    public void shuffle() {
        Random rand= new Random();
        int r;
        Card temp;
        for (int i= cards.size() - 1; i > 0; i-- ) {
            r= rand.nextInt(i + 1);
            temp= cards.get(r);
            cards.set(r, cards.get(i));
            cards.set(i, temp);
        }
    }

    public Card deal() {
        return cards.remove(0);
    }

    @Override
    public String toString() {
        String result= "";
        for (Card c : cards) {
            result+= c.toString();
        }
        return result;
    }

}
