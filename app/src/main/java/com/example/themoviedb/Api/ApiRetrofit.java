package com.example.themoviedb.Api;

import com.example.themoviedb.LatestModel;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiRetrofit {

    //4ec92a5ee97823eb5d0497fb05a5f5a1
	//de998429af83f5ec5b284335b9c7fa10c951176a

	ApiRetrofit API = new Retrofit.Builder()
			.baseUrl("https://api.themoviedb.org/")
			.addConverterFactory(GsonConverterFactory.create())
			.build()
			.create(ApiRetrofit.class);

	@GET("3/authentication/token/new?api_key=4ec92a5ee97823eb5d0497fb05a5f5a1")
	Call<ResponseBody> signIn(@Query("email") String email,
							  @Query("password") String password);


	@GET("3/movie/latest")
	Call<LatestModel> getMovies(@Query("api_key") String key);

}