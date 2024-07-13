package com.xiaolanhe.lottery.strategy.service.algorithm;

import com.xiaolanhe.lottery.strategy.model.vo.AwardRateInfo;

import java.util.List;

/** 抽奖算法接口
 * @author xiaolanhe
 * @version V1.0
 * @Package com.xiaolanhe.lottery.strategy.service.algorithm
 * @date 2024/7/13 16:59
 */
public interface IDrawAlgorithm {

    /**
     * desciption  初始化中奖概率元组
     * @param strategyId 策略ID
     * @param awardRateInfoList 奖品概率配置集合
     * @return void
     * @Date 2024/7/13 17:03
    */
    void initRateTuple(Long strategyId, List<AwardRateInfo> awardRateInfoList);

    /**
     * desciption 此策略iD是否已经初始化过
      * @param strategyId
     * @return boolean
     * @Date 2024/7/13 18:48
    */
    boolean isExistRateTuple(Long strategyId);

    /**
     * desciption 生成随机数，再根据对应的抽奖算法，返回中奖结果
      * @param strategyId
     * @param excludeAwardIds 排除掉不能作为抽奖的奖品id
     * @return java.lang.String
     * @Date 2024/7/13 18:49
    */
    String randomDraw(Long strategyId, List<String> excludeAwardIds);
}
