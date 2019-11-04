package com.example.formlogin;

import com.example.formlogin.Model.Example;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface API {
    @POST("rest")
    Call<ResponseBody> GetLogin(@Body Object object);
}
