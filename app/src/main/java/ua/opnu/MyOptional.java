package ua.opnu;

public class MyOptional<T> {
    private T value;
    private boolean present;

    public MyOptional() {
        this.present = false;
        this.value = null;
    }

    public MyOptional(T value) {
        if (value == null) {
            throw new IllegalArgumentException("MyOptional не приймає null");
        }
        this.value = value;
        this.present = true;
    }

    public boolean isPresent() {
        return this.present;
    }

    public boolean isEmpty() {
        return !isPresent();
    }

    public T get() {
        if (isEmpty()) {
            throw new IllegalStateException("Значення немає");
        }
        return value;
    }

    public T orElse(T defaultValue) {
        if (isPresent()) {
            return value;
        }
        return defaultValue;
    }

    @Override
    public String toString() {
        if (isPresent()) {
            return "MyOptional[Value=" + value + "]";
        } else {
            return "MyOptional[empty]";
        }
    }

}
