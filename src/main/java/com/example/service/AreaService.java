package com.example.service;

import com.example.domain.Area;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface AreaService {
    /**
     * 新增
     * @param area
     * @return
     */
    public boolean insertArea(Area area);

    /**
     * 查询全部
     * @return
     */
    public List<Area> selectArea();

    /**
     * 通过场地名查询
     * @return
     */
    public List<Area> selectByNameArea(String area_name);

    /**
     * 通过id查询
     * @param id
     * @return
     */
    public Area selectByIdArea(Integer id);

    /**
     * 编辑
     * @param area
     * @return
     */
    public boolean updateArea(Area area);

    /**
     * 删除
     * @param id
     * @return
     */
    public boolean deleteArea(Integer id);

    public boolean updateNumberArea(Area area);
}
