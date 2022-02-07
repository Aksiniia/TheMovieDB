package com.example.themoviedb.Api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiRetrofit {

	ApiRetrofit API = new Retrofit.Builder()
			.baseUrl("")
			.addConverterFactory(GsonConverterFactory.create())
			.build()
			.create(ApiRetrofit.class);


}