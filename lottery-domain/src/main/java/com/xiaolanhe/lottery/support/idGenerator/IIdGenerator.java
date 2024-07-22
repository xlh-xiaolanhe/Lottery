package com.xiaolanhe.lottery.support.idGenerator;

/**  id生成策略接口
 * @author xiaolanhe
 * @version V1.0
 * @Package com.xiaolanhe.lottery.idGenerator.policy
 * @date 2024/7/22 23:06
 */
public interface IIdGenerator {
    /**
     * 生成下一个ID
     * @return 下一个ID
     */
    long nextId();
}
