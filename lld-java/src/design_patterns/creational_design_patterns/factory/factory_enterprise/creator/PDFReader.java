package design_patterns.creational_design_patterns.factory.factory_enterprise.creator;

import design_patterns.creational_design_patterns.factory.factory_enterprise.product.Document;
import design_patterns.creational_design_patterns.factory.factory_enterprise.product.PDFDocument;

public class PDFReader extends DocumentReaderFactory {
    @Override
    protected Document createDocument() {
        return new PDFDocument();
    }
}
