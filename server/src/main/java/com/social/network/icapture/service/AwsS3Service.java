package com.social.network.icapture.service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AwsS3Service {

    @Autowired
    private AmazonS3 s3;
    @Value("${aws.s3.bucket}")
    private String bucketName;
    @Autowired
    private Logger logger;


    public String uploadFile(final MultipartFile multipartFile, String keyName) {
        final File file = convertMultipartFileToFile(multipartFile);
        s3.putObject(bucketName, keyName, file);
        file.delete();
        String s3Url = String.join("", new String[]{"https://", bucketName, ".s3.amazonaws.com/", keyName});
        return s3Url;
    }

    public File convertMultipartFileToFile(final MultipartFile multipartFile) {
        final File file = new File(multipartFile.getOriginalFilename());
        try (final FileOutputStream outputStream = new FileOutputStream(file)) {
            outputStream.write(multipartFile.getBytes());
        } catch (IOException ex) {
            logger.info(String.format("Error converting the multi-part file to file: "), ex.getMessage());
        }
        return file;
    }

    public List<String> listBucket() {
        List<String> result = new ArrayList<>();
        List<S3ObjectSummary> objects = s3.listObjectsV2(bucketName).getObjectSummaries();
        for (S3ObjectSummary object: objects) {
            result.add(object.getKey());
        }
        return result;
    }

    public File downloadFile(String keyName) {
        try {
            S3Object object = s3.getObject(bucketName, keyName);
            S3ObjectInputStream s3is = object.getObjectContent();
            File file = new File("/Users/lixiaoying/Desktop/"+keyName);
            FileOutputStream fos = new FileOutputStream(file);
            byte[] readBuf = new byte[1024];
            int readLen = 0;
            while ((readLen = s3is.read(readBuf)) > 0) {
                // still content
                fos.write(readBuf, 0, readLen);
            }
            s3is.close();
            fos.close();
            return file;

        } catch (AmazonServiceException | IOException e) {
            logger.info(String.format("Exception thrown via file download: %s"), e.getMessage());
            return null;
        }
    }

}
