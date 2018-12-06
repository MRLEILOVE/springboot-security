package com.leigq.www.springsecuritystudy.domain.mapper;

import com.leigq.www.springsecuritystudy.domain.entity.SysPermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 权限
 * <p>
 * 创建人：asus <br>
 * 创建时间：2018-12-06 18:01 <br>
 * <p>
 * 修改人： <br>
 * 修改时间： <br>
 * 修改备注： <br>
 * </p>
 */
@Mapper
public interface SysPermissionMapper {
    @Select("select * from sys_permission where role_id=#{roleid}")
    List<SysPermission> listByRoleId(Integer roleId);
}
