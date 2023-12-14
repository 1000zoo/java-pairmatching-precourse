package pairmatching.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pairmatching.constants.ErrorMessage;
import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.CrewMembers;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.domain.Pair;
import pairmatching.domain.Pairs;
import pairmatching.domain.PairsInformation;

public class PairMatching {

    // level 에는 여러 코스, 미션들이 있고, 각 (코스, 미션)에는 하나의 Pairs 가 있다.
    private final Map<Level, List<Pairs>> pairRepository = new HashMap<>();

    public Pairs createPairs(PairsInformation information, CrewMembers crewMembers) {
        Pairs pairs = matchingUntilSuccess(information, crewMembers);
        put(information.level(), pairs);
        return pairs;
    }

    public void clear() {
        pairRepository.clear();
    }

    public Pairs findPairsByInformation(PairsInformation information) {
        Level level = information.level();
        Course course = information.course();
        Mission mission = information.mission();

        if (!pairRepository.containsKey(level)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PAIRS.getMessage());
        }
        for (Pairs pairs : pairRepository.get(level)) {
            if (pairs.hasSameInformation(information)) {
                return pairs;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.INVALID_PAIRS.getMessage());
    }

    private void put(Level level, Pairs pairs) {
        if (!pairRepository.containsKey(level)) {
            pairRepository.put(level, new ArrayList<>());
        }
        pairRepository.get(level).add(pairs);
    }

    private Pairs matchingUntilSuccess(PairsInformation information, CrewMembers crewMembers) {
        for (int i = 0; i < 3; i++) { // 최대 시도 횟수 3
            List<String> names = shuffle(crewMembers.getMemberNames());
            Pairs pairs = matching(names, information);
            if (!hasDuplicatedPair(pairs, information)) {
                return pairs;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.MATCHING_FAILED.getMessage());
    }

    private boolean hasDuplicatedPair(Pairs pairs, PairsInformation information) {
        Level level = information.level();
        if (!pairRepository.containsKey(level)) {
            return false;
        }
        for (Pairs other : pairRepository.get(level)) {
            if (other.hasSameInformation(information) && other.hasSamePair(pairs)) {
                return true;
            }
        }
        return false;
    }

    private Pairs matching(List<String> names, PairsInformation information) {
        Course course = information.course();
        return new Pairs(matching(names, course), information);
    }

    private List<Pair> matching(List<String> names, Course course) {
        if (names.size() % 2 == 1) {
            return oddCase(names, course);
        }
        List<Pair> pairList = new ArrayList<>();
        List<Crew> members = new ArrayList<>();
        for (String name : names) {
            members.add(new Crew(name, course));
            if (members.size() == 2) {
                pairList.add(new Pair(new ArrayList<>(members)));
                members.clear();
            }
        }

        return pairList;
    }

    private List<Pair> oddCase(List<String> names, Course course) {
        List<Pair> pairList = new ArrayList<>();
        List<Crew> members = new ArrayList<>();

        for (int i = 0; i < names.size() - 3; i++) {
            members.add(new Crew(names.get(i), course));
            if (members.size() == 2) {
                pairList.add(new Pair(new ArrayList<>(members)));
                members.clear();
            }
        }

        for (int i = names.size() - 3; i < names.size(); i++) {
            members.add(new Crew(names.get(i), course));
        }
        pairList.add(new Pair(new ArrayList<>(members)));
        return pairList;
    }

    private List<String> shuffle(List<String> names) {
        return Randoms.shuffle(names);
    }

    public boolean hasSameInformationsPair(PairsInformation information) {
        Level level = information.level();

        if (!pairRepository.containsKey(level)) {
            return false;
        }

        for (Pairs pairs : pairRepository.get(level)) {
            if (pairs.hasSameInformation(information)) {
                return true;
            }
        }

        return false;
    }
}
