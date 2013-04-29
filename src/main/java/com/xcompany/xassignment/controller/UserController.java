/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xcompany.xassignment.controller;

import com.xcompany.xassignment.dao.AbstractDao;
import com.xcompany.xassignment.model.Users;
import com.xcompany.xassignment.service.UserAccountService;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author bilalahmad
 */
@Controller
public class UserController {

    Logger logger = Logger.getLogger(AbstractDao.class);
    @Autowired
    private UserAccountService userAccountService;

    /////////////////////////////////////////// Users ///////////////////////////////////////////// 
    /////////////////////////////////////////// Read All ///////////////////////////////////////////// 
    //CRUD
    // Read All
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String readAllUsers(ModelMap modelMap) {
        modelMap.addAttribute("userList", userAccountService.readAllUsers());
        return "user/list";
    }

    /////////////////////////////////////////// Create /////////////////////////////////////////////    
    // Create Request
    @RequestMapping(value = "/users/create", method = RequestMethod.GET)
    public String createRequest(ModelMap modelMap) {
        userAccountService.createRequest();
        modelMap.addAttribute("user", new Users());
        return "user/cru";
    }
    // Create submit

    @RequestMapping(value = "/users/create", method = RequestMethod.POST)
    public String createSubmit(ModelMap modelMap, @Valid @ModelAttribute("user") Users user, BindingResult results) {
        if (results.hasErrors()) {
            modelMap.addAttribute("user", user);
            return "user/cru";
        }
        userAccountService.createUser(user);
        return "redirect:/users";
    }

    /////////////////////////////////////////// Delete /////////////////////////////////////////////    
    // Update Requestg
    @RequestMapping(value = "/users/{userId}/update", method = RequestMethod.GET)
    public String updateRequest(ModelMap modelMap, @PathVariable("userId") Long userId) {
        modelMap.addAttribute("user", userAccountService.readUser(userId));
        return "user/cru";
    }
    // Update Submit

    @RequestMapping(value = "/users/{userId}/update", method = RequestMethod.PUT)
    public String updateSubmit(ModelMap modelMap, @Valid @ModelAttribute("user") Users user, BindingResult results) {
        if (results.hasErrors()) {
            modelMap.addAttribute("user", user);
            return "user/cru";
        }
        userAccountService.updateUser(user);
        return "redirect:/users";
    }

    //Details
    // Read single
    @RequestMapping(value = "/users/{userId}/view", method = RequestMethod.GET)
    public String view(ModelMap modelMap, @PathVariable("userId") Long userId) {
        modelMap.addAttribute("user", userAccountService.readUser(userId));
        return "view";
    }

    /////////////////////////////////////////// Delete ///////////////////////////////////////////// 
    @RequestMapping(value = "/users/{userId}/delete", method = RequestMethod.DELETE)
    public String delete(ModelMap modelMap, @PathVariable("userId") Long userId) {
        userAccountService.deleteUser(userId);
        return "redirect:/users";
    }

    /////////////////////////////////////////// Login Page ///////////////////////////////////////////// 
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(ModelMap modelMap, HttpServletRequest request) {
        return "login";
    }

    /////////////////////////////////////////// Landing Page ///////////////////////////////////////////// 
    @RequestMapping(value = {"", "/", "/landing"}, method = RequestMethod.GET)
    public String landing(ModelMap mode, HttpServletRequest request) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        logger.info("User Name: " + auth.getName());
        for (Iterator<? extends GrantedAuthority> it = auth.getAuthorities().iterator(); it.hasNext();) {
            GrantedAuthority authority = it.next();
            logger.info("User Authority: " + authority.getAuthority());
        }
        return "landing";
    }
}
