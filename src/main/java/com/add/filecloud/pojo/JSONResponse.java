package com.add.filecloud.pojo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class JSONResponse {
    private boolean success;
    private String code;
    private String message;
    private Object data;

}
