package com.xiaolanhe.lottery.support.idGenerator.policy;

import com.xiaolanhe.lottery.support.idGenerator.IIdGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/** 短码生成策略，仅支持很小的调用量，用于生成活动配置类编号，保证全局唯一
 *@author: xiaolanhe
 *@createDate: 2024/7/22 23:21
 */
@Component
public class ShortCode implements IIdGenerator {

    private Logger logger = LoggerFactory.getLogger(ShortCode.class);

    private final Lock lock = new ReentrantLock();
    @Override
    public long nextId() {
        try{
            lock.tryLock(1000, TimeUnit.MILLISECONDS);
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int week = calendar.get(Calendar.WEEK_OF_YEAR);
            int day = calendar.get(Calendar.DAY_OF_WEEK);
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            // 打乱排序：2020年为准 + 小时 + 周期 + 日 + 三位随机数
            StringBuilder idStr = new StringBuilder();
            idStr.append(year - 2024);
            idStr.append(hour);
            idStr.append(String.format("%02d", week));
            idStr.append(day);
            idStr.append(String.format("%03d", new Random().nextInt(1000)));
            return Long.parseLong(idStr.toString());
        }catch (Exception e){
            logger.error("ShortCode产生id异常", e);
            return 0;
        }finally {
            lock.unlock();
        }
    }
}
