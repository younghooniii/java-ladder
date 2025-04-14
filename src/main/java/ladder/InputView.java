package ladder;

import java.util.*;
import java.util.stream.Collectors;

class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public List<Participant> getParticipants() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String namesInput = scanner.nextLine();

        String[] names = namesInput.split(",");
        List<Participant> participants = new ArrayList<>();
        Set<String> uniqueNames = new HashSet<>();

        for (String name : names) {
            Participant participant = new Participant(name);
            if (uniqueNames.contains(participant.getName())) {
                throw new IllegalArgumentException("중복된 이름이 있습니다: " + participant.getName());
            }
            participants.add(new Participant(name));
            uniqueNames.add(participant.getName());
        }
        return participants;
    }

    public int getLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }

    public List<LadderItems> getLadderItems(int numOfParticipants) {
        System.out.println("실행 결과를 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String itemsInput = scanner.nextLine();
        String[] items = itemsInput.split(",");

        if (items.length != numOfParticipants) {
            throw new IllegalArgumentException("입력한 이름의 개수와 참가자의 수가 일치하지 않습니다.");
        }

        return Arrays.stream(items)
                .map(LadderItems::new)
                .collect(Collectors.toList());
    }

    public String getLadderGameResultParticipant() {
        System.out.println("결과를 보고 싶은 사람은?");
        return scanner.nextLine();
    }

}