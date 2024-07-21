package com.xiaolanhe.lottery.infrastructure.dao;

import com.xiaolanhe.lottery.infrastructure.po.Award;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author xiaolanhe
 * @version V1.0
 * @Package com.xiaolanhe.lottery.infrastructure.dao
 * @date 2024/7/13 16:55
 */

@Mapper
public interface IAwardDao {
    Award queryAwardInfo(String awardId);

    void insertList(List<Award> req);

}
