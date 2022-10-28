package br.com.videos.flixchannel.controller;

import br.com.videos.flixchannel.controller.dto.VideoDTO;
import br.com.videos.flixchannel.controller.form.CreateVideoForm;
import br.com.videos.flixchannel.model.Video;
import br.com.videos.flixchannel.service.VideoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.time.LocalDateTime;


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

    @GetMapping("/{id}")
    public ResponseEntity<VideoDTO> getVideoById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(videoService.getVideoById(id));
    }

    @PostMapping
    public ResponseEntity createVideo(@RequestBody @Valid CreateVideoForm form){
        String id = videoService.createVideo(form);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id.toString())
                .toUri();
        return ResponseEntity.created(uri).body(getVideoById(Long.parseLong(id)));
    }
}
