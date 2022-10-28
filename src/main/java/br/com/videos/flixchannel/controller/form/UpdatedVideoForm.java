package br.com.videos.flixchannel.controller.form;

public class UpdatedVideoForm extends CreateVideoForm{

    private String id;

    public UpdatedVideoForm() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
