package poker;

import java.util.ArrayList;

public class Player implements SimulatedPlayer {
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

    public Player(HoleCards pocket) {
        holeCards= pocket.getCards();
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

    @Override
    public void addPlayer(Player p) {
        wins+= p.getWins();
        ties+= p.getTies();
    }

    public Card[] getHoleCards() {
        return holeCards;
    }

    @Override
    public int getWins() {
        return wins;
    }

    @Override
    public int getTies() {
        return ties;
    }
}
