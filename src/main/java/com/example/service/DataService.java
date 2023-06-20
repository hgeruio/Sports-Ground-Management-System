package com.example.service;

import com.example.domain.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface DataService {
    @Autowired
    public boolean insertData(Data data);

    public List<Data> selectData();

    public Data selectByData(String area_name,String fellow);

    public List<Data> findByRequired(Data data);

}
