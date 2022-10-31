package com.example.teleprogram.controllers;

import com.example.teleprogram.entities.Teleprogram;
import com.example.teleprogram.services.*;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.expression.Arrays;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/")
public class ChannelController {

    private AccessService accessService;
    private AdminService adminService;
    private ViewerService viewerService;
    private TVProgrammService tvProgrammService;
    private  ChannelService channelService;
    @Bean
    ChannelService getChannelService () {
        return new ChannelService ();
    }

    @GetMapping("/")
    public String LogIn(){
        return "authorize";
    }

    @GetMapping("/access")
    public String authorization(String login, String password, Model model){
        if(accessService.access(login, password).equals("viewer")){
            return "viewerSite";
        }
        if (accessService.access(login,password).equals("admin")){
            return "adminSite";
        }
        model.addAttribute("a", accessService.access(login,password));
        model.addAttribute("b",password);
        model.addAttribute("c",login);
        return "UserNotFound";
    }

    @GetMapping("/viewer")
    public String viewerSite(){return "viewerSite";}
    @GetMapping("/admin")
    public String adminSite(){return "adminSite";}

    @GetMapping("/tvprogramm")
    public String viewProgramm(Model model){
        model.addAttribute("programm",viewerService.showProgramm());
        return "tvProgramm";
    }

    @GetMapping("/menu")
    public String viewChannels(Model model) {
        model.addAttribute("channel",viewerService.showChannels());
        return "channelsMenu";
    }

    @GetMapping("/alphabet")
    public String sortChannels(Model model) {
        model.addAttribute("sorted",viewerService.sortChannels());
        return "alphabetSort";
    }

    @GetMapping("/admtvprogramm")
    public String viewProgrammsByAdmin(Model model) {
        model.addAttribute("programm",adminService.showProgramm());
        return "adminTVProgramm";
    }

}
