package com.xiaolanhe.lottery.award.service.goods.impl;/**
 * @Package com.xiaolanhe.lottery.award.service.goods.impl
 * @author xiaolanhe
 * @date 2024/7/14 20:24
 * @version V1.0
 */

import com.xiaolanhe.lottery.award.model.request.GoodsRequest;
import com.xiaolanhe.lottery.award.model.response.DistributionResponse;
import com.xiaolanhe.lottery.award.service.goods.DistributionBase;
import com.xiaolanhe.lottery.award.service.goods.IDistributionGoods;
import com.xiaolanhe.lottery.common.Constants;
import org.springframework.stereotype.Component;

/** 实物奖品
 *@author: xiaolanhe
 *@createDate: 2024/7/14 20:24
 */
@Component
public class PhysicalGoods extends DistributionBase implements IDistributionGoods {
    @Override
    public DistributionResponse doDistribution(GoodsRequest req) {
        // 模拟调用实物发奖
        logger.info("模拟调用实物发奖 uId：{} awardContent：{}", req.getUid(), req.getAwardContent());

        // 更新用户领奖结果
        super.updateUserAwardState(req.getUid(), req.getOrderId(), req.getAwardId(), Constants.AwardStateEnum.SUCCESS.getCode(), Constants.AwardStateEnum.SUCCESS.getInfo());

        return new DistributionResponse(req.getUid(), Constants.AwardStateEnum.SUCCESS.getCode(), Constants.AwardStateEnum.SUCCESS.getInfo());
    }

    @Override
    public Integer getDistributionGoodsName() {
        return Constants.AwardTypeEnum.PHYSICAL.getCode();
    }
}
