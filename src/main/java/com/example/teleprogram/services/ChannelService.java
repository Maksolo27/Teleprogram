package com.example.teleprogram.services;

import com.example.teleprogram.entities.Channel;
import com.example.teleprogram.repositories.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class ChannelService {


    @Autowired
    private ChannelRepository channelRepository;


    public List<Channel> getAllChanels () {
        return sortChanelsByNumber (channelRepository.getAllChanels ());
    }

    public Channel getChanelById(long id) {
        return channelRepository.getChanelById (id);
    }

    public int getSize(){return channelRepository.getSize();}

    public void addChanel (Channel channel) {
        channelRepository.addChannel (channel);
    }

    public void removeChannel (Long id) {
        channelRepository.deleteChanelById (id);
    }

    public void updateChannel (Channel channel) {
        channelRepository.updateChannel (channel);
    }

    private List<Channel> sortChanelsByNumber (List<Channel> channels) {
        channels.sort (Comparator.comparing (Channel::getId));
        return channels;
    }

}
