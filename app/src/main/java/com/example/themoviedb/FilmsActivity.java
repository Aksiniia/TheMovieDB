package com.example.themoviedb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.themoviedb.Api.ApiRetrofit;
import com.example.themoviedb.databinding.ActivityFilmsBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmsActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		final ActivityFilmsBinding binding = ActivityFilmsBinding.inflate(getLayoutInflater());
		super.onCreate(savedInstanceState);
		setContentView(binding.getRoot());

//		RecyclerView r = findViewById(R.id.rec_new);
//		r.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
		ApiRetrofit.API.getMovies("4ec92a5ee97823eb5d0497fb05a5f5a1").enqueue(new Callback<LatestModel>() {
			@Override
			public void onResponse(Call<LatestModel> call, Response<LatestModel> response) {
				if (response.code() == 200) {
				binding.name.setText(response.body().original_title);
				}
			}

			@Override
			public void onFailure(Call<LatestModel> call, Throwable t) {
				Toast.makeText(FilmsActivity.this, "error", Toast.LENGTH_SHORT).show();
			}
		});

	}

	public void info(View view) {
		startActivity(new Intent(FilmsActivity.this, InfoActivity.class));
	}
}