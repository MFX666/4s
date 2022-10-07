package com.hmf.server.param;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author humengfan
 * @since 2022年05月04日 11:03
 */
@Data
public class ConsumerParam {
    @ApiModelProperty("客户名称")
    @TableField("consumer_name")
    private String consumerName;

    @ApiModelProperty("客户联系方式")
    @TableField("consumer_telephone")
    private String consumerTelephone;
}
