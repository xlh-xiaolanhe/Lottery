package com.xiaolanhe.lottery.infrastructure.dao;

import com.xiaolanhe.lottery.infrastructure.po.Activity;
import org.apache.ibatis.annotations.Mapper;

/**
 *@author: xiaolanhe
 *@createDate: 2024/7/9 22:44
 */

@Mapper
public interface IActivityDao {
    void insert(Activity activity);

    Activity queryActivityById(Long activityId);
}
