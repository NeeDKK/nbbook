package com.cy.book.common;

import lombok.Data;

/**
 * @Description: Vaptcha人机验证服务器端验证返回消息封装
 */
@Data
public class VaptchaMessage {

    private Integer success; //验证结果，1为通过，0为失败

    private Integer score; //可信度，区间[0, 100]

    private String msg; //信息描述


}
