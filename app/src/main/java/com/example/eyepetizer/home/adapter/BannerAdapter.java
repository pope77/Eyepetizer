package com.example.eyepetizer.home.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.eyepetizer.R;
import com.example.eyepetizer.database.Banner;

import java.util.List;

/**
 * Banner适配器
 * @author popeg
 */
public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.ViewHolder> {

    private List<Banner> banners;
    private Context context;

    public BannerAdapter(List<Banner> banners,Context context) {
        this.banners = banners;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_banner,viewGroup,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        String url = banners.get(i).getUrl();
        Glide.with(context).load(url).into(viewHolder.bannerPic);
    }

    @Override
    public int getItemCount() {
        return banners.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView bannerPic;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            bannerPic = itemView.findViewById(R.id.imageView_item_banner);
        }
    }
}
