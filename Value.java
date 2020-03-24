package poker;

public class Value {
    public int numval;
    public Rank rank;

    @Override
    public boolean equals(Object obj) {
        assert obj.getClass() == this.getClass();
        Value v= (Value) obj;
        return v.numval == numval;
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
        case 1:
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
