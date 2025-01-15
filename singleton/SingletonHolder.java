package singleton;

public class SingletonHolder {
    private SingletonHolder() {}

    private static class SingletonHelper {
        private static final SingletonHolder INSTANCE = new SingletonHolder();
    }

    public static SingletonHolder getInstance() {
        return SingletonHelper.INSTANCE;
    }
}