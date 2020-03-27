package poker;

public class Value {
    public int numval;
    public Rank rank;

    @Override
    public int hashCode() {
        final int prime= 5;
        int result= 1;
        result= prime * result + numval;
        result= prime * result + (rank == null ? 0 : rank.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Value other= (Value) obj;
        if (numval != other.numval) return false;
        if (rank != other.rank) return false;
        return true;
    }

    public Value(int v) {
        numval= v;
        rank= findr(v);
    }

    public int getNumval() {
        return numval;
    }

    public Rank getRank() {
        return rank;
    }

    public Rank findr(int v) {
        Rank r;
        switch (v) {
        case 1: // Unused
            r= Rank.LO_ACE;
            break;
        case 2:
            r= Rank.TWO;
            break;
        case 3:
            r= Rank.THREE;
            break;
        case 4:
            r= Rank.FOUR;
            break;
        case 5:
            r= Rank.FIVE;
            break;
        case 6:
            r= Rank.SIX;
            break;
        case 7:
            r= Rank.SEVEN;
            break;
        case 8:
            r= Rank.EIGHT;
            break;
        case 9:
            r= Rank.NINE;
            break;
        case 10:
            r= Rank.TEN;
            break;
        case 11:
            r= Rank.JACK;
            break;
        case 12:
            r= Rank.QUEEN;
            break;
        case 13:
            r= Rank.KING;
            break;
        case 14:
            r= Rank.ACE;
            break;
        default:
            r= Rank.ACE;// Should never get here
        }
        return r;
    }

}
