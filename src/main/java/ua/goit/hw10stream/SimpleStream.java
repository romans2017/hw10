package ua.goit.hw10stream;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.*;

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
        BigInteger maxLong = BigInteger.valueOf(Long.MAX_VALUE);

        BigInteger bigA = BigInteger.valueOf(a);
        BigInteger bigC = BigInteger.valueOf(c);
        BigInteger bigM = BigInteger.valueOf(m);
        BigInteger bigSeed = BigInteger.valueOf(seed);

        return Stream.iterate(bigSeed, (BigInteger x) -> {
                    BigInteger xNext = bigA.multiply(x).add(bigC).mod(bigM);
                    if (xNext.compareTo(maxLong) > 0) {
                        xNext = xNext.shiftRight(16); //use bits higher then 16
                    }
                    return xNext;
                }
        ).mapToLong(BigInteger::longValue)
                .boxed();
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        List<T> firstList = first.collect(Collectors.toList());
        List<T> secondList = second.collect(Collectors.toList());

        return IntStream.range(0, Math.min(firstList.size(), secondList.size()))
                .mapToObj(i -> Stream.of(firstList.get(i), secondList.get(i)))
                .flatMap(item -> item);
    }

}
