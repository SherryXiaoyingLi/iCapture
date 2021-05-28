package com.social.network.icapture.service;

import com.social.network.icapture.model.Photo;
import com.social.network.icapture.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoService {

    @Autowired
    private PhotoRepository photoRepository;

    public long addPhoto(Photo photo) {
        Photo newPhoto = photoRepository.insertPhoto(photo);
        return newPhoto.getPhotoId();
    }

    public List<Photo> getAllPhotos() {
        List<Photo> photoList = photoRepository.findAll();
        return photoList;
    }
}
