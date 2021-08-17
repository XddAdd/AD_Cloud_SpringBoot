package com.add.filecloud.controller;

import cn.hutool.json.JSONObject;
import com.add.filecloud.pojo.FileFolder;
import com.add.filecloud.pojo.FileStorehouse;
import com.add.filecloud.service.FileFolderService;
import com.add.filecloud.service.FileService;
import com.add.filecloud.service.FileStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileStoreService fileStoreService;
    @Autowired
    private FileFolderService fileFolderService;
    @Autowired
    private FileService fileService;

    /**
     * 展示所有的子文件和子文件夹
     * @param storeId
     * @param folderId
     * @return
     */
    @GetMapping("/fileList")
    public Object fileList(@RequestParam("storeId") Integer storeId,
                           @RequestParam("folderId") Integer folderId) {
        FileStorehouse fileStorehouse = fileStoreService.queryFileStorehouseByFileStoreIdFileFolderId(storeId, folderId);
        return fileStorehouse;
    }


    /**
     * 创建新文件夹
     * @param storeId
     * @param folderId
     * @param folderName
     * @return
     */
    @RequestMapping(value = "/newFileFolder", method = RequestMethod.GET)
    public Object newFileFolder(@RequestParam Integer storeId,
                                @RequestParam Integer folderId,
                                @RequestParam String folderName) {
        Boolean b = fileFolderService.newFileFolder(storeId, folderId, folderName);
        return b;
    }

    @GetMapping("/getParentFolderId")
    public Object getParentFolderId(@RequestParam Integer storeId,
                                    @RequestParam Integer folderId) {
        Integer p = fileFolderService.getParentFolderId(folderId);
        return p;
    }

    @PostMapping("/fileExist")
    public Object fileExist(@RequestParam Integer storeId,
                            @RequestParam Integer folderId,
                            @RequestParam String fileName,
                            @RequestParam String fileMd5Value) {
        JSONObject res = fileService.getUploadProcess(storeId, folderId, fileName, fileMd5Value);
        return res;
    }



}
