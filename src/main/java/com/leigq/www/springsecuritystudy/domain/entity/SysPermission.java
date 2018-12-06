package com.leigq.www.springsecuritystudy.domain.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Arrays;
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
@Data
public class SysPermission implements Serializable {
    static final long serialVersionUID = 1L;

    private Integer id;

    private String url;

    private Integer roleId;

    private String permission;

    private List permissions;

    // 省略除permissions外的getter/setter

    public List getPermissions() {
        return Arrays.asList(this.permission.trim().split(","));
    }

    public void setPermissions(List permissions) {
        this.permissions = permissions;
    }
}
