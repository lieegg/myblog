package com.my.blog.website.utils;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;

/**
 * httpCLient工具类
 * daimy
 */
public class HttpClientUtil {
	private static PoolingHttpClientConnectionManager cm;
	private static String EMPTY_STR = "";
	private static String UTF_8 = "UTF-8";

	private static void init() {
		if (cm == null) {
			cm = new PoolingHttpClientConnectionManager();
			cm.setMaxTotal(50);// 整个连接池最大连接数
			cm.setDefaultMaxPerRoute(5);// 每路由最大连接数，默认值是2
		}
	}

	/**
	 * 通过连接池获取HttpClient
	 * 
	 * @return
	 */
	private static CloseableHttpClient getHttpClient() {
		init();
		return HttpClients.custom().setConnectionManager(cm).build();
	}

	/**
	 * 
	 * @param url
	 * @return
	 */
	public static String httpGetRequest(String url) {
		HttpGet httpGet = new HttpGet(url);
		return getResult(httpGet);
	}

	public static String httpGetRequest(String url, Map<String, Object> params) throws URISyntaxException {
		URIBuilder ub = new URIBuilder();
		ub.setPath(url);

		ArrayList<NameValuePair> pairs = covertParams2NVPS(params);
		ub.setParameters(pairs);

		HttpGet httpGet = new HttpGet(ub.build());
		return getResult(httpGet);
	}

	public static String httpGetRequest(String url, Map<String, Object> headers, Map<String, Object> params)
			throws URISyntaxException {
		URIBuilder ub = new URIBuilder();
		ub.setPath(url);

		ArrayList<NameValuePair> pairs = covertParams2NVPS(params);
		ub.setParameters(pairs);

		HttpGet httpGet = new HttpGet(ub.build());
		for (Map.Entry<String, Object> param : headers.entrySet()) {
			httpGet.addHeader(param.getKey(), String.valueOf(param.getValue()));
		}
		return getResult(httpGet);
	}

	public static String httpPostRequest(String url) {
		HttpPost httpPost = new HttpPost(url);
		return getResult(httpPost);
	}

	public static String httpPostRequest(String url, Map<String, Object> params) throws UnsupportedEncodingException {
		HttpPost httpPost = new HttpPost(url);
		ArrayList<NameValuePair> pairs = covertParams2NVPS(params);
		httpPost.setEntity(new UrlEncodedFormEntity(pairs, UTF_8));
		return getResult(httpPost);
	}

	public static String httpPostRequest(String url, Map<String, Object> headers, Map<String, Object> params)
			throws UnsupportedEncodingException {
		HttpPost httpPost = new HttpPost(url);

		for (Map.Entry<String, Object> param : headers.entrySet()) {
			httpPost.addHeader(param.getKey(), String.valueOf(param.getValue()));
		}

		ArrayList<NameValuePair> pairs = covertParams2NVPS(params);
		httpPost.setEntity(new UrlEncodedFormEntity(pairs, UTF_8));

		return getResult(httpPost);
	}

	private static ArrayList<NameValuePair> covertParams2NVPS(Map<String, Object> params) {
		ArrayList<NameValuePair> pairs = new ArrayList<NameValuePair>();
		for (Map.Entry<String, Object> param : params.entrySet()) {
			pairs.add(new BasicNameValuePair(param.getKey(), String.valueOf(param.getValue())));
		}

		return pairs;
	}

	/**
	 * 处理Http请求
	 * 
	 * @param request
	 * @return
	 */
	private static String getResult(HttpRequestBase request) {
		// CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpClient httpClient = getHttpClient();
		try {
			CloseableHttpResponse response = httpClient.execute(request);
			// response.getStatusLine().getStatusCode();
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				// long len = entity.getContentLength();// -1 表示长度未知
				String result = EntityUtils.toString(entity);
				response.close();
				// httpClient.close();
				return result;
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}

		return EMPTY_STR;
	}

	public static String httpRequestWithXmlStr(String urlStr, String xmlStr) throws Exception {
		URL url = new URL(urlStr);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		// 设置是否向httpUrlConnection输出，因为这个是post请求，参数要放在
		// http正文内，因此需要设为true, 默认情况下是false;
		connection.setDoOutput(true);
		// 设置是否从httpUrlConnection读入，默认情况下是true;
		connection.setDoInput(true);
		// Post 请求不能使用缓存
		connection.setUseCaches(false);
		connection.setRequestMethod("POST");
		connection.setConnectTimeout(12 * 1000);
		connection.setReadTimeout(20 * 1000);

		connection.setRequestProperty("Content-Type", "text/xml");
		// http.setRequestProperty("Cookie", DataDefine.mCookieStore);
		DataOutputStream out = new DataOutputStream(connection.getOutputStream());
		out.write(xmlStr.toString().getBytes());
		out.flush();
		out.close();
		connection.connect();
		InputStream in = connection.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in, "GBK"));
		String line = "";
		StringBuffer result = new StringBuffer();
		while ((line = reader.readLine()) != null) {
			result.append(line);
		}
		in.close();
		connection.disconnect();
		return result.toString();
	}

	public static String httpRequestWithXmlStr(String urlStr, String xmlStr,String encoding) throws Exception {
		URL url = new URL(urlStr);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		// 设置是否向httpUrlConnection输出，因为这个是post请求，参数要放在
		// http正文内，因此需要设为true, 默认情况下是false;
		connection.setDoOutput(true);
		// 设置是否从httpUrlConnection读入，默认情况下是true;
		connection.setDoInput(true);
		// Post 请求不能使用缓存
		connection.setUseCaches(false);
		connection.setRequestMethod("POST");
		connection.setConnectTimeout(12 * 1000);
		connection.setReadTimeout(20 * 1000);
		connection.setRequestProperty("Content-Type", "text/xml");
		connection.setRequestProperty("Accept-Charset", "GBK");
		connection.setRequestProperty("contentType", "GBK");
		// http.setRequestProperty("Cookie", DataDefine.mCookieStore);
		DataOutputStream out = new DataOutputStream(connection.getOutputStream());
		out.write(xmlStr.getBytes("GBK"));
		out.flush();
		out.close();
		connection.connect();
		InputStream in = connection.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in, "GBK"));
		String line = "";
		StringBuffer result = new StringBuffer();
		while ((line = reader.readLine()) != null) {
			result.append(line);
		}
		in.close();
		connection.disconnect();
		return result.toString();
	}

	public String httpsRequest(String reqUrl ,String xml) throws Exception {


		URL url = new URL(null, reqUrl, new sun.net.www.protocol.https.Handler());
		SSLContext context = SSLContext.getInstance("TLS");
		context.init(null, new TrustManager[] { new TrustAllManager() }, null);
		HttpsURLConnection.setDefaultSSLSocketFactory(context.getSocketFactory());
		HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
			@Override
			public boolean verify(String arg0, SSLSession arg1) {
				return true;
			}
		});

		HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
		connection.setRequestMethod("POST");
		connection.setConnectTimeout(12 * 1000);
		connection.setReadTimeout(20 * 1000);

		connection.setDoInput(true);
		connection.setDoOutput(true);
		connection.setRequestProperty("Content-Type", "text/xml"); //
		DataOutputStream out = new DataOutputStream(connection.getOutputStream());
		out.write(xml.toString().getBytes());
		out.flush();
		out.close();
		connection.connect();
		InputStream in = connection.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String line = "";
		StringBuffer result = new StringBuffer();
		while ((line = reader.readLine()) != null) {
			result.append(line);
		}
		in.close();
		connection.disconnect();
		return result.toString();
	}

}
