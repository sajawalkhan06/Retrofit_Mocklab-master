package com.example.popie.retrofit_mocklab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.popie.retrofit_mocklab.Adapter.RecyclerViewAdapter;
import com.example.popie.retrofit_mocklab.Model.Event;
import com.example.popie.retrofit_mocklab.UserClient.UserClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerViewAdapter adapter;
    Retrofit retrofit;
    UserClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        retrofit = new Retrofit.Builder()
                .baseUrl("http://uoleventdiary.mocklab.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        client = retrofit.create(UserClient.class);

        Call<List<Event>> call = client.getEvents();

        call.enqueue(new Callback<List<Event>>() {
            @Override
            public void onResponse(Call<List<Event>> call, Response<List<Event>> response) {
                if (response.isSuccessful()) {
                    adapter = new RecyclerViewAdapter(getApplicationContext(), response.body());
                    recyclerView.setAdapter(adapter);
                } else {
                    Toast.makeText(getApplicationContext(), "Respnonse not successful", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Event>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
