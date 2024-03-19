package com.ljt528.boardback.service.implement;

import java.io.File;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ljt528.boardback.service.FileService;

@Service
public class FileServiceImplement implements FileService{

    @Value("${file.path}")
    private String filePath;

    @Value("${file.url}")
    private String fileUrl;

    // 파일 받아오기
    @Override
    public String upload(MultipartFile file) {

        // 빈 파일인지 검사
        if (file.isEmpty()) return null;

        // 받아온 파일로부터 original파일 이름을 가져옴
        String originalFileName = file.getOriginalFilename();
        // 파일의 확장자를 가져옴
        String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
        // UUID = 범용 고유식별자로써 중복될 가능성이 거의 0에 가까움
        String uuid = UUID.randomUUID().toString();
        String saveFileName = uuid + extension;
        String savePath = filePath + saveFileName;

        try {
            file.transferTo(new File(savePath));
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }

        String url = fileUrl + saveFileName;
        return url;

    }

    // 이미지 받아오기
    @Override
    public Resource getImage(String fileName) {

        Resource resource = null;

        try {
            resource = new UrlResource("file:" + filePath + fileName);
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }

        return resource;

    }
    
}
