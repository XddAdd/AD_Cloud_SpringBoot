package com.add.filecloud.controller;


import com.add.filecloud.pojo.User;

import com.add.filecloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;



    @RequestMapping(value="/register", method = RequestMethod.POST)
    private String register(@RequestParam String username,
                          @RequestParam String password,
                          @RequestParam String sex,
                          @RequestParam String nickname) {
        User user = new User(username, password, sex, nickname);
        //注册用户
        userService.register(user);
        System.out.println(user);
        return "redirect:/view/login.html";
    }



    @RequestMapping(value="/login", method = RequestMethod.POST)
    private String login(@RequestParam String username,
                         @RequestParam String password) {
        User user = userService.queryByUsername(username);
        if (user == null) throw new RuntimeException("用户名不存在");
        if (!password.equals(user.getPassword())) throw new RuntimeException("密码错误, username为: " + username);
        //TODO 登录成功，创建session
        String addr = "redirect:/view/file_list.html?userId="+user.getId()+"&storeId=" + user.getFileStorehouseId() + "&folderId=-1";
        return addr;
    }

}
