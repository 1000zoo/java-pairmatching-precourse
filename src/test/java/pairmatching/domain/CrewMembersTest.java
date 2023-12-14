package pairmatching.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CrewMembersTest {

    private final List<String> nameList = List.of("지우", "이슬");
    private final Course course = Course.BACKEND;

    @Test
    @DisplayName("이름 리스트를 잘 불러오는 지 확인")
    void getMemberNamesTest() {
        // given
        CrewMembers members = CrewMembers.of(nameList, course);

        // when
        List<String> nameList = members.getMemberNames();

        // then
        assertThat(nameList.size()).isEqualTo(nameList.size());
    }

}