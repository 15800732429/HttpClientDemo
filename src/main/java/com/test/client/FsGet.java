package com.test.client;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class FsGet {
	public static void main(String[] args) throws ClientProtocolException, IOException {
		String url = "https://api.apishop.net/communication/phone/getLocationByPhoneNum?apiKey=anJBypUde088834d600f358ec0136b805aff3f51ff2660d&phoneNum=15800732429";
		CloseableHttpClient httpClient;
		HttpGet httpGet;
		CloseableHttpResponse httpResponse;
		HttpEntity responseBody;
		int responseCode;
		Header[] responseHeader;
		
		//创建一个httpClient的实例
		httpClient = HttpClients.createDefault();
		//创建一个httpGet请求实例
		httpGet = new HttpGet(url);
		//使用httpClient实例发送刚创建的get请求，并用httpResponse将反馈接收
		httpResponse = httpClient.execute(httpGet);
		
		//从反馈中提取出状态码
		responseCode = httpResponse.getStatusLine().getStatusCode();
		//从反馈中提取出反馈主体
		responseBody = httpResponse.getEntity();
		//从反馈中提取出所有头部信息
		responseHeader = httpResponse.getAllHeaders();
		
		//用EntityUtils工具类将反馈主体处理为字符串形式
		String responseBodyString = EntityUtils.toString(responseBody,"utf-8");
		
		//用哈希图将反馈头信息以键值对形式保存
		HashMap<String,String> hashMap = new HashMap<String,String>();
		for(Header header:responseHeader){
			hashMap.put(header.getName(),header.getValue());
		}
		
		System.out.println("This is the response code:" + responseCode);
        System.out.println("This is the response body:" + responseBodyString);
        System.out.println("This is the response header in hash" + hashMap);

		
	}

}

