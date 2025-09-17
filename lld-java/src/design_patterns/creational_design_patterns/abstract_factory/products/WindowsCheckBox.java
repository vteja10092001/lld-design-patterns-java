package design_patterns.creational_design_patterns.abstract_factory.products;

public class WindowsCheckBox implements CheckBox {

    private boolean checked = false;

    @Override
    public void render() {
        System.out.println("rendering WindowsCheckBox !");
    }

    @Override
    public void toggle() {
        checked = !checked;
        System.out.println("Windows checkbox is now " + (checked ? "checked" : "unchecked"));
    }
}
