package com.xiaolanhe.lottery.strategy.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/** 奖品及中将概率信息组合类
 *@author: xiaolanhe
 *@createDate: 2024/7/13 17:01
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AwardRateInfo {
    private String awardId;
    private BigDecimal awardRate;
}
