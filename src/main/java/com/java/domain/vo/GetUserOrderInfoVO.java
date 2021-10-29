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
public class GetUserOrderInfoVO implements Serializable {

    public interface GetUserOrderInfo { }

    @ApiModelProperty(value = "区号")
    @NotBlank(message = "区号不能为空", groups = {GetUserOrderInfo.class})
    private String areaCode;

    @ApiModelProperty(value = "手机号")
    @NotBlank(message = "区号不能为空", groups = {GetUserOrderInfo.class})
    private String phone;
}

