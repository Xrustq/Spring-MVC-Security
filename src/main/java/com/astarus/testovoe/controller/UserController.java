package com.astarus.testovoe.controller;

import com.astarus.testovoe.other.GenerateUUID;
import com.astarus.testovoe.dao.RoleDAO;
import com.astarus.testovoe.email.EmailConfig;
import com.astarus.testovoe.model.Role;
import com.astarus.testovoe.model.User;
import com.astarus.testovoe.service.SecurityService;
import com.astarus.testovoe.service.UserService;
import com.astarus.testovoe.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

/**
 * Controller for {@link com.astarus.testovoe.model.User}'s pages.
 *
 * @author Rustam Mirgazizov
 * @version 1.0
 */

@Controller
public class UserController {

    @Autowired
    public EmailConfig emailService;

    @Autowired
    public JavaMailSender emailSender;

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private RoleDAO roleDAO;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {        //model в параметрах была
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userForm.setPassword(bCryptPasswordEncoder.encode(userForm.getPassword()));
        userForm.setUuid(GenerateUUID.gen());

        userService.save(userForm);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(userForm.getEmail());
        message.setSubject("Confirmation of registration");
        message.setText("To confirm the registration, click on the link " +
                        "http://localhost:8080/checking/" + userForm.getUuid());

        emailSender.send(message);


        securityService.autoLogin(userForm.getEmail(), userForm.getConfirmPassword());

        return "redirect:/confirm";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Email or password is incorrect.");
        }

        if (logout != null) {
            model.addAttribute("message", "Logged out successfully.");
        }

        return "login";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "redirect:/documents";
    }

    @RequestMapping(value = "/confirm", method = RequestMethod.GET)
    public String confirm(Model model) {
        return "confirm";
    }

    @RequestMapping(value = "/confirmed", method = RequestMethod.GET)
    public String confirmed(Model model) {
        return "confirmed";
    }

    @RequestMapping(value = "/checking/{uuid}", method = RequestMethod.GET)
    public String checking(@ModelAttribute("userForm") User userForm, @PathVariable("uuid") String uuid) {

          User user = userService.findByUuid(uuid);
          user.setVerification(true);
          Set<Role> roles = new HashSet<>();
          roles.add(roleDAO.getOne(1L));
          user.setRoles(roles);
          userService.save(user);

        return "redirect:/confirmed";
    }

}
