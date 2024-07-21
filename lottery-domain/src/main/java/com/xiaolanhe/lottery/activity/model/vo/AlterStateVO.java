package com.xiaolanhe.lottery.activity.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**  活动状态变更类
 *@author: xiaolanhe
 *@createDate: 2024/7/21 20:22
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlterStateVO {
    private Long activityId;

    private Integer prevState;

    private Integer curState;
}
