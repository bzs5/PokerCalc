package poker;

import java.util.ArrayList;

public class Simulate {

    public Player[] players;

    public int numPlayers;

    public Deck currDeck;

    public static void main(String[] args) {
        Card[] p1= { new Card(Suit.SPADES, 6), new Card(Suit.CLUBS, 11) };
        Card[] p2= { new Card(Suit.DIAMONDS, 3), new Card(Suit.DIAMONDS, 2) };
        Card[] p3= { new Card(Suit.HEARTS, 7), new Card(Suit.HEARTS, 6) };
        Simulate simulation= new Simulate(p1, p2, p3);
        simulation.runSimulation(1000000);
    }

    public void runSimulation(int numSimulations) {
        double oneP= numSimulations / 100;
        for (int i= 0; i < numSimulations; i++ ) {
            if (i % (oneP * 10) == 0) {
                System.out.println(i / oneP + "% done");
            }
            Deck copy= currDeck.copy();
            copy.shuffle();
            for (Player p : players) {
                p.reset();
            }
            for (int j= 0; j < 5; j++ ) {
                Card c= copy.deal();
                for (Player p : players) {
                    p.playerCards.add(c);
                }
            }
            Player winner= null;
            boolean tied= false;
            Long maxValue= 0L;
            for (int k= 0; k < numPlayers; k++ ) {
                players[k].findHand();
                if (k == 0) {
                    winner= players[0];
                    maxValue= winner.playerHand.getHandValue();
                } else {
                    int won= players[k].playerHand.compareTo(winner.playerHand);
                    if (won == 1) {
                        winner= players[k];
                        maxValue= winner.playerHand.getHandValue();
                        tied= false;
                    } else if (won == 0) {
                        tied= true;
                    }
                }

            }
            if (tied) {
                for (Player p : players) {
                    if (p.playerHand.getHandValue() == maxValue) {
                        p.ties++ ;
                    }
                }
            } else {
                winner.wins++ ;
            }

        }
        for (int l= 0; l < numPlayers; l++ ) {
            System.out.println("Player " + (l + 1) + " wins: " + players[l].wins / oneP + "%");
            System.out.println("Player " + (l + 1) + " ties: " + players[l].ties / oneP + "%");
        }
    }

    public Simulate(Card[] p1, Card[] p2) {
        numPlayers= 2;
        players= new Player[numPlayers];
        players[0]= new Player(p1);
        players[1]= new Player(p2);
        currDeck= new Deck(combineHands(p1, p2));
    }

    public Simulate(Card[] p1, Card[] p2, Card[] p3) {
        numPlayers= 3;
        players= new Player[numPlayers];
        players[0]= new Player(p1);
        players[1]= new Player(p2);
        players[2]= new Player(p3);
        currDeck= new Deck(combineHands(p1, p2, p3));
    }

    public Simulate(Card[] p1, Card[] p2, Card[] p3, Card[] p4) {
        numPlayers= 4;
        players= new Player[numPlayers];
        players[0]= new Player(p1);
        players[1]= new Player(p2);
        players[2]= new Player(p3);
        players[3]= new Player(p4);
        currDeck= new Deck(combineHands(p1, p2, p3, p4));
    }

    public class Player {
        public ArrayList<Card> playerCards= new ArrayList<>();

        public Card[] holeCards;

        int wins= 0;
        int ties= 0;

        Hand playerHand;

        public Player(Card[] pocket) {
            assert pocket.length == 2;
            holeCards= pocket;
            playerCards.add(holeCards[0]);
            playerCards.add(holeCards[1]);
        }

        public void reset() {
            playerCards.clear();
            playerCards.add(holeCards[0]);
            playerCards.add(holeCards[1]);
        }

        public void findHand() {
            Card[] held= new Card[playerCards.size()];
            assert held.length == 7;
            playerHand= new Hand(playerCards.toArray(held));
        }
    }

    private static Card[] combineHands(Card[] p1, Card[] p2) {
        Card[] result= new Card[2 * 2];
        result[0]= p1[0];
        result[1]= p1[1];
        result[2]= p2[0];
        result[3]= p2[1];
        return result;
    }

    private static Card[] combineHands(Card[] p1, Card[] p2, Card[] p3) {
        Card[] result= new Card[2 * 3];
        result[0]= p1[0];
        result[1]= p1[1];
        result[2]= p2[0];
        result[3]= p2[1];
        result[4]= p3[0];
        result[5]= p3[1];
        return result;
    }

    private static Card[] combineHands(Card[] p1, Card[] p2, Card[] p3, Card[] p4) {
        Card[] result= new Card[2 * 4];
        result[0]= p1[0];
        result[1]= p1[1];
        result[2]= p2[0];
        result[3]= p2[1];
        result[4]= p3[0];
        result[5]= p3[1];
        result[6]= p4[0];
        result[7]= p4[1];
        return result;
    }

}
