package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.domain.CoinData;
import com.example.demo.domain.CoinDetail;
import com.example.demo.repository.CoinDataRepository;
import com.example.demo.repository.CoinDetailRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

@SpringBootTest(classes = DemoApplication.class)
@ActiveProfiles("test")
public class DemoApplicationTests {


    @Resource
    private CoinDataRepository coinDataRepository;

    @Resource
    private CoinDetailRepository coinDetailRepository;

    @DisplayName("showCoinData")
    @Test
    public void showApiData() {

        String apiUrl = "https://api.coindesk.com/v1/bpi/currentprice.json";
        BufferedReader reader;
        reader = null;
        StringBuilder result;

        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Content-Typ", "application/x-www-form-urlencoded");
            connection.setRequestProperty("Charset", "UFT-8");
            connection.connect();
            result = new StringBuilder();
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
            JSONObject jsonObject = JSON.parseObject(result.toString());

            CoinData coinData = new CoinData();
            coinData.setChartName(recurseKeys(jsonObject, "chartName"));
            coinData.setDisclaimer(recurseKeys(jsonObject, "disclaimer"));
            coinData.setUpdated(recurseKeys(jsonObject, "updated"));
            coinData.setUpdatedISO(recurseKeys(jsonObject, "updatedISO"));
            coinData.setUpdateDuk(recurseKeys(jsonObject, "updateduk"));
            List<CoinDetail> detailList = new ArrayList<>();
            CoinDetail usd = setCoinDetail(jsonObject.getJSONObject("bpi").getJSONObject("USD"));
            CoinDetail gbp = setCoinDetail(jsonObject.getJSONObject("bpi").getJSONObject("GBP"));
            CoinDetail eur = setCoinDetail(jsonObject.getJSONObject("bpi").getJSONObject("EUR"));
            detailList.add(usd);
            detailList.add(gbp);
            detailList.add(eur);
            coinData.setChildren(detailList);

            System.out.println(coinData);
            System.out.println(usd);
            System.out.println(gbp);
            System.out.println(eur);

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @DisplayName("add")
    @Test
    public void addCoinData() {

        CoinData coinData = new CoinData();
        coinData.setChartName("Tether");
        coinData.setDisclaimer("test");
        coinData.setUpdated("Sep 22, 2022 06:55:00 UTC");
        coinData.setUpdatedISO("2022-09-22T06:55:00+00:00");
        coinData.setUpdateDuk("Sep 22, 2022 at 07:55 BST");
        List<CoinDetail> detailList = new ArrayList<>();
        CoinDetail coinDetail = new CoinDetail();
        coinDetail.setSymbol("&euro");
        coinDetail.setRateFloat("18291.6043");
        coinDetail.setCode("EUR");
        coinDetail.setRate("18,291.6043");
        coinDetail.setDescription("Euro");
        coinDetailRepository.save(coinDetail);
        detailList.add(coinDetail);
        coinData.setChildren(detailList);
        coinDataRepository.save(coinData);
    }

    @DisplayName("searchAndUpdate")
    @Test
    public void searchAndUpdateCoinData() {
        //查詢
        String keyword = "Bitcoin";
        CoinData coinData = coinDataRepository.findCoinDataByChartName(keyword);
        System.out.println(coinData);

        //更新
        coinData.setChartName("Ether");
        coinData.setUpdated("test");
        coinDataRepository.save(coinData);
        System.out.println(coinData);
    }

    @DisplayName("delete")
    @Test
    public void deleteCoinData() {
        //查詢
        String keyword = "Bitcoin";
        CoinData coinData = coinDataRepository.findCoinDataByChartName(keyword);
        coinDataRepository.delete(coinData);

    }


    private String recurseKeys(JSONObject jObj, String findKey) throws JSONException {
        String finalValue = "";
        if (jObj == null) {
            return finalValue;
        }

        Iterator<String> keyItr = jObj.keySet().iterator();
        Map<String, String> map = new HashMap<>();

        while (keyItr.hasNext()) {
            String key = keyItr.next();
            map.put(key, jObj.getString(key));
        }

        for (Map.Entry<String, String> e : (map).entrySet()) {
            String key = e.getKey();
            if (key.equalsIgnoreCase(findKey)) {
                return jObj.getString(key);
            }

            Object value = jObj.get(key);

            if (value instanceof JSONObject) {
                finalValue = recurseKeys((JSONObject) value, findKey);
            }
        }
        return finalValue;
    }

    private CoinDetail setCoinDetail(JSONObject jsonObject) {
        CoinDetail coinDetail = new CoinDetail();

        coinDetail.setCode(recurseKeys(jsonObject, "code"));
        coinDetail.setSymbol(recurseKeys(jsonObject, "symbol"));
        coinDetail.setRate(recurseKeys(jsonObject, "rate"));
        coinDetail.setDescription(recurseKeys(jsonObject, "description"));
        coinDetail.setRateFloat(recurseKeys(jsonObject, "rate_float"));

        return coinDetail;
    }

}
