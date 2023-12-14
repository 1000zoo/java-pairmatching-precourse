package pairmatching.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LevelTest {

    @Test
    @DisplayName("레벨로 Level enum 불러오기")
    void findByStringTest() {
        // given
        String origin = "레벨1";
        Level answer = Level.LEVEL1;
        // when
        Level result = Level.findByString(origin);

        // then
        assertThat(result).isEqualTo(answer);

    }

    @Test
    @DisplayName("유효하지 않은 레벨")
    void invalidLevel() {

        assertThrows(
                IllegalArgumentException.class,
                () -> Level.findByString("레벨0")
        );

    }
}