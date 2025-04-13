package ladder;

import java.util.stream.Collectors;

public class OutputView {
    private final int NAME_WIDTH = 5;
    private final LadderGame ladderGame;

    public OutputView (LadderGame ladderGame) {
        this.ladderGame = ladderGame;
    }

    public void printResult() {
        System.out.println("사다리 결과:");
        printParticipants();
        printLadder();
    }

    public void printParticipants() {
        String nameRow = ladderGame.getParticipants().stream()
                .map(participant -> String.format("%-" + NAME_WIDTH + "s", participant.getName()))
                .collect(Collectors.joining(" "));
        System.out.println(nameRow);
    }

    public void printLadder() {
        ladderGame.getLadder().getLines().forEach(line -> System.out.println(line.draw()));
    }

}
