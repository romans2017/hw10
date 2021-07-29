package ua.goit.hw10stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SimpleStream {

    public static String oddIndexesStrings(List<String> list) {
        StringBuilder stringBuilder = new StringBuilder();
        IntStream.range(0, list.size()).forEach(item -> {
            if (item % 2 == 1) {
                stringBuilder.append(item);
                stringBuilder.append(". ");
                stringBuilder.append(list.get(item));
                stringBuilder.append(", ");
            }
        });
        return stringBuilder.toString();
    }

    public static String sortUpperStrings(List<String> list) {
        return list.stream().map(String::toUpperCase).sorted(Comparator.reverseOrder()).collect(Collectors.joining(" "));
    }

    public static String getNumbers(String[] numbers) {
        return Arrays.stream(numbers).filter(item -> item.matches("[0-9]"))..sorted(Comparator.naturalOrder()).collect(Collectors.joining(", "));
    }

    public static Stream<Long>generatePseudoRandom(Long a, Long c, Long m, Long seed) {
        return Stream.iterate(seed, (Long x) -> (a * x + c) % m);
    }

}
