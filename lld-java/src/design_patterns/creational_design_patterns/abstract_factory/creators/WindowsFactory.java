package design_patterns.creational_design_patterns.abstract_factory.creators;

import design_patterns.creational_design_patterns.abstract_factory.products.Button;
import design_patterns.creational_design_patterns.abstract_factory.products.CheckBox;
import design_patterns.creational_design_patterns.abstract_factory.products.WindowsButton;
import design_patterns.creational_design_patterns.abstract_factory.products.WindowsCheckBox;


public class WindowsFactory implements GUIFactory {
    @Override
    public CheckBox createCheckbox() {
        return new WindowsCheckBox();
    }

    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}
