package com.example.lance.test1;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private MyAdapter mMyAdapter;
    private List<DataMsg> mDataMsgs = new ArrayList<>();
    private EditText mEdMsg;
    private Button mBtSend;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mMyAdapter = new MyAdapter(mDataMsgs);
        mMyAdapter.notifyDataSetChanged();
        mRecyclerView.setAdapter(mMyAdapter);

        initData();
        initInfo();

    }

    private void initInfo() {
        mEdMsg = (EditText) findViewById(R.id.et_msg);
        mBtSend = (Button) findViewById(R.id.bt_send);
        mBtSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String edMsg = mEdMsg.getText().toString();
                if(!"".equals(edMsg)){
                    DataMsg dataMsg = new DataMsg(edMsg,1,new Date());
                    mDataMsgs.add(dataMsg);
                    mMyAdapter.notifyItemInserted(mDataMsgs.size());
                    mRecyclerView.scrollToPosition(mDataMsgs.size()-1);
                    mEdMsg.setText("");//清空输入框内容

                }
            }
        });
    }

    private void initData() {
        DataMsg dataMsg = new DataMsg("你好，好久不见",0,new Date());
        DataMsg dataMsg1 = new DataMsg("你好",1,new Date());
        mDataMsgs.add(dataMsg);
        mDataMsgs.add(dataMsg1);
    }
}
