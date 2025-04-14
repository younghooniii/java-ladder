package ladder;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private final int NAME_WIDTH = 5;
    private final LadderGame ladderGame;

    public OutputView (LadderGame ladderGame) {
        this.ladderGame = ladderGame;
    }

    public void printLadderGame() {
        System.out.println("사다리 결과:");
        printParticipants();
        printLadderLines();
        printLadderItems();
    }

    public void printLadderGameResult(List<LadderGameResult> ladderGameResults, String participantName) {
        if (participantName.equals("all")) {
            ladderGame.getParticipants().forEach(participant -> System.out.println(participant.toString()));
            return;
        }
        LadderGameResult ladderGameResult = ladderGameResults.stream()
                .filter(result -> result.getParticipant().getName().equals(participantName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 참가자가 없습니다."));
        System.out.println(ladderGameResult.toString());
    }

    public void printParticipants() {
        String participantsRow = ladderGame.getParticipants().stream()
                .map(participant -> String.format("%-" + NAME_WIDTH + "s", participant.getName()))
                .collect(Collectors.joining(" "));
        System.out.println(participantsRow);
    }

    public void printLadderLines() {
        ladderGame.getLadder().getLines().forEach(line -> System.out.println(line.draw()));
    }

    public void printLadderItems() {
        String itemsRow = ladderGame.getLadderItems().stream()
                .map(item -> String.format("%-" + NAME_WIDTH + "s", item.getName()))
                .collect(Collectors.joining(" "));
        System.out.println(itemsRow);
    }

}
