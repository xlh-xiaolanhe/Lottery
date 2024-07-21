package com.xiaolanhe.lottery.strategy.model.response;

import com.xiaolanhe.lottery.common.Constants;
import com.xiaolanhe.lottery.strategy.model.vo.AwardBriefVO;
import lombok.Data;

/**
 *@author: xiaolanhe
 *@createDate: 2024/7/13 18:41
 */

@Data
public class DrawResponse {
    private String uid;
    private Long strategyId;

    private Integer drawState = Constants.DrawResultEnum.NO_PRIZE.getCode();

    private AwardBriefVO awardInfo;

    public DrawResponse(String uid, Long strategyId, Integer drawState) {
        this.uid = uid;
        this.strategyId = strategyId;
        this.drawState = drawState;
    }

    public DrawResponse(String uid, Long strategyId, Integer drawState, AwardBriefVO awardInfo) {
        this.uid = uid;
        this.strategyId = strategyId;
        this.drawState = drawState;
        this.awardInfo = awardInfo;
    }
}
