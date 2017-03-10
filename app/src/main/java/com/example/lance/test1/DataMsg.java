package com.example.lance.test1;

import android.provider.ContactsContract;

import java.util.Date;

/**
 * Created by lance on 2017/3/9.
 */

public class DataMsg {
    public static final int TYPE_FROM = 0;
    public static final int TYPE_SEND = 1;

    private Date date;
    private String content;
    private int type;

    public DataMsg(String content, int type, Date date){
        this.content = content;
        this.type = type;
        this.date = date;

    }


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
