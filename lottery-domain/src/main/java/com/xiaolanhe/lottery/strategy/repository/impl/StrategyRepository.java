package com.xiaolanhe.lottery.strategy.repository.impl;

import com.xiaolanhe.lottery.infrastructure.dao.IAwardDao;
import com.xiaolanhe.lottery.infrastructure.dao.IStrategyDao;
import com.xiaolanhe.lottery.infrastructure.dao.IStrategyDetailDao;
import com.xiaolanhe.lottery.infrastructure.po.Award;
import com.xiaolanhe.lottery.infrastructure.po.Strategy;
import com.xiaolanhe.lottery.infrastructure.po.StrategyDetail;
import com.xiaolanhe.lottery.strategy.model.aggregates.StrategyRich;
import com.xiaolanhe.lottery.strategy.repository.IStrategyRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 *@author: xiaolanhe
 *@createDate: 2024/7/13 20:16
 */

@Component
public class StrategyRepository implements IStrategyRepository {
    @Resource
    private IStrategyDao strategyDao;

    @Resource
    private IStrategyDetailDao strategyDetailDao;

    @Resource
    private IAwardDao awardDao;
    @Override
    public StrategyRich queryStrategyRich(Long strategyId) {
        Strategy strategy = strategyDao.queryStrategy(strategyId);
        List<StrategyDetail> strategyDetailList = strategyDetailDao.queryStrategyDetailList(strategyId);
        return new StrategyRich(strategyId, strategy, strategyDetailList);
    }

    @Override
    public Award queryAwardInfo(String awardId) {
        return awardDao.queryAwardInfo(awardId);
    }

    @Override
    public List<String> queryNoStockAwardIds(Long strategyId) {
        return strategyDetailDao.queryNoStockStrategyAwardList(strategyId);
    }

    @Override
    public boolean deductStock(Long strategyId, String awardId) {
        StrategyDetail strategyDetail = new StrategyDetail();
        strategyDetail.setStrategyId(strategyId);
        strategyDetail.setAwardId(awardId);
        int count = strategyDetailDao.deductStock(strategyDetail);
        return count == 1;
    }
}
