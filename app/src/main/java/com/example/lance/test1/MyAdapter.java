package com.example.lance.test1;

import android.annotation.TargetApi;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static com.example.lance.test1.R.layout.*;

/**
 * Created by lance on 2017/3/9.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {

    class MyHolder extends RecyclerView.ViewHolder{
        private TextView mLfDate;
        private TextView mLfContent;

        private TextView mRtDate;
        private TextView mRtContent;


        public MyHolder(View itemView) {
            super(itemView);
            mLfDate = (TextView) itemView.findViewById(R.id.tv_lf_date);
            mLfContent = (TextView) itemView.findViewById(R.id.tv_from);

            mRtDate = (TextView) itemView.findViewById(R.id.tv_rt_date);
            mRtContent = (TextView) itemView.findViewById(R.id.tv_send);

        }
    }

    private List<DataMsg> mDataMsgs;
    public MyAdapter(List<DataMsg> dataMsgs){
        mDataMsgs = dataMsgs;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater mLayoutInflater = LayoutInflater.from(parent.getContext());

        switch (viewType){
            case 0:
                View view = mLayoutInflater.inflate(R.layout.left,parent,false);
                return new MyHolder(view);
            case 1:
                View view2 = mLayoutInflater.inflate(R.layout.rigth,parent,false);
                return new MyHolder(view2);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        int data1 = getItemViewType(position);
        DataMsg dataMsg = mDataMsgs.get(position);
        if(data1 == DataMsg.TYPE_FROM){
            SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
            holder.mLfDate.setText(df.format(dataMsg.getDate()));
            holder.mLfContent.setText(dataMsg.getContent());
        }else if(data1 == DataMsg.TYPE_SEND){
            SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");



            holder.mRtDate.setText(df.format(dataMsg.getDate()));
            holder.mRtContent.setText(dataMsg.getContent());
        }
    }

    @Override
    public int getItemViewType(int position) {
        int data = mDataMsgs.get(position).getType();
        return data;
    }

    @Override
    public int getItemCount() {
        return mDataMsgs.size();
    }
}
