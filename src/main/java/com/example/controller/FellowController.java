package com.example.controller;

import com.example.domain.Fellow;
import com.example.service.FellowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping(value = "/fellows")
public class FellowController {
    @Autowired
    private FellowService fellowService;

    @PostMapping
    public Result saveFellow(@RequestBody Fellow fellow) {
        boolean flag=fellowService.saveFellow(fellow);
        return new Result(flag? Code.SAVE_OK:Code.SAVE_ERR,flag);
    }

    @GetMapping
    public Result selectFellow() {
        List<Fellow>fellows= fellowService.selectFellow();
        Integer code=fellows!=null?Code.GET_OK:Code.GET_ERR;
        String msg=fellows!=null?"":"数据查询失败，请重试";
        return new Result(code,fellows,msg);
    }

    @GetMapping("/{id}")
    public Result selectIdFellow(Integer id) {
        Fellow fellow= fellowService.selectIdFellow(id);
        Integer code=fellow!=null?Code.GET_OK:Code.GET_ERR;
        String msg=fellow!=null?"":"数据查询失败，请重试";
        return new Result(code,fellow,msg);
    }

    @GetMapping("/phone/{fellow_phone}")
    public Result selectByFellow(@PathVariable String fellow_phone) {
//        System.out.println(fellow_phone);
        List<Fellow> fellow=fellowService.selectByFellow(fellow_phone);
//        System.out.println(fellow);
        Integer code=fellow!=null?Code.GET_OK:Code.GET_ERR;
        String msg=fellow!=null?"":"没有该数据，请重试";
        return new  Result(code,fellow,msg);
    }

    @PutMapping
    public Result updateFellow(@RequestBody Fellow fellow) {
        boolean flag=fellowService.updateFellow(fellow);
        return new Result(flag?Code.UPDATE_OK:Code.UPDATE_ERR,flag);
    }

    @DeleteMapping("/{id}")
    public Result deleteFellow(@PathVariable Integer id) {
        Boolean flag= fellowService.deleteFellow(id);
        return new Result(flag?Code.DELETE_OK:Code.DELETE_ERR,flag);
    }
}
