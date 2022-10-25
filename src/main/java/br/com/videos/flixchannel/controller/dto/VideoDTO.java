package br.com.videos.flixchannel.controller.dto;

import br.com.videos.flixchannel.model.Video;

public class VideoDTO {

    private String descricao;
    private String title;
    private String url;

    public VideoDTO() {
    }

    public VideoDTO(String descricao, String title, String url) {
        this.descricao = descricao;
        this.title = title;
        this.url = url;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public static VideoDTO valueOf(Video video){
        return new VideoDTO(video.getDescricao(), video.getTitulo(), video.getUrl());
    }
}
