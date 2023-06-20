package com.example.service.impl;

import com.example.dao.AreaDao;
import com.example.domain.Area;
import com.example.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDao areaDao;

    @Override
    public boolean insertArea(Area area) {
        return areaDao.insertArea(area)>0;
    }

    @Override
    public List<Area> selectArea() {
        return areaDao.selectArea();
    }

    @Override
    public List<Area> selectByNameArea(String area_name){
        return areaDao.selectByNameArea(area_name);
    }

    @Override
    public Area selectByIdArea(Integer id) {
        return areaDao.selectByIdArea(id);
    }

    @Override
    public boolean updateArea(Area area) {
        return areaDao.updateArea(area)>0;
    }

    @Override
    public boolean deleteArea(Integer id) {
        return areaDao.deleteArea(id)>0;
    }

    @Override
    public boolean updateNumberArea(Area area) {
        return areaDao.updateNumberArea(area)>0;
    }
}
