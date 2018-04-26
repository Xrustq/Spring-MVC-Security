package com.astarus.testovoe.dao;

import com.astarus.testovoe.model.Document;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



@Repository
public class DocumentDAOImpl implements DocumentDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addDocument(Document document) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();

        session.persist(document);

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void updateDocument(Document document) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();

        session.update(document);

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void removeDocumentById(int id) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();

        Document document = (Document) session.get(Document.class, new Long(id));

        session.delete(document);

        session.getTransaction().commit();
        session.close();

    }

    @Override
    public Document getDocumentById(int id) {
        Session session =this.sessionFactory.openSession();
        session.beginTransaction();

        Document document = (Document) session.get(Document.class, new Long(id));

        session.getTransaction().commit();
        session.close();
        return document;
    }

    @Override
    public List<Document> listDocumentsById() {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        List<Document> documentList = session.createQuery("from Document").list();
        session.getTransaction().commit();
        session.close();
        return documentList;
    }

    @Override
    public List<Document> listDocumentsByName() {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        List<Document> documentListByName = session.createQuery("from Document order by name").list();
        session.getTransaction().commit();
        session.close();
        return documentListByName;
    }

    @Override
    public List<Document> listDocumentsByCreated() {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        List<Document> documentListByCreated = session.createQuery("from Document order by created").list();
        session.getTransaction().commit();
        session.close();
        return documentListByCreated;
    }

    @Override
    public List<Document> listDocumentsByAuthor() {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        List<Document> documentListByAuthor = session.createQuery("from Document order by author").list();
        session.getTransaction().commit();
        session.close();
        return documentListByAuthor;
    }

    @Override
    public List<Document> listDocumentsByDescription() {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        List<Document> documentListByDescription = session.createQuery("from Document order by description").list();
        session.getTransaction().commit();
        session.close();
        return documentListByDescription;
    }
}
