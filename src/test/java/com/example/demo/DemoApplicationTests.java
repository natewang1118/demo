package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.domain.CoinData;
import com.example.demo.domain.CoinDetail;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

@SpringBootTest
public class DemoApplicationTests {
    
    @Test
    public void contextLoads() {

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
            CoinDetail usd = setCoinDetail(jsonObject.getJSONObject("USD"));
            CoinDetail gbp = setCoinDetail(jsonObject.getJSONObject("GBP"));
            CoinDetail eur = setCoinDetail(jsonObject.getJSONObject("EUR"));
            detailList.add(usd);
            detailList.add(gbp);
            detailList.add(eur);
            coinData.setDetailList(detailList);

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
