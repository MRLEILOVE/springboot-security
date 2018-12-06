package com.leigq.www.springsecuritystudy.service;

import com.leigq.www.springsecuritystudy.domain.entity.SysUserRole;
import com.leigq.www.springsecuritystudy.domain.mapper.SysUserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户-角色
 * <p>
 * 创建人：leigq <br>
 * 创建时间：2018-12-06 14:57 <br>
 * <p>
 * 修改人： <br>
 * 修改时间： <br>
 * 修改备注： <br>
 * </p>
 */
@Service
@Transactional
public class SysUserRoleService {

    @Autowired
    private SysUserRoleMapper userRoleMapper;

    public List<SysUserRole> listByUserId(Integer userId) {
        return userRoleMapper.listByUserId(userId);
    }
}
