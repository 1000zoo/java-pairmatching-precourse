package pairmatching.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pairmatching.domain.Course;
import pairmatching.domain.CrewMembers;
import pairmatching.parser.CrewParser;

public class CrewRepository {

    private final static Map<Course, String> pathMap = Map.of(
            Course.BACKEND, "src/main/resources/backend-crew.md",
            Course.FRONTEND, "src/main/resources/frontend-crew.md"
    );

    private final Map<Course, CrewMembers> repository = new HashMap<>();

    public void init() {
        for (Course course : pathMap.keySet()) {
            loadData(course);
        }
    }

    private void loadData(Course course) {
        List<String> names = CrewParser.parser(pathMap.get(course));
        repository.put(course, CrewMembers.of(names, course));
    }

    public CrewMembers findCrewMembersByCourseName(String courseName) {
        return repository.get(Course.findByName(courseName));
    }

}
