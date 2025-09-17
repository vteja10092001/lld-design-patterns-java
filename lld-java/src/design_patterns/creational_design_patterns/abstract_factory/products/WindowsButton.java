package design_patterns.creational_design_patterns.abstract_factory.products;

public class WindowsButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering Windows Button !");
    }

    @Override
    public void onClick() {
        System.out.println("Clicked Windows Button !");
    }
}
