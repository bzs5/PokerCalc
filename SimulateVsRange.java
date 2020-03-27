package poker;

public class SimulateVsRange {

    Player playerOne;

    RangePlayer playerTwo;

    public static void main(String[] args) {
        Card[] c1= { new Card(Suit.HEARTS, 14), new Card(Suit.DIAMONDS, 14) };
        Range r2= new Range(10);
        r2.Remove(new HoleCards(c1));
        SimulateVsRange simulation= new SimulateVsRange(new Player(c1), new RangePlayer(r2));
        int num= 100000;
        SimulatedPlayer[] results= simulation.runSimulation(num, null, true);
        for (int l= 0; l < results.length; l++ ) {
            System.out
                .printf(
                    "Player %d wins: %6.3f%%%n", l + 1,
                    results[l].getWins() / (.01 * r2.getCards().size() * num));
            System.out
                .printf(
                    "Player %d ties: %6.3f%%%n", l + 1,
                    results[l].getTies() / (.01 * r2.getCards().size() * num));
        }
    }

    public SimulatedPlayer[] runSimulation(int numSimulationsEach, Card[] table,
        boolean showProgress) {
        int count= 1;
        int numIterations= playerTwo.size();
        System.out.println("Starting simulation");
        for (HoleCards poss : playerTwo.getCards()) {
            SimulateVsHand iteration= new SimulateVsHand(new Player(playerOne.getHoleCards()),
                new Player(poss), table);
            Player[] output= iteration.runSimulation(numSimulationsEach, false);
            playerOne.addPlayer(output[0]);
            playerTwo.addPlayer(output[1]);
            if (showProgress) {
                System.out.println(count + "/" + numIterations);
            }

            count++ ;
        }
        System.out.println("Simulation finished");
        SimulatedPlayer[] result= { playerOne, playerTwo };
        return result;
    }

    public SimulateVsRange(Player p1, RangePlayer p2) {
        playerOne= p1;
        playerTwo= p2;
    }

}
