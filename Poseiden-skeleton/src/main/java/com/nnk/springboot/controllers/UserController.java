package com.nnk.springboot.controllers;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.service.UserService;


@Controller
public class UserController {
    @Autowired
    private UserService userService;
    
    private static final Logger LOGGER = LogManager.getLogger(UserController.class);

    @RequestMapping("/user/list")
    public String home(Model model)
    {
        model.addAttribute("users", userService.findAll());
        LOGGER.info("All a User");
        return "user/list";
    }

    @GetMapping("/user/add")
    public String addUser(User user) {
    	   LOGGER.info("All a User");
        return "user/add";
    }

    @PostMapping("/user/validate")
    public String validate(@Valid @ModelAttribute("user")User user,
    		BindingResult result, Model model ,RedirectAttributes redirAttrs) {
    	
    	String  signupError = null;
    	
    	User existsUser = userService.findByUsername(user.getUsername()) ; 
    	 if (existsUser != null) {
             signupError = "The UserName already exists";
         }
    	 
         if (signupError == null) {
            userService.save(user);
            redirAttrs.addFlashAttribute("message", "You've successfully saved .");
            return "redirect:/user/list";
         }

         else {
             model.addAttribute("signupError", true);
         }

         return "user/add";

        

      }
    

    @GetMapping("/user/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        User user = userService.findbyId(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        user.setPassword("");
        model.addAttribute("user", user);
        LOGGER.info("Update a User By id");
        return "user/update";
    }

    @PostMapping("/user/update/{id}")
    public String updateUser(@PathVariable("id") Integer id, @Valid User user,
                             BindingResult result, Model model) {
    	
    	// TODO: check required fields, if valid call service to update User and
    			// return User list
    	User u =userService.findByUsername(user.getUsername());
    	String name;
    			if (result.hasErrors() && u != null ) {
    				
    				model.addAttribute("name", true);
    				user.setId(id);
    				return "user/update";
    			}
    			
    			
    		
    			if (u == null) {
    				userService.save(user);
        			model.addAttribute("user", userService.findAll());
        			LOGGER.info("Update and Save User ");
				}
    			
    			
    			
    		
    			return "redirect:/user/list";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id, Model model) {
        User user = userService.findbyId(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        userService.delete(user);
        model.addAttribute("users", userService.findAll());
        LOGGER.info("Delete a User");
        return "redirect:/user/list";
    }
}
