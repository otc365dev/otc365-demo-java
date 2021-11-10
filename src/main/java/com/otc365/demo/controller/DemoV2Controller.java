package com.otc365.demo.controller;

import com.otc365.demo.common.constant.Consts;
import com.otc365.demo.domain.vo.GetOrderInfoVO;
import com.otc365.demo.domain.vo.GetUserOrderInfoVO;
import com.otc365.sdk.ApiV1;
import com.otc365.sdk.ApiV2;
import com.otc365.sdk.util.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/v2")
public class DemoV2Controller {

    private  static Logger logger = LoggerFactory.getLogger(DemoV2Controller.class);

    @GetMapping("/getPrice")
    public String queryPrice(@RequestParam String coinType) throws Exception{
        return Utils.httpGet(Consts.AppConfig.URL+"/cola/quotePriceBusiness/priceConfig/getPrice?coinType="+coinType);
    }

    @PostMapping("/getUserOrderInfo")
    public String getUserOrderInfo(@RequestBody @Validated(value = GetUserOrderInfoVO.GetUserOrderInfo.class) GetUserOrderInfoVO getUserOrderInfoVO) throws Exception{

        Map<String, Object> params = new HashMap<>();
        params.put("companyId", Consts.AppConfig.APP_KEY);
        params.put("areaCode", getUserOrderInfoVO.getAreaCode());
        params.put("phone", getUserOrderInfoVO.getPhone());


        ApiV2 apiV2 = new ApiV2(Consts.AppConfig.APP_PRIVATE_KEY);

        return apiV2.call(Consts.AppConfig.URL+"/cola/apiOpen/common/getUserOrderInfo",params);

    }

    @PostMapping("/getOrderInfo")
    public String getOrderInfo(@RequestBody @Validated(value = GetOrderInfoVO.GetOrderInfo.class) GetOrderInfoVO getOrderInfoVO) throws Exception{

        Map<String, Object> params = new HashMap<>();
        params.put("companyId", Consts.AppConfig.APP_KEY);
        params.put("companyOrderNum", getOrderInfoVO.getCompanyOrderNum());
        ApiV2 apiV2 = new ApiV2(Consts.AppConfig.APP_PRIVATE_KEY);
        return apiV2.call(Consts.AppConfig.URL+"/cola/apiOpen/common/getOrderInfo",params);



    }

    @GetMapping("/buyOrder")
    public String buyOrder() throws Exception{

        Map<String,Object> params = new HashMap<>();

        params.put("username","haha");
        params.put("areaCode","86");
        params.put("phone","18900000007");
        params.put("idCardType","1");
        params.put("idCardNum","430524143201097878");
        params.put("kyc",2);
        params.put("companyOrderNum","NB"+System.currentTimeMillis());
        params.put("coinSign","USDT");
        params.put("coinAmount",20);
        params.put("total",200);
        params.put("orderPayChannel",3);
        params.put("payCoinSign","cny");
        params.put("companyId","12511234561");
        params.put("orderTime",System.currentTimeMillis());
        params.put("orderType",1); //buy order
        params.put("signType",1);
        params.put("syncUrl","https://demo.otc365test.com");
        params.put("asyncUrl","https://demo.otc365test.com");

        ApiV2 apiV2 = new ApiV2(Consts.AppConfig.APP_PRIVATE_KEY);

        return apiV2.call(Consts.AppConfig.URL+"/cola/apiOpen/addOrder",params);

    }


    @GetMapping("/sellOrder")
    public String sellOrder() throws Exception{
        Map<String, Object> params = new HashMap<>();
        params.put("areaCode", "86");
        params.put("asyncUrl", "127.0.0.1:8090/v1/demo/return.php");
        params.put("total", "200");
        params.put("coinSign", "USDT");
        params.put("coinAmount", "20");
        params.put("companyId", Consts.AppConfig.APP_KEY);
        params.put("companyOrderNum", UUID.randomUUID().toString());//商户自定义订单号
        params.put("idCardNum", "430524143201097878");
        params.put("idCardType", "1");
        params.put("kyc", "2");
        params.put("orderPayChannel", "3");
        params.put("orderTime",System.currentTimeMillis());
        params.put("orderType", "2"); //sell order
        params.put("signType",1);
        params.put("payCoinSign", "cny");
        params.put("phone", "18900000007");
        params.put("syncUrl", "127.0.0.1:8090/v1/demo/return.php");
        params.put("username", "范思哲");
        params.put("payCardNo", "99999999999999999999999");

        ApiV2 apiV2 = new ApiV2(Consts.AppConfig.APP_PRIVATE_KEY);

        return apiV2.call(Consts.AppConfig.URL+"/cola/apiOpen/addOrder",params);

    }
}
