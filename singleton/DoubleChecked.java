package il.co.ilrd.book.singleton;

public class DoubleChecked {
    private static volatile DoubleChecked instance;

    private DoubleChecked() {}

    public static DoubleChecked getInstance() {
        if (instance == null) {
            synchronized (DoubleChecked.class) {
                if (instance == null) {
                    instance = new DoubleChecked();
                }
            }
        }
        return instance;
    }
}