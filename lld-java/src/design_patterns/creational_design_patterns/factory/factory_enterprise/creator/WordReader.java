package design_patterns.creational_design_patterns.factory.factory_enterprise.creator;

import design_patterns.creational_design_patterns.factory.factory_enterprise.product.Document;
import design_patterns.creational_design_patterns.factory.factory_enterprise.product.WordDocument;

public class WordReader extends DocumentReaderFactory {
    @Override
    protected Document createDocument() {
        return new WordDocument();
    }
}
