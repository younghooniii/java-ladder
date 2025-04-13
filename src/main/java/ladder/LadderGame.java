package ladder;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {
    private final List<Participant> participants;
    private final Ladder ladder;

    public LadderGame(List<Participant> participants, int height) {
        this.participants = participants;
        this.ladder = new Ladder(height, participants.size());
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public Ladder getLadder() {
        return ladder;
    }

}