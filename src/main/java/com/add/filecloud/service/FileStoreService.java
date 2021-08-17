package com.add.filecloud.service;

import com.add.filecloud.pojo.FileStorehouse;

public interface FileStoreService {

    void newFileStorehouse(Integer userId);


    FileStorehouse queryFileStorehouseByFileStoreIdFileFolderId(Integer fileStoreId,
                                                                Integer fileFolderId);



}
