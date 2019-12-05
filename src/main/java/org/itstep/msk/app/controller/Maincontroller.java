package org.itstep.msk.app.controller;

import org.itstep.msk.app.entity.Customer;
import org.itstep.msk.app.repository.CustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class Maincontroller {

    @GetMapping("/")
    public String getIndex(){
        return "index";
    }

    @GetMapping("/denypage")
    public String deny (){
        return "redirect:/register";
    }


}

