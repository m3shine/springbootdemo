package com.example.service;

import com.example.domain.Stock;
import com.example.domain.StockRepository;
import com.example.domain.utils.Juhe;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public void updateStocks(){
        JSONObject res = juhe.call("finance/stock/shall","&stock=a");
        if(res != null){
            JSONArray array = res.getJSONArray("data");
            if(array.size()>0){
                for (int i = 0; i <array.size() ; i++) {
                    Stock stock = new Stock();
                    stock.setCode(array.getJSONObject(i).get("code").toString());
                    stock.setName(array.getJSONObject(i).get("name").toString());
                    stock.setSettlement(Double.parseDouble(array.getJSONObject(i).get("settlement").toString()));
                    stock.setDate(new Date());
                    stockRepository.save(stock);
                }
            }
        }
    }
}
