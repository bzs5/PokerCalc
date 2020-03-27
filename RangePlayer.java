package poker;

public class RangePlayer extends Range implements SimulatedPlayer {

    int wins= 0;

    int ties= 0;

    public RangePlayer() {
        super();
    }

    public RangePlayer(int n) {
        super(n);
    }

    public RangePlayer(Range r) {
        cards= r.getCards();
    }

    @Override
    public int getWins() {
        return wins;
    }

    @Override
    public int getTies() {
        return ties;
    }

    @Override
    public void addPlayer(Player p) {
        wins+= p.getWins();
        ties+= p.getTies();
    }

}
