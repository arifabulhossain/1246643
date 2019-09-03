package com.aharif.hospitalManagement.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = "/")
    public String displayIndex(){

        return "dashboard";
    }

    @GetMapping("/about")
    public String accessDenied() {

        return "about";
    }


    @GetMapping("/profile")
    public String accessProfile() {

        return "profile";
    }


    @GetMapping("/vission")
    public String accessVission() {

        return "vission";
    }



    @GetMapping("/service")
    public String accessService() {

        return "service";
    }

}
