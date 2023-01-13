package org.itstep.msk.app.controller;

import lombok.RequiredArgsConstructor;
import org.itstep.msk.app.exeption.CustomerException;
import org.itstep.msk.app.service.ServiceCustomer;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class ForgotPasswordController {

    private final ServiceCustomer serviceCustomer;

    @GetMapping(value = "/forgot_password",produces = MediaType.TEXT_HTML_VALUE)
    public String resetPasswordFormRequest() {
        return "forgot_password_form";
    }

    @PostMapping("/forgot_password")
    public String processFormRequest(HttpServletRequest servletRequest, Model model) {
        try {
            String email = servletRequest.getParameter("email");
            String token = serviceCustomer.updateResetPasswordToken(email);
        } catch (CustomerException customerException) {
            model.addAttribute("error", customerException.getMessage());
        }
        return "forgot_password_form";
    }
}
