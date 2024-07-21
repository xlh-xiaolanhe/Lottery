package com.xiaolanhe.lottery.activity.service.stateFlow;

import com.xiaolanhe.lottery.activity.respository.IActivityRepository;
import com.xiaolanhe.lottery.common.Constants;
import com.xiaolanhe.lottery.common.Result;

import javax.annotation.Resource;

/** 活动状态抽象类
 *@author: xiaolanhe
 *@createDate: 2024/7/21 21:20
 */
public abstract class AbstractState {

    @Resource
    protected IActivityRepository activityRepository;

    /** 活动提审
     *@param: activityId
     *@param: currentState
     */
    public abstract Result arraignment(Long activityId, Enum<Constants.ActivityStateEnum> currentState);

    /**
     * 审核通过
     * @param activityId
     * @param currentState
    */
    public abstract Result checkPass(Long activityId, Enum<Constants.ActivityStateEnum> currentState);

    /**
     * 审核拒绝
     * @param activityId
     * @param currentState
     */
    public abstract Result checkRefuse(Long activityId, Enum<Constants.ActivityStateEnum> currentState);

    /**
     * 撤销审核
     * @param activityId
     * @param currentState
     */
    public abstract Result checkRevoke(Long activityId, Enum<Constants.ActivityStateEnum> currentState);


    /**
     * 关闭活动
     * @param activityId
     * @param currentState
     */
    public abstract Result close(Long activityId, Enum<Constants.ActivityStateEnum> currentState);

    /**
     * 打开活动
     * @param activityId
     * @param currentState
     */
    public abstract Result open(Long activityId, Enum<Constants.ActivityStateEnum> currentState);

    /**
     * 执行活动
     * @param activityId
     * @param currentState
     */
    public abstract Result doing(Long activityId, Enum<Constants.ActivityStateEnum> currentState);
}
