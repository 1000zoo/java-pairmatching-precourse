package pairmatching.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pairmatching.domain.Course;
import pairmatching.domain.CrewMembers;
import pairmatching.domain.Level;
import pairmatching.domain.Pairs;

public class PairMatching {

    private final Map<Level, List<Pairs>> pairRepository = new HashMap<>();

    public void createPairs(String levelString, String missionString, CrewMembers crewMembers) {
        Course course = crewMembers.getCourse();
    }
}
