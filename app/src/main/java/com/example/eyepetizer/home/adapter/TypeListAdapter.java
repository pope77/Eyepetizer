package com.example.eyepetizer.home.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.eyepetizer.R;
import com.example.eyepetizer.database.Banner;
import com.example.eyepetizer.database.Type;

import java.util.List;

/**
 * 分类列表适配器
 *
 * @author popeg
 */
public class TypeListAdapter extends RecyclerView.Adapter<TypeListAdapter.ViewHolder> {

    private List<Type> typeList;
    private Context context;

    public TypeListAdapter(List<Type> typeList, Context context) {
        this.typeList = typeList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_type, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Glide.with(context).load(typeList.get(i).getBgPicture()).into(viewHolder.typePic);
        viewHolder.typeName.setText("#" + typeList.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return typeList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView typePic;
        TextView typeName;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            typePic = itemView.findViewById(R.id.imageView_item);
            typeName = itemView.findViewById(R.id.textView_item_type);
            cardView = itemView.findViewById(R.id.cardView_item_type);
        }
    }
}
