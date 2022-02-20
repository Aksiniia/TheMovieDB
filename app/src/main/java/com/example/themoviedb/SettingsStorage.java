package com.example.themoviedb;

import android.content.Context;
import android.content.SharedPreferences;

public class SettingsStorage {
	public static String token;

	public static void save(Context context) {
		final SharedPreferences sharedPreferences = context.getSharedPreferences("", Context.MODE_PRIVATE);
		final SharedPreferences.Editor edit = sharedPreferences.edit();
		edit.putString("token", token);
		edit.commit();
	}

	public static void load(Context context) {
		final SharedPreferences sharedPreferences = context.getSharedPreferences("", Context.MODE_PRIVATE);
		token = sharedPreferences.getString("token", null);

	}
}
