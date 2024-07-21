package com.xiaolanhe.lottery.activity.service.deploy.impl;

import cn.hutool.json.JSONUtil;
import com.xiaolanhe.lottery.activity.model.aggregates.ActivityConfigRich;
import com.xiaolanhe.lottery.activity.model.request.ActivityConfigRequest;
import com.xiaolanhe.lottery.activity.model.vo.ActivityVO;
import com.xiaolanhe.lottery.activity.model.vo.AwardVO;
import com.xiaolanhe.lottery.activity.model.vo.StrategyDetailVO;
import com.xiaolanhe.lottery.activity.model.vo.StrategyVO;
import com.xiaolanhe.lottery.activity.respository.IActivityRepository;
import com.xiaolanhe.lottery.activity.service.deploy.IActivityDeploy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/** 部署活动配置服务
 *@author: xiaolanhe
 *@createDate: 2024/7/21 20:37
 */

@Service
public class ActivityDeployImpl implements IActivityDeploy {

    private Logger logger = LoggerFactory.getLogger(ActivityDeployImpl.class);

    @Resource
    private IActivityRepository activityRepository;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void createActivity(ActivityConfigRequest req) {
        logger.info("创建活动配置开始，activityId：{}", req.getActivityId());
        ActivityConfigRich activityConfigRich = req.getActivityConfigRich();
        try{
            // 添加活动配置
            ActivityVO activity = activityConfigRich.getActivity();
            activityRepository.addActivity(activity);

            // 添加奖品配置
            List<AwardVO> awardList = activityConfigRich.getAwardList();
            activityRepository.addAward(awardList);

            // 添加策略配置
            StrategyVO strategy = activityConfigRich.getStrategy();
            activityRepository.addStrategy(strategy);

            // 添加策略明细配置
            List<StrategyDetailVO> strategyDetailList = activityConfigRich.getStrategy().getStrategyDetailList();
            activityRepository.addStrategyDetailList(strategyDetailList);

            logger.info("创建活动配置完成，activityId：{}", req.getActivityId());
        }catch (DuplicateKeyException e){
            logger.error("创建活动配置失败，唯一索引冲突 activityId：{} reqJson：{}", req.getActivityId(), JSONUtil.toJsonStr(req), e);
            throw e;
        }

    }

    @Override
    public void updateActivity(ActivityConfigRequest req) {
        // TODO: 非核心功能后续补充
    }
}
