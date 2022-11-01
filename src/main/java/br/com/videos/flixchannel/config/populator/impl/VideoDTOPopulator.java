package br.com.videos.flixchannel.config.populator.impl;

import br.com.videos.flixchannel.config.populator.Populator;
import br.com.videos.flixchannel.controller.dto.VideoDTO;
import br.com.videos.flixchannel.model.Video;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class VideoDTOPopulator implements Populator<Video, VideoDTO> {


    @Override
    public void populate(Video source, VideoDTO target) {
        validate(source);
        target.setTitle(source.getTitulo());
        target.setDescricao(source.getDescricao());
        target.setUrl(source.getUrl());
    }

    private void validate(Video source) {
        Assert.hasText(source.getTitulo(),"The video has not title.");
    }
}
