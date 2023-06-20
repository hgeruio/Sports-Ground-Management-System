package com.example.controller;

import com.example.domain.Area;
import com.example.domain.Data;
import com.example.domain.FindData;
import com.example.service.AreaService;
import com.example.service.DataService;
import com.example.service.FellowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/datas")
public class DataController {
    @Autowired
    private DataService dataService;
    @Autowired
    private AreaService areaService;
    @Autowired
    private FellowService fellowService;

    @PostMapping
    public Result insertData(@RequestBody Data data) {
        boolean flag1 = dataService.insertData(data);
        //已知要插入的data数据，则可根据data中的area_name求出使用的场地名称，进而推出使用场地的信息，然后将场地的数量减一
        List<Area> areas = areaService.selectByNameArea(data.getArea_name());
        Area area = areas.get(0);
        System.out.println(area.getNumber());
        boolean flag2 = area.getNumber() > 0;
        if (flag2) {
            area.setNumber(area.getNumber() - 1);
            System.out.println(area);
            areaService.updateArea(area);
        }
        //判断手机号是否办理会员，若办理，则打八折(应该为前端执行)
//        Double money=area.getMoney();
//        Fellow fellow=fellowService.selectByFellow(null, data.getPhone());
        String msg = flag1 && flag2 ? "" : "添加失败，请重试！";
        return new Result(flag1 && flag2 ? Code.UPDATE_OK : Code.UPDATE_ERR, msg);
    }

    @GetMapping
    public Result selectData() {
        List<Data> dataList = dataService.selectData();
        Integer code = dataList != null ? Code.GET_OK : Code.GET_ERR;
        String msg = dataList != null ? "" : "查询失败，请重试！";
        System.out.println(dataList);
        return new Result(code, dataList, msg);
    }

    @PostMapping("/findData")
    public Result findByRequired(@RequestBody FindData findData){
        Data data=new Data();
        System.out.println(findData);
        data.setArea_name(findData.getArea_name());
        data.setUser(findData.getUser());
        System.out.println(data);
        List<Data> datas=dataService.findByRequired(data);
        System.out.println(datas);
        Integer code = datas != null ? Code.GET_OK : Code.GET_ERR;
        String msg = datas != null ? "" : "查询失败，请重试！";
        return new Result(code, datas, msg);
    }
}
