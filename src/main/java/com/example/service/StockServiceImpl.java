package com.example.service;

import com.example.domain.ShowAPIProperties;
import com.example.domain.Stock;
import com.example.domain.StockRepository;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;

/**
 * Created by djklaf on 2017/1/9.
 */
@Service
public class StockServiceImpl implements StockService {
    @Autowired
    StockRepository stockRepository;

    @Autowired
    ShowAPIProperties apiProperties;

    /**
     * 从ws获取当天（接口调用默认就是当天数据）上证全部a股数据并存库
     */
    @Override
    @Transactional
    public void initSHStocks() {
        for (int page = 1; page < 25; page++) {
            JSONObject res = apiProperties.call(apiProperties.getStocklist(), "&market="+apiProperties.getMarket()+"&page=" + page);
            if (res != null) {
                JSONArray array = res.getJSONArray("contentlist");
                if (array.size() > 0) {
                    for (int i = 0; i < array.size(); i++) {
                        Stock stock = new Stock();
                        stock.setCode(array.getJSONObject(i).getString("code"));
                        stock.setName(array.getJSONObject(i).getString("name"));
                        stock.setPinyin(array.getJSONObject(i).getString("pinyin"));
                        stock.setMarket(array.getJSONObject(i).getString("market"));
                        stockRepository.save(stock);
                    }
                }
            }
        }
    }

    @Override
    public String showStocks() {
        JSONArray arrayList = new JSONArray();
        for (int page = 1; page < 25; page++) {
            JSONObject res = apiProperties.call(apiProperties.getStocklist(), "&market="+apiProperties.getMarket()+"&page=" + page);
            if (res != null) {
                JSONArray array = res.getJSONArray("contentlist");
                if (array.size() > 0) {
                    arrayList.addAll(array);
                }
            }
        }
        return arrayList.toString();
    }

    @Override
    public String pickStocks(LocalDate date,Double percent){
        return "";
    }
}

