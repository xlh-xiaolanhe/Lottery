package com.xiaolanhe.lottery.common;

/**
 *@author: xiaolanhe
 *@createDate: 2024/7/9 22:29
 */
public class Constants {

    /**
     响应状态枚举
    */
    public enum ResponseCode {
        SUCCESS("0000", "成功"),
        UN_ERROR("0001","未知失败"),
        ILLEGAL_PARAMETER("0002","非法参数"),
        INDEX_DUP("0003","主键冲突")
        ;

        private String code;
        private String message;

        ResponseCode(String code, String message) {
            this.code = code;
            this.message = message;
        }

        public String getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }
    }
}
