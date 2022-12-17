package com.example.teleprogram.controllers;

import com.example.teleprogram.configuration.SwaggerConfig;
import com.example.teleprogram.entities.Channel;
import com.example.teleprogram.services.*;

import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/channels")
@Tag (name = SwaggerConfig.TAG_CHANNEL,
        description = "Controller for CRUD operations with teleprograms"
)
public class ChannelController {

    @Autowired
    private ChannelService channelService;

    @GetMapping
    @ApiOperation (value = "Get list of channels (sorted by numbers)",
            code = 200,
            tags = {SwaggerConfig.TAG_CHANNEL}
    )
    public ResponseEntity<List<Channel>> getChannelList () {
        return ResponseEntity.ok (channelService.getAllChanels ());
    }
    @ApiOperation (value = "Create new channel",
            code = 200,
            tags = {SwaggerConfig.TAG_CHANNEL}
    )
    @PostMapping("/create")
    public void putChannel (@RequestBody Channel channel) {
        channelService.addChanel (channel);
    }

    @DeleteMapping("/remove")
    @ApiOperation (value = "Remove channel",
            code = 200,
            tags = {SwaggerConfig.TAG_CHANNEL})
    public void removeChannel (@RequestParam Long id) {
        channelService.getChanelById (id);
    }

    @PutMapping("/update")
    @ApiOperation (value = "Update channel",
            code = 200,
            tags = {SwaggerConfig.TAG_CHANNEL})
    public void updateChannel (@RequestBody Channel channel) {
        channelService.updateChannel (channel);
    }


}
