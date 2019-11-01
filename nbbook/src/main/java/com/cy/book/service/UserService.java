package com.cy.book.service;

import java.util.List;
import java.util.Map;

import com.cy.book.entity.User;

/**
 * @Description: UserService
 */
public interface UserService {

    /**
     * @description: 根据用户id查询用户
     */
     User findUserByUserId(Long userId);


    /**
     * @description: 根据用户名查询用户
     */
     User findUserByUserName(String userName);


    /**
     * @description: 新增用户
     */
     int saveUser(User user);

    /**
     * @description: 更新用户
     */
     int updateUser(User user);

    /**
     * @description: 根据id删除用户
     */
     int deleteUser(Long userId);


    /**
     * @description: 查询用户列表
     */
     List<User> selectUserList(Map<String, Object> map);


    /**
     * @description: 查询用户总数
     */
     int getTotalUser(Map<String, Object> map);

    /**
     * @description: 为用户分配角色
     */
     int insertUserRoles(Map<String, Object> map);
}
