package com.xiaolanhe.lottery.infrastructure.dao;

import com.xiaolanhe.lottery.infrastructure.po.Strategy;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author xiaolanhe
 * @version V1.0
 * @Package com.xiaolanhe.lottery.infrastructure.dao
 * @date 2024/7/13 16:55
 */
@Mapper
public interface IStrategyDao {
    Strategy queryStrategy(Long strategyId);

    void insert(Strategy req);

}
