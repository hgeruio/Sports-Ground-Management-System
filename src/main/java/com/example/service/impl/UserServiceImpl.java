package com.example.service.impl;

import com.example.dao.UserDao;
import com.example.domain.User;
import com.example.service.UserService;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public boolean saveUser(User user) {
        return userDao.saveUser(user) > 0;
    }

    public boolean deleteUser(Integer id) {
        return userDao.deleteUser(id) > 0;
    }

    public boolean updateUser(User user) {
        return userDao.updateUser(user) > 0;
    }

    public User selectByIdUser(Integer id) {
        return userDao.selectByIdUser(id);
    }

    public List<User> selectAllUser() {
        return userDao.selectAllUser();
    }

    public User selectLogin(String username, String password) {
        return userDao.selectLogin(username, password);
    }

}
