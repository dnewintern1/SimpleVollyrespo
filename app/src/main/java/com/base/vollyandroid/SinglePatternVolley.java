package com.base.vollyandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

public class SinglePatternVolley extends AppCompatActivity {

    private TextView serverRespo;
    private Button btnResponse;

    private String server_url="http://172.20.10.2/gretting/myfile.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_pattern_volley);

        serverRespo = findViewById(R.id.serverRespo);

        btnResponse = findViewById(R.id.btnResponse);

        btnResponse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StringRequest stringRequest = new StringRequest(Request.Method.POST, server_url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                                serverRespo.setText(response);

                            }
                        }, new Response.ErrorListener() {


                    @Override
                    public void onErrorResponse(VolleyError error) {

                        serverRespo.setText(error +"");
                        error.printStackTrace();

                    }
                });

                Mysingleton.getInstance(getApplicationContext()).addtoRequestqueue(stringRequest);
            }
        });

    }
}