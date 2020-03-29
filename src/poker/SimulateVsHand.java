package poker;

public class SimulateVsHand {

    private Player[] players;

    private final int numPlayers;

    private Deck currDeck;

    private final int tableLength;

    private Card[] tableCards= new Card[5];

    public static void main(String[] args) {
        Card[] c1= { new Card(Suit.CLUBS, 8), new Card(Suit.SPADES, 7) };
        Card[] c2= { new Card(Suit.DIAMONDS, 14), new Card(Suit.HEARTS, 13) };
        Card[] table= { new Card(Suit.DIAMONDS, 8), new Card(Suit.HEARTS, 7),
                new Card(Suit.CLUBS, 13) };
        SimulateVsHand simulation= new SimulateVsHand(new Player(c1), new Player(c2), table);
        int num= 1000000;
        Player[] results= simulation.runSimulation(num, true);
        for (int l= 0; l < results.length; l++ ) {
            System.out
                .println(
                    "Player " + (l + 1) + " wins: " + results[l].getWins() / (.01 * num) + "%");
            System.out
                .println(
                    "Player " + (l + 1) + " ties: " + results[l].getTies() / (.01 * num) + "%");
        }
    }

    public Player[] runSimulation(int numSimulations, boolean printProgress) {
        if (printProgress) {
            System.out.println("Simulation started");
        }
        for (int i= 0; i < numSimulations; i++ ) {
            if (printProgress && i % (numSimulations / 10) == 0) {
                System.out.println(100 * i / numSimulations + "% complete");
            }
            Deck copy= currDeck.copy();
            copy.shuffle();
            for (Player p : players) {
                p.reset();
            }
            for (int j= 0; j < 5; j++ ) {
                Card c= j >= tableLength ? copy.deal() : tableCards[j];
                tableCards[j]= c;
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
                        p.addTies();
                    }
                }
            } else {
                winner.addWins();
            }

        }
        if (printProgress) {
            System.out.println("Simulation finished");
        }
        return players;
    }

    public SimulateVsHand(Player p1, Player p2, Card[] table) {
        numPlayers= 2;
        players= new Player[numPlayers];
        players[0]= p1;
        players[1]= p2;
        if (table == null) {
            tableLength= 0;
        } else {
            tableLength= table.length;
            for (int i= 0; i < tableLength; i++ ) {
                tableCards[i]= table[i];
            }
        }
        currDeck= new Deck(combineHands(p1.getHoleCards(), p2.getHoleCards()));

    }

    public SimulateVsHand(Player p1, Player p2, Player p3, Card[] table) {
        numPlayers= 3;
        players= new Player[numPlayers];
        players[0]= p1;
        players[1]= p2;
        players[2]= p3;
        if (table == null) {
            tableLength= 0;
        } else {
            tableLength= table.length;
            for (int i= 0; i < tableLength; i++ ) {
                tableCards[i]= table[i];
            }
        }
        currDeck= new Deck(combineHands(p1.getHoleCards(), p2.getHoleCards(), p3.getHoleCards()));
    }

    public SimulateVsHand(Player p1, Player p2, Player p3, Player p4, Card[] table) {
        numPlayers= 4;
        players= new Player[numPlayers];
        players[0]= p1;
        players[1]= p2;
        players[2]= p3;
        players[3]= p4;
        if (table == null) {
            tableLength= 0;
        } else {
            tableLength= table.length;
            for (int i= 0; i < tableLength; i++ ) {
                tableCards[i]= table[i];
            }
        }
        currDeck= new Deck(combineHands(p1.getHoleCards(), p2.getHoleCards(), p3.getHoleCards(),
            p4.getHoleCards()));

    }

    private Card[] combineHands(Card[] p1, Card[] p2) {
        Card[] result= new Card[2 * 2 + tableLength];
        result[0]= p1[0];
        result[1]= p1[1];
        result[2]= p2[0];
        result[3]= p2[1];
        for (int i= 0; i < tableLength; i++ ) {
            result[4 + i]= tableCards[i];
        }
        return result;
    }

    private Card[] combineHands(Card[] p1, Card[] p2, Card[] p3) {
        Card[] result= new Card[2 * 3 + tableLength];
        result[0]= p1[0];
        result[1]= p1[1];
        result[2]= p2[0];
        result[3]= p2[1];
        result[4]= p3[0];
        result[5]= p3[1];
        for (int i= 0; i < tableLength; i++ ) {
            result[6 + i]= tableCards[i];
        }
        return result;
    }

    private Card[] combineHands(Card[] p1, Card[] p2, Card[] p3, Card[] p4) {
        Card[] result= new Card[2 * 4 + tableLength];
        result[0]= p1[0];
        result[1]= p1[1];
        result[2]= p2[0];
        result[3]= p2[1];
        result[4]= p3[0];
        result[5]= p3[1];
        result[6]= p4[0];
        result[7]= p4[1];
        for (int i= 0; i < tableLength; i++ ) {
            result[8 + i]= tableCards[i];
        }
        return result;
    }

}
