package com.example.themoviedb;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
	public static String API_KEY;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		loadApi_key(this);

		startActivity(new Intent(MainActivity.this, API_KEY == null ? SignInActivity.class : FilmsActivity.class));
		finish();

	}

	public static void loadApi_key(Context context) {
		android.content.SharedPreferences sharedPreferences = context.getSharedPreferences("settings", MODE_PRIVATE);
		API_KEY = sharedPreferences.getString("API_KEY", null);
	}

	public static void saveApi_key(Context context) {
		android.content.SharedPreferences sharedPreferences = context.getSharedPreferences("settings", MODE_PRIVATE);
		final SharedPreferences.Editor edit = sharedPreferences.edit();
		edit.putString("API_KEY", API_KEY);
		edit.commit();
	}

	public void toSignIn(View view) {
		startActivity(new Intent(
				MainActivity.this,
				SignInActivity.class
		));
		finish();
	}
}