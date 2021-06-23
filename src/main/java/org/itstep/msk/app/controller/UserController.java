package org.itstep.msk.app.controller;

import org.itstep.msk.app.entity.Customer;
import org.itstep.msk.app.repository.CustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class UserController {

    private final CustomRepository repo;
    private final PasswordEncoder encoder;

    @Autowired
    public UserController(CustomRepository repo, PasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

    //Get login page and fill it with  user's credentials
    @GetMapping("/login")
    public String Login(Model model){
        model.addAttribute("customer", new Customer());
        return "register";
    }

    /*
    Save in database customer with parameters  name , password.
    And if credentials are valid, return html page with successfully registration
 */
    @PostMapping("/login")
    public String successfully( @Valid @ModelAttribute("customer") Customer customer,BindingResult result){
        if (result.hasErrors()) {
            return "register";
        }
       String name =customer.getName();
        String email= customer.getEmail();
        String pass = encoder.encode(customer.getPassword());
     //  String  enc = encoder.encode(customer.getPassword());
        repo.save(customer);
        return "registersuccess";
    }
}




