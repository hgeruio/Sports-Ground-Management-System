package com.example.dao;

import com.example.domain.Area;
import com.example.domain.Fellow;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AreaDao {
    @Insert("insert into area(area_name,area_range,number,money) values (#{area_name},#{area_range},#{number},#{money})")
    public int insertArea(Area area);

    @Select("select * from area")
    public List<Area> selectArea();

    @Select("select *from area where id=#{id}")
    public Area selectByIdArea(Integer id);

    @Select("select *from area where area_name like CONCAT('%',#{area_name},'%')")
    public List<Area> selectByNameArea(String area_name);

    @Update("update area set area_name=#{area_name},area_range=#{area_range},number=#{number},money=#{money} where id=#{id}")
    public int updateArea(Area area);

    @Update("update area set area_range=#{area_range},number=#{number},money=#{money} where area_name=#{area_name}")
    public int updateNumberArea(Area area);

    @Delete("delete from area where id=#{id}")
    public int deleteArea(Integer id);
}

