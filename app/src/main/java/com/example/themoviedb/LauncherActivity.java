package com.example.themoviedb;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class LauncherActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		SettingsStorage.load(this);
		startActivity(new Intent(this, SettingsStorage.token == null ? MainActivity.class : FilmsActivity.class));
		finish();
	}
}