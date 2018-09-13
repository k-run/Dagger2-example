package com.example.karanc.daggerexample.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.karanc.daggerexample.Activity.MainActivity;
import com.example.karanc.daggerexample.POJO.Result;
import com.example.karanc.daggerexample.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RandomUserAdapter extends RecyclerView.Adapter<RandomUserAdapter.RandomUserViewHolder> {

    private final Picasso picasso;
    private List<Result> res = new ArrayList<>();

    public RandomUserAdapter(MainActivity mainActivity, Picasso picasso) {
        this.picasso = picasso;
    }

    @NonNull
    @Override
    public RandomUserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_random_user,
                parent,false);
        return new RandomUserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RandomUserAdapter.RandomUserViewHolder holder, int position) {
    Result resList = res.get(position);
    holder.textView.setText(resList.getName().getFirst());
    holder.emailText.setText(resList.getEmail());
    picasso.with(holder.imageView.getContext()).load(resList.getPicture().getLarge()).into(holder.imageView);
    }


    @Override
    public int getItemCount() {
        return res.size();
    }

    public void setItems(List<Result> resultList) {
        res = resultList;
        notifyDataSetChanged();
    }

   public class RandomUserViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public ImageView imageView;
        public TextView emailText;

        public RandomUserViewHolder(View itemView) {
            super(itemView);
            this.textView = itemView.findViewById(R.id.text_randomuser);
            this.imageView = itemView.findViewById(R.id.image_randomuser);
            this.emailText = itemView.findViewById(R.id.email);
        }
    }
}
