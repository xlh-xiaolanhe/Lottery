package com.xiaolanhe.lottery.strategy.service.algorithm.impl;

import com.xiaolanhe.lottery.strategy.model.vo.AwardRateInfo;
import com.xiaolanhe.lottery.strategy.service.algorithm.BaseDrawAlgorithm;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/** 排掉已经中奖的概率，重新计算中奖范围
 *@author: xiaolanhe
 *@createDate: 2024/7/13 18:53
 */

@Component("entiretyRateRandomDrawAlgorithm")
public class EntiretyRateRandomDrawAlgorithm extends BaseDrawAlgorithm {
    @Override
    public String randomDraw(Long strategyId, List<String> excludeAwardIds) {
        List<AwardRateInfo> avilavableList = Optional.ofNullable(awardRateInfoMap.get(strategyId)).orElse(new ArrayList<>()).stream()
                .filter(n -> !excludeAwardIds.contains(n.getAwardId()))
                .collect(Collectors.toList());

        if(CollectionUtils.isEmpty(avilavableList)) return "";

        // 因为会排除excludeAwardIds，所以重新计算总概率
        BigDecimal totalRate = avilavableList.stream().map(AwardRateInfo::getAwardRate).reduce(BigDecimal.ZERO, BigDecimal::add);

        if(avilavableList.size() == 1) return avilavableList.get(0).getAwardId();

        // 获取随机概率值
        SecureRandom secureRandom = new SecureRandom();
        int random = secureRandom.nextInt(100) + 1;

        String awardId = "";
        int curPos = 0;
        for(AwardRateInfo info : avilavableList){
            int rateVal = info.getAwardRate().divide(totalRate, 2, BigDecimal.ROUND_UP).multiply(new BigDecimal(100)).intValue();
            // 看看落在哪个中奖区间
            if(random <= (curPos + rateVal)){
                awardId = info.getAwardId();
                break;
            }
            curPos += rateVal;
        }
        return awardId;
    }
}
