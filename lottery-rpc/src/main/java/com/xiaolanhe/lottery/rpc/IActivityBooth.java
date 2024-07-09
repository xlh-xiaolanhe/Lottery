package com.xiaolanhe.lottery.rpc;

import com.xiaolanhe.lottery.rpc.req.ActivityRequest;
import com.xiaolanhe.lottery.rpc.res.ActivityResponse;

/**
 * @author xiaolanhe
 * @version V1.0
 * @Package com.xiaolanhe.lottery.rpc
 * @date 2024/7/9 22:48
 */
public interface IActivityBooth {
    ActivityResponse queryActivityById(ActivityRequest request);
}
