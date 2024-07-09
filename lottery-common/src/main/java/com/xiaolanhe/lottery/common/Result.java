package com.xiaolanhe.lottery.common;

import lombok.Data;

import java.io.Serializable;

/**
 *@author: xiaolanhe
 *@createDate: 2024/7/9 22:31
 */
@Data
public class Result implements Serializable {

    private static final long serialVersionUID = -6650701810440276160L;

    private String code;

    private String msg;

    public static Result buildResult(String code, String msg) {
        return new Result(code, msg);
    }

    public static Result buildSuccessResult(){
        return new Result(Constants.ResponseCode.SUCCESS.getCode(), Constants.ResponseCode.SUCCESS.getMessage());
    }

    public static Result buildErrorResult(){
        return new Result(Constants.ResponseCode.UN_ERROR.getCode(), Constants.ResponseCode.UN_ERROR.getMessage());
    }

    public Result(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
