package com.cy.book.service;

import java.util.List;
import java.util.Map;

import com.cy.book.entity.Role;

/**
 * @Description: RoleService
 */
public interface RoleService {


    /**
     * @description: 新增角色
     */
     int saveRole(Role role);


    /**
     * @description: 更新角色
     */
     int updateRole(Role role);


    /**
     * @description: 根据id删除角色
     */
     int deleteRole(Integer roleId);


    /**
     * @description: 通过用户id删除用户角色表的关联关系
     */
     void deleteRoleUserRsByUserId(Long userId);


    /**
     * @description: 通过角色id删除用户角色表的关联关系
     */
     void deleteRoleUserRsByRoleId(Integer roleId);


    /**
     * @description: 查询角色列表
     */
     List<Role> selectRoleList(Map<String, Object> map);


    /**
     * @description: 查询角色总数
     */
     int getTotalRole(Map<String, Object> map);


    /**
     * @description: 根据用户id查找角色集合
     */
     List<Role> findByUserId(Long userId);


    /**
     * @description: 为角色分配权限
     */
     int insertRolePermissions(Map<String, Object> map);
}
