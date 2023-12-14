package pairmatching.domain;

import java.util.Arrays;

public enum Course {
    BACKEND("백엔드"), FRONTEND("프론트엔드");

    private final String name;

    Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Course findByName(String name) {
        return Arrays.stream(values())
                .filter(course -> name.equals(course.name))
                .findAny()
                .orElseThrow();
    }
}
