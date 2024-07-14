package com.xiaolanhe.lottery.award.service.goods.impl;

import com.xiaolanhe.lottery.award.model.request.GoodsRequest;
import com.xiaolanhe.lottery.award.model.response.DistributionResponse;
import com.xiaolanhe.lottery.award.service.goods.DistributionBase;
import com.xiaolanhe.lottery.award.service.goods.IDistributionGoods;
import com.xiaolanhe.lottery.common.Constants;
import org.springframework.stereotype.Component;

/** 优惠券类型商品
 *@author: xiaolanhe
 *@createDate: 2024/7/14 20:10
 */

@Component
public class CouponGoods extends DistributionBase implements IDistributionGoods {
    @Override
    public DistributionResponse doDistribution(GoodsRequest req) {
        // 模拟调用优惠券发放接口
        logger.info("模拟调用优惠券发放接口 uId：{} awardContent：{}", req.getUid(), req.getAwardContent());

        // 更新用户领奖结果
        super.updateUserAwardState(req.getUid(), req.getOrderId(), req.getAwardId(), Constants.AwardStateEnum.SUCCESS.getCode(), Constants.AwardStateEnum.SUCCESS.getInfo());

        return new DistributionResponse(req.getUid(), Constants.AwardStateEnum.SUCCESS.getCode(), Constants.AwardStateEnum.SUCCESS.getInfo());
    }

    @Override
    public Integer getDistributionGoodsName() {
       return Constants.AwardTypeEnum.COUPON.getCode();
    }
}
