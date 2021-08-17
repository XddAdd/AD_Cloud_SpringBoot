package com.add.filecloud.dao;

import com.add.filecloud.pojo.FileStorehouse;

public interface FileStoreDao {

    /**
     * 新增文件仓库
     * @param userId
     */
    void newFileStorehouse(Integer userId);

    /**
     * 根据id查询文件仓库并返回
     * @param fileStoreId
     * @return
     */
    FileStorehouse queryFileStoreById(Integer fileStoreId);
}
