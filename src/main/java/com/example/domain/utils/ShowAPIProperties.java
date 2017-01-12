package com.example.domain.utils;

import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by djklaf on 2017/1/12.
 */
@Component
@ConfigurationProperties(value = "showapi",locations = "classpath:/wsconf.properties")
public class ShowAPIProperties {

    private static final Logger log = LoggerFactory.getLogger(ShowAPIProperties.class);

    private String site;
    private String stocklist;
    private String singlestock;
    private String appid;
    private String sign;
    private String market;

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getStocklist() {
        return stocklist;
    }

    public void setStocklist(String stocklist) {
        this.stocklist = stocklist;
    }

    public String getSinglestock() {
        return singlestock;
    }

    public void setSinglestock(String singlestock) {
        this.singlestock = singlestock;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    /**
     *
     * @param path showapi接口名
     * @param params
     * @return
     */
    public JSONObject call(String path, String params){
        //showapi接口调用间隔要求1秒
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String url = this.getSite()+path+"?showapi_appid=" +this.getAppid()+"&showapi_sign="+this.getSign()+params;
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        JSONObject json = JSONObject.fromObject(response);
        if(json.getInt("showapi_res_code")==0){
            JSONObject result = json.getJSONObject("showapi_res_body");
            return result;
        }else{
            log.error("调用接口发生错误，错误码："+json.getString("showapi_res_error")+"\r\n");
        }
        return null;
    }
}
