package com.add.filecloud.service.impl;

import com.add.filecloud.dao.FileFolderDao;
import com.add.filecloud.pojo.FileFolder;
import com.add.filecloud.service.FileFolderService;
import com.add.filecloud.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FileFolderServiceImpl implements FileFolderService {

    @Autowired
    private FileFolderDao fileFolderDao;


    @Override
    @Transactional
    public List<FileFolder> querySonFileFoldersById(Integer fileFolderId) {
        return fileFolderDao.querySonFileFoldersById(fileFolderId);
    }


    @Transactional
    @Override
    public FileFolder queryFileFolderById(Integer folderId) {
        return fileFolderDao.queryFileFolderById(folderId);
    }


    @Override
    @Transactional
    public Boolean newFileFolder(Integer storeId, Integer folderId, String folderName) {
        if (storeId == null || folderId == null || folderName == null) throw new RuntimeException("创建文件夹失败,参数中有null");
        //校验是否已经有相同名称的文件夹
        List<FileFolder> sonFileFolderList = this.querySonFileFoldersById(folderId);
        for (FileFolder f : sonFileFolderList) {
            if (folderName.equals(f.getFileFolderName())) throw new RuntimeException("创建文件夹失败,已存在该文件夹");
        }
        //插入数据库
        FileFolder parentFolder = queryFileFolderById(folderId);
        FileFolder folder = new FileFolder();
        folder.setParentFolderId(folderId);
        folder.setFileFolderName(folderName);
        folder.setFileStorehouseId(storeId);
        String path = storeId + "/" + folderName; //默认无父文件夹
        if (parentFolder != null) path = parentFolder.getFileFolderPath() + "/" + folderName;
        folder.setFileFolderPath(path);
        Integer line = fileFolderDao.insertFileFolder(folder);
        if (line != 1) throw new RuntimeException("插入文件夹记录失败");
        //本地磁盘创建文件夹
        FileUtil.newFileFolder(path);
        return true;
    }



    @Override
    @Transactional
    public Integer getParentFolderId(Integer folderId) {
        FileFolder fileFolder = fileFolderDao.queryFileFolderById(folderId);
        return fileFolder.getParentFolderId();
    }
}
