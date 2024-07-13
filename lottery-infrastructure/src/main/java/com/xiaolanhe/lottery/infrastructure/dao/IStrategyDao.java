package com.xiaolanhe.lottery.infrastructure.dao;

import com.xiaolanhe.lottery.infrastructure.po.Strategy;

/**
 * @author xiaolanhe
 * @version V1.0
 * @Package com.xiaolanhe.lottery.infrastructure.dao
 * @date 2024/7/13 16:55
 */
public interface IStrategyDao {
    Strategy queryStrategy(Long strategyId);
}
