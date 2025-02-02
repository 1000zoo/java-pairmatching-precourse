package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class CrewMembers {

    private final List<Crew> members;
    private final Course course;

    private CrewMembers(List<Crew> members, Course course) {
        this.members = members;
        this.course = course;
    }

    public static CrewMembers of(List<String> names, Course course) {
        List<Crew> members = new ArrayList<>();

        for (String name : names) {
            members.add(new Crew(name, course));
        }

        return new CrewMembers(members, course);
    }

    public List<String> getMemberNames() {
        return members.stream().map(Crew::name).toList();
    }

    public Course getCourse() {
        return course;
    }
}
