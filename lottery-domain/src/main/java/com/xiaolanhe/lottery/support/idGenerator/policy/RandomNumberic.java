package com.xiaolanhe.lottery.support.idGenerator.policy;

import com.xiaolanhe.lottery.support.idGenerator.IIdGenerator;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

/**
 *@author: xiaolanhe
 *@createDate: 2024/7/22 23:27
 */
@Component
public class RandomNumberic implements IIdGenerator {
    @Override
    public long nextId() {
        return Long.parseLong(RandomStringUtils.randomNumeric(11));
    }
}
