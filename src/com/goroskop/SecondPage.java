package com.goroskop;

import com.goroskop.Goroskop;
import com.goroskop.request.DBConnector;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SecondPage extends Activity implements OnClickListener {
	/* Called when the activity is first created. */
	final CharSequence[] mChoise = { "Сегодня", "Завтра", "Неделя", "Месяц",
			"Ну нахер" };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second);

		
		TextView goroskopInfoText = (TextView) findViewById(R.id.goroskopInfoText);
		//goroskopInfoText.setText("");
		
		
		TextView goroskopDateText = (TextView) findViewById(R.id.goroskopDateText);
		//goroskopDateText.setText("");

		
		Button buttonReturnToMainPage = (Button) findViewById(R.but.buttonReturnToMainPage);
		buttonReturnToMainPage.setOnClickListener(this);
		
		
		ImageView imgZnakZodiaka = (ImageView) findViewById(R.id.imgZnakZodiaka);

		/* Connect to DB */
		DBConnector dBConnector = new DBConnector(Goroskop.day, Goroskop.znakId);

		/* Check result from DB connector */
		if (dBConnector.getResult() != 0) {
			/* show message "Server not found" */
			showTrollFace();
		} else {
			imgZnakZodiaka.setImageResource(Goroskop.znakImgId);
			////goroskopInfoText.setText(dBConnector.getText());
			//goroskopDateText.setText(dBConnector.getDate());
			//goroskopDateText.setText("Стрельцы, сегодня просто красивы, обаятельны и пиздаты впрочем как и всегда! За вами бегают табуны лиц противоположенного пола. Ух, можете загулять мама не горюй.");
		}
	}

	@Override
	public void onClick(View src) {
		finish();
	}

	public void showTrollFace() {
		LayoutInflater inflater = getLayoutInflater();
		View layout = inflater.inflate(R.layout.custom_layout,
				(ViewGroup) findViewById(R.id.toast_layout));

		ImageView image = (ImageView) layout.findViewById(R.id.image);
		image.setImageResource(R.drawable.trollfacep_small);

		TextView text = (TextView) layout.findViewById(R.id.text);
		text.setText("Server not found!");
		text.setTextSize(20);

		Toast toast = new Toast(getApplicationContext());
		toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
		toast.setDuration(Toast.LENGTH_LONG);
		toast.setView(layout);
		toast.show();
	}
}