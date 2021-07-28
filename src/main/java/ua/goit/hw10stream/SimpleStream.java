package ua.goit.hw10stream;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

}
