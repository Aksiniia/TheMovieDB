package com.example.themoviedb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		android.content.SharedPreferences sharedPreferences = getSharedPreferences("",MODE_PRIVATE);
		boolean isShown = sharedPreferences.getBoolean(com.example.themoviedb.SharedPreferences.splash_key, true);

		if (isShown){
//			startActivity(new Intent(MainActivity.this,
//					FilmsActivity.class));
		} else {

			android.content.SharedPreferences.Editor editor = sharedPreferences.edit();
			editor.putBoolean(com.example.themoviedb.SharedPreferences.splash_key, true);
			editor.commit();
		}
	}

	public void toSignIn(View view) {
		startActivity(new Intent(
				MainActivity.this,
				SignInActivity.class
		));
		finish();
	}
}