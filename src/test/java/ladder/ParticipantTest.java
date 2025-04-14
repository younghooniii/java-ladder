package ladder;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ParticipantTest {

    @Test
    @DisplayName("비어있는 이름 또는 null인 경우 예외 발생")
    void testValidateName1() {
        assertThrows(IllegalArgumentException.class, () -> new Participant(null));
        assertThrows(IllegalArgumentException.class, () -> new Participant("   "));
    }

    @Test
    @DisplayName("이름이 최대 5글자를 초과 하는 경우 예외 발생")
    void testValidateName2() {
        assertThrows(IllegalArgumentException.class, () -> new Participant("abcdef"));
    }

    @Test
    @DisplayName("이름이 all인 경우 예외 발생")
    void testValidateName3() {
        assertThrows(IllegalArgumentException.class, () -> new Participant("all"));
    }
}
