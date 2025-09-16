package design_patterns.creational_design_patterns.factory.factory_enterprise;

import design_patterns.creational_design_patterns.factory.factory_enterprise.creator.PDFReader;
import design_patterns.creational_design_patterns.factory.factory_enterprise.creator.TextReader;
import design_patterns.creational_design_patterns.factory.factory_enterprise.creator.WordReader;

public class FactoryDemo {
    public static void main(String[] args) {
        PDFReader pdfReader = new PDFReader();
        pdfReader.readDocument();

        TextReader textReader = new TextReader();
        textReader.readDocument();

        WordReader wordReader = new WordReader();
        wordReader.readDocument();
    }
}
