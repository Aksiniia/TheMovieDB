package com.example.themoviedb;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;

public class Storage {
	private static Storage instance;
	private String apiKey;
	private final Context context;

	public static Storage getInstance(Context context) {
		if (instance == null) {
			instance = new Storage(context);
		}
		return instance;
	}

	private Storage(Context context) {
		this.context = context;
		android.content.SharedPreferences sharedPreferences = context.getSharedPreferences("settings", MODE_PRIVATE);
		apiKey = sharedPreferences.getString("API_KEY", null);

	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
		android.content.SharedPreferences sharedPreferences = context.getSharedPreferences("settings", MODE_PRIVATE);
		final SharedPreferences.Editor edit = sharedPreferences.edit();
		edit.putString("API_KEY", apiKey);
		edit.commit();
	}

	public String getApiKey() {
		return apiKey;
	}
}
