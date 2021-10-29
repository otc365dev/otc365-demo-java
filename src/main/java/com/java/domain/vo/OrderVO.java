package com.java.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author peter
 * @create 2020-07-08-18:28
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderVO implements Serializable {

    public interface AddOrder { }

    public interface GetOrderInfo { }

    @ApiModelProperty(value = "商户id")
    @NotNull(message = "商户id不能为空", groups = {GetOrderInfo.class})
    private Long companyId;

    @ApiModelProperty(value = "商户订单号")
    @NotBlank(message = "商户订单号不能为空", groups = {GetOrderInfo.class})
    private String companyOrderNum;

    @ApiModelProperty(value = "商户用户id")
    private Long companyUserId;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "实名认证")
    private Integer kyc;

    @ApiModelProperty(value = "用户姓名")
    private String username;

    @ApiModelProperty(value = "手机区号")
    private String areaCode;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "订单类型")
    private Integer orderType;

    @ApiModelProperty(value = "证件类型")
    private Integer idCardType;

    @ApiModelProperty(value = "证件号码")
    private String idCardNum;

    @ApiModelProperty(value = "支付账户")
    private String payCardNo;

    @ApiModelProperty(value = "开户银行")
    private String payCardBank;

    @ApiModelProperty(value = "开户支行")
    private String payCardBranch;

    @ApiModelProperty(value = "支付渠道")
    private Integer orderPayChannel;

    @ApiModelProperty(value = "订单号")
    private String orderNo;

    @ApiModelProperty(value = "币种标识")
    private String coinSign;

    @ApiModelProperty(value = "支付币种标识")
    private String payCoinSign;

    @ApiModelProperty(value = "订单币种总数")
    private BigDecimal coinSum;

    @ApiModelProperty(value = "单价")
    private BigDecimal unitPrice;

    @ApiModelProperty(value = "订单总价")
    private BigDecimal coinPrice;

    @ApiModelProperty(value = "显示总价")
    private BigDecimal displayAmount;

    @ApiModelProperty(value = "手续费")
    private BigDecimal fee;

    @ApiModelProperty(value = "派单模式")
    //@NotNull(message = "派单模式不能为空", groups = {AddOrder.class,WebAddOrder.class})
    private Integer mode = 1;

    @ApiModelProperty(value = "交易员id")
    private Long traderId;

    @ApiModelProperty(value = "交易员用户id")
    private Long traderUserId;

    @ApiModelProperty(value = "交易员收付款账号id")
    private Long traderPaymentId;

    @ApiModelProperty(value = "下单时间")
    //@NotBlank(message = "下单时间不能为空", groups = {AddOrder.class})
    private String orderTime;

    @ApiModelProperty(value = "同步回调地址")
    //@NotBlank(message = "同步回调地址不能为空", groups = {AddOrder.class})
    private String syncUrl;

    @ApiModelProperty(value = "异步回调地址")
    //@NotBlank(message = "异步回调地址不能为空", groups = {AddOrder.class})
    private String asyncUrl;

    @ApiModelProperty(value = "签名")
    @NotBlank(message = "签名不能为空", groups = {AddOrder.class, GetOrderInfo.class})
    private String sign;

}

