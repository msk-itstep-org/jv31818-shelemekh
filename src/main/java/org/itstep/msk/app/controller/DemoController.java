package org.itstep.msk.app.controller;

import org.hibernate.mapping.ManyToOne;
import org.itstep.msk.app.entity.Customer;
import org.itstep.msk.app.repository.CustomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/main")
public class DemoController {
    @Autowired
    private CustomRepo customRepo;


    @RequestMapping(value = "/main",method = RequestMethod.GET)
    public String index(@RequestParam String name,
                          Map<String,Object> model
    ) {
        model.put("name",name);

        return "/main";

    }
    @PostMapping("/register")
    @ResponseBody
    public List<Customer> register(){
        Optional<Customer> optional = null ;

        Optional<Customer> cust = customRepo.findById(optional.get().getId());


        return register();

    }
}
