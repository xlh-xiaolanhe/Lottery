package com.xiaolanhe.lottery.strategy.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/** 中奖结果封装
 *@author: xiaolanhe
 *@createDate: 2024/7/14 15:27
 */

@Data
public class AwardInfo {
    /**
     * 奖品ID
     */
    private String awardId;

    /**
     * 奖品类型（1:文字描述、2:兑换码、3:优惠券、4:实物奖品）
     */
    private Integer awardType;

    /**
     * 奖品名称
     */
    private String awardName;

    /**
     * 奖品内容「描述、奖品码、sku」
     */
    private String awardContent;

    public AwardInfo(String awardId, String awardName) {
        this.awardId = awardId;
        this.awardName = awardName;
    }

    public AwardInfo(String awardId, Integer awardType, String awardName, String awardContent) {
        this.awardId = awardId;
        this.awardType = awardType;
        this.awardName = awardName;
        this.awardContent = awardContent;
    }
}
