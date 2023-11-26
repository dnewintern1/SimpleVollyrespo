package com.base.vollyandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class MakingJsonReq extends AppCompatActivity {

    Button btnjsonResponse;
    TextView name,email,mobile;

    private String server_url="http://172.20.10.2/gretting/arrayjson.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_making_json_req);

        btnjsonResponse = findViewById(R.id.btnjsonResponse);
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        mobile=findViewById(R.id.mobile);

        btnjsonResponse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, server_url, null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {

                                try{
                                    name.setText(response.getString("firstName"));
                                    email.setText(response.getString("lastName"));
                                    mobile.setText(response.getString("gender"));

                                }catch(JSONException e){
                                    e.printStackTrace();

                                }


                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        name.setText("there is somthing wrong "+ error);

                    }
                });

                Mysingleton.getInstance(MakingJsonReq.this).addtoRequestqueue(jsonObjectRequest);

            }
        });
    }
}