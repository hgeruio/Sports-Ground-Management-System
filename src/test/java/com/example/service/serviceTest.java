package com.example.service;

import com.example.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class serviceTest {
    @Autowired
    private UserService userService;

    @Test
    public void textSelectById(){
        User user=userService.selectByIdUser(1);
        System.out.println(user);
    }
    @Test
    public void textSelectAll(){
        List<User> userList=userService.selectAllUser();
        System.out.println(userList);
    }

    @Test
    public void textDelete(){
        boolean user=userService.deleteUser(2);
        System.out.println(user);
    }

    @Test
    public void textUpdate(){
        User user=new User();
        user.setId(4);
        user.setUsername("root");
        user.setPassword("root123");
        user.setEmail("123@qq.com");
        user.setIs_admin("管理员");
        boolean b=userService.updateUser(user);
        System.out.println(b);
    }

    @Test
    public void textInsert(){
        User user=new User();
        user.setUsername("root");
        user.setPassword("root");
        user.setEmail("123@qq.com");
        user.setIs_admin("普通员工");
        boolean b=userService.saveUser(user);
        System.out.println(b);
    }
}
