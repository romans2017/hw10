package ua.goit.hw10stream;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
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
        return list.stream()
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining(" "));
    }

    public static String getNumbers(String[] numbers) {
        return Arrays.stream(numbers)
                .map(item -> item.replaceAll("\\D+", ",")) //get arrays of String numbers with comma as delimiter
                .flatMap(item -> Arrays.stream(item.split(","))) //get stream with String numbers
                .mapToInt(Integer::parseInt)//get IntStream to sort as numbers (not strings)
                .sorted()
                .mapToObj(String::valueOf)//convert to String for output
                .collect(Collectors.joining(", "));
    }

    public static Stream<Long> generatePseudoRandom(long a, long c, long m, long seed) {
        if (a > Long.MAX_VALUE / a) {
            BigInteger bigA = new BigInteger(String.valueOf(a));
            BigInteger bigC = new BigInteger(String.valueOf(c));
            BigInteger bigM = new BigInteger(String.valueOf(m));
            BigInteger bigSeed = new BigInteger(String.valueOf(seed));
            return Stream.iterate(bigSeed, (BigInteger x) -> bigA.multiply(x).add(bigC).mod(bigM).shiftRight(16))
                    .mapToLong(BigInteger::longValue)
                    .boxed();
        } else {
            return Stream.iterate(seed, x -> (a * x + c) % m);
        }
    }

    /*public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {

    }*/

}
