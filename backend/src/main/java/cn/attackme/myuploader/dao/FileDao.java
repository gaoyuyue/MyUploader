package cn.attackme.myuploader.dao;

import cn.attackme.myuploader.model.File;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileDao {
    /**
     * 通过主键获取一行数据
     * @return
     */
    File getById(Long id);

    /**
     * 插入一行数据
     * @param file
     */
    void save(File file);


    /**
     * 更新一行数据
     * @param file
     */
    void update(File file);

    /**
     * 删除一行数据
     * @param id
     */
    void deleteById(Long id);
}
