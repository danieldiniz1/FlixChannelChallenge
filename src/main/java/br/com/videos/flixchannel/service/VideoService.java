package br.com.videos.flixchannel.service;

import br.com.videos.flixchannel.controller.dto.VideoDTO;
import org.springframework.data.domain.Page;


public interface VideoService {
    Page<VideoDTO> getAllVideos(Integer page, Integer linesPerPage, String orderBy, String direction);

    VideoDTO getVideoById(Long id);
}
