package com.hmf.server.entity.VO;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author humengfan
 * @since 2022年05月04日 11:38
 */
@Data
public class ConsumerVo {
    @ApiModelProperty("客户id")
    private Long id;

    @ApiModelProperty("客户名称")
    @TableField("consumer_name")
    private String consumerName;

    @ApiModelProperty("客户联系方式")
    @TableField("consumer_telephone")
    private String consumerTelephone;

    @ApiModelProperty("企业")
    @TableField("company_id")
    private Long companyId;

}
