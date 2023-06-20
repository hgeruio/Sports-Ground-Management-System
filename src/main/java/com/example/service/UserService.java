package com.example.service;

import com.example.domain.User;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface UserService {
    /**
     * 保存
     * @param user
     * @return
     */
    public boolean saveUser(User user);

    /**
     * 删除
     * @param id
     * @return
     */
    public boolean deleteUser(Integer id);

    /**
     * 修改
     * @param user
     * @return
     */
    public boolean updateUser(User user);

    /**
     * 根据id查找
     * @param id
     * @return
     */
    public User selectByIdUser(Integer id);

    /**
     * 查找全部
     * @return
     */
    public List<User> selectAllUser();

    public User selectLogin(String username,String password);

}
