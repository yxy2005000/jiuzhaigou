package com.example.jiuzhaigou.api;

import com.example.jiuzhaigou.entity.UserInfo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UserApi {
    @GET("api/user/info")
    Call<UserInfo> getUserInfo(@Query("userId") String userId);
}