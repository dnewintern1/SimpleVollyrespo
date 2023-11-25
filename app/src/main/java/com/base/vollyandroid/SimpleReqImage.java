package com.base.vollyandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.media.ImageReader;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;

public class SimpleReqImage extends AppCompatActivity {

    private ImageView imageid;

    private String server_url="http://172.20.10.2/img/mypic.png";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_req_image);

        Button btnResponse = findViewById(R.id.btnResponse);
         imageid = findViewById(R.id.imageid);


        btnResponse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ImageRequest imageRequest = new ImageRequest(server_url,
                        new Response.Listener<Bitmap>() {
                            @Override
                            public void onResponse(Bitmap response) {

                                imageid.setImageBitmap(response);

                            }
                        }, 0, 0, ImageView.ScaleType.CENTER_CROP, null, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(SimpleReqImage.this,"somthing went wrong",Toast.LENGTH_SHORT).show();
                        error.printStackTrace();

                    }
                });

                Mysingleton.getInstance(SimpleReqImage.this).addtoRequestqueue(imageRequest);

            }
        });
    }
}