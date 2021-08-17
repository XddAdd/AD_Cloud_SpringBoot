package com.add.filecloud.service.impl;

import com.add.filecloud.dao.FileDao;
import com.add.filecloud.dao.FileFolderDao;
import com.add.filecloud.dao.FileStoreDao;
import com.add.filecloud.pojo.File;
import com.add.filecloud.pojo.FileFolder;
import com.add.filecloud.pojo.FileStorehouse;
import com.add.filecloud.service.FileFolderService;
import com.add.filecloud.service.FileService;
import com.add.filecloud.service.FileStoreService;
import com.add.filecloud.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FileStoreServiceImpl implements FileStoreService {

    @Autowired
    private FileStoreDao fileStoreDao;
    @Autowired
    private FileFolderService fileFolderService;
    @Autowired
    private FileService fileService;

    @Override
    @Transactional
    public void newFileStorehouse(Integer userId) {
        fileStoreDao.newFileStorehouse(userId);
        //本地磁盘创建文件夹
        FileUtil.newFileFolder(userId.toString());
    }


    @Override
    @Transactional
    public FileStorehouse queryFileStorehouseByFileStoreIdFileFolderId(Integer fileStoreId, Integer fileFolderId) {
        FileStorehouse fileStorehouse = fileStoreDao.queryFileStoreById(fileStoreId);
        //查询子文件和子文件夹并设置
        List<FileFolder> fileFolderList = fileFolderService.querySonFileFoldersById(fileFolderId);
        List<File> fileList = fileService.querySonFilesById(fileFolderId);
        fileStorehouse.setFileFolderList(fileFolderList);
        fileStorehouse.setFileList(fileList);
        return fileStorehouse;
    }


}
