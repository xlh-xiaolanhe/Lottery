package com.xiaolanhe.lottery.strategy.service.draw;

import com.xiaolanhe.lottery.strategy.service.algorithm.IDrawAlgorithm;
import lombok.Data;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/** 抽奖配置类
 *@author: xiaolanhe
 *@createDate: 2024/7/13 19:53
 */

@Data
public class DrawConfig {

    @Resource
    private IDrawAlgorithm defaultRateRandomDrawAlgorithm;

    @Resource
    private IDrawAlgorithm singleRateRandomDrawAlgorithm;

    protected static Map<Integer,  IDrawAlgorithm> drawAlgorithmMap = new HashMap<>();

    public static void setDrawAlgorithmMap(Map<Integer, IDrawAlgorithm> drawAlgorithmMap) {
        DrawConfig.drawAlgorithmMap = drawAlgorithmMap;
    }

    @PostConstruct
    public void init(){
        drawAlgorithmMap.put(1, defaultRateRandomDrawAlgorithm);
        drawAlgorithmMap.put(2, singleRateRandomDrawAlgorithm);
    }
}
