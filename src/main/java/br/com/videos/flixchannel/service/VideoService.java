package br.com.videos.flixchannel.service;

import br.com.videos.flixchannel.controller.dto.VideoDTO;
import br.com.videos.flixchannel.controller.form.CreateVideoForm;
import br.com.videos.flixchannel.controller.form.UpdatedVideoForm;
import org.springframework.data.domain.Page;


public interface VideoService {
    Page<VideoDTO> getAllVideos(Integer page, Integer linesPerPage, String orderBy, String direction);

    VideoDTO getVideoById(Long id);

    String createVideo(CreateVideoForm form);

    VideoDTO updateVideo(UpdatedVideoForm form, Long id);

    void deleteVideo(Long id);
}
