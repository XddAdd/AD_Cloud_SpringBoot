package com.add.filecloud.dao;

import com.add.filecloud.pojo.User;


public interface UserDao {

    /**
     * 根据username查询对应的user，不存在返回null
     * @param username
     * @return
     */
    User queryByUsername(String username);

    /**
     * 根据username查询对应的user id
     * @param username
     * @return
     */
    Integer getIdByUsername(String username);

    /**
     * 新增user
     * @param user
     * @return
     */
    Integer insertUser(User user);

    /**
     * 更新user
     * @param user
     * @return
     */
    Integer updateUser(User user);

    /**
     * 修改user
     * @param id
     * @return
     */
    Integer deleteUser(int id);
}
