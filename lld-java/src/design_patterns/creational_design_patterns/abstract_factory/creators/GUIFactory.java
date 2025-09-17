package design_patterns.creational_design_patterns.abstract_factory.creators;

import design_patterns.creational_design_patterns.abstract_factory.products.Button;
import design_patterns.creational_design_patterns.abstract_factory.products.CheckBox;

public interface GUIFactory {

    CheckBox createCheckbox();
    Button createButton();
}
