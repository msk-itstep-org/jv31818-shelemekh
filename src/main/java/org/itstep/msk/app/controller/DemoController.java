package org.itstep.msk.app.controller;

import org.hibernate.mapping.ManyToOne;
import org.itstep.msk.app.entity.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.NamedStoredProcedureQueries;
import java.util.Map;

@Controller
@RequestMapping("/main")
public class DemoController {
    @RequestMapping(value = "/main",method = RequestMethod.GET)
    public String index(@RequestParam String name,
                          Map<String,Object> model
    ) {
        model.put("name",name);

        return "/main";
    }
}
