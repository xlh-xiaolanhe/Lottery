package com.xiaolanhe.lottery.activity.respository;

import com.xiaolanhe.lottery.activity.model.vo.ActivityVO;
import com.xiaolanhe.lottery.activity.model.vo.AwardVO;
import com.xiaolanhe.lottery.activity.model.vo.StrategyDetailVO;
import com.xiaolanhe.lottery.activity.model.vo.StrategyVO;
import com.xiaolanhe.lottery.common.Constants;

import java.util.List;

/**
 * @author xiaolanhe
 * @version V1.0
 * @Package com.xiaolanhe.lottery.activity.resposity
 * @date 2024/7/21 20:35
 */
public interface IActivityRepository {

    void addActivity(ActivityVO activity);

    void addAward(List<AwardVO> awardList);

    void addStrategy(StrategyVO strategy);

    void addStrategyDetailList(List<StrategyDetailVO> strategyDetailList);

    boolean alterStatus(Long activityId, Enum<Constants.ActivityStateEnum> currentState, Constants.ActivityStateEnum activityStateEnum);
}
