package com.cy.book.service.impl;

import org.springframework.stereotype.Service;

import com.cy.book.dao.PermissionMapper;
import com.cy.book.entity.Permission;
import com.cy.book.entity.User;
import com.cy.book.service.PermissionService;

import javax.annotation.Resource;
import java.util.List;

@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {


    @Resource
    private PermissionMapper permissionMapper;

    /**
     * @description: 获取用户权限信息
     */
    @Override
    public List<Permission> queryPermissionsByUser(User user) {
        return permissionMapper.queryPermissionsByUser(user);
    }

    /**
     * @description: 获取所有权限列表
     */
    @Override
    public List<Permission> queryAll() {
        return permissionMapper.queryAll();
    }

    /**
     * @description: 通过角色id删除角色权限表的关联关系
     */
    @Override
    public void deleteRolePermissionRsByRoleId(Integer roleId) {
        permissionMapper.deleteRolePermissionRsByRoleId(roleId);
    }

    /**
     * @description: 通过角色id查询已经分配的权限信息
     */
    @Override
    public List<Integer> queryPermissionIdsByRoleId(Integer roleId) {
        return permissionMapper.queryPermissionIdsByRoleId(roleId);
    }
}
