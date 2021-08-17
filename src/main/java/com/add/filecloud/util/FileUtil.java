package com.add.filecloud.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class FileUtil {

    public static String FILE_ROOT_PATH;

    @Value("${file_root_path}")
    public void setFileRootPath(String path) {
        FILE_ROOT_PATH = path;
    }


    /**
     * 新建文件夹
     * @param folderPath
     * @return
     */
    public static Boolean newFileFolder(String folderPath){
        File f = new File(FILE_ROOT_PATH + folderPath);
        return f.mkdir();
    }
}
