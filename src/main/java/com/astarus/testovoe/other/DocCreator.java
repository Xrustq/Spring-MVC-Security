package com.astarus.testovoe.other;

import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.exceptions.InvalidFormatException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;

import java.io.*;

/**
 * Class for generation MS Word document.
 *
 * @author Rustam Mirgazizov
 * @version 1.0
 */

public class DocCreator {
    public static void create(String name) throws IOException, Docx4JException {

        WordprocessingMLPackage wordMLPackage;
        wordMLPackage = WordprocessingMLPackage.createPackage();
        wordMLPackage.getMainDocumentPart().addParagraphOfText("Hello Word!");
        wordMLPackage.save(new java.io.File("D:/"+ name + ".docx"));
    }
}
