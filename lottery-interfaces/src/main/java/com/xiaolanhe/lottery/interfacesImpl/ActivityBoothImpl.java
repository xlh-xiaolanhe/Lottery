package com.xiaolanhe.lottery.interfacesImpl;

import com.xiaolanhe.lottery.common.Constants;
import com.xiaolanhe.lottery.common.Result;
import com.xiaolanhe.lottery.infrastructure.dao.IActivityDao;
import com.xiaolanhe.lottery.infrastructure.po.Activity;
import com.xiaolanhe.lottery.rpc.IActivityBooth;
import com.xiaolanhe.lottery.rpc.dto.ActivityDto;
import com.xiaolanhe.lottery.rpc.req.ActivityRequest;
import com.xiaolanhe.lottery.rpc.res.ActivityResponse;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;

/**
 *@author: xiaolanhe
 *@createDate: 2024/7/9 22:53
 */

@Service
public class ActivityBoothImpl implements IActivityBooth {

    @Resource
    private IActivityDao activityDao;

    @Override
    public ActivityResponse queryActivityById(ActivityRequest request) {
        Activity activity = activityDao.queryActivityById(request.getActivityId());

        ActivityDto activityDto = new ActivityDto();
        activityDto.setActivityId(activity.getActivityId());
        activityDto.setActivityName(activity.getActivityName());
        activityDto.setActivityDesc(activity.getActivityDesc());
        activityDto.setBeginDateTime(activity.getBeginDateTime());
        activityDto.setEndDateTime(activity.getEndDateTime());
        activityDto.setStockCount(activity.getStockCount());
        activityDto.setTakeCount(activity.getTakeCount());

        return new ActivityResponse(new Result(Constants.ResponseCode.SUCCESS.getCode(), Constants.ResponseCode.SUCCESS.getMessage()), activityDto);
    }
}
