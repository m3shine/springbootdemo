package com.example.domain.utils;

import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by djklaf on 2017/1/5.
 */
@Component
@ConfigurationProperties(prefix = "juhe",locations = "classpath:/wsconf.properties")
public class Juhe {
    private static final Logger log = LoggerFactory.getLogger(Juhe.class);
    private String site;
    private String appkey;

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getAppkey() {
        return appkey;
    }

    public void setAppkey(String appkey) {
        this.appkey = appkey;
    }

    public JSONObject call(String path,String params){
        String url = this.getSite()+path+"?key=" +this.getAppkey()+params;
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        JSONObject json = JSONObject.fromObject(response);
        if(json.getInt("error_code")==0){
            JSONObject result = json.getJSONObject("result");
            return result;
        }else{
            log.error("调用接口发生错误，错误码："+json.getString("error_code")+"\r\n");
        }
        return null;
    }
}
