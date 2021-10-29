package com.java.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author peter
 * @create 2020-07-08-18:28
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetOrderInfoVO implements Serializable {

    public interface GetOrderInfo { }

    @ApiModelProperty(value = "商户订单号")
    @NotBlank(message = "商户订单号不能为空", groups = {GetOrderInfo.class})
    private String companyOrderNum;

}

