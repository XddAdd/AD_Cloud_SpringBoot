package com.add.filecloud.service;

import cn.hutool.json.JSONObject;
import com.add.filecloud.pojo.File;

import java.util.List;

public interface FileService {

    List<File> querySonFilesById(Integer fileFolderId);

    JSONObject getUploadProcess(Integer storeId, Integer folderId, String fileName, String fileMd5Value);
}
