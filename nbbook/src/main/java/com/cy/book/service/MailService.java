package com.cy.book.service;

/**
 * @Description: MailService邮件发送
 */
public interface MailService {

    /**
     * @description: 发送简单邮件
     */
     void sendSimpleMail(String to, String subject, String content);
}
