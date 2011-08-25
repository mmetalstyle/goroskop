package com.goroskop;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.goroskop.ContactItem;

public class Goroskop extends ListActivity implements OnClickListener {
	public static int day; // 0 - сегодня, 1 - вчера, 2 - 2 дня назад
	public static int znakId;
	public static int znakImgId; 

	final CharSequence[] mChoise = { "Сегодня", "Вчера", "2 дня назад",
			"Отмена" };
	final int[] znakImgIdArray = { R.drawable.scnd_blizn, R.drawable.scnd_devi,
			R.drawable.scnd_kozerogi, R.drawable.scnd_lvi, R.drawable.scnd_ovni, R.drawable.scnd_raki,
			R.drawable.scnd_ribi, R.drawable.scnd_skorpioni, R.drawable.scnd_strelci,
			R.drawable.scnd_telci, R.drawable.scnd_vesi, R.drawable.scnd_vodolei };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		ArrayList<ContactItem> list = new ArrayList<ContactItem>();
		list.add(new ContactItem("Близнецы", znakImgIdArray[0]));
		list.add(new ContactItem("Девы", znakImgIdArray[1]));
		list.add(new ContactItem("Козероги", znakImgIdArray[2]));
		list.add(new ContactItem("Львы", znakImgIdArray[3]));
		list.add(new ContactItem("Овны", znakImgIdArray[4]));
		list.add(new ContactItem("Раки", znakImgIdArray[5]));
		list.add(new ContactItem("Рыбы", znakImgIdArray[6]));
		list.add(new ContactItem("Скорпионы", znakImgIdArray[7]));
		list.add(new ContactItem("Стрельцы", znakImgIdArray[8]));
		list.add(new ContactItem("Тельцы", znakImgIdArray[9]));
		list.add(new ContactItem("Весы", znakImgIdArray[10]));
		list.add(new ContactItem("Водолеи", znakImgIdArray[11]));

		ListAdapter adapter = new SimpleAdapter(this,
				(List<? extends Map<String, ?>>) list, R.layout.main,
				new String[] { ContactItem.NAME, ContactItem.PHONE },
				new int[] { R.id.name, R.id.phone });
		setListAdapter(adapter);
		getListView().setDividerHeight(3);
	}

	public void onListItemClick(ListView parent, View v, int position, long id) {
		Log.i("onListItemClick", "position: " + position);
		showDialog(position);
	}

	@Override
	protected Dialog onCreateDialog(final int id) {
		final Intent intent = new Intent();
		intent.setClass(this, SecondPage.class);

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Выберите день");
		builder.setItems(mChoise, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int item) {
				Log.i("onClick", "day: " + item + " znak: " + id);
				Goroskop.day = item;
				Goroskop.znakId = id;
				Goroskop.znakImgId = znakImgIdArray[id];
				
				if (item != 3) {
					startActivity(intent);
				}
			}
		});

		builder.setCancelable(false);
		return builder.create();
	}

	@Override
	public void onClick(View v) {

	}
}