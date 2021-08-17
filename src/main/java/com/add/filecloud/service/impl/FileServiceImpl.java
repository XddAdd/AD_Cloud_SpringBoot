package com.add.filecloud.service.impl;

import cn.hutool.json.JSONObject;
import com.add.filecloud.dao.FileDao;
import com.add.filecloud.pojo.File;
import com.add.filecloud.pojo.FileFolder;
import com.add.filecloud.service.FileFolderService;
import com.add.filecloud.service.FileService;
import com.add.filecloud.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private FileDao fileDao;
    @Autowired
    private FileFolderService fileFolderService;


    @Override
    @Transactional
    public List<File> querySonFilesById(Integer fileFolderId) {
        return fileDao.querySonFilesById(fileFolderId);
    }


    @Override
    @Transactional
    public JSONObject getUploadProcess(Integer storeId, Integer folderId, String fileName, String fileMd5Value) {
        FileFolder fileFolder = fileFolderService.queryFileFolderById(folderId);
        String uploadPath = FileUtil.FILE_ROOT_PATH;
        //判断根目录
        if (fileFolder == null) uploadPath += storeId + "/" + fileName;
        else uploadPath += fileFolder.getFileFolderPath() + "/" + fileName;
        //特判文件已经存在

        return null;
    }
}
