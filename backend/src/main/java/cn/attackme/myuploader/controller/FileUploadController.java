package cn.attackme.myuploader.controller;

import cn.attackme.myuploader.dao.FileDao;
import cn.attackme.myuploader.model.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/File")
public class FileUploadController {
    @Autowired
    private FileDao fileDao;

    @PostMapping("/")
    public Long upload(File file){
        file.setUploadTime(new Date());
        fileDao.save(file);
        return file.getId();
    }
}
