package br.com.videos.flixchannel.config.populator.impl;

import br.com.videos.flixchannel.controller.form.CreateVideoForm;
import br.com.videos.flixchannel.model.Video;
import br.com.videos.flixchannel.config.populator.Populator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class VideoReversePopulator implements Populator<CreateVideoForm, Video> {


    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void populate(CreateVideoForm source, Video target) {
        validateSource(source);
        target.setTitulo(source.getTitle());
        target.setDescricao(source.getDescription());
        target.setUrl(source.getUrl());
        LOGGER.info("The video has been create with title name: " + target.getTitulo());
    }

    private void validateSource(CreateVideoForm source) {
        Assert.notNull(source,"Form can not be null");
    }
}
