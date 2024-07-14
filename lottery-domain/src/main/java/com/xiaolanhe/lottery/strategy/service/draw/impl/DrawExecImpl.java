package com.xiaolanhe.lottery.strategy.service.draw.impl;

import cn.hutool.json.JSONUtil;
import com.xiaolanhe.lottery.strategy.service.algorithm.IDrawAlgorithm;
import com.xiaolanhe.lottery.strategy.service.draw.AbstractDrawBase;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 *@author: xiaolanhe
 *@createDate: 2024/7/13 20:11
 */

@Service("drawExec")
@Data
public class DrawExecImpl extends AbstractDrawBase {
    private Logger logger = LoggerFactory.getLogger(DrawExecImpl.class);

    @Override
    protected List<String> queryExcludeAwardIds(Long strategyId) {
        List<String> excludesIds = strategyRepository.queryNoStockAwardIds(strategyId);
        logger.info("执行抽奖策略 strategyId：{}，无库存排除奖品列表ID集合 excludesIds：{}", strategyId, JSONUtil.toJsonStr(excludesIds));
        return excludesIds;
    }

    @Override
    protected String drawAlgorithm(Long strategyId, IDrawAlgorithm drawAlgorithm, List<String> excludeAwardIds) {
        // 进行抽奖
        String awardId = drawAlgorithm.randomDraw(strategyId, excludeAwardIds);

        if(!StringUtils.hasText(awardId)){
            return null;
        }

        // 扣减库存，暂时采用数据库行级锁的方式进行扣减库存，后续优化为 Redis 分布式锁扣减 decr/incr
        boolean deductResult = strategyRepository.deductStock(strategyId, awardId);

        // 返回结果，库存扣减成功返回奖品ID，否则返回NULL 「在实际的业务场景中，如果中奖奖品库存为空，则会发送兜底奖品，比如各类券」
        return deductResult ? awardId : null;
    }
}
