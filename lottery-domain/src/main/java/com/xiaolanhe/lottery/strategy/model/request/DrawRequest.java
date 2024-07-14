package com.xiaolanhe.lottery.strategy.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *@author: xiaolanhe
 *@createDate: 2024/7/13 18:40
 */

@Data
@AllArgsConstructor
public class DrawRequest {
    private String uid;
    private Long strategyId;
}
