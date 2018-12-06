package com.leigq.www.springsecuritystudy.domain.mapper;

import com.leigq.www.springsecuritystudy.domain.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 用户
 * <p>
 * 创建人：leigq <br>
 * 创建时间：2018-12-06 14:52 <br>
 * <p>
 * 修改人： <br>
 * 修改时间： <br>
 * 修改备注： <br>
 * </p>
 */
@Mapper
public interface SysUserMapper {
    @Select("select * from sys_user where id = #{id}")
    SysUser selectById(Integer id);

    @Select("select * from sys_user where name = #{name}")
    SysUser selectByName(String name);
}
