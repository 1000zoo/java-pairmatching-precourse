package pairmatching;

import java.util.List;
import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.Pair;

public class TestUtils {

    public static Pair getPair(List<String> names) {
        return new Pair(getCrewMembers(names));
    }

    private static List<Crew> getCrewMembers(List<String> names) {
        return names.stream().map(TestUtils::getBackendCrew).toList();
    }

    private static Crew getBackendCrew(String name) {
        return new Crew(name, Course.BACKEND);
    }
}
