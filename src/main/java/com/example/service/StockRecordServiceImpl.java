package com.example.service;

import com.example.domain.Stock;
import com.example.domain.StockRecord;
import com.example.domain.StockRecordRepository;
import com.example.domain.StockRepository;
import com.example.domain.utils.DateUtil;
import com.example.domain.utils.ShowAPIProperties;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by djklaf on 2017/1/12.
 */
@Service
public class StockRecordServiceImpl implements StockRecordService {
    private static final Logger log = LoggerFactory.getLogger(StockRecordService.class);

    @Autowired
    ShowAPIProperties apiProperties;

    @Autowired
    StockRepository stockRepository;

    @Autowired
    StockRecordRepository stockRecordRepository;

    @Autowired
    DateUtil dateUtil;

    @Override
    @Transactional
    public void updateStocks() {
        try {
            List<Stock> stockList = stockRepository.findAll();
            if (stockList != null && stockList.size() > 0) {
                for (Stock s : stockList) {
                    JSONObject res = apiProperties.call(apiProperties.getSinglestock(), "&code=" + s.getCode());
                    if (res != null) {
                        JSONObject obj = res.getJSONObject("stockMarket");
                        if (obj != null && obj.size() > 2) {
                            StockRecord stockRecord = new StockRecord();
                            stockRecord.setCode(obj.getString("code"));
                            stockRecord.setName(obj.getString("name"));
                            stockRecord.setMarket(obj.getString("market"));
                            stockRecord.setOpenPrice(obj.getDouble("openPrice"));
                            stockRecord.setClosePrice(obj.getDouble("closePrice"));
                            stockRecord.setTradeNum(obj.getDouble("tradeNum"));
                            stockRecord.setTradeAmount(obj.getDouble("tradeAmount"));
                            stockRecord.setDate(dateUtil.str2Date(obj.getString("date")));
                            stockRecord.setDiffMoney(obj.getDouble("diff_money"));
                            stockRecord.setDiffRate(obj.getDouble("diff_rate"));
                            stockRecord.setTurnover(obj.getString("turnover"));
                            stockRecord.setPe(obj.getString("pe"));
                            stockRecord.setPb(obj.getString("pb"));
                            stockRecordRepository.save(stockRecord);
                        }
                    }
                }
            }
        }catch (Exception e){
            log.info(e.getMessage());
        }
    }

}
