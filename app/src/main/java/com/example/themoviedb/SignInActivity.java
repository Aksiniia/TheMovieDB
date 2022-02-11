package com.example.themoviedb;


import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.themoviedb.Api.ApiRetrofit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignInActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sign_in);

		Button button = findViewById(R.id.signIn);
		EditText pass = findViewById(R.id.editTextTextPassword);
		EditText email = findViewById(R.id.editTextTextEmailAddress);


		final TextWatcher watcher = new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

			}

			@Override
			public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

			}

			@Override
			public void afterTextChanged(Editable editable) {
				boolean enabled = true;
				String p = pass.getText().toString();
				String em = email.getText().toString();
				if (p.isEmpty() || em.isEmpty()) {
					enabled = false;
				}
				button.setEnabled(enabled);
			}
		};

		email.addTextChangedListener(watcher);
		pass.addTextChangedListener(watcher);

		button.setOnClickListener(v -> {
			String p = pass.getText().toString();
			String em = email.getText().toString();

			if (!Patterns.EMAIL_ADDRESS.matcher(em).matches()) {
				email.setError("Invalid email");
				return;
			}
			if (p.length() <= 5) {
				pass.setError("Invalid password");
				return;
			} else {
				// TODO get Api key from api
				MainActivity.API_KEY = "4ec92a5ee97823eb5d0497fb05a5f5a1";
				MainActivity.saveApi_key(this);

				startActivity(new Intent(SignInActivity.this, FilmsActivity.class));
				finish();
			}


			ApiRetrofit.API.signIn(em, p).enqueue(new Callback<ResponseBody>() {
				@Override
				public void onResponse(@NonNull Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {
					int a = 0;
				}

				@Override
				public void onFailure(@NonNull Call<ResponseBody> call, Throwable t) {

				}
			});
		});
	}

	public void toFilms(View view) {
	}
}