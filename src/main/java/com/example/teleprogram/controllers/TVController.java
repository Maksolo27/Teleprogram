package com.example.teleprogram.controllers;

import com.example.teleprogram.entities.Teleprogram;
import com.example.teleprogram.services.*;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@AllArgsConstructor
@RequestMapping("/")
public class TVController {

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
    public String authorization(String login, String password){
        if(accessService.access(login, password).equals("viewer")){
            return "viewerSite";
        }
        if (accessService.access(login,password).equals("admin")) {
            return "adminSite";
        }
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
        model.addAttribute("programm",tvProgrammService.getAllProgram());
        return "adminTVProgramm";
    }

    @GetMapping("/admtvprogramm/{id}")
    public String show(@PathVariable("id")int id, Model model){
        model.addAttribute("program",tvProgrammService.getProgrammById(id));
        model.addAttribute("descriptions",adminService.showProgramm(id));
        return "show";
    }


    @GetMapping("/new")
    public String createProg(Model model){
        model.addAttribute("teleprogramm", new Teleprogram());
        return "newProgramm";
    }

    @PostMapping("/admtvprogramm")
    public String create(@ModelAttribute("teleporgramm")Teleprogram teleprogram){
        tvProgrammService.save(teleprogram);
        return "redirect:/admtvprogramm";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model,@PathVariable("id") int id){
        model.addAttribute("programm", tvProgrammService.getProgrammById(id));
        return "editProgramm";
    }

    @PatchMapping("/edit/{id}")
    public String update(@ModelAttribute("programm") Teleprogram teleprogram, @PathVariable("id")int id){
        adminService.editProg(id,teleprogram);
        return "redirect:/admtvprogramm";
    }

    @DeleteMapping("/admtvprogramm/{id}")
    public String delete(@PathVariable("id")int id){
        tvProgrammService.delete(id);
        return"redirect:/admtvprogramm";
    }
}
