package com.discord.bot.config;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManagers;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class AudioConfig {

    @Value("${audio.frame-buffer-duration:10000}")
    private int frameBufferDuration;

    @Value("${audio.item-loader-thread-pool-size:10}")
    private int itemLoaderThreadPoolSize;

    @Bean
    public AudioPlayerManager audioPlayerManager() {
        log.info("Initializing AudioPlayerManager with frame buffer duration: {}ms", frameBufferDuration);
        
        DefaultAudioPlayerManager mgr = new DefaultAudioPlayerManager();
        
        // Configure frame buffer duration (default 10 seconds)
        mgr.setFrameBufferDuration(frameBufferDuration);
        
        // Configure thread pool size for item loading
        mgr.setItemLoaderThreadPoolSize(itemLoaderThreadPoolSize);
        
        // Register audio sources
        AudioSourceManagers.registerRemoteSources(mgr);
        AudioSourceManagers.registerLocalSource(mgr);
        
        log.info("AudioPlayerManager initialized successfully");
        return mgr;
    }
}
