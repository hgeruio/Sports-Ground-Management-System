package com.example.service;

import com.example.domain.Fellow;
import org.apache.ibatis.annotations.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface FellowService {
    /**
     * 保存
     * @param fellow
     * @return
     */
    public boolean saveFellow(Fellow fellow);

    /**
     * 查询
     * @return
     */
    public List<Fellow> selectFellow();

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public Fellow selectIdFellow(Integer id);

    /**
     * 根据条件查询
     * @param fellow_phone
     * @return
     */
    public List<Fellow> selectByFellow(String fellow_phone);

    /**
     * 更新
     * @param fellow
     * @return
     */
    public boolean updateFellow(Fellow fellow);

    /**
     * 删除
     * @param id
     * @return
     */
    public boolean deleteFellow(Integer id);
}
