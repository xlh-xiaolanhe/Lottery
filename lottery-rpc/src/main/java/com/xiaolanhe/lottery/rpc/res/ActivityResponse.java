package com.xiaolanhe.lottery.rpc.res;


import com.xiaolanhe.lottery.common.Result;
import com.xiaolanhe.lottery.rpc.dto.ActivityDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 *@author: xiaolanhe
 *@createDate: 2024/7/9 22:40
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivityResponse implements Serializable {
    private Result result;
    private ActivityDto activity;
}
