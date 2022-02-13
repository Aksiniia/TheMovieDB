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
		if (Storage.getInstance(this).getApiKey() != null) {
			startActivity(new Intent(MainActivity.this, FilmsActivity.class));
			finish();
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