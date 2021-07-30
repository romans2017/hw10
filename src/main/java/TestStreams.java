import ua.goit.hw10stream.SimpleStream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStreams {
    public static void main(String[] args) {
        List<String> list = List.of("aaa", "bbbb", "abcc", "abc", "a", "cdr");
        System.out.println(SimpleStream.oddIndexesStrings(list));
        System.out.println(SimpleStream.sortUpperStrings(list));
        System.out.println(SimpleStream.getNumbers(new String[]{"1, 2, 0", "5dgd152ujy45"}));
        System.out.println(SimpleStream.generatePseudoRandom(25214903917L, 11L, (long) 2e48, 10L).limit(20).collect(Collectors.toList()));
        System.out.println(SimpleStream.generatePseudoRandom(5, 11L, (long) 2e16, 10).limit(20).collect(Collectors.toList()));
        System.out.println(SimpleStream.zip(Stream.of(1, 2), Stream.of("A", "B", "C", "D")).collect(Collectors.toList()));
    }
}
