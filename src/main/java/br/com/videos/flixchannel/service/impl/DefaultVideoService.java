package br.com.videos.flixchannel.service.impl;

import br.com.videos.flixchannel.controller.dto.VideoDTO;
import br.com.videos.flixchannel.controller.form.CreateVideoForm;
import br.com.videos.flixchannel.controller.form.UpdatedVideoForm;
import br.com.videos.flixchannel.exception.ObjectNotFoundException;
import br.com.videos.flixchannel.model.Video;
import br.com.videos.flixchannel.config.populator.Populator;
import br.com.videos.flixchannel.repository.VideoRepository;
import br.com.videos.flixchannel.service.VideoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class DefaultVideoService implements VideoService {

    private static final Logger LOGGER = LogManager.getLogger();

    private final String VIDEO_NOT_FOUND = "The video is not found!";

    @Autowired
    private Populator<Video,VideoDTO> videoDTOPopulator;


    @Autowired()
    private Populator<CreateVideoForm,Video> videoPopulator;

    @Autowired
    private VideoRepository videoRepository;

    @Override
    public Page<VideoDTO> getAllVideos(Integer page, Integer linesPerPage, String orderBy, String direction) {
        LOGGER.info("Service ativado para buscar todos os videos");
        Page<Video> videos = videoRepository.findAll(PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy));
        if (videos.isEmpty()){
            throw new ObjectNotFoundException("Não existem videos para exibir.");
        }
        videos.forEach(System.out::println);
        Page<VideoDTO> videosDTO = videos.map((video) -> VideoDTO.valueOf(video));
        return videosDTO;
    }

    @Override
    public VideoDTO getVideoById(Long id) {
        return converterToVideoDTO(videoRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(VIDEO_NOT_FOUND)));
    }

    @Override
    public String createVideo(CreateVideoForm form) {
        Video video = Video.VideoEmpty();
        videoPopulator.populate(form,video);
        return videoRepository.save(video).getId().toString();
    }

    @Override
    public VideoDTO updateVideo(UpdatedVideoForm form, Long id) {
        Video videoToUpdate = videoRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(VIDEO_NOT_FOUND));
        updatingVideo(form, videoToUpdate);
        videoRepository.save(videoToUpdate);
        return converterToVideoDTO(videoToUpdate);
    }

    private void updatingVideo(UpdatedVideoForm form, Video videoToUpdate) {
        videoToUpdate.setTitulo(form.getTitle());
        videoToUpdate.setDescricao(form.getDescription());
        videoToUpdate.setUrl(form.getUrl());
    }

    private VideoDTO converterToVideoDTO(Video video) {
        VideoDTO videoDTO = VideoDTO.VideoDTOEmptyToPopulate();
        videoDTOPopulator.populate(video,videoDTO);
        return videoDTO;
    }
}
