package com.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.playoffstudio.com.externaldatabasereadandroidexample.R;
import com.pojo.Pojo;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.CustomViewHoler>{

    public List<Pojo> pojoList;
    public Context context;
    public MyAdapter(Context context , List<Pojo> pojoList){
        this.context = context;
        this.pojoList = pojoList;
    }


    @NonNull
    @Override
    public CustomViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_adapter , null );
        CustomViewHoler customViewHoler = new CustomViewHoler(view);
        return customViewHoler;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHoler holder, int position) {

        Pojo pojo = pojoList.get(position);
        //holder.id.setText(pojo.getId());
        holder.title.setText(pojo.getName());
    }

    @Override
    public int getItemCount() {
        return pojoList.size();
    }

    public class CustomViewHoler extends RecyclerView.ViewHolder{


        @BindView(R.id.data_title)
        TextView title;

        public CustomViewHoler(View itemView) {
            super(itemView);
            ButterKnife.bind(this , itemView);
        }
    }
}
