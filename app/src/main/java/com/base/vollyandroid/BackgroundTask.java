package com.base.vollyandroid;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.ContentHandler;
import java.util.ArrayList;

public class BackgroundTask {

    Context mContext;
    ArrayList<Contact> arraylist = new ArrayList<>();

    String json_URL = "http://192.168.29.45/gretting/arrayjson.php";


    public BackgroundTask(Context context){
        this.mContext=context;
    }

    public  ArrayList<Contact> getList() {

        JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(Request.Method.POST, json_URL, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        int count = 0;
                        while (count<response.length()){

                            try{
                                JSONObject jsonObject = response.getJSONObject(count);
                                Contact contact  = new Contact(jsonObject.getString("Name"),jsonObject.getString("Email"));
                                arraylist.add(contact);
                                count++;
                            }catch (JSONException e){
                                e.printStackTrace();
                            }

                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(mContext, "ther is somthing wrong"+ error, Toast.LENGTH_SHORT).show();


            }
        }

        );

        Mysingleton.getInstance(mContext).addtoRequestqueue(jsonObjectRequest);
        return arraylist;
    }

}
