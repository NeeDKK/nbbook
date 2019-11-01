package com.cy.book.service.impl;

import com.cy.book.dao.RoleMapper;
import com.cy.book.entity.Role;
import com.cy.book.exception.ParamException;
import com.cy.book.service.RoleService;
import com.google.common.base.Preconditions;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    /**
     * @description: 新增角色
     */
    @Override
    public int saveRole(Role role) {
        if (checkRoleNameExist(role.getRoleName(), role.getRoleId())) {
            throw new ParamException("角色名已被占用");
        }
        Role roles = Role.builder().roleName(role.getRoleName()).build();
        return roleMapper.insertSelective(roles);
    }

    /**
     * @description: 更新角色
     */
    @Override
    public int updateRole(Role role) {
        if (checkRoleNameExist(role.getRoleName(), role.getRoleId())) {
            throw new ParamException("角色名已被占用");
        }
        Role before = roleMapper.selectByPrimaryKey(role.getRoleId());
        Preconditions.checkNotNull(before, "需更新的角色不存在");
        Role roles = Role.builder().roleId(role.getRoleId()).roleName(role.getRoleName()).build();
        return roleMapper.updateByPrimaryKeySelective(roles);
    }

    /**
     * @description: 根据id删除角色
     */
    @Override
    public int deleteRole(Integer roleId) {
        Role before = roleMapper.selectByPrimaryKey(roleId);
        Preconditions.checkNotNull(before, "需删除的角色不存在");
        return roleMapper.deleteByPrimaryKey(roleId);
    }

    /**
     * @description: 通过用户id删除用户角色表的关联关系
     */
    @Override
    public void deleteRoleUserRsByUserId(Long userId) {

        roleMapper.deleteRoleUserRsByUserId(userId);
    }

    /**
     * @description: 通过角色id删除用户角色表的关联关系
     */
    @Override
    public void deleteRoleUserRsByRoleId(Integer roleId) {

        roleMapper.deleteRoleUserRsByRoleId(roleId);
    }

    /**
     * @description: 查询角色列表
     */
    @Override
    public List<Role> selectRoleList(Map<String, Object> map) {
        return roleMapper.selectRoleList(map);
    }

    /**
     * @description: 查询角色总数
     */
    @Override
    public int getTotalRole(Map<String, Object> map) {
        return roleMapper.getTotalRole(map);
    }

    /**
     * @description: 根据用户id查找角色集合
     */
    @Override
    public List<Role> findByUserId(Long userId) {
        return roleMapper.findByUserId(userId);
    }

    /**
     * @description: 为角色分配权限
     */
    @Override
    public int insertRolePermissions(Map<String, Object> map) {
        return roleMapper.insertRolePermissions(map);
    }


    /**
     * @description: check角色名是否存在
     */
    public boolean checkRoleNameExist(String roleName, Integer roleId) {
        return roleMapper.countByRoleName(roleName, roleId) > 0;
    }
}
