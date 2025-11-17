package ua.opnu;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.function.Predicate;

public class PredicateFilter {
    public static <T> T[] filter(T[] input, Predicate<T> p) {
        T[] result = (T[]) Array.newInstance(input.getClass().
                getComponentType(), input.length);

        int counter = 0;
        for (T i : input) {
            if (p.test(i)) {
                result[counter] = i;
                counter++;
            }
        }

        return Arrays.copyOfRange(result, 0, counter);
    }

}
