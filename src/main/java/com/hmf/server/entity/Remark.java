package com.hmf.server.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 
 * </p>
 *
 * @author mfx
 * @since 2022-05-04
 */
@Getter
@Setter
@TableName("t_remark")
@ApiModel(value = "Remark对象", description = "")
public class Remark implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("评论表id")
    private Long id;

    @ApiModelProperty("企业")
    @TableField("company_id")
    private Long companyId;

    @ApiModelProperty("用户")
    @TableField("user_id")
    private Long userId;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @ApiModelProperty("内容")
    private String content;


}
