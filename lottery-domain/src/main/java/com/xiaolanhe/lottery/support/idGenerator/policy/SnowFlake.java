package com.xiaolanhe.lottery.support.idGenerator.policy;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.json.JSONUtil;
import com.xiaolanhe.lottery.support.idGenerator.IIdGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *@author: xiaolanhe
 *@createDate: 2024/7/22 23:08
 */
@Component
public class SnowFlake implements IIdGenerator {

    private Snowflake snowflake;
    private final Lock lock = new ReentrantLock();

    private Logger logger = LoggerFactory.getLogger(SnowFlake.class);

    public SnowFlake(){
        long workerId;
        try{
            workerId = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
        }catch (Exception e){
            workerId = NetUtil.getLocalhost().hashCode();
        }
        workerId = workerId >> 16 & 31;
        long dataCenterId = 1L;
        snowflake = IdUtil.createSnowflake(workerId, dataCenterId);
    }



    @Override
    public long nextId() {
        try {
            lock.tryLock(1000, TimeUnit.MILLISECONDS);
            return snowflake.nextId();
        } catch (InterruptedException e) {
            logger.error("SnowFlake生成id异常", e);
            return 0L;
        }finally {
            lock.unlock();
        }
    }
}
