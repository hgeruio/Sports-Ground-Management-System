package com.example.service;

import com.example.domain.Area;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class AreaServiceTest {
    @Autowired
    private AreaService areaService;

    @Test
    public void selectAllArea(){
        List<Area>areaList=areaService.selectArea();
        System.out.println(areaList);
    }

}
