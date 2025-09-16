package design_patterns.creational_design_patterns.singleton;

public class SingletonExample {
    private volatile static SingletonExample instance;

    private SingletonExample() {

    }

    public static SingletonExample getInstance() {
        if (instance == null) {
            synchronized (SingletonExample.class) {
                instance = new SingletonExample();
            }
        }

        return instance;
    }

    public static void main(String[] args) {
        SingletonExample singleton1 = SingletonExample.getInstance();
        SingletonExample singleton2 = SingletonExample.getInstance();

        // Both objects should point to the same instance
        System.out.println("Are both objects same? " + (singleton1 == singleton2));
    }
}
