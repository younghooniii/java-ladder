package ladder;

public class LadderGameResult {
    private final Participant participant;
    private final LadderItems ladderItems;

    public LadderGameResult(Participant participant, LadderItems ladderItems) {
        this.participant = participant;
        this.ladderItems = ladderItems;
    }

    public Participant getParticipant() {
        return participant;
    }

    public LadderItems getLadderItems() {
        return ladderItems;
    }

    @Override
    public String toString() {
        return getParticipant() + " : " + getLadderItems();
    }
}
