package cn.attackme.myuploader.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 分块上传工具类
 */
public class UploadUtils {
    private static Map<String, boolean[]> chunkMap = new HashMap<>();

    /**
     * 判断文件所有分块是否已上传
     * @param key
     * @return
     */
    public static boolean isUploaded(String key) {
        if (isExist(key)) {
            for (boolean b : chunkMap.get(key)) {
                if (!b) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * 判断文件是否有分块已上传
     * @param key
     * @return
     */
    private static boolean isExist(String key) {
        return chunkMap.containsKey(key);
    }

    /**
     * 为文件添加上传分块记录
     * @param key
     * @param chunk
     * @param chunks
     */
    public static void addChunk(String key, Integer chunk, Integer chunks) {
        if (!isExist(key)) {
            synchronized (UploadUtils.class) {
                if (isExist(key)) {
                    chunkMap.put(key, new boolean[chunks]);
                }
            }
        }
        chunkMap.get(key)[chunk] = true;
    }
}
