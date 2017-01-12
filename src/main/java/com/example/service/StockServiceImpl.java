package com.example.service;

import com.example.domain.utils.ShowAPIProperties;
import com.example.domain.Stock;
import com.example.domain.StockRepository;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
     * 从showapi获取上证数据并存库
     */
    @Override
    @Transactional
    public void initSHStocks() {
        int size = stockRepository.findAll().size();
        if(size == 0){
            JSONObject res = apiProperties.call(apiProperties.getStocklist(), "&market="+apiProperties.getMarket());
            if(res != null){
                int pages = res.getInt("allPages");
                for (int page = 1; page < pages; page++) {
                    JSONObject newres = apiProperties.call(apiProperties.getStocklist(), "&market="+apiProperties.getMarket()+"&page=" + page);
                    if (res != null) {
                        JSONArray array = newres.getJSONArray("contentlist");
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
        }
    }

    /**
     * 新股入库
     */
    @Override
    @Transactional
    public void addNewStocks(){
        if(haveNewStocks()){
            JSONObject res = apiProperties.call(apiProperties.getStocklist(), "&market="+apiProperties.getMarket());
            if(res != null){
                //后续改用jpa实现直接取code列表
                List<Stock> dblist = stockRepository.findAll();
                List<String> codeList = new ArrayList<>();
                for (Stock s : dblist){
                    codeList.add(s.getCode());
                }
                int pages = res.getInt("allPages");
                for (int page = 1; page < pages; page++) {
                    JSONObject newres = apiProperties.call(apiProperties.getStocklist(), "&market="+apiProperties.getMarket()+"&page=" + page);
                    if (res != null) {
                        JSONArray array = newres.getJSONArray("contentlist");
                        if (array.size() > 0) {
                            for (int i = 0; i < array.size(); i++) {
                                String code = array.getJSONObject(i).getString("code");
                                if(!codeList.contains(code)){
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
    public Boolean haveNewStocks(){
        JSONObject res = apiProperties.call(apiProperties.getStocklist(), "&market="+apiProperties.getMarket());
        if (res != null) {
            int num = res.getInt("allNum");
            int size = stockRepository.findAll().size();
            if (num > size) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String pickStocks(LocalDate date,Double percent){
        return "";
    }
}

