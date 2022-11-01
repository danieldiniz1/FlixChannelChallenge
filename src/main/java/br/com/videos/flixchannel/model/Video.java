package br.com.videos.flixchannel.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_videos")
public class Video {

    private static final String FIELDNAME = "field_";

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = FIELDNAME + "title")
    private String titulo;
    @Column(name = FIELDNAME + "description")
    private String descricao;
    @Column(name = FIELDNAME + "url")
    private String url;

    private Video() {
    }

    public Video(String titulo, String descricao, String url) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Video video)) return false;
        return getId().equals(video.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public static Video valueOf(String titulo, String descricao, String url){
        return new Video(titulo,descricao,url);
    }

    public static Video VideoEmpty(){return new Video();}
}
