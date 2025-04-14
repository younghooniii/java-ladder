package ladder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {
    private final List<Participant> participants;
    private final List<LadderItems> ladderItems;
    private final Ladder ladder;

    public LadderGame(List<Participant> participants, List<LadderItems> ladderItems, int height) {
        this.participants = participants;
        this.ladderItems = ladderItems;
        this.ladder = new Ladder(height, participants.size());
    }

    public LadderGame(List<Participant> participants, List<LadderItems> ladderItems, Ladder ladder) {
        this.participants = participants;
        this.ladderItems = ladderItems;
        this.ladder = ladder;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public List<LadderItems> getLadderItems() {
        return ladderItems;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public List<LadderGameResult> play() {
        for (Line line : ladder.getLines()) {
            List<Boolean> points = line.getPoints();
            for (int i = 0; i < points.size(); i++) {
                if (points.get(i)) {
                    Participant temp = participants.get(i);
                    participants.set(i, participants.get(i + 1));
                    participants.set(i + 1, temp);
                }
            }
        }

        return IntStream.range(0, participants.size())
                .mapToObj(i -> new LadderGameResult(participants.get(i), ladderItems.get(i)))
                .collect(Collectors.toList());
    }

}