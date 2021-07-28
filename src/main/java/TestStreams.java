import ua.goit.hw10stream.SimpleStream;

import java.util.List;

public class TestStreams {
    public static void main(String[] args) {
        List<String> list = List.of("qwer", "asdf", "dfvgfdbfd", "asdf", "asdf");
        System.out.println(SimpleStream.oddIndexes(list));
    }
}
