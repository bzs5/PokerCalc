package poker;

public class RangePlayer extends Range implements SimulatedPlayer {

    private int wins= 0;

    private int ties= 0;

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

    @Override
    public void addWins() {
        wins++ ;
    }

    @Override
    public void addTies() {
        ties++ ;
    }

}
