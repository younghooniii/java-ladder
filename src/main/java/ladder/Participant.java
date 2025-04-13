package ladder;

public class Participant {
    private final int MAX_LENGTH = 5;
    private final String name;

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
        return trimmed;
    }

    public String getName() {
        return name;
    }

}
