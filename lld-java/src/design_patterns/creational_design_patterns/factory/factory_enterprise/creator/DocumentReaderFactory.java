package design_patterns.creational_design_patterns.factory.factory_enterprise.creator;

import design_patterns.creational_design_patterns.factory.factory_enterprise.product.Document;

public abstract class DocumentReaderFactory {

    protected abstract Document createDocument();

    public void readDocument() {
        Document doc = createDocument();

        doc.open();
        doc.printDocument();
        doc.close();

        System.out.println("Document read completed!");
        System.out.println();
    }
}
