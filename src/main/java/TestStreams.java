import ua.goit.hw10stream.SimpleStream;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TestStreams {
    public static void main(String[] args) {
        List<String> list = List.of("aaa", "bbbb", "abcc", "abc", "a", "cdr");
        System.out.println(SimpleStream.oddIndexesStrings(list));
        System.out.println(SimpleStream.sortUpperStrings(list));
        System.out.println(SimpleStream.getNumbers(new String[]{"1, 2, 0", "5"}));
        System.out.println(SimpleStream.generatePseudoRandom(25214903917l, 11l, (long) 2e48, 10l).limit(10).collect(Collectors.toList()));
        //System.out.println(SimpleStream.generatePseudoRandom(5, 11l, (long)16,10).limit(10).collect(Collectors.toList()));
    }
}
