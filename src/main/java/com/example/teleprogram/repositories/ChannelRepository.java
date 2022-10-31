package com.example.teleprogram.repositories;

import com.example.teleprogram.entities.Channel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ChannelRepository {

    private final List<Channel> channels = new ArrayList<> ();


    public ChannelRepository () {
        channels.add (new Channel (0L, "ICTV", "films"));
        channels.add (new Channel (1L, "STB", "housewife programms"));
        channels.add (new Channel (2L, "Football 1", "sport"));
    }


    public List<Channel> getAllChanels () {
        return channels;
    }

    public Channel getChanelById(long id) {
        return channels.get ((int) id);
    }
    public int getSize(){return  channels.size();}

}
