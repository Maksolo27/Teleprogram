package com.example.teleprogram.controllers;

import com.example.teleprogram.entities.Channel;
import com.example.teleprogram.repositories.ChannelRepository;
import com.example.teleprogram.services.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/channels")
public class ChannelController {

    @Autowired
    private ChannelService channelService;

    @Bean
    ChannelService getChannelService () {
        return new ChannelService ();
    }


    @GetMapping()
    public String getChannelList (Model model) {
        List<Channel> channelList = channelService.getAllChanels ();
        model.addAttribute (channelList);
        return "channels";
    }


}
