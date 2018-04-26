package com.astarus.testovoe.controller;

import com.astarus.testovoe.model.Document;
import com.astarus.testovoe.model.User;
import com.astarus.testovoe.other.Date;
import com.astarus.testovoe.other.DocCreator;
import com.astarus.testovoe.service.DocumentService;
import com.astarus.testovoe.service.DocumentServiceImpl;
import org.apache.commons.io.IOUtils;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Controller for {@link Document}'s pages.
 *
 * @author Rustam Mirgazizov
 * @version 1.0
 */


@Controller
public class DocumentController {


    @Autowired
    private DocumentService documentService;

    @RequestMapping(value = "/documents", method = RequestMethod.GET)
    public String listDocumentsById(Model model){
        model.addAttribute("document", new Document());
        model.addAttribute("listDocumentsById", this.documentService.listDocumentsById());

        return "managedocuments";
    }

    @RequestMapping(value = "/documents/sortByName", method = RequestMethod.GET)
    public String listDocumentsByName(Model model){
        model.addAttribute("document", new Document());
        model.addAttribute("listDocumentsByName", this.documentService.listDocumentsByName());

        return "managedocuments";
    }

    @RequestMapping(value = "/documents/sortByCreated", method = RequestMethod.GET)
    public String listDocumentsByCreated(Model model){
        model.addAttribute("document", new Document());
        model.addAttribute("listDocumentsByCreated", this.documentService.listDocumentsByCreated());

        return "managedocuments";
    }

    @RequestMapping(value = "/documents/sortByAuthor", method = RequestMethod.GET)
    public String listDocumentsByAuthor(Model model){
        model.addAttribute("document", new Document());
        model.addAttribute("listDocumentsByAuthor", this.documentService.listDocumentsByAuthor());

        return "managedocuments";
    }

    @RequestMapping(value = "/documents/sortByDescription", method = RequestMethod.GET)
    public String listDocumentsByDescription(Model model){
        model.addAttribute("document", new Document());
        model.addAttribute("listDocumentsByDescription", this.documentService.listDocumentsByDescription());

        return "managedocuments";
    }

    @RequestMapping(value = "/documents/add", method = RequestMethod.POST)
    public String addDocument(Model model, @ModelAttribute("document") Document document,
                              @ModelAttribute("userForm") User userForm,@RequestParam("file") CommonsMultipartFile file)
                                throws IOException, Docx4JException {

            model.addAttribute("document", new Document());
            model.addAttribute("listDocumentsById", this.documentService.listDocumentsById());

            Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();

            file = document.getFile();

            document.setAuthor(loggedInUser.getName());
            document.setCreated(Date.date());

            DocCreator.create(document.getName());

            file.transferTo(new File("D:/tmp/" + document.getName() + ".docx"));


            document.setFile(file);

            this.documentService.addDocument(document);

        return "redirect:/documents";
    }

    @RequestMapping(value = "download/{id}", method = RequestMethod.GET)
    public String DownloadDocument(@PathVariable("id") int id, HttpServletResponse response, Model model) throws IOException {
        Document document = documentService.getDocumentById(id);
        response.setContentType(document.getName());
        response.setContentLength(document.getFile().getBytes().length);
        response.setHeader("Content-Disposition","attachment; filename=\"" + document.getName()+".docx" +"\"");

        OutputStream out = response.getOutputStream();
        IOUtils.copy(document.getFile().getInputStream(), out);
        out.flush();
        out.close();
        return "redirect:/documents";
    }

    @RequestMapping("/remove/{id}")
    public String removeDocument(@PathVariable("id") int id){
        this.documentService.removeDocumentById(id);

        return "redirect:/documents";
    }
}
