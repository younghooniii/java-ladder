package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadderGameTest {
    @Test
    @DisplayName("Line이 False 일 때")
    void play1() {
        Participant participant1 = new Participant("A");
        Participant participant2 = new Participant("B");
        List<Participant> participants = List.of(participant1, participant2);

        LadderItems ladderItem1 = new LadderItems("꽝");
        LadderItems ladderItem2 = new LadderItems("당첨");
        List<LadderItems> ladderItems = List.of(ladderItem1, ladderItem2);

        Line line = new Line(List.of(true));

        Ladder ladder = new Ladder(List.of(line));

        LadderGame ladderGame = new LadderGame(participants, ladderItems, ladder);

        List<LadderGameResult> results = ladderGame.play();

        assertEquals("A", results.get(0).getParticipant().getName());
        assertEquals("꽝", results.get(0).getLadderItems().getName());
        assertEquals("B", results.get(1).getParticipant().getName());
        assertEquals("당첨", results.get(1).getLadderItems().getName());

    }

}
