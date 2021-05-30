package com.social.network.icapture.service;

import com.social.network.icapture.model.Photo;
import com.social.network.icapture.repository.PhotoRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PhotoService {

    @Autowired
    private PhotoRepository photoRepository;
    @Autowired
    private AwsS3Service awsS3Service;
    @Autowired
    Logger logger;

    public long addPhoto(final MultipartFile multipartFile, long userId, String text) {
        LocalDateTime createTime = LocalDateTime.now();
        String keyName = createTime.atZone(ZoneId.of("America/Los_Angeles")).toInstant().toEpochMilli()
                + "-" + multipartFile.getOriginalFilename();
        String s3Url = awsS3Service.uploadFile(multipartFile, keyName);
        // if no exception thrown
        Photo photo = new Photo(18, createTime, s3Url, userId, text, new ArrayList<>(), new ArrayList<>());
        return photoRepository.insertPhoto(photo);
    }

    public List<Photo> getAllPhotos() {
//        logger.info(awsS3Service.listBucket().toString());
        List<Photo> photoList = photoRepository.findAll();
        return photoList;
    }

    public void getPhoto() {
        File file = awsS3Service.downloadFile("pic.jpg");
        logger.info("logging: "+String.valueOf(file == null));
    }
}
