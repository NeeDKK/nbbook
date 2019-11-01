package com.cy.book.service.impl;

import com.cy.book.dao.UserMapper;
import com.cy.book.entity.User;
import com.cy.book.exception.ParamException;
import com.cy.book.service.UserService;
import com.cy.book.util.IDUtils;
import com.cy.book.util.Md5Util;
import com.google.common.base.Preconditions;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    /**
     * @description: 根据用户id查询用户
     */
    @Override
    public User findUserByUserId(Long userId) {
        User before = userMapper.selectByPrimaryKey(userId);
        Preconditions.checkNotNull(before, "用户不存在");
        return userMapper.selectByPrimaryKey(userId);
    }

    /**
     * @description: 根据用户名查询用户
     */
    @Override
    public User findUserByUserName(String userName) {
        return userMapper.selectByUserName(userName);
    }

    /**
     * @description: 新增用户
     */
    @Override
    public int saveUser(User user) {
        if (checkUserIdExist(user.getUserId())) {
            throw new ParamException("用户ID已经存在,请重新添加");
        }
        if (checkUserNameExist(user.getUserName(), user.getUserId())) {
            throw new ParamException("用户名已被占用");
        }
        if (checkUserTrueNameExist(user.getUserTrueName(), user.getUserId())) {
            throw new ParamException("真实姓名已经存在");
        }
        if (checkUserEmailExist(user.getUserEmail(), user.getUserId())) {
            throw new ParamException("邮箱已被占用");
        }
        if (checkUserPhoneExist(user.getUserPhone(), user.getUserId())) {
            throw new ParamException("手机号已被占用");
        }
        User users = User.builder()
                .userId(IDUtils.genUserId())
                .userName(user.getUserName())
                .userTrueName(user.getUserTrueName())
                .userPassword(Md5Util.md5(user.getUserPassword(), Md5Util.SALT))
                .userEmail(user.getUserEmail())
                .userPhone(user.getUserPhone())
                .build();
        int count = userMapper.insertSelective(users);
        return count;

    }

    /**
     * @description: 更新用户
     */
    @Override
    public int updateUser(User user) {
        if (checkUserNameExist(user.getUserName(), user.getUserId())) {
            throw new ParamException("用户名已被占用");
        }
        if (checkUserTrueNameExist(user.getUserTrueName(), user.getUserId())) {
            throw new ParamException("真实姓名已经存在");
        }
        if (checkUserEmailExist(user.getUserEmail(), user.getUserId())) {
            throw new ParamException("邮箱已被占用");
        }
        if (checkUserPhoneExist(user.getUserPhone(), user.getUserId())) {
            throw new ParamException("手机号已被占用");
        }
        User before = userMapper.selectByPrimaryKey(user.getUserId());
        Preconditions.checkNotNull(before, "需更新的用户不存在");
        User after = User.builder()
                .userId(user.getUserId())
                .userName(user.getUserName())
                .userTrueName(user.getUserTrueName())
                .userPassword(Md5Util.md5(user.getUserPassword(), Md5Util.SALT))
                .userEmail(user.getUserEmail())
                .userPhone(user.getUserPhone())
                .userState(user.getUserState())
                .build();
        int count = userMapper.updateByPrimaryKeySelective(after);
        return count;
    }

    /**
     * @description: check邮箱是否存在
     */
    public boolean checkUserEmailExist(String userEmail, Long userId) {
        return userMapper.countByMail(userEmail, userId) > 0;

    }


    /**
     * @description: check真实姓名是否存在
     */
    public boolean checkUserTrueNameExist(String userTrueName, Long userId) {
        return userMapper.countByUserTrueName(userTrueName, userId) > 0;

    }

    /**
     * @description: check手机号是否存在
     */
    public boolean checkUserPhoneExist(String userPhone, Long userId) {
        return userMapper.countByPhone(userPhone, userId) > 0;
    }

    /**
     * @description: check用户名是否存在
     */
    public boolean checkUserNameExist(String userName, Long userId) {
        return userMapper.countByName(userName, userId) > 0;
    }

    /**
     * @description: check用户Id是否存在
     */
    public boolean checkUserIdExist(Long userId) {
        return userMapper.countByUserId(userId) > 0;
    }

    /**
     * @description: 根据id删除用户
     */
    @Override
    public int deleteUser(Long userId) {

        User user = userMapper.selectByPrimaryKey(userId);
        Preconditions.checkNotNull(user, "需删除的用户不存在");
        int count = userMapper.deleteByPrimaryKey(userId);
        return count;

    }

    /**
     * @description: 查询用户列表
     */
    @Override
    public List<User> selectUserList(Map<String, Object> map) {
        return userMapper.selectUserList(map);
    }

    /**
     * @description: 查询用户总数
     */
    @Override
    public int getTotalUser(Map<String, Object> map) {
        return userMapper.getTotalUser(map);
    }

    /**
     * @description: 为用户分配角色
     */
    @Override
    public int insertUserRoles(Map<String, Object> map) {
        return userMapper.insertUserRoles(map);
    }


}
