package com.xiaolanhe.lottery.strategy.service.algorithm.impl;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.security.SecureRandom;
import java.util.List;

/** 【推荐】单项随机概率抽奖，抽到一个已经排掉的奖品则未中奖
 *@author: xiaolanhe
 *@createDate: 2024/7/13 19:49
 */

@Component("singleRateRandomDrawAlgorithm")
public class SingleRateRandomDrawAlgorithm extends EntiretyRateRandomDrawAlgorithm {
    @Override
    public String randomDraw(Long strategyId, List<String> excludeAwardIds) {
        String[] rateTuple = rateTupleMap.get(strategyId);
        if(StringUtils.isEmpty(rateTuple)) return "";

        //随机获取索引
        int index = new SecureRandom().nextInt(100) + 1;
        int pos = super.hashIdx(index);

        String awardId = rateTuple[pos];
        if(excludeAwardIds.contains(awardId)) return "未中奖";

        return awardId;
    }
}
