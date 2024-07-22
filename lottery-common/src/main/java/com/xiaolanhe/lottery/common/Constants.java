package com.xiaolanhe.lottery.common;

import lombok.Data;

/**
 *@author: xiaolanhe
 *@createDate: 2024/7/9 22:29
 */

@Data
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

    /**
      抽奖策略
    */
    public enum StrategyModeEnum {
        /**
         若抽中的奖品已经没有库存，抽奖结果展示为未中奖
        */
        SINGLE(1, "单项概率"),
        /**
         没有库存的奖品的概率均摊给剩下的奖品
        */
        ENTIRETY(2, "总体概率")
        ;

        private Integer code;
        private String info;

        StrategyModeEnum(Integer code, String info) {
            this.code = code;
            this.info = info;
        }

        public Integer getCode() {
            return code;
        }

        public String getInfo() {
            return info;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public void setInfo(String info) {
            this.info = info;
        }
    }


    /**
        中奖状态：0未中奖、1已中奖、2兜底奖
    */
    public enum DrawResultEnum {
        NO_PRIZE(0, "未中奖"),
        SUCCESS(1, "已中奖"),
        COVER(2, "兜底奖")
        ;
        private Integer code;
        private String info;

        DrawResultEnum(Integer code, String info) {
            this.code = code;
            this.info = info;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }
    }

    /**
     奖品发放状态
    */
    public enum AwardStateEnum {
        WAIT(0, "等待发放"),
        SUCCESS(1, "发放成功"),
        FAIL(2, "发放失败"),
        ;


        private Integer code;
        private String info;

        AwardStateEnum(Integer code, String info) {
            this.code = code;
            this.info = info;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }
    }

    public enum AwardTypeEnum {
        DESC(1, "文字描述"),
        RedeemCode(2, "兑换码"),
        COUPON(3, "优惠券"),
        PHYSICAL(4, "实物奖品"),
        ;

        private Integer code;
        private String info;

        AwardTypeEnum(Integer code, String info) {
            this.code = code;
            this.info = info;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
       }
   }

    public enum ActivityStateEnum{
       /** 1：编辑 */
       EDIT(1, "编辑"),
       /** 2：提审 */
       ARRAIGNMENT(2, "提审"),
       /** 3：撤审 */
       REVOKE(3, "撤审"),
       /** 4：通过 */
       PASS(4, "通过"),
       /** 5：运行(活动中) */
       DOING(5, "运行(活动中)"),
       /** 6：拒绝 */
       REFUSE(6, "拒绝"),
       /** 7：关闭 */
       CLOSE(7, "关闭"),
       /** 8：开启 */
       OPEN(8, "开启");

       private Integer code;
       private String info;

       ActivityStateEnum(Integer code, String info) {
           this.code = code;
           this.info = info;
       }

       public Integer getCode() {
           return code;
       }

       public void setCode(Integer code) {
           this.code = code;
       }

       public String getInfo() {
           return info;
       }

       public void setInfo(String info) {
           this.info = info;
       }
   }

    public enum IdsEnum {
        /**
         * 雪花算法
         */
         SnowFlake,
        /**
         * 日期算法  只适合id数比较小的场景
         */
         ShortCode,
        /**
         * 数字随机算法
         */
         RandomNumeric
    }
}
