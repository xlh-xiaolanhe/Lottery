package com.xiaolanhe.lottery.activity.service.stateFlow.event;

import com.xiaolanhe.lottery.activity.service.stateFlow.AbstractState;
import com.xiaolanhe.lottery.common.Constants;
import com.xiaolanhe.lottery.common.Result;
import org.springframework.stereotype.Component;

/**
 *@author: xiaolanhe
 *@createDate: 2024/7/21 22:19
 */

@Component
public class PassState extends AbstractState {
    @Override
    public Result arraignment(Long activityId, Enum<Constants.ActivityStateEnum> currentState) {
        return Result.buildResult(Constants.ResponseCode.UN_ERROR, "已审核状态不可重复提审");
    }

    @Override
    public Result checkPass(Long activityId, Enum<Constants.ActivityStateEnum> currentState) {
        return Result.buildResult(Constants.ResponseCode.UN_ERROR, "已审核状态不可重复审核");
    }

    @Override
    public Result checkRefuse(Long activityId, Enum<Constants.ActivityStateEnum> currentState) {
        boolean isSuccess = activityRepository.alterStatus(activityId, currentState, Constants.ActivityStateEnum.REFUSE);
        return isSuccess ? Result.buildResult(Constants.ResponseCode.SUCCESS, "活动审核拒绝完成") : Result.buildErrorResult("活动状态变更失败");
    }

    @Override
    public Result checkRevoke(Long activityId, Enum<Constants.ActivityStateEnum> currentState) {
        return Result.buildResult(Constants.ResponseCode.UN_ERROR, "审核通过不可撤销(可先拒绝审核)");
    }

    @Override
    public Result close(Long activityId, Enum<Constants.ActivityStateEnum> currentState) {
        boolean isSuccess = activityRepository.alterStatus(activityId, currentState, Constants.ActivityStateEnum.CLOSE);
        return isSuccess ? Result.buildResult(Constants.ResponseCode.SUCCESS, "活动审核关闭完成") : Result.buildErrorResult("活动状态变更失败");
    }

    @Override
    public Result open(Long activityId, Enum<Constants.ActivityStateEnum> currentState) {
        return Result.buildResult(Constants.ResponseCode.UN_ERROR, "非关闭活动不可开启");
    }

    @Override
    public Result doing(Long activityId, Enum<Constants.ActivityStateEnum> currentState) {
        boolean isSuccess = activityRepository.alterStatus(activityId, currentState, Constants.ActivityStateEnum.DOING);
        return isSuccess ? Result.buildResult(Constants.ResponseCode.SUCCESS, "活动变更活动中完成") : Result.buildErrorResult("活动状态变更失败");
    }
}
