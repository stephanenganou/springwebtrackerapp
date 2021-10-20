package com.simpleapp.havefun.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Stephane, Nganou Wafo
 * Handle the logs form process.
 */
@Controller
public class LoginController {

    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage(@RequestParam(value = "error", required = false) boolean isError,
                                  Model theModel) {
        if(isError){
            theModel.addAttribute("loginError", true);
        }
        return "plain-login";
    }

    // mapping for /access-denied
    @GetMapping("/access-denied")
    public String showAccessDeniedPage(){

        return "access-denied";
    }
}
