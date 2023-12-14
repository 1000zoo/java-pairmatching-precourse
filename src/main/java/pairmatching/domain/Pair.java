package pairmatching.domain;

import java.util.List;

public class Pair {

    private final List<Crew> members;

    public Pair(List<Crew> members) {
        this.members = members;
    }

    public String pairString() {
        StringBuilder sb = new StringBuilder();

        for (Crew crew : members) {
            sb.append(crew.name()).append(" : ");
        }
        sb.setLength(sb.length() - 3);

        return sb.toString();
    }

    public boolean hasSamePair(Pair pair) {
        int count = 0;

        for (Crew crew : members) {
            if (pair.contains(crew)) {
                count++;
            }
        }

        return count > 1;
    }

    private boolean contains(Crew crew) {
        return members.contains(crew);
    }

    @Override
    public String toString() {
        return "Pair{" +
                "members=" + members +
                '}';
    }
}
