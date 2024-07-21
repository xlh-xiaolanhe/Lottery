package com.xiaolanhe.lottery.activity.model.request;

import com.xiaolanhe.lottery.activity.model.aggregates.ActivityConfigRich;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 活动配置请求对象
 *@author: xiaolanhe
 *@createDate: 2024/7/21 20:33
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivityConfigRequest {

    /**
     * 活动ID
     */
    private Long activityId;

    /**
     * 活动配置信息
     */
    private ActivityConfigRich activityConfigRich;
}
