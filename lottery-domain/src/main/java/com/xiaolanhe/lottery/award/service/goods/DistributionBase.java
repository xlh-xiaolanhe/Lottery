package com.xiaolanhe.lottery.award.service.goods;

import com.xiaolanhe.lottery.award.repository.IAwardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**  商品配送基类
 *@author: xiaolanhe
 *@createDate: 2024/7/14 20:04
 */
public class DistributionBase{
    protected Logger logger = LoggerFactory.getLogger(DistributionBase.class);

    @Resource
    private IAwardRepository awardRepository;

    /**
     * desciption 更新用户奖品发放状态
      * @param uid
     * @param orderId
     * @param awardId
     * @param awardState
     * @param awardStateInfo
     * @return void
     * @Date 2024/7/14 20:08
    */
    protected void updateUserAwardState(String uid, String orderId, String awardId, Integer awardState, String awardStateInfo) {
        // TODO 后期添加更新分库分表中，用户个人的抽奖记录表中奖品发奖状态
        logger.info("TODO 后期添加更新分库分表中，用户个人的抽奖记录表中奖品发奖状态 uid：{}", uid);
    }
}
