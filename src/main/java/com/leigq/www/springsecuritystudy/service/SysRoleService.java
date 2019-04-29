package com.leigq.www.springsecuritystudy.service;

import com.leigq.www.springsecuritystudy.domain.entity.SysRole;
import com.leigq.www.springsecuritystudy.domain.mapper.SysRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 角色
 * <p>
 * 创建人：leigq <br>
 * 创建时间：2018-12-06 14:56 <br>
 * <p>
 * 修改人： <br>
 * 修改时间： <br>
 * 修改备注： <br>
 * </p>
 */
@Service
@Transactional
public class SysRoleService {

    @Autowired
    private SysRoleMapper roleMapper;

    public SysRole selectById(Integer id) {
        return roleMapper.selectById(id);
    }

    public SysRole selectByName(String roleName) {
        return roleMapper.selectByName(roleName);
    }
}
