package com.xiaolanhe.lottery.award.service.factory;

import com.xiaolanhe.lottery.award.service.goods.IDistributionGoods;
import org.springframework.stereotype.Service;

/** 配送商品简单工厂
 *@author: xiaolanhe
 *@createDate: 2024/7/14 20:32
 */

@Service
public class DistributionGoodsSimpleFactory extends GoodsConfig{
    public IDistributionGoods getDistributionGoodsService(Integer goodsType) {
        return goodsMap.get(goodsType);
    }
}
