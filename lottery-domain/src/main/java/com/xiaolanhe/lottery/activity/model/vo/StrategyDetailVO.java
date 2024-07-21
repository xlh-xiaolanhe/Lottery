package com.xiaolanhe.lottery.activity.model.vo;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

/** 策略详情配置
 *@author: xiaolanhe
 *@createDate: 2024/7/21 20:28
 */

@Data
@ToString
public class StrategyDetailVO {

    /**
     * 策略ID
     */
    private Long strategyId;

    /**
     * 奖品ID
     */
    private String awardId;

    /**
     * 奖品名称
     */
    private String awardName;

    /**
     * 奖品库存
     */
    private Integer awardCount;

    /**
     * 奖品剩余库存
     */
    private Integer awardSurplusCount;

    /**
     * 中奖概率
     */
    private BigDecimal awardRate;
}
