package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class OutputViewTest {
    @Test
    @DisplayName("없는 참가자 조회 시 에러")
    void printLadderGameResult1() {
        Participant participant1 = new Participant("A");
        List<Participant> participants = List.of(participant1);
        LadderItems ladderItems1 = new LadderItems("1");
        List<LadderItems> ladderItems = List.of(ladderItems1);
        LadderGame ladderGame = new LadderGame(participants, ladderItems, 1);
        LadderGameResult ladderGameResult = new LadderGameResult(participant1, ladderItems1);
        List<LadderGameResult> ladderGameResults = List.of(ladderGameResult);
        OutputView outputView = new OutputView(ladderGame);
        assertThrows(IllegalArgumentException.class, () -> {
            outputView.printLadderGameResult(ladderGameResults, "B");
        });
    }

    @Test
    @DisplayName("All 조회")
    void printLadderGameResult2() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        Participant participant1 = new Participant("A");
        Participant participant2 = new Participant("B");
        List<Participant> participants = List.of(participant1, participant2);
        LadderItems ladderItems1 = new LadderItems("1");
        LadderItems ladderItems2 = new LadderItems("2");
        List<LadderItems> ladderItems = List.of(ladderItems1, ladderItems2);
        LadderGame ladderGame = new LadderGame(participants, ladderItems, 1);
        LadderGameResult ladderGameResult1 = new LadderGameResult(participant1, ladderItems1);
        LadderGameResult ladderGameResult2 = new LadderGameResult(participant2, ladderItems2);
        List<LadderGameResult> ladderGameResults = List.of(ladderGameResult1, ladderGameResult2);
        OutputView outputView = new OutputView(ladderGame);
        outputView.printLadderGameResult(ladderGameResults, "all");
        String output = outputStream.toString();
        System.setOut(originalOut);
        String[] lines = output.split(System.lineSeparator());
        assert lines.length == 2;
    }
}
