package pairmatching.domain;

import java.util.List;

public class Pair {
    // 얘가 자체적으로 하는 일
    // 페어인 크루끼리 묶어줌
    // Pair 를 받았을 떄, 같은 Pair 인 지 확인해야함
    // 확인 알고리즘
    // 각 List 의 크기를 비교한다.
    // 크기가 같다면, 내부 이름을 비교한다. Crew 는 equals 가 구현되어있음

    private final List<Crew> members;

    public Pair(List<Crew> members) {
        this.members = members;
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
}
