package poker;

public interface SimulatedPlayer {

    int getWins();

    void addWins();

    int getTies();

    void addTies();

    void addPlayer(Player p);
}
