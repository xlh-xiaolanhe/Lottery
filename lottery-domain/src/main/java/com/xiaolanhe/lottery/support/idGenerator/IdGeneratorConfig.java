package com.xiaolanhe.lottery.support.idGenerator;

import cn.hutool.core.lang.generator.SnowflakeGenerator;
import com.xiaolanhe.lottery.common.Constants;
import com.xiaolanhe.lottery.support.idGenerator.policy.RandomNumberic;
import com.xiaolanhe.lottery.support.idGenerator.policy.ShortCode;
import com.xiaolanhe.lottery.support.idGenerator.policy.SnowFlake;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 *@author: xiaolanhe
 *@createDate: 2024/7/22 23:29
 */

@Configuration
public class IdGeneratorConfig {
    @Bean(value = "idGeneratorMap")
    public Map<Constants.IdsEnum, IIdGenerator> idGeneratorMap() {
        Map<Constants.IdsEnum, IIdGenerator> idGeneratorMap = new HashMap<>();
        idGeneratorMap.put(Constants.IdsEnum.RandomNumeric, new RandomNumberic());
        idGeneratorMap.put(Constants.IdsEnum.SnowFlake, new SnowFlake());
        idGeneratorMap.put(Constants.IdsEnum.ShortCode, new ShortCode());
        return idGeneratorMap;
    }
}
