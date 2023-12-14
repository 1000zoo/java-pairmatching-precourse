package pairmatching.domain;

public record Crew(String name, Course course) {

    @Override
    public String toString() {
        return name;
    }
}
