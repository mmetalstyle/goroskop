package com.goroskop.request;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class DBConnector {
	private String text;
	private String date;
	private int result = 0;
	private int dayIndex;
	private int znakZodiakaIndex;
	public DBConnector(int aDayIndex, int aZnakZodiakaIndex) {
		dayIndex = aDayIndex;
		znakZodiakaIndex = aZnakZodiakaIndex;

		/*
		 * "Брутальный гороскоп", "today": { "bl": "bl 1", "dv": "dv", "kz":
		 * "kz", "lv": "lv", "ov": "ov", "rk": "rk", "rb": "rb", "sk": "sk",
		 * "st": "st", "tl": "tl", "vs": "vs", "vd": "vd", } }
		 */
		UrlConnector connector = new UrlConnector("http://tranceforce.ru/goroskop.php");
		setResult(getDataFromJSON(connector.getUrlContents()));

		// Set Info
		if (result == -1)
			return;
	}

	private int getDataFromJSON(String input) {
		try {
			JSONObject json = new JSONObject(input);
			Log.i("REQUEST_DATA", dayIndex +" -- "+znakZodiakaIndex );
			Log.i("REQUEST_DATA", (String)((JSONObject)json.get(dayIndex+"")).get(znakZodiakaIndex+""));
			setText((String)((JSONObject)json.get(dayIndex+"")).get(znakZodiakaIndex+""));
			
			switch (dayIndex) {
			case 0:
				setDate("Сегодня: 23 июля 2011");
				break;
			case 1:
				setDate("Вчера: 23 июля 2011");
				break;
			case 2:
				setDate("2 дня назад: 23 июля 2011");
				break;
			}
		} catch (JSONException e) {
			e.printStackTrace();
			return -1;
		}
		return 0;
	}

	public String getText() {
		return text;
	}

	public String getDate() {
		return date;
	}

	public int getResult() {
		return result;
	}

	public void setText(String aText) {
		text = aText;
	}

	public void setDate(String aData) {
		date = aData;
	}

	public void setResult(int aResult) {
		result = aResult;
	}
}
