package com.cy.book.service;

/**
 * @Description:
 */
public interface VaptchaCheckService {

    /**
     * @description: 人机验证结果校验
     */
    boolean vaptchaCheck(String token, String ip) throws Exception;
}
