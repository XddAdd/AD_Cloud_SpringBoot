package com.add.filecloud.dao;

import com.add.filecloud.pojo.FileFolder;

import java.util.List;

public interface FileFolderDao {

    List<FileFolder> querySonFileFoldersById(Integer fileFolderId);

    FileFolder queryFileFolderById(Integer folderId);

    Integer insertFileFolder(FileFolder folder);
}
