package com.example.dao;

import com.example.domain.Fellow;
import com.example.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface FellowDao {
    @Insert("insert into fellow(fellow_name,fellow_phone,fellow_sex,fellow_date) values (#{fellow_name},#{fellow_phone},#{fellow_sex},#{fellow_date}) ")
    public int saveFellow(Fellow fellow);

    @Select("select * from fellow")
    public List<Fellow> selectFellow();

    @Select("select * from fellow where id=#{id}")
    public Fellow selectIdFellow(Integer id);

    @Select("select * from fellow where fellow_phone  like CONCAT('%',#{fellow_phone},'%')")
    public List<Fellow> selectByFellow(String fellow_phone);

    @Update("update fellow set fellow_name=#{fellow_name},fellow_phone=#{fellow_phone},fellow_sex=#{fellow_sex},fellow_date=#{fellow_date} where id=#{id}")
    public int updateFellow(Fellow fellow);

    @Delete("delete from fellow where id=#{id}")
    public int deleteFellow(Integer id);
}
