package com.add.filecloud.dao;

import com.add.filecloud.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void queryByUsername() {
        User user = userDao.queryByUsername("add");
        assertNotNull(user);
        assertEquals(user.getUsername(), "add");
    }

    @Test
    public void getIdByUsername() {
        Integer id = userDao.getIdByUsername("add");
        assertNotNull(id);
        assertEquals(id, new Integer(1));
    }

    @Test
    public void insertUser() {
        User user = new User();
        user.setUsername("xdd");
        user.setPassword("123");
        Integer line = userDao.insertUser(user);
        assertEquals(line, new Integer(1));

    }

    @Test
    public void updateUser() {
        User user = userDao.queryByUsername("xdd");
        user.setFileStorehouseId(1);
        System.out.println(user);
        Integer line = userDao.updateUser(user);
        assertEquals(line, new Integer(1));
    }

    @Test
    public void deleteUser() {
        Integer line = userDao.deleteUser(2);
        assertEquals(line, new Integer(1));
    }
}