package com.goroskop.request;

import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import android.util.Log;

public class UrlConnector {
	private String Url = "";

	public UrlConnector(String aUrl) {
		this.Url = aUrl;
	}

	public String getUrlContents() {
		HttpClient httpclient = new DefaultHttpClient();
		HttpPost httppost = new HttpPost(Url);
		String response = "";
		try {
			ResponseHandler<String> responseHandler = new BasicResponseHandler();
			response = httpclient.execute(httppost, responseHandler);
			//Log.i("response :", response);
		} catch (ClientProtocolException e) {
			Log.i("response :", "ERROR 1");
			e.printStackTrace();
		} catch (IOException e) {
			Log.i("response :", "ERROR 2: ");
			e.printStackTrace();

		}
		return response;
	}
}
