package com.add.filecloud.dao;


import com.add.filecloud.pojo.File;

import java.util.List;

public interface FileDao {


    List<File> querySonFilesById(Integer fileFolderId);
}
