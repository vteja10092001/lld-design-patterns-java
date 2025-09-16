package design_patterns.creational_design_patterns.factory.factory_enterprise.product;

public class WordDocument implements Document {

    @Override
    public void open() {
        System.out.println("Opening Word Document Data...");

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() {
        System.out.println("Closing Word Document Data...");

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void printDocument() {
        System.out.println("Printing Word Document Data...");

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
