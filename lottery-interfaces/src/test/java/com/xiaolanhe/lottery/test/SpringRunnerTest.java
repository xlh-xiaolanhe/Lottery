package com.xiaolanhe.lottery.test;/**
 * @Package com.xiaolanhe.lottery.test
 * @author xiaolanhe
 * @date 2024/7/14 17:04
 * @version V1.0
 */

import com.alibaba.fastjson.JSON;
import com.xiaolanhe.lottery.infrastructure.dao.IActivityDao;
import com.xiaolanhe.lottery.infrastructure.po.Activity;
import com.xiaolanhe.lottery.strategy.model.request.DrawRequest;
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
}
