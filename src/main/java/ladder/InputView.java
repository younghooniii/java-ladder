package ladder;

import java.util.*;

class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public List<Participant> getParticipants() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String namesInput = scanner.nextLine();

        String[] names = namesInput.split(",");
        List<Participant> participants = new ArrayList<>();

        for (String name : names) {
            participants.add(new Participant(name));
        }
        return participants;
    }

    public int getLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }
}