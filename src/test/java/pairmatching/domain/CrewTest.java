package pairmatching.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CrewTest {

    @Test
    @DisplayName("크루 equals 판정 테스트")
    void equalsTest() {
        // given
        Crew crew1 = new Crew("지우", Course.BACKEND);
        Crew crew2 = new Crew("지우", Course.FRONTEND);
        Crew crew3 = new Crew("지우", Course.BACKEND);

        // when
        boolean result1 = crew1.equals(crew2);
        boolean result2 = crew1.equals(crew3);

        // then
        Assertions.assertThat(result1).isEqualTo(false);
        Assertions.assertThat(result2).isEqualTo(true);

    }

}