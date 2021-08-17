package com.add.filecloud.pojo;

import lombok.Data;
import lombok.ToString;


import java.util.Date;

@Data
@ToString
public class User {
    //用户id
    private Integer id;
    //用户名
    private String username;
    //密码
    private String password;
    //用户昵称
    private String nickname;
    //出生日期
    private Date birthday;
    //性别
    private String sex;
    //用户注册时间
    private Date registerTime;
    //用户头像路径
    private String imagePath;
    //用户仓库id
    private Integer fileStorehouseId;
    //用户当前所在文件夹id
    private Integer fileFolderId;

    public User() {}

    public User(String username, String password, String sex, String nickname) {
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.nickname = nickname;
    }
}
