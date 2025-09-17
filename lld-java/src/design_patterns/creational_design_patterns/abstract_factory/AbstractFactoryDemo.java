package design_patterns.creational_design_patterns.abstract_factory;

import design_patterns.creational_design_patterns.abstract_factory.creators.GUIFactory;
import design_patterns.creational_design_patterns.abstract_factory.creators.MacFactory;
import design_patterns.creational_design_patterns.abstract_factory.creators.WindowsFactory;

public class AbstractFactoryDemo {
    public static void main(String[] args) {
        GUIFactory guiFactory = new WindowsFactory();
        guiFactory.createButton().render();
        guiFactory.createCheckbox().render();

        guiFactory = new MacFactory();
        guiFactory.createButton().render();
        guiFactory.createCheckbox().render();

    }
}
