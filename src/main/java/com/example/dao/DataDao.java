package com.example.dao;

import com.example.domain.Area;
import com.example.domain.Data;
import com.example.domain.Fellow;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
@Mapper
public interface DataDao {
    @Insert("insert into data(user,phone,area_name,fellow,money,time,end_time) values (#{user},#{phone},#{area_name},#{fellow},#{money},#{time},#{end_time}) ")
    public int insertData(Data data);

    @Select("select * from data")
    public List<Data> selectData();


}

