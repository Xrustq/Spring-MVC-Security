package com.astarus.testovoe.service;

import com.astarus.testovoe.dao.DocumentDAO;
import com.astarus.testovoe.model.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentDAO documentDAO;


    @Override
    public void addDocument(Document document) {
        documentDAO.addDocument(document);
    }

    @Override
    public void updateDocument(Document document) {
        documentDAO.updateDocument(document);
    }

    @Override
    public void removeDocumentById(int id) {
        documentDAO.removeDocumentById(id);
    }

    @Override
    public Document getDocumentById(int id) {
        return documentDAO.getDocumentById(id);
    }

    @Override
    public List<Document> listDocumentsById() {
        return documentDAO.listDocumentsById();
    }

    public List<Document> listDocumentsByName() {
        return documentDAO.listDocumentsByName();
    }

    @Override
    public List<Document> listDocumentsByCreated() {
        return documentDAO.listDocumentsByCreated();
    }

    @Override
    public List<Document> listDocumentsByAuthor() {
        return documentDAO.listDocumentsByAuthor();
    }

    @Override
    public List<Document> listDocumentsByDescription() {
        return documentDAO.listDocumentsByCreated();
    }


}
