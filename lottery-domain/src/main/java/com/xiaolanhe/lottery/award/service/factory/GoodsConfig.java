package com.xiaolanhe.lottery.award.service.factory;

import com.xiaolanhe.lottery.award.service.goods.IDistributionGoods;
import com.xiaolanhe.lottery.award.service.goods.impl.CouponGoods;
import com.xiaolanhe.lottery.award.service.goods.impl.DescGoods;
import com.xiaolanhe.lottery.award.service.goods.impl.PhysicalGoods;
import com.xiaolanhe.lottery.award.service.goods.impl.RedeemCodeGoods;
import com.xiaolanhe.lottery.common.Constants;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/** 各类发奖奖品配置类
 *@author: xiaolanhe
 *@createDate: 2024/7/14 20:30
 */
public class GoodsConfig {
    protected  Map<Integer, IDistributionGoods> goodsMap = new ConcurrentHashMap<>();

    @Resource
    private DescGoods descGoods;

    @Resource
    private RedeemCodeGoods redeemCodeGoods;

    @Resource
    private CouponGoods couponGoods;

    @Resource
    private PhysicalGoods physicalGoods;

    @PostConstruct
    public void init() {
        goodsMap.put(Constants.AwardTypeEnum.DESC.getCode(), descGoods);
        goodsMap.put(Constants.AwardTypeEnum.RedeemCode.getCode(), redeemCodeGoods);
        goodsMap.put(Constants.AwardTypeEnum.COUPON.getCode(), couponGoods);
        goodsMap.put(Constants.AwardTypeEnum.PHYSICAL.getCode(), physicalGoods);
    }
}
