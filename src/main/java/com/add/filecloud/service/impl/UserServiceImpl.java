package com.add.filecloud.service.impl;

import com.add.filecloud.dao.UserDao;
import com.add.filecloud.pojo.User;
import com.add.filecloud.service.FileStoreService;
import com.add.filecloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private FileStoreService fileStoreService;

    /**
     * 插入user，插入失败返回null
     * @param user
     * @return
     */
    @Override
    @Transactional
    public void register(User user) {
        if (user == null || user.getUsername() == null) throw new RuntimeException("注册用户失败: user为null/username为null");
        try {
            User exist = this.queryByUsername(user.getUsername());
            if (exist != null) throw new RuntimeException("注册失败,用户名已经存在,username为: " + user.getUsername());
            //创建用户
            Integer line = userDao.insertUser(user);
            user = this.queryByUsername(user.getUsername());
            //设置user的fileStoreId字段
            user.setFileStorehouseId(user.getId());
            userDao.updateUser(user);
            //创建用户仓库
            fileStoreService.newFileStorehouse(user.getId());
        } catch (Exception e) {
            throw new RuntimeException("注册用户失败: " + e.getMessage());
        }
    }



    /**
     * 根据username查询user，不存在返回null
     * @param username
     * @return
     */
    @Override
    @Transactional
    public User queryByUsername(String username) {
        if (username != null) {
            try {
                return userDao.queryByUsername(username);
            } catch (Exception e) {
                throw new RuntimeException("根据username查询用户失败: " + e.getMessage());
            }
        }
        throw new RuntimeException("根据username查询用户失败: username为null");
    }
}
