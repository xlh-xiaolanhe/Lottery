package com.xiaolanhe.lottery.activity.service.stateFlow;

import com.xiaolanhe.lottery.activity.service.stateFlow.event.ArraignmentState;
import com.xiaolanhe.lottery.activity.service.stateFlow.event.CloseState;
import com.xiaolanhe.lottery.activity.service.stateFlow.event.DoingState;
import com.xiaolanhe.lottery.activity.service.stateFlow.event.EditingState;
import com.xiaolanhe.lottery.activity.service.stateFlow.event.OpenState;
import com.xiaolanhe.lottery.activity.service.stateFlow.event.PassState;
import com.xiaolanhe.lottery.activity.service.stateFlow.event.RefuseState;
import com.xiaolanhe.lottery.common.Constants;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *@author: xiaolanhe
 *@createDate: 2024/7/21 22:23
 */
public class StateConfig {
    @Resource
    private ArraignmentState arraignmentState;
    @Resource
    private CloseState closeState;
    @Resource
    private DoingState doingState;
    @Resource
    private EditingState editingState;
    @Resource
    private OpenState openState;
    @Resource
    private PassState passState;
    @Resource
    private RefuseState refuseState;

    protected Map<Enum<Constants.ActivityStateEnum>, AbstractState> stateGroup = new ConcurrentHashMap<>();

    @PostConstruct
    public void init(){
        stateGroup.put(Constants.ActivityStateEnum.ARRAIGNMENT, arraignmentState);
        stateGroup.put(Constants.ActivityStateEnum.CLOSE, closeState);
        stateGroup.put(Constants.ActivityStateEnum.DOING, doingState);
        stateGroup.put(Constants.ActivityStateEnum.EDIT, editingState);
        stateGroup.put(Constants.ActivityStateEnum.OPEN, openState);
        stateGroup.put(Constants.ActivityStateEnum.PASS, passState);
        stateGroup.put(Constants.ActivityStateEnum.REFUSE, refuseState);
    }
}
