package com.xiaolanhe.lottery.strategy.service.draw;

import com.xiaolanhe.lottery.infrastructure.po.StrategyDetail;
import com.xiaolanhe.lottery.strategy.model.vo.AwardRateInfo;
import com.xiaolanhe.lottery.strategy.service.algorithm.IDrawAlgorithm;
import java.util.List;
import java.util.stream.Collectors;

/**
 *@author: xiaolanhe
 *@createDate: 2024/7/13 20:02
 */
public class DrawBase extends DrawConfig{

    public void checkAndInitData(Long strategyId, Integer strategyMode, List<StrategyDetail> strategyDetailList){
        if(strategyMode != 1 && strategyMode != 2){
            return;
        }

        IDrawAlgorithm drawAlgorithm = drawAlgorithmMap.get(strategyMode);

        if(drawAlgorithm.isExistRateTuple(strategyId)) return;

        List<AwardRateInfo> awardRateInfoList = strategyDetailList.stream()
                .map(n -> new AwardRateInfo(n.getAwardId(), n.getAwardRate())).collect(Collectors.toList());

        drawAlgorithm.initRateTuple(strategyId, awardRateInfoList);
    }
}
