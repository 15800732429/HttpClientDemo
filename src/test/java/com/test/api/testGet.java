package com.test.api;

import org.testng.annotations.Test;

import com.alibaba.fastjson.JSONObject;
import com.test.client.RestfulClient;
import com.test.utils.JSONParser;

import java.io.IOException;
import java.text.ParseException;

import org.apache.http.client.ClientProtocolException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

public class testGet {
	RestfulClient client;
    JSONObject responseBody;
    JSONParser jParser;
    int responseCode;
    String city;
    String province;
    String url1 = "https://api.apishop.net/communication/phone/getLocationByPhoneNum?apiKey=anJBypUde088834d600f358ec0136b805aff3f51ff2660d&phoneNum=15800732429";
	
  @Test
  public void TestGetRequest() {
	//断言反馈中城市是否正确
  	Assert.assertEquals(city, "上海");
           //断言反馈中的状态码是否正确
          Assert.assertEquals(responseCode, 200);
    //断言反馈中省份是否正确
          //Assert.assertEquals(province, "上海");    
          
  }
  @BeforeClass
  public void beforeClass() throws ClientProtocolException, IOException, ParseException {
	//发送请求，获取反馈
      client = new RestfulClient();
      client.getResponse(url1);
      responseBody = client.getBodyInJSON();
      System.out.println("responseBody等于"+responseBody);
      responseCode = client.getCodeInNumber();
      System.out.println("responseCode等于"+responseCode);
       //调用JSONParser获取反馈中的城市信息
      jParser = new JSONParser();
      city = jParser.getCity(responseBody);
      System.out.println("city等于"+city);
      
      //province = jParser.getProvince(responseBody);
      //System.out.println("province等于"+province);
	  
  }

}
