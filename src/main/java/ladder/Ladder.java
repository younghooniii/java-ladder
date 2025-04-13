package ladder;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

class Ladder {
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public Ladder(int height, int countOfParticipants) {
        this(IntStream.range(0, height)
                .mapToObj(i -> new Line(countOfParticipants))
                .collect(Collectors.toList()));
    }

    public List<Line> getLines() {
        return lines;
    }

}
