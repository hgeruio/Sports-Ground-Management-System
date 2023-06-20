package com.example.controller;

import com.example.domain.Area;
import com.example.domain.Data;
import com.example.service.AreaService;
import com.example.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/areas")
public class AreaController {
    @Autowired
    private AreaService areaService;
    @Autowired
    private DataService dataService;

    @PostMapping
    public Result insertArea(@RequestBody Area area) {
        boolean flag=areaService.insertArea(area);
        return new Result(flag?Code.SAVE_OK:Code.SAVE_ERR,flag);
    }

    @GetMapping
    public Result selectArea() {
        List<Data> datas=dataService.selectData();
        for(int i=0;i<datas.size();i++){
            Data d=datas.get(i);
            if(d.getEnd_time().compareTo(new Date())>0){
                List<Area> area= areaService.selectByNameArea(d.getArea_name());
                area.get(0).setNumber(area.get(0).getNumber()+1);
                areaService.updateNumberArea(area.get(0));
            }
        }
        List<Area> areaList= areaService.selectArea();
        Integer code=areaList!=null?Code.GET_OK:Code.GET_ERR;
        String msg=areaList!=null?"":"数据查询失败，请重试！";
        return new Result(code,areaList,msg);
    }

    @GetMapping("/{id}")
    public Result selectByIdArea(@PathVariable Integer id) {
        Area area= areaService.selectByIdArea(id);
        Integer code=area!=null?Code.GET_OK:Code.GET_ERR;
        String msg=area!=null?"":"数据查询失败，请重试！";
        return new Result(code,area,msg);
    }
    @GetMapping("/name/{area_name}")
    public Result selectByNameArea(@PathVariable String area_name) {
        List<Area> area= areaService.selectByNameArea(area_name);
        Integer code=area!=null?Code.GET_OK:Code.GET_ERR;
        String msg=area!=null?"":"数据查询失败，请重试！";
        return new Result(code,area,msg);
    }

    @PutMapping
    public Result updateArea(@RequestBody Area area) {
        boolean flag= areaService.updateArea(area);
        return new Result(flag?Code.UPDATE_OK:Code.UPDATE_ERR,flag);
    }

    @DeleteMapping("/{id}")
    public Result deleteArea(@PathVariable Integer id) {
        boolean flag= areaService.deleteArea(id);
        return new Result(flag?Code.DELETE_OK:Code.DELETE_ERR,flag);
    }
}
