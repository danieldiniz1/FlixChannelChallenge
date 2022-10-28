package br.com.videos.flixchannel.populator;

public interface Populator<SOURCE,TARGET> {

    void populate(SOURCE source,TARGET target);
}
