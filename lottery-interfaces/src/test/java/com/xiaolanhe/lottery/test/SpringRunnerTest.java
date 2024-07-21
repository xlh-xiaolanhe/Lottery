package com.xiaolanhe.lottery.test;/**
 * @Package com.xiaolanhe.lottery.test
 * @author xiaolanhe
 * @date 2024/7/14 17:04
 * @version V1.0
 */

import com.alibaba.fastjson.JSON;
import com.xiaolanhe.lottery.award.model.request.GoodsRequest;
import com.xiaolanhe.lottery.award.model.response.DistributionResponse;
import com.xiaolanhe.lottery.award.service.factory.DistributionGoodsSimpleFactory;
import com.xiaolanhe.lottery.award.service.goods.IDistributionGoods;
import com.xiaolanhe.lottery.common.Constants;
import com.xiaolanhe.lottery.infrastructure.dao.IActivityDao;
import com.xiaolanhe.lottery.infrastructure.po.Activity;
import com.xiaolanhe.lottery.strategy.model.request.DrawRequest;
import com.xiaolanhe.lottery.strategy.model.response.DrawResponse;
import com.xiaolanhe.lottery.strategy.model.vo.AwardBriefVO;
import com.xiaolanhe.lottery.strategy.service.draw.IDrawExec;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

/**
 *@author: xiaolanhe
 *@createDate: 2024/7/14 17:04
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringRunnerTest {
    private Logger logger = LoggerFactory.getLogger(SpringRunnerTest.class);

    @Resource
    private IActivityDao activityDao;

    @Resource
    private IDrawExec drawExec;

    @Resource
    private DistributionGoodsSimpleFactory distributionGoodsSimpleFactory;

    @Test
    public void test_insert() {
        Activity activity = new Activity();
        activity.setActivityId(100002L);
        activity.setActivityName("测试活动");
        activity.setActivityDesc("仅用于插入数据测试");
        activity.setBeginDateTime(new Date());
        activity.setEndDateTime(new Date());
        activity.setStockCount(100);
        activity.setTakeCount(10);
        activity.setState(0);
        activity.setCreator("xiaolanhe");
        activityDao.insert(activity);
    }

    @Test
    public void test_select() {
        Activity activity = activityDao.queryActivityById(100001L);
        logger.info("测试结果：{}", JSON.toJSONString(activity));
    }

    @Test
    public void test_drawExec() {
        drawExec.doDrawExec(new DrawRequest("小傅哥", 10001L));
        drawExec.doDrawExec(new DrawRequest("小佳佳", 10001L));
        drawExec.doDrawExec(new DrawRequest("小蜗牛", 10001L));
        drawExec.doDrawExec(new DrawRequest("八杯水", 10001L));
    }

    @Test
    public void test_award() {
        DrawResponse response = drawExec.doDrawExec(new DrawRequest("xiaolanhe", 10001L));
        Integer drawState = response.getDrawState();

        if (Constants.DrawResultEnum.NO_PRIZE.getCode().equals(drawState)) {
            logger.info("未中奖 DrawAwardInfo is null");
            return;
        }
        // 封装发奖参数，orderId：2109313442431 为模拟ID，需要在用户参与领奖活动时生成
        AwardBriefVO drawAwardInfo = response.getAwardInfo();
        GoodsRequest goodsReq = new GoodsRequest(response.getUid(), "2109313442431", drawAwardInfo.getAwardId(), drawAwardInfo.getAwardName(), drawAwardInfo.getAwardContent());

        // 根据 awardType 从抽奖工厂中获取对应的发奖服务
        IDistributionGoods distributionGoodsService = distributionGoodsSimpleFactory.getDistributionGoodsService(drawAwardInfo.getAwardType());
        DistributionResponse distributionRes = distributionGoodsService.doDistribution(goodsReq);

        logger.info("测试结果：{}", JSON.toJSONString(distributionRes));
    }
}
