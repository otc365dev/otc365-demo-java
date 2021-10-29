package com.java.controller;

import com.alibaba.fastjson.JSONObject;
import com.java.common.constant.Consts;
import com.java.common.enums.ExceptionEnum;
import com.java.common.util.*;
import com.java.domain.vo.GetOrderInfoVO;
import com.java.domain.vo.GetUserOrderInfoVO;
import io.swagger.annotations.ApiOperation;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * peter
 * 接口例子
 */
@RestController
public class ConmonController {

    private  static Logger logger = LoggerFactory.getLogger(ConmonController.class);

    @GetMapping("/getPrice")
    @ApiOperation(value = "获取价格",notes = "获取价格")
    public Result queryPrice(@RequestParam String coinType){
        try {
            HttpResultUtil result = HttpUtil.doGet(Consts.COMMON.URL+"/cola/quotePriceBusiness/priceConfig/getPrice?coinType="+coinType);
            logger.info("获取价格返回结果：{}", result+"");
            if(result.getCode() != HttpStatus.SC_OK || null == result.getContent().getData()){
                return ResultUtil.error(ExceptionEnum.QUERY_PRICE);
            }
            return ResultUtil.success(result.getContent().getData());
        } catch (Exception e){
             logger.error(ExceptionEnum.QUERY_PRICE.getMsg(), e);
             return ResultUtil.error(ExceptionEnum.QUERY_PRICE);
        }
    }

    @PostMapping("/getUserOrderInfo")
    @ApiOperation(value = "查询用户交易情况",notes = "查询用户交易情况")
    public Result getUserOrderInfo(@RequestBody @Validated(value = GetUserOrderInfoVO.GetUserOrderInfo.class) GetUserOrderInfoVO getUserOrderInfoVO){
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("secretKey", Consts.COMMON.APPSECRET);
            map.put("companyId", Consts.COMMON.APPKEY);
            map.put("areaCode", getUserOrderInfoVO.getAreaCode());
            map.put("phone", getUserOrderInfoVO.getPhone());
            String sign = SignUtil.createSign(map);
            map.put("sign", sign);
            map.remove("secretKey");
            HttpResultUtil result = HttpUtil.doPostBody(Consts.COMMON.URL+"/cola/order/common/getUserOrderInfo", null, JSONObject.toJSONString(map));
            logger.info("查询用户交易情况返回结果：{}", result+"");
            if(result.getCode() != HttpStatus.SC_OK || null == result.getContent().getData()){
                return ResultUtil.error(ExceptionEnum.QUERY_USER_TRADE_ERROR);
            }
            return ResultUtil.success(result.getContent().getData());
        } catch (Exception e){
            logger.error(ExceptionEnum.QUERY_USER_TRADE_ERROR.getMsg(), e);
            return ResultUtil.error(ExceptionEnum.QUERY_USER_TRADE_ERROR);
        }
    }

    @PostMapping("/getOrderInfo")
    @ApiOperation(value = "查询订单信息",notes = "查询订单信息")
    public Result getOrderInfo(@RequestBody @Validated(value = GetOrderInfoVO.GetOrderInfo.class) GetOrderInfoVO getOrderInfoVO){
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("secretKey", Consts.COMMON.APPSECRET);
            map.put("companyId", Consts.COMMON.APPKEY);
            map.put("companyOrderNum", getOrderInfoVO.getCompanyOrderNum());
            String sign = SignUtil.createSign(map);
            map.put("sign", sign);
            map.remove("secretKey");
            HttpResultUtil result = HttpUtil.doPostBody(Consts.COMMON.URL+"/cola/order/common/getOrderInfo", null, JSONObject.toJSONString(map));
            logger.info("查询订单信息返回结果：{}", result+"");
            if(result.getCode() != HttpStatus.SC_OK || null == result.getContent().getData()){
                return ResultUtil.error(ExceptionEnum.QUERY_ORDER);
            }
            return ResultUtil.success(result.getContent().getData());
        } catch (Exception e){
            logger.error(ExceptionEnum.QUERY_ORDER.getMsg(), e);
            return ResultUtil.error(ExceptionEnum.QUERY_ORDER);
        }
    }

    @PostMapping("/buyOrder")
    @ApiOperation(value = "下买单",notes = "下买单")
    public Result buyOrder(){
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("areaCode", "86");
            map.put("asyncUrl", "127.0.0.1:8090/v1/demo/return.php");
            map.put("total", "200");
            map.put("coinSign", "USDT");
            map.put("coinAmount", "20");
            map.put("companyId", Consts.COMMON.APPKEY);
            map.put("companyOrderNum", UUID.randomUUID().toString());//商户自定义订单号
            map.put("idCardNum", "430524143201097878");
            map.put("idCardType", "1");
            map.put("kyc", "2");
            map.put("orderPayChannel", "3");
            map.put("orderTime", "1594174982945");
            map.put("orderType", "1");
            map.put("payCoinSign", "cny");
            map.put("phone", "18900000001");
            map.put("syncUrl", "127.0.0.1:8090/v1/demo/return.php");
            map.put("username", "范思哲");
            map.put("secretKey", Consts.COMMON.APPSECRET);//密钥
            String sign = SignUtil.createSign(map);//创建签名
            map.put("sign", sign);
            map.remove("secretKey");
            HttpResultUtil result = HttpUtil.doPostBody(Consts.COMMON.URL+"/cola/order/addOrder", null, JSONObject.toJSONString(map));
            logger.info("请求下买单返回结果：{}", result+"");
            if(result.getCode() != HttpStatus.SC_OK || null == result.getContent().getData()){
                return ResultUtil.error(ExceptionEnum.BUY_ORDER_ERROR);
            }
            return ResultUtil.success(result.getContent().getData());
        } catch (Exception e){
            logger.error(ExceptionEnum.BUY_ORDER_ERROR.getMsg(), e);
            return ResultUtil.error(ExceptionEnum.BUY_ORDER_ERROR);
        }
    }


    @PostMapping("/sellOrder")
    @ApiOperation(value = "下卖单",notes = "下卖单")
    public Result sellOrder(){
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("areaCode", "86");
            map.put("asyncUrl", "127.0.0.1:8090/v1/demo/return.php");
            map.put("total", "200");
            map.put("coinSign", "USDT");
            map.put("coinAmount", "20");
            map.put("companyId", Consts.COMMON.APPKEY);
            map.put("companyOrderNum", UUID.randomUUID().toString());//商户自定义订单号
            map.put("idCardNum", "430524143201097878");
            map.put("idCardType", "1");
            map.put("kyc", "2");
            map.put("orderPayChannel", "3");
            map.put("orderTime", "1594174982945");
            map.put("orderType", "2");
            map.put("payCoinSign", "cny");
            map.put("phone", "18900000001");
            map.put("syncUrl", "127.0.0.1:8090/v1/demo/return.php");
            map.put("username", "范思哲");
            map.put("payCardNo", "99999999999999999999999");
            map.put("secretKey", Consts.COMMON.APPSECRET);//密钥
            String sign = SignUtil.createSign(map);//创建签名
            map.put("sign", sign);
            map.remove("secretKey");
            HttpResultUtil result = HttpUtil.doPostBody(Consts.COMMON.URL+"/cola/order/addOrder", null, JSONObject.toJSONString(map));
            logger.info("请求下卖单返回结果：{}", result+"");
            if(result.getCode() != HttpStatus.SC_OK || null == result.getContent().getData()){
                return ResultUtil.error(ExceptionEnum.SELL_ORDER_ERROR);
            }
            return ResultUtil.success(result.getContent().getData());
        } catch (Exception e){
            logger.error(ExceptionEnum.SELL_ORDER_ERROR.getMsg(), e);
            return ResultUtil.error(ExceptionEnum.SELL_ORDER_ERROR);
        }
    }

    @GetMapping("/sign")
    @ApiOperation(value = "签名",notes = "签名")
    public void sign(){
        Map<String, Object> map = new HashMap<>();
        map.put("coinAmount", "100");
        map.put("coinSign", "usdt");
        map.put("companyOrderNum", "hafagafasfadfwerwer32");
        map.put("otcOrderNum", "12511234561_1592731510161");
        map.put("orderType", "1");
        map.put("tradeStatus", "1");//密钥
        map.put("tradeOrderTime", "2020-07-15 18:46:04");
        map.put("unitPrice", "7.01");
        map.put("total", "701");
        map.put("successAmount", "701");
        String sign = SignUtil.createSign(map);//创建签名
        System.out.println("签名："+sign);
    }


}
