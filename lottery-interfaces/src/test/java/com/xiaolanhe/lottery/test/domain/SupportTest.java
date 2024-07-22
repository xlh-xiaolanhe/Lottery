package com.xiaolanhe.lottery.test.domain;

import com.xiaolanhe.lottery.common.Constants;
import com.xiaolanhe.lottery.support.idGenerator.IIdGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Map;

/**
 *@author: xiaolanhe
 *@createDate: 2024/7/22 23:41
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class SupportTest {
    private Logger logger = LoggerFactory.getLogger(SupportTest.class);

    @Resource(name = "idGeneratorMap")
    private Map<Constants.IdsEnum, IIdGenerator> idGeneratorMap;

    @Test
    public void test_idGenerator() {
        logger.info("雪花算法：{}", idGeneratorMap.get(Constants.IdsEnum.SnowFlake).nextId());
        logger.info("随机数字符串算法：{}", idGeneratorMap.get(Constants.IdsEnum.RandomNumeric).nextId());
        logger.info("短码算法：{}", idGeneratorMap.get(Constants.IdsEnum.ShortCode).nextId());

    }
}
