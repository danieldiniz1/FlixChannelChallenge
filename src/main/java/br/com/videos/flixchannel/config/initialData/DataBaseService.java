package br.com.videos.flixchannel.config.initialData;

import br.com.videos.flixchannel.model.Video;
import br.com.videos.flixchannel.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataBaseService {

    @Autowired
    private VideoRepository videoRepository;


    public void initiateDataBase(){
        Video video = Video.valueOf("teste titulo","descrição de teste","teste de url");
        videoRepository.save(video);

    }

    private static void salvarvideos(Video video) {

    }
}
