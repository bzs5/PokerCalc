package poker;

import java.util.Arrays;

public class Hand implements Comparable<Object> {

    private final HandType TYPE;

    private final long HANDVALUE;

    private final Card[] CARDS;

    public Hand(Card[] c) {
        int len= c.length;
        if (len == 5) {
            CARDS= c;
            HANDVALUE= valueHand(CARDS);
        } else if (len == 6) {
            Hand newHand= findBestHandSix(c);
            HANDVALUE= newHand.getHandValue();
            CARDS= newHand.getCards();
        } else {// len == 7
            Hand newHand= findBestHandSeven(c);
            HANDVALUE= newHand.getHandValue();
            CARDS= newHand.getCards();
        }
        TYPE= HandType.values()[(int) (HANDVALUE / 10000000000L)];
    }

    @Override
    public String toString() {
        String result= "(";
        for (Card c : CARDS) {
            result+= c.toString() + " ";
        }
        result+= "), " + TYPE.name().replace("_", " ");
        return result;
    }

    @Override
    public int compareTo(Object obj) {
        assert obj.getClass() == this.getClass();
        Hand other= (Hand) obj;
        long otherval= other.getHandValue();
        long ourval= HANDVALUE;
        if (ourval == otherval) { return 0; }
        if (ourval < otherval)
            return -1;
        return 1;
    }

    public static Hand findBestHandSix(Card[] cardsInHands) {
        assert cardsInHands.length == 6;
        Heap<Hand> heap= new Heap<>(true);
        for (int i= 0; i < 6; i++ ) {
            Card[] iterCards= new Card[5];
            int place= 0;
            for (int j= 0; j < 6; j++ ) {
                if (j != i) {
                    iterCards[place]= cardsInHands[j];
                    place++ ;
                }
            }
            Hand iterHand= new Hand(iterCards);
            heap.add(iterHand, iterHand.getHandValue());

        }
        return heap.poll();

    }

    public static Hand findBestHandSeven(Card[] cardsInHands) {
        assert cardsInHands.length == 7;
        Heap<Hand> heap= new Heap<>(true);
        for (int i= 0; i < 7; i++ ) {
            // Doesn't do anything for i = 6, but i<6 looks more magic number-y
            for (int j= i + 1; j < 7; j++ ) {
                Card[] iterCards= new Card[5];
                int place= 0;
                for (int k= 0; k < 7; k++ ) {
                    if (k != i && k != j) {
                        iterCards[place]= cardsInHands[k];
                        place++ ;
                    }
                }
                Hand iterHand= new Hand(iterCards);
                heap.add(iterHand, iterHand.getHandValue());
            }

        }
        return heap.poll();
    }

    public static long valueHand(Card[] cardsInHand) {
        long result= 0;
        assert cardsInHand.length == 5;
        boolean straight= false;
        boolean flush= false;
        int numPairs= 0;
        int[] suites= new int[4];
        int[] vals= new int[5];
        int count= 0;
        for (Card c : cardsInHand) {
            // Count the suites present
            switch (c.getSuit()) {
            case SPADES:
                suites[0]++ ;
                break;
            case DIAMONDS:
                suites[1]++ ;
                break;
            case HEARTS:
                suites[2]++ ;
                break;
            case CLUBS:
                suites[3]++ ;
                break;
            }
            // Put the values of the cards into an array
            vals[count]= c.getValue();
            count++ ;
        }
        // Sort into ascending order. This will simplify everything from here onwards.
        Arrays.sort(vals);
        // Check for flushes
        boolean found= false;
        int a= 0;
        while (!found && a < 4) {
            found= suites[a] == 5;
            a++ ;
        }
        flush= found;
        // Check for straights
        boolean stillPossible= true;
        int b= 1;
        while (stillPossible && b < 5) {
            stillPossible= vals[b] == vals[0] + b;
            b++ ;
        }
        straight= stillPossible;
        // Straight Flush:
        if (straight && flush) { return vals[4] == 14 ? 90000000000L : 80000000000L + vals[4]; }
        // Check for pairs: needed to find quads, full houses, threes, two pairs, one pair.
        // The pairs here can be equal in value to another, i.e numPairs == 2 can be a three of a
        // kind
        for (int c= 0; c < 4; c++ ) {
            if (vals[c] == vals[c + 1]) {
                numPairs++ ;
            }
        }
        if (numPairs == 3) {// This is either quads or a full house
            if (vals[1] == vals[3]) { // Since the array is sorted and has 3 pairs : always true for
                                      // quads, never for full house
                // quads
                result= 70000000000L + vals[2] * 100;// The middle value is always part of the quads
                return vals[0] == vals[1] ? (result+= vals[4]) : (result+= vals[0]);
                // If true the kicker is higher than the quads, if false then it is lower. This lets
                // us find the value easily.
            } else {
                // full house
                result= 60000000000L + vals[2] * 100;// The middle value is always part of the trips
                return vals[1] == vals[2] ? (result+= vals[3]) : (result+= vals[1]);
                // If true then the pair is higher than the trips, if false then it is lower than
                // the trips. This lets us find the value easily.
            }
        }
        int[] wheel= { 2, 3, 4, 5, 14 };// Since ace can also be the low card in a straight, we
                                        // need to see if this is the case.
        // This is the only hardcoded list of values, as it saves time compared to other ways of
        // checking.
        // We still need to see if it's a straight or a straight flush.
        // This is done after quads and full house, because there's no overlap between those--if we
        // do have the A2345 straight, it will never be triggered as a full house or quads anyway.
        if (numPairs == 0 && Arrays.equals(vals, wheel)) {
            return flush ? 80000000005L : 40000000005L;
        }
        // Due to ordering of hands, we handle the other flushes and straights now
        if (flush) {
            // For flush we need to record every single card due to the way kickers work.
            return 50000000000L + vals[4] * 100000000 + vals[3] * 1000000 + vals[2] * 10000 +
                vals[1] * 100 + vals[0];
        }
        if (straight)
            // For straight we just need the top card.
            return 40000000000L + vals[4];
        if (numPairs == 2) {// Either three of a kind or two pairs
            if (vals[0] == vals[2] || vals[1] == vals[3] || vals[2] == vals[4]) {
                // Three of a kind
                int three= vals[2];
                result= 30000000000L + three * 10000;// Now find whether the three of a kind is the
                                                     // low, med, or high value
                if (vals[4] == three) { return result+= vals[1] * 100 + vals[0]; }
                if (vals[0] == three) { return result+= vals[4] * 100 + vals[3]; }
                return result+= vals[4] * 100 + vals[0];

            } else {
                // Two pair
                int p1= vals[1];
                int p2= vals[3];
                result= 20000000000L + p2 * 10000 + p1 * 100;
                // Now find whether the kicker is the low, med, or high value
                if (vals[4] != p2) { return result+= vals[4]; }
                if (vals[2] != p1) { return result+= vals[2]; }
                return result+= vals[0];

            }
        }
        if (numPairs == 1) {
            // One pair--fun fact, one pair is actually more common than no pairs.
            result= 10000000000L;
            // Now we need to find where the pair is in the hand, value-wise.
            if (vals[0] == vals[1]) {
                return result + vals[0] * 1000000 + vals[4] * 10000 + vals[3] * 100 + vals[2];
            } else if (vals[1] == vals[2]) {
                return result + vals[1] * 1000000 + vals[4] * 10000 + vals[3] * 100 + vals[0];
            } else if (vals[2] == vals[3]) {
                return result + vals[2] * 1000000 + vals[4] * 10000 + vals[1] * 100 + vals[0];
            } else {// vals[3]==vals[4]
                return result + vals[3] * 1000000 + vals[2] * 10000 + vals[1] * 100 + vals[0];
            }
        }
        // High card: also need to value all 5, just like a flush
        return vals[4] * 100000000 + vals[3] * 1000000 + vals[2] * 10000 +
            vals[1] * 100 + vals[0];
    }

    public long getHandValue() {
        return HANDVALUE;
    }

    public Card[] getCards() {
        return CARDS.clone();
    }
}
