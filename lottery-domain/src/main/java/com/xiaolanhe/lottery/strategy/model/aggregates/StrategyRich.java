package com.xiaolanhe.lottery.strategy.model.aggregates;


import com.xiaolanhe.lottery.strategy.model.vo.StrategyBriefVO;
import com.xiaolanhe.lottery.strategy.model.vo.StrategyDetailBriefVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 *@author: xiaolanhe
 *@createDate: 2024/7/13 20:14
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StrategyRich {
    private Long strategyId;
    private StrategyBriefVO strategy;
    private List<StrategyDetailBriefVO> strategyDetailList;
}
