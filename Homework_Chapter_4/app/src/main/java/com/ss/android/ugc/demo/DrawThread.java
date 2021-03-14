package com.ss.android.ugc.demo;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;

import androidx.annotation.NonNull;

import com.ss.android.ugc.demo.widget.Clock;

public class DrawThread extends HandlerThread implements Handler.Callback {
    private Handler mHandler;
    public static final int MSG_DRAW=100;
    private final Clock mClock;

    public DrawThread(String name, Clock clock) {
        super(name);
        mClock=clock;
    }

    @Override
    protected void onLooperPrepared() {
        super.onLooperPrepared();
        mHandler=new Handler(getLooper(),this);
        mHandler.sendEmptyMessage(MSG_DRAW);
    }

    @Override
    public boolean handleMessage(@NonNull Message msg) {
        if(msg.what==MSG_DRAW){
            mClock.invalidate();
            mHandler.sendEmptyMessageDelayed(MSG_DRAW,1000);
        }
        return true;
    }
}
