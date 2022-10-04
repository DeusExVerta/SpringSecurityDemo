package com.Howard.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;

import com.Howard.dto.UserDTO;
import com.Howard.entity.User;
import com.Howard.service.UserService;

import lombok.AllArgsConstructor;



@Controller
@AllArgsConstructor(onConstructor=@__(@Autowired))
public class AuthController {

	private UserService userService;
	
    // handler method to handle home page request
    @GetMapping("/index")
    public String home(){
        return "index";
    }
    
    // handler method to handle login request  
    @GetMapping("/login")
    public String loginPage()
    {
    	return "login";
    }

    // handler method to handle user registration form request
    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        // create model object to store form data
        model.addAttribute("user", new UserDTO());
        return "register";
    }
    
    // handler method to handle user registration form submit request
    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDTO userDto,
                               BindingResult result,
                               Model model){
        User existingUser = userService.findUserByEmail(userDto.getEmail());

        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
            result.rejectValue("email", null,
                    "There is already an account registered with the same email");
        }

        if(result.hasErrors()){
            model.addAttribute("user", userDto);
            return "/register";
        }

        userService.saveUser(userDto);
        return "redirect:/register?success";
    }
    
    // handler method to handle list of users
    @GetMapping("/users")
    public String users(Model model){
        model.addAttribute("users", userService.findAllUsers());
        return "users";
    }
    
    
}