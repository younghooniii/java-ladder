package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertThrows;

class InputViewTest {

    @Test
    @DisplayName("입력한 실행 결과 개수가 참가자 수와 다르면 예외 발생")
    void ladderItemsMismatch() {
        String input = "꽝,당첨\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        InputView inputView = new InputView();
        assertThrows(IllegalArgumentException.class, () -> {
            inputView.getLadderItems(3);
        });
    }

    @Test
    @DisplayName("참가자 이름이 겹치면 예외 발생")
    void participantsTest() {
        String input = "A,A\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        InputView inputView = new InputView();
        assertThrows(IllegalArgumentException.class, () -> {
            inputView.getParticipants();
        });
    }

}