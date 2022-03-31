package com.example.apicallingretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.lang.reflect.Method;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Tag;

public class MainActivity extends AppCompatActivity {

    private static final  String TAG = "MainActivity";

    private Button getData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getData = findViewById(R.id.get);
        getData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Methods methods =  RetrofitClient.getRetrofitInstance().create(Methods.class);
                Call<ApiModel> call = methods.getAllData();
                call.enqueue(new Callback<ApiModel>() {
                    @Override
                    public void onResponse(Call<ApiModel> call, Response<ApiModel> response) {
                        Log.e(TAG, "OnResponse code :"+response.code());
                        Log.e(TAG, "OnResponse :"+response.code());
                    }

                    @Override
                    public void onFailure(Call<ApiModel> call, Throwable t) {
                        Log.e(TAG, "OnResponse code :"+t.getMessage());

                    }
                });

            }
        });

    }
}