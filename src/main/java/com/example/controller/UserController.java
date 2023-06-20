package com.example.controller;

import com.example.domain.Login;
import com.example.domain.User;
import com.example.service.UserService;
import com.example.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


import javax.servlet.http.*;
import java.io.IOException;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    TokenUtil tokenUtil;


    @PostMapping
    public Result saveUser(@RequestBody User user) {
        boolean flag = userService.saveUser(user);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag);
    }

    @PutMapping
    public Result updateUser(@RequestBody User user) {
        boolean flag = userService.updateUser(user);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag);
    }

    @DeleteMapping("/{id}")
    public Result deleteUser(@PathVariable Integer id) {
        boolean flag = userService.deleteUser(id);
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, flag);
    }

    @GetMapping("/{id}")
    public Result selectByIdUser(@PathVariable Integer id) {
        User user = userService.selectByIdUser(id);
        Integer code = user != null ? Code.GET_OK : Code.GET_ERR;
        String msg = user != null ? "" : "数据查询失败，请重试";
        return new Result(code, user, msg);
    }

    @GetMapping
    public Result getAll() {
        List<User> userList = userService.selectAllUser();
        Integer code = userList != null ? Code.GET_OK : Code.GET_ERR;
        String msg = userList != null ? "" : "数据查询失败，请重试";
        return new Result(code, userList, msg);
    }

    @PostMapping("/login")
    public Result selectLogin(@RequestBody Login login) throws IOException {
//        System.out.println(login.getUsername());
        User user = userService.selectLogin(login.getUsername(), login.getPassword());
        Integer code = user != null ? Code.GET_OK : Code.GET_ERR;
        String msg = user != null ? "" : "登录失败，请重试";
        String token="";
        if (user!=null) {
            token=tokenUtil.getToken(user.getId().toString(),user.getUsername(),user.getPassword(), user.getEmail(), user.getIs_admin());
            System.out.println(111+token);
        }
        return new Result(code, user, msg,token);
    }

    @GetMapping("/test-token")
    public boolean testToken(HttpServletRequest request){
        String token = request.getHeader("token");
        System.out.println(token);
        return true;
    }

}
