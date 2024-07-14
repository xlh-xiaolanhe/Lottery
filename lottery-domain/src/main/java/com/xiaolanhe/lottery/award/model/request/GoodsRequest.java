package com.xiaolanhe.lottery.award.model.request;

import com.xiaolanhe.lottery.award.model.vo.ShippingAddress;
import lombok.Data;

/** 奖品发货信息
 *@author: xiaolanhe
 *@createDate: 2024/7/14 19:46
 */

@Data
public class GoodsRequest {
    /**
     用户id
    */
    private String uid;
    /**
     抽奖单号id
    */
    private String orderId;
    /**
     奖品id
    */
    private String awardId;
    /**
     奖品名称
    */
    private String awardName;

    /**
     奖品内容(描述、奖品码、sku)
    */
    private String awardContent;

    /**
     送货地址(只有实物类商品需要地址)
    */
    private ShippingAddress shippingAddress;

    /**
     扩展信息
    */
    private String extInfo;

    public GoodsRequest(String uid, String number, String awardId, String awardName, String awardContent) {
        this.uid = uid;
        this.orderId = orderId;
        this.awardId = awardId;
        this.awardName = awardName;
        this.awardContent = awardContent;
    }
}
