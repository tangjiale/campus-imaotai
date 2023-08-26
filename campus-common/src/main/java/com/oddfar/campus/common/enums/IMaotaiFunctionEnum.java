package com.oddfar.campus.common.enums;

/***
 * I茅台功能类型
 * @author tangjiale
 */
public enum IMaotaiFunctionEnum {
    YY(1, "预约"),
    LX(2, "旅行"),
    NL(3, "获取耐力"),
    SG(4, "申购成功");

    private Integer code;
    private String msg;

    private IMaotaiFunctionEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
