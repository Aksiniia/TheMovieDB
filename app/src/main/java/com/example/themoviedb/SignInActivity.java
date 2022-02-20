package com.example.themoviedb;


import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.themoviedb.Api.ApiRetrofit;
import com.example.themoviedb.Api.Token;
import com.example.themoviedb.Api.ValidateUser;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignInActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sign_in);
		SettingsStorage.load(this);

		if (SettingsStorage.token != null) {

		}
		Button button = findViewById(R.id.signIn);
		EditText passInput = findViewById(R.id.editTextTextPassword);
		EditText emailInput = findViewById(R.id.editTextTextEmailAddress);


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
				String password = passInput.getText().toString();
				String email = emailInput.getText().toString();
				if (password.isEmpty() || email.isEmpty()) {
					enabled = false;
				}
				button.setEnabled(enabled);
			}
		};

		emailInput.addTextChangedListener(watcher);
		passInput.addTextChangedListener(watcher);

		button.setOnClickListener(v -> {
			String password = passInput.getText().toString();
			String email = emailInput.getText().toString();

//			if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
//				emailInput.setError("Invalid emailInput");
//			}
			if (password.length() <= 5) {
				passInput.setError("Invalid password");
			} else {
				ApiRetrofit.API.signIn().enqueue(new Callback<Token>() {
					@Override
					public void onResponse(@NonNull Call<Token> call, @NonNull Response<Token> response) {
						if (response.code() == 200 && response.body() != null) {
							SettingsStorage.token = response.body().request_token;
							SettingsStorage.save(SignInActivity.this);
							System.out.println();

							ApiRetrofit.API.validate(new ValidateUser(email, password, SettingsStorage.token)).enqueue(new Callback<ValidateResponse>() {
								@Override
								public void onResponse(Call<ValidateResponse> call, Response<ValidateResponse> response) {
									if (response.code() == 200 && response.body() != null && response.body().success) {
										SettingsStorage.token = response.body().request_token;
										SettingsStorage.save(SignInActivity.this);
										startActivity(new Intent(SignInActivity.this, FilmsActivity.class));
										finish();
									}
								}

								@Override
								public void onFailure(Call<ValidateResponse> call, Throwable t) {

								}
							});
						}
					}

					@Override
					public void onFailure(@NonNull Call<Token> call, Throwable t) {

					}
				});
			}
		});
	}

	public void toFilms(View view) {
	}
}