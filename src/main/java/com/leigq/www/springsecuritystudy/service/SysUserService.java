package com.leigq.www.springsecuritystudy.service;

import com.leigq.www.springsecuritystudy.domain.entity.SysUser;
import com.leigq.www.springsecuritystudy.domain.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户
 * <p>
 * 创建人：leigq <br>
 * 创建时间：2018-12-06 14:55 <br>
 * <p>
 * 修改人： <br>
 * 修改时间： <br>
 * 修改备注： <br>
 * </p>
 */
@Service
@Transactional
public class SysUserService {

    @Autowired
    private SysUserMapper userMapper;

    public SysUser selectById(Integer id) {
        return userMapper.selectById(id);
    }

    public SysUser selectByName(String name) {
        return userMapper.selectByName(name);
    }
}
