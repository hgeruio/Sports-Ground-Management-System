package com.example;

import com.example.dao.UserDao;
import com.example.domain.User;
import com.example.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

class JavawebMainApplicationTests {
@Autowired
    UserDao userDao;
@Autowired
    UserService userService;
    @Test
    void contextLoads() {
        User user = userDao.selectByIdUser(1);
        System.out.println(user);

        User suser = userService.selectByIdUser(1);
        System.out.println(suser);
    }


}
