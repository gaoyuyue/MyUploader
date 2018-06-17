package cn.attackme.myuploader.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * File表存储上传的文件信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class File implements Serializable {

    private static final long serialVersionUID = -6956947981866795431L;

    private Long id;
    private String md5;
    private String path;
    private Date uploadTime;

    public File(String md5, String path, Date uploadTime) {
        this.md5 = md5;
        this.path = path;
        this.uploadTime = uploadTime;
    }
}
