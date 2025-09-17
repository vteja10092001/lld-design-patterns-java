package design_patterns.creational_design_patterns.abstract_factory.products;

public class MacCheckBox implements CheckBox {
    private boolean checked;

    @Override
    public void render() {
        System.out.println("rendering Mac checkbox !");
    }

    @Override
    public void toggle() {
        checked = !checked;
        System.out.println("Mac checkbox is now " + (checked ? "checked" : "unchecked"));
    }
}
