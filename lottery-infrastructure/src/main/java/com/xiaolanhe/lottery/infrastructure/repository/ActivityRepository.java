package com.xiaolanhe.lottery.infrastructure.repository;

import com.xiaolanhe.lottery.activity.model.vo.ActivityVO;
import com.xiaolanhe.lottery.activity.model.vo.AlterStateVO;
import com.xiaolanhe.lottery.activity.model.vo.AwardVO;
import com.xiaolanhe.lottery.activity.model.vo.StrategyDetailVO;
import com.xiaolanhe.lottery.activity.model.vo.StrategyVO;
import com.xiaolanhe.lottery.activity.respository.IActivityRepository;
import com.xiaolanhe.lottery.common.Constants;
import com.xiaolanhe.lottery.infrastructure.dao.IActivityDao;
import com.xiaolanhe.lottery.infrastructure.dao.IAwardDao;
import com.xiaolanhe.lottery.infrastructure.dao.IStrategyDao;
import com.xiaolanhe.lottery.infrastructure.dao.IStrategyDetailDao;
import com.xiaolanhe.lottery.infrastructure.po.Activity;
import com.xiaolanhe.lottery.infrastructure.po.Award;
import com.xiaolanhe.lottery.infrastructure.po.Strategy;
import com.xiaolanhe.lottery.infrastructure.po.StrategyDetail;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 *@author: xiaolanhe
 *@createDate: 2024/7/21 20:55
 */

@Component
public class ActivityRepository implements IActivityRepository {

    @Resource
    private IActivityDao activityDao;

    @Resource
    private IAwardDao awardDao;
    @Resource
    private IStrategyDao strategyDao;
    @Resource
    private IStrategyDetailDao strategyDetailDao;

    @Override
    public void addActivity(ActivityVO activity) {
        Activity req = new Activity();
        BeanUtils.copyProperties(activity, req);
        activityDao.insert(req);
    }

    @Override
    public void addAward(List<AwardVO> awardList) {
        List<Award> req = new ArrayList<>();
        for (AwardVO awardVO : awardList) {
            Award award = new Award();
            BeanUtils.copyProperties(awardVO, award);
            req.add(award);
        }
        awardDao.insertList(req);
    }

    @Override
    public void addStrategy(StrategyVO strategy) {
        Strategy req = new Strategy();
        BeanUtils.copyProperties(strategy, req);
        strategyDao.insert(req);
    }

    @Override
    public void addStrategyDetailList(List<StrategyDetailVO> strategyDetailList) {
        List<StrategyDetail> req = new ArrayList<>();
        for (StrategyDetailVO strategyDetailVO : strategyDetailList) {
            StrategyDetail strategyDetail = new StrategyDetail();
            BeanUtils.copyProperties(strategyDetailVO, strategyDetail);
            req.add(strategyDetail);
        }
        strategyDetailDao.insertList(req);
    }

    @Override
    public boolean alterStatus(Long activityId, Enum<Constants.ActivityStateEnum> prevState, Constants.ActivityStateEnum currentState) {
        AlterStateVO alterStateVO = new AlterStateVO(activityId,((Constants.ActivityStateEnum) prevState).getCode(), currentState.getCode());
        int count = activityDao.alterState(alterStateVO);
        return 1 == count;
    }
}
