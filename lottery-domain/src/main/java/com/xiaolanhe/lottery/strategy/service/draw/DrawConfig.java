package com.xiaolanhe.lottery.strategy.service.draw;

import com.xiaolanhe.lottery.common.Constants;
import com.xiaolanhe.lottery.strategy.service.algorithm.IDrawAlgorithm;
import lombok.Data;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/** 抽奖配置类
 *@author: xiaolanhe
 *@createDate: 2024/7/13 19:53
 */

@Data
public class DrawConfig {

    @Resource
    private IDrawAlgorithm entiretyRateRandomDrawAlgorithm;

    @Resource
    private IDrawAlgorithm singleRateRandomDrawAlgorithm;

    protected static Map<Integer,  IDrawAlgorithm> drawAlgorithmMap = new ConcurrentHashMap<>();


    @PostConstruct
    public void init(){
        drawAlgorithmMap.put(Constants.StrategyModeEnum.SINGLE.getCode(), singleRateRandomDrawAlgorithm);
        drawAlgorithmMap.put(Constants.StrategyModeEnum.ENTIRETY.getCode(), entiretyRateRandomDrawAlgorithm);
    }
}
