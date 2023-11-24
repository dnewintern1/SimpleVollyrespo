package com.base.vollyandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.StringRequest;

import java.net.NetPermission;

public class SettingUpRequestQueue extends AppCompatActivity {

    private TextView serverRespo;
    private Button btnResponse;

    RequestQueue requestQueue;


    private String server_url="http://172.20.10.2/gretting/myfile.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_up_request_queue);

        serverRespo = findViewById(R.id.serverRespo);

        btnResponse = findViewById(R.id.btnResponse);

        Cache cache = new DiskBasedCache(getCacheDir(),1024*1024);

        Network network = new BasicNetwork(new HurlStack());

        requestQueue = new RequestQueue(cache,network);
        requestQueue.start();

        btnResponse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StringRequest stringRequest = new StringRequest(Request.Method.POST, server_url,

                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                                serverRespo.setText(response);
                                requestQueue.stop();

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        serverRespo.setText(error +"");


                    }
                }

                );

                requestQueue.add(stringRequest);
            }
        });
    }
}