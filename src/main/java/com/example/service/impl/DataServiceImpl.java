package com.example.service.impl;

import com.example.dao.DataDao;
import com.example.domain.Data;
import com.example.mapper.DataMapper;
import com.example.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataServiceImpl implements DataService {
    @Autowired
    private DataDao dataDao;
    @Autowired
    private DataMapper dataMapper;

    @Override
    public boolean insertData(Data data) {
        return dataDao.insertData(data)>0;
    }

    @Override
    public List<Data> selectData() {
        return dataDao.selectData();
    }

    @Override
    public Data selectByData(String area_name, String fellow) {
        return selectByData(area_name,fellow);
    }


    //多条件查询
    @Override
    public List<Data> findByRequired(Data data) {
        return dataMapper.findByRequired(data);
    }
}
