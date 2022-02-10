package com.example.themoviedb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.themoviedb.Api.PopularModel;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.Holder> {
	Context context;
	PopularModel popularModel;

	public MovieAdapter(Context context, PopularModel popularModel) {
		this.context = context;
		this.popularModel = popularModel;
	}

	@NonNull
	@Override
	public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		return new Holder(
				LayoutInflater.from(context)
						.inflate(R.layout.film_item,
								parent,
								false)
		);
	}

	@Override
	public void onBindViewHolder(@NonNull Holder holder, int position) {
//		final View viewById = ((ImageView) holder.itemView.findViewById(R.id.image));
		((TextView)holder.itemView.findViewById(R.id.title)).setText(popularModel.results[position].original_title);
		Glide
				.with(context)
				.load("https://image.tmdb.org/t/p/original/" + popularModel.results[position].backdrop_path)
				.into((ImageView) holder.itemView.findViewById(R.id.image));

	}

	@Override
	public int getItemCount() {
		return popularModel.results.length;
	}

	public static class Holder extends RecyclerView.ViewHolder {
		public Holder(@NonNull View itemView) {
			super(itemView);
		}
	}
}
