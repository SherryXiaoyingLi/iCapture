package com.social.network.icapture.controller;

import com.social.network.icapture.model.Photo;
import com.social.network.icapture.service.PhotoService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/photos")
public class PhotoController {

    @Autowired
    private PhotoService photoService;
    @Autowired
    private Logger logger;

    @PostMapping("/upload")
    public ResponseEntity<Long> addPhoto(@RequestBody Photo photo) {
        logger.info("getting upload request");
        long photoId = photoService.addPhoto(photo);
        return new ResponseEntity<>(photoId, HttpStatus.OK);
    }

    @GetMapping("/public")
    public ResponseEntity<List<Photo>> getPhotos() {
        List<Photo> photos = photoService.getAllPhotos();
        return new ResponseEntity<>(photos, HttpStatus.OK);
    }

}
