package org.itstep.msk.app.controller;

import org.itstep.msk.app.entity.Customer;
import org.itstep.msk.app.repository.CustomRepository;
import org.itstep.msk.app.service.PageServiceCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/register")
public class UserController {

    private final CustomRepository repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private PageServiceCustomer pageServiceCustomer;

    @Autowired
    public UserController(CustomRepository repo) {
        this.repo = repo;
      //  this.encoder = encoder;
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
    public String successfully(@Valid @ModelAttribute("customer") Customer customer, BindingResult result, RedirectAttributes attributes){
        if (result.hasErrors()) {
            return "register";
        }
      // String name =customer.getName();
    //    String email= customer.getEmail();
        String pass = passwordEncoder.encode(customer.getPassword());
     //  String  enc = encoder.encode(customer.getPassword());
        repo.save(customer);
        attributes.addFlashAttribute("message","The registration has been successfully passed ");
        return "registersuccess";
    }
    @GetMapping("/page/{pageNum}")
    public String listPage(@PathVariable(name = "pageNum") int pageNum,Model model){
        Page<Customer> page = pageServiceCustomer.listByPage(pageNum);
        List<Customer> list = page.getContent();
        long firstcount =(pageNum-1)* PageServiceCustomer.USER_PER_PAGE+1;
        long secodcount = firstcount* PageServiceCustomer.USER_PER_PAGE-1;
            if (secodcount> page.getTotalElements()){
                secodcount=page.getTotalElements();

            }
        model.addAttribute("currentpage",pageNum);
            model.addAttribute("totalPage",page.getTotalPages());
        model.addAttribute("firstcount",firstcount);
            model.addAttribute("secodcount",secodcount);
            model.addAttribute("totalItem",page.getTotalElements());
        model.addAttribute("customer",list);
        return "pagincustomer";
    }

}




