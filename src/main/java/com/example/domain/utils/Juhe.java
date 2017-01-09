package com.example.domain.utils;

import net.sf.json.JSONObject;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by djklaf on 2017/1/5.
 */
@Component
@ConfigurationProperties(prefix = "juhe",locations = "classpath:/wsconf.properties")
public class Juhe {
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
        if("SUCCESSED!".equals(json.get("reason"))){
            JSONObject result = json.getJSONObject("result");
            return result;
        }
        return null;
    }


}
