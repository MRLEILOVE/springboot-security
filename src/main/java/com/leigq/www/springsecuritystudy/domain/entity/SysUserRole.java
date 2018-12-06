package com.leigq.www.springsecuritystudy.domain.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户-角色
 * <p>
 * 创建人：leigq <br>
 * 创建时间：2018-12-06 14:51 <br>
 * <p>
 * 修改人： <br>
 * 修改时间： <br>
 * 修改备注： <br>
 * </p>
 */
@Data
public class SysUserRole implements Serializable {
    static final long serialVersionUID = 1L;

    private Integer userId;

    private Integer roleId;

}
