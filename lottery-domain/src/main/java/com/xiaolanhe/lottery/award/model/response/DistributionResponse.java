package com.xiaolanhe.lottery.award.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;

/** 商品配送结果
 *@author: xiaolanhe
 *@createDate: 2024/7/14 19:53
 */

@Data
@AllArgsConstructor
public class DistributionResponse {

    /** 用户ID */
    private String uId;

    /** 编码 */
    private Integer code;
    /** 描述 */
    private String info;

    /** 结算单ID，如：发券后有券码、发货后有单号等，用于存根查询 */
    private String statementId;

    public DistributionResponse(String uId, Integer code, String info) {
        this.uId = uId;
        this.code = code;
        this.info = info;
    }
}
