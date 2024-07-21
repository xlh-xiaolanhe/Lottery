package com.xiaolanhe.lottery.activity.service.deploy;

import com.xiaolanhe.lottery.activity.model.request.ActivityConfigRequest;

/**
 * @author xiaolanhe
 * @version V1.0
 * @Package com.xiaolanhe.lottery.activity.service.deploy
 * @date 2024/7/21 20:36
 */
public interface IActivityDeploy {
    /** 创建活动信息
     * @param req
     */
    void createActivity(ActivityConfigRequest req);

    /**
     * desciption 修改活动信息
      * @param req
    */
    void updateActivity(ActivityConfigRequest req);
}
