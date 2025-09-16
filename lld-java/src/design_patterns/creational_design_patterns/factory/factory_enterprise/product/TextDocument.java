package design_patterns.creational_design_patterns.factory.factory_enterprise.product;

public class TextDocument implements Document {

    @Override
    public void open() {
        System.out.println("Opening Text Document Data...");

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() {
        System.out.println("Closing Text Document Data...");

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void printDocument() {
        System.out.println("Printing Text Document Data...");

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
