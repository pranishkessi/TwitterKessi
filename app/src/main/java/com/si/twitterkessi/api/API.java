package com.si.twitterkessi.api;


import com.si.twitterkessi.model.ModelCheck;
import com.si.twitterkessi.model.ModelImage;
import com.si.twitterkessi.model.ModelSignUpResponse;
import com.si.twitterkessi.model.ModelTweet;
import com.si.twitterkessi.model.ModelUser;
import com.si.twitterkessi.model.ModelUserInfo;

import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface API {
    @FormUrlEncoded
    @POST("users/login")
    Call<ModelSignUpResponse> checkUser(@Field("email") String username, @Field("password") String password);


    @POST("users/signup")
    Call<ModelSignUpResponse> register(@Body ModelUser cud);

    @Multipart
    @POST("upload")
    Call<ModelImage> uploadImage(@Part MultipartBody.Part imageFile);

    @POST("users/check")
    Call<ModelCheck> check(@Body ModelUser email);

    @POST("users/showalltweet")
    Call<List<ModelTweet>> GetTweet(@Header("Authorization") String token);

    @POST("users/me")
    Call<ModelUserInfo> getUser(@Header("Authorization") String token);
}
