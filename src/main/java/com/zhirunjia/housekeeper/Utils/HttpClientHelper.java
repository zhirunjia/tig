package com.zhirunjia.housekeeper.Utils;


import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import android.util.Log;

import com.zhirunjia.housekeeper.Domain.Constants.GlobalVarable;

/**
 * Created by Xu wenQiang on 2014/5/15.
 */
public class HttpClientHelper {
    private static String TAG = "HttpClientHelper";
    private static HttpClient customerHttpClient;

    public static HttpClient getCustomerHttpClient(){

        if(customerHttpClient != null) return customerHttpClient;

        HttpParams httpParams = new BasicHttpParams();

        // 从连接池中取连接的超时时间
        ConnManagerParams.setTimeout(httpParams, GlobalVarable.CONN_MANAGER_TIMETOUT);
        // 连接超时
        HttpConnectionParams.setConnectionTimeout(httpParams, GlobalVarable.HTTP_CONNECT_TIMEOUT);
        // 请求超时
        HttpConnectionParams.setSoTimeout(httpParams, GlobalVarable.HTTP_SO_TIMEOUT);

        // 使用线程安全的连接管理来创建 HttpClient
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        ClientConnectionManager clientConnectionManager = new ThreadSafeClientConnManager(httpParams,schemeRegistry);
        customerHttpClient  = new DefaultHttpClient(clientConnectionManager, httpParams);
        return customerHttpClient;
    }

    public static String getMethod(String httpUrl, List<BasicNameValuePair> params) throws Throwable {
        Log.i(TAG, "HTTP URL: " + httpUrl);
        if (params != null) {
            Log.i(TAG, "HTTP Request params: " + params.toString());
        }
        HttpClient httpClient = getCustomerHttpClient();
        if (params != null && params.size() > 0) {
            //对参数编码
            String strParams = URLEncodedUtils.format(params, "UTF-8");
            httpUrl += "?" + strParams;
        }
        HttpGet httpGet = new HttpGet(httpUrl);
        HttpResponse httpResponse = httpClient.execute(httpGet);

        try{
            //Log.i(TAG, "HTTP Entity" + EntityUtils.toString(httpResponse.getEntity(), "无实体"));
            Log.i(TAG, "HTTP Status: " + httpResponse.getStatusLine().getStatusCode());
            Log.i(TAG, "HTTP ReasonPhrase: " + httpResponse.getStatusLine().getReasonPhrase());
        }catch (Exception e){
            Log.e(TAG, "Log error: " + e.toString());
        }

        if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            return EntityUtils.toString(httpResponse.getEntity(), "utf-8");
        }
        return null;
    }

    public static String postMethod(String httpUrl, List<BasicNameValuePair> params) throws Throwable {
        HttpClient httpClient = getCustomerHttpClient();
        HttpPost httpPost = new HttpPost(httpUrl);
        if (params != null && params.size() > 0) {
            httpPost.setEntity(new UrlEncodedFormEntity(params, "utf-8")); //将参数填入POST Entity中
        }
        HttpResponse httpResponse = httpClient.execute(httpPost);

        try{
            //Log.i(TAG, "HTTP Entity" + EntityUtils.toString(httpResponse.getEntity(), "无实体"));
            Log.i(TAG, "HTTP Status: " + httpResponse.getStatusLine().getStatusCode());
            Log.i(TAG, "HTTP ReasonPhrase: " + httpResponse.getStatusLine().getReasonPhrase());
        }catch (Exception e){
            Log.e(TAG, "Log error: " + e.toString());
        }

        if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            return EntityUtils.toString(httpResponse.getEntity(), "utf-8");
        }
        return null;
    }


    public static void postUpload(File file, String url, Map<String, String> params) throws Throwable {
        /*HttpClient httpclient = getCustomerHttpClient();
        HttpPost httppost = new HttpPost(url);
        System.out.println("executing request url " + url);
        MultipartEntity mpEntity = new MultipartEntity(); //文件传输
        // 添加上传文件
        ContentBody cbFile = new FileBody(file);
        mpEntity.addPart("file", cbFile); // <input type="file" name="userfile" />  对应的
        // 添加请求参数
        if (params != null && params.size() > 0) {
            for (String key : params.keySet()) {
                StringBody stringBody = new StringBody(params.get(key));
                mpEntity.addPart(key, stringBody);
            }
        }

        httppost.setEntity(mpEntity);
        System.out.println("executing request " + httppost.getRequestLine());

        HttpResponse response = httpclient.execute(httppost);
        HttpEntity resEntity = response.getEntity();

        System.out.println(response.getStatusLine());//通信Ok
        if (resEntity != null) {
            resEntity.getContent().close();
        }
        httpclient.getConnectionManager().shutdown();*/
    }

    public static void postDowload(String filePath, String url) throws Throwable {
        HttpClient httpclient = getCustomerHttpClient();
        HttpPost httppost = new HttpPost(url);
        System.out.println("executing request url " + url);
        HttpResponse resp = httpclient.execute(httppost);
        //判断访问状态是否正确执行
        if (HttpStatus.SC_OK == resp.getStatusLine().getStatusCode()) {
            HttpEntity entity = resp.getEntity();
            InputStream inputStream = entity.getContent();
            File file = new File(filePath);
            OutputStream outputStream = new FileOutputStream(file);
            byte buffer[] = new byte[4 * 1024];
            while ((inputStream.read(buffer)) != -1) {
                outputStream.write(buffer);
            }
            outputStream.flush();
            outputStream.close();
            inputStream.close();
        }
    }

}
