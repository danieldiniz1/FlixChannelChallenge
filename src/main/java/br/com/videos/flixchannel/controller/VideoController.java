package br.com.videos.flixchannel.controller;

import br.com.videos.flixchannel.controller.dto.VideoDTO;
import br.com.videos.flixchannel.service.VideoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/videos")
public class VideoController {

    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private VideoService videoService;

    @GetMapping
    public ResponseEntity<Page<VideoDTO>> getAllVideos(@RequestParam(value = "page",defaultValue = "0") Integer page,
                                                       @RequestParam(value = "linesPerPage",defaultValue = "24") Integer linesPerPage,
                                                       @RequestParam(value = "orderBy",defaultValue = "titulo") String orderBy,
                                                       @RequestParam(value = "direction",defaultValue = "ASC") String direction){
        LOGGER.info("Iniciando busca por todos os videos");

        return ResponseEntity.ok(videoService.getAllVideos(page,linesPerPage,orderBy,direction));
    }
}
