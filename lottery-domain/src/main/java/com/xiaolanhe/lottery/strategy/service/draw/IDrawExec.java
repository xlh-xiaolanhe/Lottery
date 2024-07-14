package com.xiaolanhe.lottery.strategy.service.draw;

import com.xiaolanhe.lottery.strategy.model.request.DrawRequest;
import com.xiaolanhe.lottery.strategy.model.response.DrawResponse;

/** 抽奖接口
 * @author xiaolanhe
 * @version V1.0
 * @Package com.xiaolanhe.lottery.strategy.service.draw
 * @date 2024/7/13 18:39
 */
public interface IDrawExec {
    /**
     * 抽奖方法
     * @param request 抽奖请求参数
     * @return 抽奖结果
     */
    DrawResponse doDrawExec(DrawRequest request);
}
