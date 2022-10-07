package com.hmf.server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * <p>
 * 
 * </p>
 *
 * @author mfx
 * @since 2022-01-08
 */

@TableName("t_user")
@ApiModel(value = "User对象", description = "")
public class User implements Serializable,UserDetails {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty("用户id")
    @TableId(value = "id", type = IdType.AUTO)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    @ApiModelProperty("用户真实姓名")
    @TableField("real_name")
    private String realName;

    @ApiModelProperty("用户登录账号")
    @TableField("username")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private LocalDateTime createtime;

    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private LocalDateTime updatetime;

    @ApiModelProperty("电话号码")
    private String telephone;

    @ApiModelProperty("性别")
    private String sex;

    @ApiModelProperty("权限id")
    @TableField("role_id")
    private Long roleId;

    @ApiModelProperty("身份证号码")
    @TableField("id_card")
    private String idCard;

    @ApiModelProperty("入职时间")
    @TableField("enter_time")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date enterTime;

    @ApiModelProperty("关联店铺")
    @TableField("company_id")
    private Long companyId;

    @ApiModelProperty("角色")
    @TableField(exist = false)
    private List<Role> roles;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @ApiModelProperty(value = "职位")
    private String position;

    @ApiModelProperty("是否能使用")
    @TableField("is_enable")
    private Boolean isEnable;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = roles
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoleName()))
                .collect(Collectors.toList());
        return authorities;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return isEnable;
    }
    public User() {
    }

    public User(Long id, String realName, String username, String password, LocalDateTime createtime, LocalDateTime updatetime, String telephone, String sex, Long roleId, String idCard, Date enterTime, Long companyId, List<Role> roles, String position, Boolean isEnable) {
        this.id = id;
        this.realName = realName;
        this.username = username;
        this.password = password;
        this.createtime = createtime;
        this.updatetime = updatetime;
        this.telephone = telephone;
        this.sex = sex;
        this.roleId = roleId;
        this.idCard = idCard;
        this.enterTime = enterTime;
        this.companyId = companyId;
        this.roles = roles;
        this.position = position;
        this.isEnable = isEnable;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreatetime() {
        return createtime;
    }

    public void setCreatetime(LocalDateTime createtime) {
        this.createtime = createtime;
    }

    public LocalDateTime getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(LocalDateTime updatetime) {
        this.updatetime = updatetime;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Date getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(Date enterTime) {
        this.enterTime = enterTime;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Boolean getEnable() {
        return isEnable;
    }

    public void setEnable(Boolean enable) {
        isEnable = enable;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", realName='" + realName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", createtime=" + createtime +
                ", updatetime=" + updatetime +
                ", telephone='" + telephone + '\'' +
                ", sex='" + sex + '\'' +
                ", roleId=" + roleId +
                ", idCard='" + idCard + '\'' +
                ", enterTime=" + enterTime +
                ", companyId=" + companyId +
                ", roles=" + roles +
                ", position='" + position + '\'' +
                ", isEnable=" + isEnable +
                '}';
    }
}
