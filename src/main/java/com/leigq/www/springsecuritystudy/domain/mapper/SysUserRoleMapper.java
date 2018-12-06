package com.leigq.www.springsecuritystudy.domain.mapper;

import com.leigq.www.springsecuritystudy.domain.entity.SysUserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 用户-角色
 * <p>
 * 创建人：leigq <br>
 * 创建时间：2018-12-06 14:53 <br>
 * <p>
 * 修改人： <br>
 * 修改时间： <br>
 * 修改备注： <br>
 * </p>
 */
@Mapper
public interface SysUserRoleMapper {
    @Select("select * from sys_user_role where user_id = #{userid}")
    List<SysUserRole> listByUserId(Integer userId);
}
