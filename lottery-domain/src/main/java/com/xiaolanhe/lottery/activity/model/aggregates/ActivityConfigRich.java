package com.xiaolanhe.lottery.activity.model.aggregates;

import com.xiaolanhe.lottery.activity.model.vo.ActivityVO;
import com.xiaolanhe.lottery.activity.model.vo.AwardVO;
import com.xiaolanhe.lottery.activity.model.vo.StrategyVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**  活动配置聚合信息
 *@author: xiaolanhe
 *@createDate: 2024/7/21 20:31
 */

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ActivityConfigRich {

    /**
     * 活动配置
     */
    private ActivityVO activity;

    /**
     * 策略配置(含策略明细)
     */
    private StrategyVO strategy;

    /**
     * 奖品配置
     */
    private List<AwardVO> awardList;
}