package com.add.filecloud.service;


import com.add.filecloud.pojo.User;

public interface UserService {

    /**
     * 新增用户，如果新增失败返回null
     * @param user
     * @return
     */
    void register(User user);

    /**
     * 根据username查询用户
     * @param username
     * @return
     */
    User queryByUsername(String username);
    


}
