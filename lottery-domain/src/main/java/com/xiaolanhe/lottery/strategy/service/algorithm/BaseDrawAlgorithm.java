package com.xiaolanhe.lottery.strategy.service.algorithm;

import com.xiaolanhe.lottery.strategy.model.vo.AwardRateInfo;
import org.apache.commons.collections4.CollectionUtils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *@author: xiaolanhe
 *@createDate: 2024/7/13 18:46
 */
public abstract class BaseDrawAlgorithm implements IDrawAlgorithm{

    // 斐波那契散列增量
    private final int HASH_INCREMENT = 0x61c88647;

    // 数组初始化长度
    private final int ARR_LENGTH = 128;

    // 存放概率与奖品对应的散列结果 strategyId -> rateTuple
    protected Map<Long, String[]> rateTupleMap = new HashMap<>();

    // 奖品区间概率  strategyId -> [awardId->begin、awardId->end]
    protected Map<Long, List<AwardRateInfo>> awardRateInfoMap = new HashMap<>();

    @Override
    public void initRateTuple(Long strategyId, List<AwardRateInfo> awardRateInfoList) {
        awardRateInfoMap.put(strategyId, awardRateInfoList);

        // 将给定的中奖概率，根据斐波那契散列，映射到数组中
        String[] rateTuple = rateTupleMap.computeIfAbsent(strategyId, n -> new String[ARR_LENGTH]);
        int curPos = 0;
        if(CollectionUtils.isNotEmpty(awardRateInfoList)){
            for(AwardRateInfo info : awardRateInfoList){
                int rateValue = info.getAwardRate().multiply(new BigDecimal(100)).intValue();

                //根据当前奖品的中奖概率区间，映射到数组中
                for(int i = curPos + 1; i <= (rateValue + curPos); i++){
                    rateTuple[hashIdx(i)] = info.getAwardId();
                }

                curPos += rateValue;
            }
        }
    }

    @Override
    public boolean isExistRateTuple(Long strategyId) {
        return false;
    }

    /**
     * desciption 斐波那契（Fibonacci）散列法，计算哈希索引下标值v
      * @param value
     * @return int
     * @Date 2024/7/13 19:19
    */
    protected int hashIdx(int value){
        int hashCode = value * HASH_INCREMENT + HASH_INCREMENT;
        return hashCode & (ARR_LENGTH - 1);
    }
}
