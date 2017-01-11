package com.example.service;

import com.example.domain.Stock;
import com.example.domain.StockRepository;
import com.example.domain.utils.Juhe;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by djklaf on 2017/1/9.
 */
@Service
public class StockServiceImpl implements StockService {
    @Autowired
    StockRepository stockRepository;

    @Autowired
    Juhe juhe;

    @Override
    public void updateStocks() {
        for (int page = 1; page < 16; page++) {
            JSONObject res = juhe.call("finance/stock/shall", "&stock=a&type=4&page=" + page);
            if (res != null) {
                JSONArray array = res.getJSONArray("data");
                if (array.size() > 0) {
                    for (int i = 0; i < array.size(); i++) {
                        Stock stock = new Stock();
                        stock.setCode(array.getJSONObject(i).getString("code"));
                        stock.setName(array.getJSONObject(i).getString("name"));
                        stock.setSettlement(array.getJSONObject(i).getDouble("settlement"));
                        stock.setDate(new Date());
                        stock.setAmount(array.getJSONObject(i).getDouble("amount"));
                        stock.setChangepercent(array.getJSONObject(i).getDouble("changepercent"));
                        stock.setVolume(array.getJSONObject(i).getDouble("volume"));
                        stockRepository.save(stock);
                    }
                }
            }
        }
    }

    @Override
    public String showStocks() {
        JSONArray arrayList = new JSONArray();
        for (int page = 1; page < 16; page++) {
            JSONObject res = juhe.call("finance/stock/shall", "&stock=a&type=4&page=" + page);
            if (res != null) {
                JSONArray array = res.getJSONArray("data");
                if (array.size() > 0) {
                    arrayList.addAll(array);
                }
            }
        }
        return arrayList.toString();
    }
}

