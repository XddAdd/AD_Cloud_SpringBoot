package com.add.filecloud.service;


import com.add.filecloud.pojo.FileFolder;

import java.util.List;

public interface FileFolderService {

    List<FileFolder> querySonFileFoldersById(Integer fileFolderId);

    FileFolder queryFileFolderById(Integer folderId);

    Boolean newFileFolder(Integer storeId, Integer folderId, String folderName);

    Integer getParentFolderId(Integer folderId);
}
