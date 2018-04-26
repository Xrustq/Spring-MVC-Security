package com.astarus.testovoe.dao;

import com.astarus.testovoe.model.Document;
import java.util.List;


public interface DocumentDAO {

    void addDocument(Document document);

    void updateDocument(Document document);

    void removeDocumentById(int id);

    Document getDocumentById(int id);

    List<Document> listDocumentsById();

    List<Document> listDocumentsByName();

    List<Document> listDocumentsByCreated();

    List<Document> listDocumentsByAuthor();

    List<Document> listDocumentsByDescription();
}
