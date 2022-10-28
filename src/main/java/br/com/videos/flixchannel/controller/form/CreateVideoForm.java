package br.com.videos.flixchannel.controller.form;


import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class CreateVideoForm {

    @NotBlank(message = "title cannot be null")
    @Length(min = 3, max = 60)
    @Pattern(regexp = "[A-z a-z]*")
    private String title;
    @NotBlank(message = "description cannot be null")
    @Length(min = 3, max = 255)
    private String description;
    @NotBlank(message = "url cannot be null")
    @Length(min = 5, max = 255)
    private String url;

    public CreateVideoForm() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


}
