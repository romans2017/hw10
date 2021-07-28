package ua.goit.hw10stream;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
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

    public static Stream<Long>generatePseudoRandom(long c, long m, long seed) {
        UnaryOperator<Long> pseudoRandom = new UnaryOperator<Long>() {
            @Override
            public Long apply(Long aLong) {
                return null;
            }
        }
        return Stream.iterate(seed, )
    }

}
