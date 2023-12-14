package pairmatching.domain;

import java.util.List;

public class Pairs {

    private final List<Pair> pairs;

    public Pairs(List<Pair> pairs) {
        this.pairs = pairs;
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
}
