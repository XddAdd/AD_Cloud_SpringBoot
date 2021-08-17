package com.add.filecloud.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
@Data
public class UploadFile {
    private Boolean finish;
    private String fileName;
    private String md5;
    private Integer chunks;
    private Long fileSize;
    private List<Boolean> chunkList;


    public UploadFile(String md5, String fileName, Long fileSize, Integer chunks) {
        this.md5 = md5;
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.chunks = chunks;
        this.finish = false;
        this.chunkList = new ArrayList<>();
        for (int i = 0 ; i < chunks ; i ++) {
            chunkList.add(false);
        }
    }
}
