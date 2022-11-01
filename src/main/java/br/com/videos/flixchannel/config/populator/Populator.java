package br.com.videos.flixchannel.config.populator;

public interface Populator<SOURCE,TARGET> {

    void populate(SOURCE source,TARGET target);
}
