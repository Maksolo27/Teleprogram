package com.example.teleprogram.repositories;

import com.example.teleprogram.entities.Channel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ChannelRepository {

    private List<Channel> channels = new ArrayList<> ();


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

    public void addChannel (Channel channel) {
        channels.add (channel);
    }

    public void deleteChanelById (Long id) {
        channels = channels.stream()
                .filter (channel -> !channel.getId ().equals (id))
                .collect (Collectors.toList ());
    }

    public void updateChannel (Channel channel) {
        channels = channels.stream()
                .filter (channel1 -> !channel1.getId ().equals (channel.getId ()))
                .collect (Collectors.toList ());
        channels.add (channel);
    }

}
