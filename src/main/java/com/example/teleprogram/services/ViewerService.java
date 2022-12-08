package com.example.teleprogram.services;
import com.example.teleprogram.repositories.ChannelRepository;
import com.example.teleprogram.repositories.TVProgrammRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ViewerService {

    private ChannelRepository channelRepository;
    private TVProgrammRepository tvProgrammRepository;
    @Autowired
    public void setChannelRepository(ChannelRepository channelRepository) {
        this.channelRepository = channelRepository;
    }
    @Autowired
    public void setTvProgrammRepository(TVProgrammRepository tvProgrammRepository) {
        this.tvProgrammRepository = tvProgrammRepository;
    }


    public List<String> showChannels(){
        List<String> channels = new ArrayList<>();
        for (int i = 0; i < channelRepository.getSize(); i++) {
            channels.add(channelRepository.getChanelById(i).getName());
        }
       return channels;
    }

    public List<String> showProgramm(){
        List<String> programms = new ArrayList<>();
        for (int i = 0; i < tvProgrammRepository.getSize(); i++) {
            programms.add(tvProgrammRepository.getProgrammById(i).getDate());
            String [] descript = tvProgrammRepository.getProgrammById(i).getDescription().split("\\|");
            programms.addAll(Arrays.asList(descript));
        }
        return programms;
    }

    public List<String> sortChannels(){
        List<String> sortedChannels = showChannels();
        Collections.sort(sortedChannels);
        return sortedChannels;
    }




}
