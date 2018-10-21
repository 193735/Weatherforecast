package com.example.administrator.weatherforecast;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2018/10/18.
 */

public class adapter extends RecyclerView.Adapter<adapter.ViewHolder>{
   private List<City>mList;
   private Context mContext;
   public adapter(Context mContext,List<City>mList){
       this.mContext = mContext;
       this.mList = mList;
   }
    @Override
    public adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       ViewHolder viewHolder  = new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item,parent,false));

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(adapter.ViewHolder holder, int position) {
       City c= mList.get(position);
        holder.textView1.setText(c.getProvince());
        holder.textView2.setText(c.getCity());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView1;
        TextView textView2;
        public ViewHolder(View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.text1);
            textView2 = itemView.findViewById(R.id.text2);
        }
    }
}
