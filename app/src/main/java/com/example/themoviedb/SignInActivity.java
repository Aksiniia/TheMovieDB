package com.example.themoviedb;


import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SignInActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sign_in);
		EditText pass = findViewById(R.id.editTextTextPassword);
		EditText email = findViewById(R.id.editTextTextEmailAddress);

		findViewById(R.id.signIn).setOnClickListener(v -> {
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
				startActivity(new Intent(SignInActivity.this, FilmsActivity.class));
			}

		});
	}

	public void toFilms(View view) {
	}
}