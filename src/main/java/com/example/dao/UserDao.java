package com.example.dao;

import com.example.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface UserDao {

    @Insert("insert into user(username,email,is_admin) values (#{username},#{email},#{is_admin}) ")
    public int saveUser(User user);

    @Select("select * from user")
    public List<User> selectAllUser();

    @Select("select * from user where id=#{id} ")
    public User selectByIdUser(Integer id);

    @Select("select * from user where username=#{username} and password=#{password}")
    public User selectLogin(@Param("username") String username,@Param("password")String password);

    @Update("update user set username=#{username},password=#{password},email=#{email},is_admin=#{is_admin} where id=#{id}")
    public int updateUser(User user);

    @Delete("delete from user where id=#{id}")
    public int deleteUser(Integer id);
}
