package com.example.popie.retrofit_mocklab.UserClient;

import com.example.popie.retrofit_mocklab.Model.Event;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by popie on 11/2/2017.
 */

public interface UserClient {

    @GET("events")
    Call<List<Event>> getEvents();

}
