package com.xiaolanhe.lottery.award.service.goods;

import com.xiaolanhe.lottery.award.model.request.GoodsRequest;
import com.xiaolanhe.lottery.award.model.response.DistributionResponse;

/** 商品配送接口
 * @author xiaolanhe
 * @version V1.0
 * @Package com.xiaolanhe.lottery.award.service.goods
 * @date 2024/7/14 20:03
 */
public interface IDistributionGoods {
    /**
     * 奖品配送接口，奖品类型（1:文字描述、2:兑换码、3:优惠券、4:实物奖品）
     *
     * @param req   物品信息
     * @return      配送结果
     */
    DistributionResponse doDistribution(GoodsRequest req);

    Integer getDistributionGoodsName();
}
