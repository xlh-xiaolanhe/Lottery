package com.xiaolanhe.lottery.activity.service.stateFlow.impl;

import com.xiaolanhe.lottery.activity.service.stateFlow.IStateHandler;
import com.xiaolanhe.lottery.activity.service.stateFlow.StateConfig;
import com.xiaolanhe.lottery.common.Constants;
import com.xiaolanhe.lottery.common.Result;
import org.springframework.stereotype.Service;

/**
 *@author: xiaolanhe
 *@createDate: 2024/7/21 22:30
 */
@Service
public class StateHandlerImpl extends StateConfig implements IStateHandler{
    @Override
    public Result arraignment(Long activityId, Enum<Constants.ActivityStateEnum> currentStatus) {
        return stateGroup.get(currentStatus).arraignment(activityId, currentStatus);
    }

    @Override
    public Result checkPass(Long activityId, Enum<Constants.ActivityStateEnum> currentStatus) {
        return stateGroup.get(currentStatus).checkPass(activityId, currentStatus);
    }

    @Override
    public Result checkRefuse(Long activityId, Enum<Constants.ActivityStateEnum> currentStatus) {
        return stateGroup.get(currentStatus).checkRefuse(activityId, currentStatus);
    }

    @Override
    public Result checkRevoke(Long activityId, Enum<Constants.ActivityStateEnum> currentStatus) {
        return stateGroup.get(currentStatus).checkRevoke(activityId, currentStatus);
    }

    @Override
    public Result close(Long activityId, Enum<Constants.ActivityStateEnum> currentStatus) {
        return stateGroup.get(currentStatus).close(activityId, currentStatus);
    }

    @Override
    public Result open(Long activityId, Enum<Constants.ActivityStateEnum> currentStatus) {
        return stateGroup.get(currentStatus).open(activityId, currentStatus);
    }

    @Override
    public Result doing(Long activityId, Enum<Constants.ActivityStateEnum> currentStatus) {
        return stateGroup.get(currentStatus).doing(activityId, currentStatus);
    }
}
