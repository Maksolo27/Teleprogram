package com.example.teleprogram.services;

import com.example.teleprogram.entities.Channel;

import com.example.teleprogram.repositories.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelService {


    @Autowired
    private ChannelRepository channelRepository;


    public List<Channel> getAllChanels () {
        return channelRepository.getAllChanels ();
    }

    public Channel getChanelById(long id) {
        return channelRepository.getChanelById (id);
    }

    public int getSize(){return channelRepository.getSize();}

    public void save(Channel channel){
        channel.setId((long) channelRepository.getSize());
        channelRepository.add(channel);
    }

    public void delete(int id){
        channelRepository.delete(id);
    }

}
