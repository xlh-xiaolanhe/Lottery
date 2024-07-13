package com.xiaolanhe.lottery.strategy.service.draw.impl;

import com.xiaolanhe.lottery.infrastructure.po.Award;
import com.xiaolanhe.lottery.infrastructure.po.Strategy;
import com.xiaolanhe.lottery.infrastructure.po.StrategyDetail;
import com.xiaolanhe.lottery.strategy.model.aggregates.StrategyRich;
import com.xiaolanhe.lottery.strategy.model.request.DrawRequest;
import com.xiaolanhe.lottery.strategy.model.response.DrawResponse;
import com.xiaolanhe.lottery.strategy.repository.IStrategyRepository;
import com.xiaolanhe.lottery.strategy.service.algorithm.IDrawAlgorithm;
import com.xiaolanhe.lottery.strategy.service.draw.DrawBase;
import com.xiaolanhe.lottery.strategy.service.draw.IDrawExec;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 *@author: xiaolanhe
 *@createDate: 2024/7/13 20:11
 */

@Service("drawExec")
@Data
public class DrawExecImpl extends DrawBase implements IDrawExec {
    private Logger logger = LoggerFactory.getLogger(DrawExecImpl.class);

    @Resource
    private IStrategyRepository strategyRepository;
    @Override
    public DrawResponse doDrawExec(DrawRequest request) {
        logger.info("执行策略抽奖开始，strategyId：{}", request.getStrategyId());
        // 获取抽奖策略配置数据
        StrategyRich strategyRich = strategyRepository.queryStrategyRich(request.getStrategyId());
        Strategy strategy = strategyRich.getStrategy();
        List<StrategyDetail> strategyDetailList = strategyRich.getStrategyDetailList();

        // 校验和初始化数据
        checkAndInitData(request.getStrategyId(), strategy.getStrategyMode(), strategyDetailList);

        // 根据策略方式进行抽奖
        IDrawAlgorithm drawAlgorithm = drawAlgorithmMap.get(strategy.getStrategyMode());
        String awardId = drawAlgorithm.randomDraw(request.getStrategyId(), new ArrayList<>());

        // 获取奖品信息
        Award award = strategyRepository.queryAwardInfo(awardId);

        logger.info("执行策略抽奖完成，中奖用户：{} 奖品ID：{} 奖品名称：{}", request.getUid(), awardId, award.getAwardName());

        // 封装结果
        return new DrawResponse(request.getUid(), request.getStrategyId(), awardId, award.getAwardName());
    }
}
