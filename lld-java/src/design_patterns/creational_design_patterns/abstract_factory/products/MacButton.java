package design_patterns.creational_design_patterns.abstract_factory.products;

public class MacButton implements Button {
    @Override
    public void render() {
        System.out.println("rendering MacButton !");
    }

    @Override
    public void onClick() {
        System.out.println("Clicked MacButton !");
    }
}
