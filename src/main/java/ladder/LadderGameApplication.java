package ladder;

import java.util.List;

public class LadderGameApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        List<Participant> participants = inputView.getParticipants();
        List<LadderItems> ladderItems = inputView.getLadderItems(participants.size());
        int height = inputView.getLadderHeight();
        LadderGame ladderGame = new LadderGame(participants, ladderItems, height);
//        OutputView outputView = new OutputView(ladderGame);
//        outputView.printLadderGame();
        List<LadderGameResult> ladderGameResults = ladderGame.play();
        String participantName = inputView.getLadderGameResultParticipant();
        System.out.println(participantName);
        System.out.println("aaa");
    }
}
