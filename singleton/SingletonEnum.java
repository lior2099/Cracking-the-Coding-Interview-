package il.co.ilrd.book.singleton;

public enum SingletonEnum {
    INSTANCE;

    public void doSomething() {
        System.out.println("Singleton Enum instance is doing something!");
    }
}

// Usage
//public class Main {
//    public static void main(String[] args) {
//        SingletonEnum instance = SingletonEnum.INSTANCE;
//        instance.doSomething();
//    }
//}


