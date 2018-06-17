package cn.attackme.myuploader.controller;

import cn.attackme.myuploader.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 大文件上传
 */
@RestController
@RequestMapping("/BigFile")
public class BigFileUploadController {
    @Autowired
    private FileService fileService;

    @PostMapping("/")
    public void upload(String md5,
                       Long size,
                       Integer chunks,
                       Integer chunk,
                       MultipartFile file) throws IOException {
        if (chunks != null) {
            fileService.uploadWithBlock(md5,size,chunks,chunk,file);
        } else {
            fileService.upload(md5,file);
        }
    }
}
