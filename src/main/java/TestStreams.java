import ua.goit.hw10stream.SimpleStream;

import java.util.List;

public class TestStreams {
    public static void main(String[] args) {
        List<String> list = List.of("qwer", "asdf", "dfvgfdbfd", "sfewf", "asdf", "dfvgfdbfd");
        System.out.println(SimpleStream.oddIndexesStrings(list));
        System.out.println(SimpleStream.sortUpperStrings(list));
    }
}
