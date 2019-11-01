package com.cy.book.service;

import java.util.List;

import com.cy.book.entity.Permission;
import com.cy.book.entity.User;

/**
 * @Description: PermissionService
 */
public interface PermissionService {

    /**
     * @description: 获取用户权限信息
     */
    List<Permission> queryPermissionsByUser(User user);

    /**
     * @description: 获取所有权限列表
     */
    List<Permission> queryAll();

    /**
     * @description: 通过角色id删除角色权限表的关联关系
     */
    void deleteRolePermissionRsByRoleId(Integer roleId);

    /**
     * @description: 通过角色id查询已经分配的权限信息
     */
    List<Integer> queryPermissionIdsByRoleId(Integer roleId);
}
