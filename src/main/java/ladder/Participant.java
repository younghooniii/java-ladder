package ladder;

public class Participant {
    private final String ALL_NAME = "all";
    private final int MAX_LENGTH = 5;
    private final String name;
    private LadderItems ladderItems;

    public Participant(String name) {
        this.name = validateName(name);
    }

    public String validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("빈 이름은 입력할 수 없습니다.");
        }
        String trimmed = name.trim();
        if (trimmed.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("참가자 이름은 최대 5글자까지 가능합니다");
        }
        if (trimmed.equals(ALL_NAME)) {
            throw new IllegalArgumentException("참가자 이름은 all일 수 없습니다.");
        }
        return trimmed;
    }

    public String getName() {
        return name;
    }

    public LadderItems getLadderItems() {
        return ladderItems;
    }

    public void setLadderItems(LadderItems ladderItems) {
        this.ladderItems = ladderItems;
    }

}
