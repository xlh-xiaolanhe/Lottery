package com.xiaolanhe.lottery.strategy.repository;


import com.xiaolanhe.lottery.strategy.model.aggregates.StrategyRich;
import com.xiaolanhe.lottery.strategy.model.vo.AwardBriefVO;

import java.util.List;

/**
 * @author xiaolanhe
 * @version V1.0
 * @Package com.xiaolanhe.lottery.strategy.repository
 * @date 2024/7/13 20:12
 */
public interface IStrategyRepository {
    StrategyRich queryStrategyRich(Long strategyId);

    AwardBriefVO queryAwardInfo(String awardId);

    List<String> queryNoStockAwardIds(Long strategyId);

    boolean deductStock(Long strategyId, String awardId);
}
