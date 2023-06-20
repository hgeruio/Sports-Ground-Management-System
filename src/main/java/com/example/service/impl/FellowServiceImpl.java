package com.example.service.impl;

import com.example.dao.FellowDao;
import com.example.domain.Fellow;
import com.example.service.FellowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FellowServiceImpl implements FellowService {
    @Autowired
    private FellowDao fellowDao;

    public boolean saveFellow(Fellow fellow) {
        return fellowDao.saveFellow(fellow)>0;
    }

    public List<Fellow> selectFellow() {
        return fellowDao.selectFellow();
    }

    @Override
    public Fellow selectIdFellow(Integer id) {
        return fellowDao.selectIdFellow(id);
    }


    public List<Fellow> selectByFellow(String fellow_phone) {
        return fellowDao.selectByFellow(fellow_phone);
    }


    public boolean updateFellow(Fellow fellow) {
        return fellowDao.updateFellow(fellow)>0;
    }


    public boolean deleteFellow(Integer id) {
        return fellowDao.deleteFellow(id)>0;
    }
}
