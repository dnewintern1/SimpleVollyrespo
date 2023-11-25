package com.base.vollyandroid;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.lang.ref.ReferenceQueue;

public class Mysingleton {

    private static Mysingleton mInstance;
    private RequestQueue requestqueue;

    private static Context mctx;

    private Mysingleton(Context context){

        mctx = context;
        requestqueue = getRequestqueue();

    }


    public  RequestQueue getRequestqueue(){

        if ((requestqueue == null)) {

            requestqueue = Volley.newRequestQueue(mctx.getApplicationContext());
        }
        return  requestqueue;
    }

    public static synchronized Mysingleton getInstance(Context context){

        if(mInstance == null){
            mInstance = new Mysingleton(context);
        }
        return mInstance;
    }

    public<T>void addtoRequestqueue(Request<T>  request){

        requestqueue.add(request);

    }


}
