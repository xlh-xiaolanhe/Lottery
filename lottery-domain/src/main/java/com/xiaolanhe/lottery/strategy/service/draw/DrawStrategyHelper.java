package com.xiaolanhe.lottery.strategy.service.draw;


import com.xiaolanhe.lottery.strategy.model.aggregates.StrategyRich;
import com.xiaolanhe.lottery.strategy.model.vo.AwardBriefVO;
import com.xiaolanhe.lottery.strategy.repository.IStrategyRepository;

import javax.annotation.Resource;

/** 抽奖策略辅助类, 存放一些通用的数据
 *@author: xiaolanhe
 *@createDate: 2024/7/14 14:51
 */
public class DrawStrategyHelper extends DrawConfig{

    @Resource
    protected IStrategyRepository strategyRepository;

    /**
     * desciption 根据抽奖策略id，查询策略配置信息与策略明细
      * @param strategyID
     * @return com.xiaolanhe.lottery.strategy.model.aggregates.StrategyRich
     * @Date 2024/7/14 14:54
    */
    protected StrategyRich queryStrategyRich(Long strategyID) {
        return strategyRepository.queryStrategyRich(strategyID);
    }

    protected AwardBriefVO queryAwardInfo(String awardId) {
        return strategyRepository.queryAwardInfo(awardId);
    }
}
