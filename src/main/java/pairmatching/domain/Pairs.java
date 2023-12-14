package pairmatching.domain;

import java.util.List;

public class Pairs {

    private final List<Pair> pairs;
    private final PairsInformation information;

    public Pairs(List<Pair> pairs, PairsInformation information) {
        this.pairs = pairs;
        this.information = information;
    }

    public boolean hasSamePair(Pairs others) {
        for (Pair pair : pairs) {
            for (Pair other : others.pairs) {
                if (pair.hasSamePair(other)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasSameInformation(PairsInformation information) {
        return information.equals(this.information);
    }
}
