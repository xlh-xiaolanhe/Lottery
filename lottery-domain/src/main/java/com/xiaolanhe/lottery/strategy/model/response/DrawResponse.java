package com.xiaolanhe.lottery.strategy.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *@author: xiaolanhe
 *@createDate: 2024/7/13 18:41
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DrawResponse {
    private String uid;
    private Long strategyId;
    /**
     * 奖品ID
    */
    private String awardId;

    /**
     * 奖品名称
    */
    private String awardName;
}
