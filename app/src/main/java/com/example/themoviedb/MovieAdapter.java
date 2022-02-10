package com.example.themoviedb;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.Holder> {
	Context context;
	List<LatestModel> latestModel;

	public MovieAdapter(Context context, List<LatestModel> latestModel) {
		this.context = context;
		this.latestModel = latestModel;
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
//		((TextView)holder.itemView.findViewById(R.id.name)).setText(latestModel.get(position).original_title);

	}

	@Override
	public int getItemCount() {
		return 3;
	}

	public static class Holder extends RecyclerView.ViewHolder {
		public Holder(@NonNull View itemView) {
			super(itemView);
		}
	}
}
