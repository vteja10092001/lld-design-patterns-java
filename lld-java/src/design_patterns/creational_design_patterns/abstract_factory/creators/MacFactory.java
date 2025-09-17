package design_patterns.creational_design_patterns.abstract_factory.creators;

import design_patterns.creational_design_patterns.abstract_factory.products.Button;
import design_patterns.creational_design_patterns.abstract_factory.products.CheckBox;
import design_patterns.creational_design_patterns.abstract_factory.products.MacButton;
import design_patterns.creational_design_patterns.abstract_factory.products.MacCheckBox;

public class MacFactory implements GUIFactory {
    @Override
    public CheckBox createCheckbox() {
        return new MacCheckBox();
    }

    @Override
    public Button createButton() {
        return new MacButton();
    }
}
