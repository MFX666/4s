package com.hmf.server.entity.VO;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author humengfan
 * @since 2022年05月04日 10:13
 */
@Data
public class RemarkVo {
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

    private String companyName;

    private String consumerName;


}
