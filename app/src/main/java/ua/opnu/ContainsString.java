package ua.opnu;

public class ContainsString {
    public static <T extends Comparable<T>,
            V extends T> boolean contains(T[] array, V element) {

        for (T item : array)
            if (item != null && item.equals(element))
                return true;

        return false;
    }
}
