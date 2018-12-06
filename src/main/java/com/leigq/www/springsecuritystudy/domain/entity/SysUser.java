package com.leigq.www.springsecuritystudy.domain.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户
 * <p>
 * 创建人：leigq <br>
 * 创建时间：2018-12-06 14:50 <br>
 * <p>
 * 修改人： <br>
 * 修改时间： <br>
 * 修改备注： <br>
 * </p>
 */
@Data
public class SysUser implements Serializable {
    static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private String password;
}