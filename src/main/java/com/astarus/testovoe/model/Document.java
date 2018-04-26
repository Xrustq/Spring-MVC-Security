package com.astarus.testovoe.model;


import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;

/**
 * Simple JavaBean domain object that represents a Document.
 *
 * @author Rustam Mirgazizov
 * @version 1.0
 */

@Entity
@Table(name = "documents")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "created")
    private String created;

    @Column(name = "author")
    private String author;

    @Column(name = "description")
    private String description;

    @Lob
    @Column(name = "file")
    private CommonsMultipartFile file;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CommonsMultipartFile getFile() {
        return file;
    }

    public void setFile(CommonsMultipartFile file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", created='" + created + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", file=" + file +
                '}';
    }
}
