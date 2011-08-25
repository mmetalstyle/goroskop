package com.goroskop.request;

public class DBConnector {
	private String text;
	private String date;
	private int result = 0;

	public DBConnector(int aDayIndex, int aZnakZodiakaIndex) {
		// TODO Connect to DB...

		setResult(0); // -1 - error

		// Set Info
		if (result == -1)
			return;
		
		setText(" Сегодня ваш мозг увеличился, килограмм так на 15, вы умны, сообразительны и красивы. "
				+ "Как нехуй делать, решаете все самые сложные задачи, "
				+ "бьете ебальники врагам и конкурентам, завоевываете симпатии противоположного пола."
				+ "К успеху идете, однозначно!");
		
		switch (aDayIndex) {
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
