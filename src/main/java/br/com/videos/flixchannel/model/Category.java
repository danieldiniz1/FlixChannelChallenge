package br.com.videos.flixchannel.model;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "tb_categories")
public class Category {

    private static final String FIELD_NAME = "field_";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = FIELD_NAME + "title" )
    private String title;

    @Column(name = FIELD_NAME + "color")
    private String color;

    public Category() {
    }

    public Category(String title, String color) {
        this.title = title;
        this.color = color;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category category)) return false;
        return getId().equals(category.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public static Category valueOf(String title, String color){
        return new Category(title,color);
    }

}
