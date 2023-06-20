package com.example.service;

import com.example.controller.Code;
import com.example.controller.Result;
import com.example.dao.FellowDao;
import com.example.domain.Fellow;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootTest
public class FellowServiceTest {
    @Autowired
    private FellowService fellowService;

    @Test
    public void selectFellow() {
        List<Fellow> fellows=fellowService.selectFellow();
        System.out.println(fellows);
    }
}
