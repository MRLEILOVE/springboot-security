package com.leigq.www.springsecuritystudy.service;

import com.leigq.www.springsecuritystudy.domain.entity.SysPermission;
import com.leigq.www.springsecuritystudy.domain.mapper.SysPermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 权限
 * <p>
 * 创建人：asus <br>
 * 创建时间：2018-12-06 18:04 <br>
 * <p>
 * 修改人： <br>
 * 修改时间： <br>
 * 修改备注： <br>
 * </p>
 */
@Service
@Transactional
public class SysPermissionService {

    @Autowired
    private SysPermissionMapper permissionMapper;

    /**
     * 获取指定角色所有权限
     */
    public List<SysPermission> listByRoleId(Integer roleId) {
        return permissionMapper.listByRoleId(roleId);
    }
}
