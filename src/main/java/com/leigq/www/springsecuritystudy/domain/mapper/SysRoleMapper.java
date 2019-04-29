package com.leigq.www.springsecuritystudy.domain.mapper;

import com.leigq.www.springsecuritystudy.domain.entity.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 角色
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
public interface SysRoleMapper {
    @Select("select * from sys_role where id = #{id}")
    SysRole selectById(Integer id);

    @Select("select * from sys_role where name = #{roleName}")
    SysRole selectByName(String roleName);
}